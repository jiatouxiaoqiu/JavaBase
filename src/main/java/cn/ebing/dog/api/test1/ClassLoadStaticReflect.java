package cn.ebing.dog.api.test1;

public class ClassLoadStaticReflect {
    static {
        System.out.println("ClassLoadStaticReflect类初始化时就会被执行！");
    }

    public static void method(){
        System.out.println("静态方法被调用");
    }

    public ClassLoadStaticReflect() {
        System.out.println("ClassLoadStaticReflect构造函数！");
    }
}
