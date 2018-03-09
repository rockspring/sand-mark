package io.swimmingsand.study.flink;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.IterativeDataSet;

/**
 * Created by zlq on 4/29/17.
 */
public class IterativelyIncremenetStudy {
    public static void main(String[] args) throws Exception {

        // set up the execution environment
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        // get input data
        DataSet<Integer> data = env.fromElements(
                1,
                2,
                3,
                4,
                5
        );
        IterativeDataSet<Integer> initial = data.iterate(10);

        DataSet<Integer> iteration = initial.map(new MapFunction<Integer, Integer>() {
            @Override
            public Integer map(Integer value) throws Exception {
                return value + 1;
            }
        });

        DataSet<Integer> finalData = initial.closeWith(iteration);

        finalData.print();
    }
}
