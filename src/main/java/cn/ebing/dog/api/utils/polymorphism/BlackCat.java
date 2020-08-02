package cn.ebing.dog.api.utils.polymorphism;

class BlackCat extends Cat {

	/**
	 * 使用 super 来调用父类构造函数
	 * 注意：如果没有使用super()或this()，则super()在每个类构造函数中由编译器自动添加。
	 *
	 */
	@Override
	public void eat() {
		System.out.println("super.age;" + super.age);
		System.out.println("吃鱼");
	}

	@Override
	public void work() {
		System.out.println("抓老鼠");
	}
}