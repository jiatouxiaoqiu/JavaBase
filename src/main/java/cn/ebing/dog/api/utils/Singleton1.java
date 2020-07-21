package cn.ebing.dog.api.utils;

/**
 * 饿汉式
 * 优点就是线程安全，缺点：类加载的时候就实例化对象了，浪费空间。于是乎，就提出了懒汉式的单例模式
 */
public class Singleton1 {
	private static Singleton1 instance = new Singleton1();

	private Singleton1 (){}

	public static Singleton1 getInstance() {
		return instance;
	}
}
