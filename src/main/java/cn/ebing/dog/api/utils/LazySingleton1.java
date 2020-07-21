package cn.ebing.dog.api.utils;

/**
 * 懒汉
 * 一种双重校验锁的单例设计模式，既保证了线程安全，又提高了性能。双重校验锁的getInstance()方法如下所示
 */
public class LazySingleton1 {
	private static LazySingleton1 instance;

	private LazySingleton1(){}

	public static LazySingleton1 getInstance() {
		if (instance == null) {
			synchronized (LazySingleton1.class) {
				if (instance == null) {
					instance = new LazySingleton1();
				}
			}
		}
		return instance;
	}
}
