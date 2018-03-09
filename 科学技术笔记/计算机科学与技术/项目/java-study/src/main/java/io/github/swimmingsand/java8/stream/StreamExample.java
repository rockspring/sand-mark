package io.github.swimmingsand.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamExample {
    public static void test() {
        List<String> list = Arrays.asList("one", "two", "three") ;
        list.stream()
                .map(s -> s.toUpperCase())
                .max(Comparator.comparing(s -> s.length()))
                .ifPresent(s -> System.out.println(s));
    }

    public static void main(String args[]) {
        test();
    }
}
