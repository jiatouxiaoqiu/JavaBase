package cn.ebing.dog.api.test;

public class StringTest {

	/**
	 * 这里必须是 static ，只有这样，才比 main 更早 Classlaoder 到 JVM 中
	 */
	private static String a = "xxx";

	public static void main(String[] args) {

		System.out.println(a);

		//创建了两个对象，一份存在字符串常量池中，一份存在堆中
		String s = new String("aa"); // s 是指向
		//检查常量池中是否存在字符串aa，此处存在则直接返回
		String s1 = s.intern();
		String s2 = "aa";

		System.gc();

		System.out.println(s == s2);  //① false
		System.out.println(s1 == s2); //② true

		String s3 = new String("b") + new String("b");
		//常量池中没有bb，在jdk1.7之后会把堆中的引用放到常量池中，故引用地址相等
		String s4 = s3.intern();
		String s5 = "bb";

		System.out.println(s3 == s5 ); //③ true
		System.out.println(s4 == s5);  //④ true

		String a = "forecastUnit.getEpsPpnrTask";
		String SPLIT = "\\."; // split 本身是正则，如果是 . 就要加入转义字符
		String[] b = a.split(SPLIT);
		System.out.println(b.length);
	}
}
