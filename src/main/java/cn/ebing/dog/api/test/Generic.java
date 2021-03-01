package cn.ebing.dog.api.test;

class GT<T> {
    public static int var = 0;
    public void nothing(T x) {}
}

public class Generic {
    public static void main(String[] args) {
        GT<Integer> gti = new GT<>();
        gti.var = 1;
        GT<String> gts = new GT<>();
        gts.var = 2;
        System.out.println("var的值是= " + gts.var);

        /**
         * IO流都是打开的，不同的通道，所以 print 顺序是随机的
         */
        System.out.println("我是标准输出流");
        System.err.println("我是标准错误输出流");
    }
}
