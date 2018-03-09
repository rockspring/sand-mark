package org.apache.lucene.util;

import org.junit.Test;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.WeakHashMap;

/**
 * Created by zlq on 6/10/15.
 */
public class ArrayTimSorterTest {

    @Test
    public void test1() {
        Object o = new Object();
        // 默认的构造函数，会使用ReferenceQueue.NULL 作为queue
        WeakReference<Object> wr = new WeakReference<Object>(o);
        System.out.println(wr.get() == null);
        o = null;
        System.gc();
        System.out.println(wr.get() == null);
    }

    @Test
    public void test2() throws Exception{
        List<WeakHashMap<byte[][], byte[][]>> maps = new ArrayList<WeakHashMap<byte[][], byte[][]>>();
        for (int i = 0; i < 1; i++) {
            WeakHashMap<byte[][], byte[][]> d = new WeakHashMap<byte[][], byte[][]>();
            byte[][] key = new byte[1000][1000];
            d.put(key, new byte[1000][1000]);
            maps.add(d);
            System.gc();
            Field queue = d.getClass().getDeclaredField("queue");
            queue.setAccessible(true);

            ReferenceQueue<Object> queue1 = (ReferenceQueue<Object>)queue.get(d);
            System.err.println(i);
        }
    }

    public <T> void swap(T arr[], int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Test
    public void testSwap() {
        Integer[] arr = new Integer[] {1,2};
        swap(arr,0,1);
    }

    @Test
    public void testMinRun() {
        int minRun = TimSorter.minRun(129);
    }

    @Test
    public void testBinarySort() {
        Integer[] scores = new Integer[] {1,3,5,2};
        for (Integer score : scores) {
            System.out.print(score);
        }
        System.out.println();

        Comparator<Integer> comparator = new Comparator<Integer>() {
            //@Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        ArrayTimSorter<Integer> arrayTimSorter = new ArrayTimSorter<Integer>(scores,comparator,2);

        arrayTimSorter.binarySort(0, 4);
    }

    @Test
    public void test() {
        Integer[] scores = new Integer[] {1,3,5,2};
        for (Integer score : scores) {
            System.out.print(score);
        }
        System.out.println();

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        ArrayTimSorter<Integer> arrayTimSorter = new ArrayTimSorter<Integer>(scores,comparator,2);
        arrayTimSorter.sort(0, scores.length);

        System.out.println("ArrayTimSorter sort");
        for (Integer score : scores) {
            System.out.print(score);
        }
        System.out.println();
    }
}
