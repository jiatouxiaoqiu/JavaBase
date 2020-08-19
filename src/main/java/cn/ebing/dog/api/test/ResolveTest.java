package cn.ebing.dog.api.test;

public class ResolveTest {
	/**
	 * 都有a，Error:(5, 41) java: 对a的引用不明确
	 *   cn.ebing.dog.api.test.ResolveTest.Parent 中的变量 a 和 cn.ebing.dog.api.test.ResolveTest.Interface0 中的变量 a 都匹配
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println(Child.a);
	}

	interface Interface0 {
		int a = 0;
	}

	static class Parent {
		static int a = 1;
	}

	static class Child extends Parent implements Interface0 {

	}

	//必须是抽象类，否则，需要实现接口的全部方法
	static abstract class Child2 implements Interface0 {

	}
}
