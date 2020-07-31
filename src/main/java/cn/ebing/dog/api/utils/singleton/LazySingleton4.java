package cn.ebing.dog.api.utils.singleton;

import java.io.Serializable;

/**
 * 显然，我们又看到了两个实例类。为了避免此问题，我们需要提供 readResolve() 方法的实现。readResolve(）代替了从流中读取对象。这就确保了在序列化和反序列化的过程中没人可以创建新的实例。
 */
public class LazySingleton4 implements Serializable {

	private static boolean initialized = false;

	private LazySingleton4() {
		synchronized (LazySingleton4.class) {
			if (initialized == false) {
				initialized = !initialized;
			} else {
				throw new RuntimeException("单例已被破坏");
			}
		}
	}

	static class SingletonHolder {
		private static final LazySingleton4 instance = new LazySingleton4();
	}

	public static LazySingleton4 getInstance() {
		return SingletonHolder.instance;
	}

	private Object readResolve() {
		return getInstance();
	}
}