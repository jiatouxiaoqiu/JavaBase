package cn.ebing.dog.api.test;

public class StringIntern {
	public static void main(String[] args) {
		String name = "xxx";

		String s1 = new StringBuilder().append("ja").append("va1").toString();
		String s2 = s1.intern();
		/**
		 * true
		 */
		System.out.println(s1==s2);

		String s5 = "dmz";
		String s3 = new StringBuilder().append("d").append("mz").toString();
		String s4 = s3.intern();
		/**
		 * false
		 */
		System.out.println(s3 == s4);

		String s7 = new StringBuilder().append("s").append("pring").toString();
		String s8 = s7.intern();
		String s6 = "spring";
		/**
		 * true
		 */
		System.out.println(s7 == s8);

	}

	/**
	 * 这段代码逻辑类比于
	 * <code>String s = "字面量"</code>;这种方式申明一个字符串
	 * 其中字面量就是在""中的值
	 *
	 */
//	public String declareString(字面量) {
//		String s;
//		// 这是一个伪方法，标明会根据字面量的值到字符串值中查找是否存在对应String实例的引用
//		s = findInStringTable(字面量);
//		// 说明字符串池中已经存在了这个引用，那么直接返回
//		if (s != null) {
//			return s;
//		}
//		// 不存在这个引用，需要新建一个字符串实例，然后调用其intern方法将其拘留到字符串池中，
//		// 最后返回这个新建字符串的引用
//		s = new String(字面量);
//		// 调用intern方法，将创建好的字符串放入到StringTable中,
//		// 类似就是调用StringTable.add(s)这也的一个伪方法
//		s.intern();
//		return s;
//	}
}
