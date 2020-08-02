package cn.ebing.dog.api.utils.polymorphism;

/**
 * @author lx
 * 哈哈 抽象类继承抽象类
 */
class AbstractPig extends Animal {
	@Override
	public void eat() {
		System.out.println("吃");
	}

	public void work() {
		System.out.println("睡");
	}
}