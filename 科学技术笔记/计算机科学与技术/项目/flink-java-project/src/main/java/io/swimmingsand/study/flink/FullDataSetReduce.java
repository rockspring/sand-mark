package io.swimmingsand.study.flink;

import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;

/**
 * Created by zlq on 4/29/17.
 */
public class FullDataSetReduce {
    public static class IntSummer implements ReduceFunction<Integer> {
        @Override
        public Integer reduce(Integer num1, Integer num2) {
            return num1 + num2;
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
         * Reducing a full DataSet using the Reduce transformation implies that the final Reduce operation cannot be
         * done in parallel. However, a reduce function is automatically combinable such that a Reduce transformation
         * does not limit scalability for most use cases.
         */
        data.reduce(new IntSummer()).print();
    }
}
