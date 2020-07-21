package cn.ebing.dog.api.utils;

/**
 * 内部类的加载机制
 * 加载一个类时，其内部类不会同时被加载。
 * 一个类被加载，当且仅当其某个静态成员（静态域、构造器、静态方法等）被调用时发生。。
 */
public class LazySingleton2 {
	private LazySingleton2() {
	}

	static class SingletonHolder {
		private static final LazySingleton2 instance = new LazySingleton2();
	}

	public static LazySingleton2 getInstance() {
		return SingletonHolder.instance;
	}
}
