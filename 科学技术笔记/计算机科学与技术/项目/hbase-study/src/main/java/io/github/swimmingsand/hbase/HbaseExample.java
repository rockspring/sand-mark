package io.github.swimmingsand.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;

import java.text.DecimalFormat;

/**
 * Created by zlq on 3/31/16.
 */
public class HbaseExample {
    public static void main(String[] args) throws Exception{
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String formated = decimalFormat.format(3.14509);
        System.out.println(formated);

        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", "localhost");

        Connection connection = ConnectionFactory.createConnection(config);
        TableName tableName = TableName.valueOf("table_test");
        Admin admin = connection.getAdmin();
        HColumnDescriptor hColumnDescriptor = new HColumnDescriptor("column_test");


        HTableDescriptor hTableDescriptor = new HTableDescriptor(tableName);
        hTableDescriptor.addFamily(hColumnDescriptor);
        admin.createTable(hTableDescriptor);
        admin.close();

        Table table = connection.getTable(tableName);
        Put put = new Put("row_test".getBytes());
        put.addColumn("column_test".getBytes(), "qualifier_test".getBytes(), "column_data_test".getBytes());
        table.put(put);
        table.close();

        table = connection.getTable(tableName);
        Get get = new Get("row_test".getBytes());
        Result result = table.get(get);
        System.out.format("result=%s\n", new String(result.getValue("column_test".getBytes(), "qualifier_test"
                .getBytes()
        )));

        admin = connection.getAdmin();
        hColumnDescriptor = new HColumnDescriptor("column_test");


        hTableDescriptor = new HTableDescriptor(tableName);
        hTableDescriptor.addFamily(hColumnDescriptor);

        admin.disableTable(tableName);
        admin.deleteTable(tableName);
        admin.close();

        /*table = connection.getTable(tableName);
        Increment increment = new Increment("row_test".getBytes());
        result = table.increment(increment);
        table.close();*/


    }
}
