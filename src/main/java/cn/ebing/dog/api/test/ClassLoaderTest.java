package cn.ebing.dog.api.test;

/**
 * 注意，上面第一行和第四行的null此处可不是空的意思，它代表的是启动类加载器。
 * 因为启动类加载器是用C++代码来实现的，严格来说不属于Java类，所以Java代码访问不到，故返回null。
 * 第二行是应用程序类加载器，第三行是扩展类加载器。
 */
public class ClassLoaderTest {
	public static void main(String[] args) {
		Object obj = new Object();
		System.out.println(obj.getClass().getClassLoader());

		ClassLoaderTest t = new ClassLoaderTest();
		System.out.println(t.getClass().getClassLoader());
		System.out.println(t.getClass().getClassLoader().getParent());
		System.out.println(t.getClass().getClassLoader().getParent().getParent());
	}
}

/**
 * 双亲委派机制,规范，我们不能随意覆盖原有的 rt.jar 的 class
 */
//自己定义的一个 java.lang包
//package java.lang;
//
//public class String {
//	public static void main(String[] args) {
//		String s = new String();
//		System.out.println(s);
//	}
//}