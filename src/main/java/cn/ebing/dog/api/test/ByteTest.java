package cn.ebing.dog.api.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author qhb
 * @Date 2021/8/23 5:29 下午
 * @Version 1.0
 */
public class ByteTest {
    /**
     * 根据以下的情况，byte慎重使用，一般都要用 int
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 这样是不允许的
         */
        // byte c = 128;


        byte a = 127;
        byte b = 127;
        /**
         * a变成负数
         */
        a += b;
        System.out.println(a);
        /**
         * a=a+b 会直接报错。
         */
        // a = a + b;

        Map<Integer, Integer> map = new HashMap<>();
    }

}
