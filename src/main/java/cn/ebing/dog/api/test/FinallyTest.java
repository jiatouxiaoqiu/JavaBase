package cn.ebing.dog.api.test;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 如果 try 中有 return 语句， 那么 finally 中的代码还是会执⾏。因为 return 表⽰的是 要整个⽅法体返回， 所以，finally 中的语句会在 return 之前执⾏。 但是 return 前执行的 finally 块内，对数据的修改效果对于引用类型和值类型会不同：
 */
public class FinallyTest {
    public static void main(String[] args) {
        //System.out.println("finally1()-> " + finally1());
        //System.out.println("finally2()-> " + finally2());
//        int[] f3 = finally3();
//        for (int i : f3) {
//            System.out.println("finally3-> " + i + "; ints.length ->" + f3.length);
//        }
        arrayList();
        CollectionUtils.intersection(null,null);
    }

    static int finally1() {
        int i = 0;
        try{
            return i;
        } finally{
            i++;
            System.out.println("finally1");
        }
    }

    static int finally2() {
        int[] ints = new int[]{2};
        System.out.println("ints.length ->" + ints.length + "; ints[0] ->" + ints[0]);
        try{
            return ints[0];
        } finally {
            ints[0]++;
            System.out.println("finally2");
        }
    }

    static void arrayList() {
        List<Integer> list = new ArrayList<>();
        list.add(null);
        list.add(1);
        for (Integer i: list) {
            System.out.println("i-> " + i);
        }
    }

    static int[] finally3() {
        int[] ints = new int[]{0};
        System.out.println("ints.length ->" + ints.length + "; ints[0] ->" + ints[0]);
        try{
            return ints;
        } finally {
            ints[0]++;
            System.out.println("finally3");
        }
    }
}
