package cn.ebing.dog.api.test1;

public class ClassLoadStaticVariable {
    static {
        System.out.println("ClassLoadStaticVariable类初始化时就会被执行！");
    }

    public static int i = 100;

    public ClassLoadStaticVariable() {
        System.out.println("ClassLoadStaticVariable构造函数！");
    }
}
