package io.github.swimmingsand.mongo;


import com.mongodb.hadoop.io.BSONWritable;
import com.mongodb.hadoop.io.MongoUpdateWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.bson.BasicBSONObject;
import org.bson.types.ObjectId;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @since 2015-02-15
 * @author leqinzhou
 */
public class MongoHadoop {
    public class DeviceMapper extends Mapper<Object, BSONWritable, Text, Text> {

        @Override
        public void map(Object key, BSONWritable val, final Context context)
                throws IOException, InterruptedException {
            String keyOut = (String)val.getDoc().get("owner") + " " + (String)val.getDoc().get("type");
            context.write(new Text(keyOut), new Text(val.getDoc().get("_id").toString()));
        }
    }

    public class DeviceReducer extends Reducer<Text, Text, NullWritable, MongoUpdateWritable> implements org.apache.hadoop.mapred.Reducer<Text, Text, NullWritable, MongoUpdateWritable> {

        @Override
        public void reduce( final Text pKey, final Iterable<Text> pValues,
                            final Context pContext )
                throws IOException, InterruptedException{

            BasicBSONObject query = new BasicBSONObject("_id", pKey.toString());
            ArrayList<ObjectId> devices = new ArrayList<ObjectId>();
            for(Text val : pValues){
                devices.add(new ObjectId(val.toString()));
            }

            BasicBSONObject devices_list = new BasicBSONObject("devices", devices);
            BasicBSONObject update = new BasicBSONObject("$pushAll", devices_list);

            pContext.write(NullWritable.get(), new MongoUpdateWritable(query, update, true, false));
        }

        @Override
        public void reduce(final Text key, final Iterator<Text> values, final OutputCollector<NullWritable, MongoUpdateWritable> output,
                           final Reporter reporter) throws IOException {
            BasicBSONObject query = new BasicBSONObject("_id", key.toString());
            ArrayList<ObjectId> devices = new ArrayList<ObjectId>();
            while (values.hasNext()) {
                Text val = values.next();
                devices.add(new ObjectId(val.toString()));
            }

            BasicBSONObject update = new BasicBSONObject("$pushAll", new BasicBSONObject("devices", devices));
            output.collect(null, new MongoUpdateWritable(query, update, true, false));
        }

        @Override
        public void close() throws IOException {
        }

        @Override
        public void configure(final JobConf job) {
        }
    }
}
