package cn.ebing.dog.api.test1;

public class ClassLoadInstance {

    static {
        System.out.println("ClassLoadInstance类初始化时就会被执行！");
    }

    public ClassLoadInstance() {
        System.out.println("ClassLoadInstance构造函数！");
    }
}

//public class ClassLoadTest {
//
//    public static void main(String[] args) {
//        ClassLoadInstance instance = new ClassLoadInstance();
//    }
//}
