package io.swimmingsand.study.flink;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;

/**
 * Created by zlq on 4/29/17.
 */
public class KeyExpressionDistinctStudy {
    // some ordinary POJO
    public static class CustomType implements Comparable{
        public String aName;
        public int aNumber;
        // [...]

        public CustomType(String name, int number) {
            this.aName = name;
            this.aNumber = number;
        }

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }

    public static void main(String[] args) throws Exception {

        // set up the execution environment
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        // get input data
        DataSet<CustomType> data = env.fromElements(
                new CustomType("abc", 1),
                new CustomType("abc", 2)
        );

        data.distinct("aName");
    }
}
