package cn.ebing.dog.api.utils.singleton;

import java.io.Serializable;

/**
 * initialized 只执行一次，这里就保证了，反射无法破坏其单例特性
 * 在分布式系统中，有些情况下你需要在单例类中实现 Serializable 接口。这样你可以在文件系统中存储它的状态并且在稍后的某一时间点取出
 * 让我们测试这个懒汉式V3版在序列化和反序列化之后是否仍然保持单例。
 */
public class LazySingleton3 implements Serializable {
	private static boolean initialized = false;

	private LazySingleton3() {
		synchronized (LazySingleton3.class) {
			if (initialized == false) {
				initialized = !initialized;
			} else {
				throw new RuntimeException("单例已被破坏");
			}
		}
	}

	static class SingletonHolder {
		private static final LazySingleton3 instance = new LazySingleton3();
	}

	public static LazySingleton3 getInstance() {
		return SingletonHolder.instance;
	}
}
