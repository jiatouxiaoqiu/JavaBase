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
    }
}
