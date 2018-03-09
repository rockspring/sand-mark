package io.swimmingsand.study.flink;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;

/**
 * Created by zlq on 4/29/17.
 */
public class FullTupleDataSetSum {
    public static void main(String[] args) throws Exception {

        // set up the execution environment
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        // get input data
        DataSet<Tuple2<Integer, Integer>> data = env.fromElements(
                new Tuple2<Integer, Integer>(1, 3),
                new Tuple2<Integer, Integer>(1, 2),
                new Tuple2<Integer, Integer>(1, 1)
        );

        /**
         * 对某一个字段值进行累加，未涉及的字段不变，输出最后一条记录的值
         */
        data.sum(0).andSum(1).print();
    }
}
