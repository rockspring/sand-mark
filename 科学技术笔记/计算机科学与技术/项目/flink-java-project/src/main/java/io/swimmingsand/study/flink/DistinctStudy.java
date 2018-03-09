package io.swimmingsand.study.flink;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple2;

/**
 * Created by zlq on 4/29/17.
 */
public class DistinctStudy {
    public static class AbsSelector implements KeySelector<Tuple2<Integer, Integer>, Integer> {
        private static final long serialVersionUID = 1L;
        @Override
        public Integer getKey(Tuple2<Integer, Integer> t) {
            return Math.abs(t.f1);
        }
    }

    public static void main(String[] args) throws Exception {

        // set up the execution environment
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        // get input data
        DataSet<Tuple2<Integer, Integer>> data = env.fromElements(
                new Tuple2<Integer, Integer>(1, -3),
                new Tuple2<Integer, Integer>(1, 3),
                new Tuple2<Integer, Integer>(1, -1)
        );

        //去除重复的行
        data.distinct().print();

        data.distinct(1).print();

        data.distinct(new AbsSelector()).print();
    }
}
