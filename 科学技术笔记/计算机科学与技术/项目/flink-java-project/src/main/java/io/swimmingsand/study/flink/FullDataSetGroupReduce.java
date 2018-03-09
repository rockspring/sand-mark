package io.swimmingsand.study.flink;

import org.apache.flink.api.common.functions.GroupReduceFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.util.Collector;

/**
 * Created by zlq on 4/29/17.
 */
public class FullDataSetGroupReduce {
    public static class MyGroupReducer implements GroupReduceFunction<Integer, Integer> {
        @Override
        public void reduce(Iterable<Integer> values, Collector<Integer> out) throws Exception {
            int sum = 0;
            for(Integer i : values) {
                sum = sum + i;
            }
            out.collect(sum);
        }
    }

    public static void main(String[] args) throws Exception {

        // set up the execution environment
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        // get input data
        DataSet<Integer> data = env.fromElements(
                1,
                2,
                3
        );


        /**
         * A GroupReduce transformation on a full DataSet cannot be done in parallel if the group-reduce function is
         * not combinable. Therefore, this can be a very compute intensive operation. See the paragraph on
         * “Combinable GroupReduceFunctions” above to learn how to implement a combinable group-reduce function.
         */
        data.reduceGroup(new MyGroupReducer()).print();
    }
}
