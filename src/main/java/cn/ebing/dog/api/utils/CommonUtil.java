package cn.ebing.dog.api.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qhb
 * @Date 2021/6/15 3:51 下午
 * @Version 1.0
 */
public class CommonUtil {
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
}
