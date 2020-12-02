package cn.ebing.dog.api.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partition {
    /**
     * 分片
     */
    public static <T> List<List<T>> partition(List<T> list , int groupSize){
        int length = list.size();
        // 计算可以分成多少组
        int num = ( length + groupSize - 1 ) / groupSize;
        List<List<T>> newList = new ArrayList<List<T>>(num);
        for (int i = 0; i < num; i++) {
            // 开始位置
            int fromIndex = i * groupSize;
            // 结束位置
            int toIndex = (i+1) * groupSize < length ? ( i+1 ) * groupSize : length ;
            newList.add(list.subList(fromIndex,toIndex)) ;
        }
        return newList;
    }

    public static void main(String[] args) {
        List<String> a = Arrays.asList("0", "3", "4", "15", "16", "17", "222");
        List<List<String>> re = partition(a, 100);
        for (List<String> b: re) {
            System.out.println("xxxx+" + b);
        }
    }
}
