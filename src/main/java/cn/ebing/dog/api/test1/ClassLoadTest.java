package cn.ebing.dog.api.test1;

public class ClassLoadTest {
    public static void main(String[] args) throws ClassNotFoundException {
        //因此 new创建实例对象，会触发类加载进行
//        ClassLoadInstance instance = new ClassLoadInstance();
        // 因此访问类的静态变量会触发类加载 因此访问类的静态方法会触发类加载
        System.out.println(ClassLoadStaticVariable.i);

        // 因此反射会触发类加载
        Class.forName("cn.ebing.dog.api.test1.ClassLoadStaticReflect");

        // 虚拟机启动时，定义了main()方法的那个类先初始化
    }
}
