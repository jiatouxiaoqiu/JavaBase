package cn.ebing.dog.api.utils.singleton;

import java.lang.reflect.Constructor;

/**
 * 根据哈希值可以看出，反射破坏了单例的特性，因此懒汉式V3版诞生了
 */
public class LazySingleton2Test {
	public static void main(String[] args) {
		//创建第一个实例
		LazySingleton3 instance1 = LazySingleton3.getInstance();

		//通过反射创建第二个实例
		LazySingleton3 instance2 = null;
		try {
			Class<LazySingleton3> clazz = LazySingleton3.class;
			Constructor<LazySingleton3> cons = clazz.getDeclaredConstructor();
			cons.setAccessible(true);
			instance2 = cons.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

		//检查两个实例的hash值
		System.out.println("Instance 1 hash:" + instance1.hashCode());
		System.out.println("Instance 2 hash:" + instance2.hashCode());
	}
}
