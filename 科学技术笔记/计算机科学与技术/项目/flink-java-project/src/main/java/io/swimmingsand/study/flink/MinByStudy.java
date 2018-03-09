package io.swimmingsand.study.flink;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;

/**
 * Created by zlq on 4/29/17.
 */
public class MinByStudy {
    public static void main(String[] args) throws Exception {

        // set up the execution environment
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        // get input data
        DataSet<Tuple2<Integer, Integer>> data = env.fromElements(
                new Tuple2<Integer, Integer>(1, 3),
                new Tuple2<Integer, Integer>(1, 2),
                new Tuple2<Integer, Integer>(1, 1)
        );

        DataSet<Tuple2<Integer, Integer>> minBy = data.minBy(0);
        minBy.print();

        //如果第一个字段的最小值有很多，再选择第二个字段的最小值
        DataSet<Tuple2<Integer, Integer>> minBy2 = data.minBy(0, 1);
        minBy2.print();
    }
}
