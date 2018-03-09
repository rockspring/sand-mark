package io.swimmingsand.study.flink;

import org.apache.flink.api.common.functions.GroupCombineFunction;
import org.apache.flink.api.common.functions.GroupReduceFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.util.Collector;

/**
 * Created by zlq on 4/29/17.
 */
public class FullDataSetGroupCombine {
    public static void main(String[] args) throws Exception {

        // set up the execution environment
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        // get input data
        DataSet<Integer> data = env.fromElements(
                1,
                2,
                3
        );

        data.combineGroup(new GroupCombineFunction<Integer, Integer>() {
            @Override
            public void combine(Iterable<Integer> values, Collector<Integer> out) throws Exception {
                int sum = 0;
                for(Integer i : values) {
                    sum = sum + i;
                }
                out.collect(sum);
            }
        }).reduceGroup(new GroupReduceFunction<Integer, Integer>() {
            @Override
            public void reduce(Iterable<Integer> values, Collector<Integer> out) throws Exception {
                int sum = 0;
                for(Integer i : values) {
                    sum = sum + i;
                }
                out.collect(sum);
            }
        }).print();

        /**
         * The GroupCombine on a full DataSet works similar to the GroupCombine on a grouped DataSet. The data is
         * partitioned on all nodes and then combined in a greedy fashion (i.e. only data fitting into memory is
         * combined at once).
         */
    }
}
