package cn.ebing.dog.api.utils.polymorphism;

/**
 * 1. 抽象类不能被实例化(初学者很容易犯的错)，如果被实例化，就会报错，编译无法通过。只有抽象类的非抽象子类可以创建对象。
 *
 * 2. 抽象类中不一定包含抽象方法，但是有抽象方法的类必定是抽象类。
 *
 * 3. 抽象类中的抽象方法只是声明，不包含方法体，就是不给出方法的具体实现也就是方法的具体功能。
 *
 * 4. 构造方法，类方法（用 static 修饰的方法）不能声明为抽象方法。
 *
 * 5. 抽象类的子类必须给出抽象类中的抽象方法的具体实现，除非该子类也是抽象类。
 */
abstract class Animal {
	/**
	 * 如果我们用final修饰方法，假如方法所属的类被继承，方法将不能在子类中被重写。
	 * @param a
	 * @return
	 * final 和 static 常常在一起用。final 不能被继承，static 存放在方法区
	 * 常量分为：1不可变的变量。2就是一个值的本身。
	 * Java常量既不在堆里也不再栈里。实在独立内存空间统一管理。
	 * 被static关键字修饰的方法或者变量不需要依赖于对象来进行访问，只要类被加载了，就可以通过类名去进行访问。
	 *
	 * 　　static成员变量的初始化顺序按照定义的顺序进行初始化。
	 *
	 * 常量池： JVM为每个已加载的类型维护一个常量池，常量池就是这个类型用到的常量的一个有序集合。包括直接常量(基本类型，String)和对其他类型、方法、字段的 符号引用(1) 。池中的数据和数组一样通过索引访问。由于常量池包含了一个类型所有的对其他类型、方法、字段的符号引用，所以常量池在Java的动态链接中起了核心作用。 常量池存在于堆中
	 *
	 * 这个语句是最常见的。 a是实例 new出来的才是对象 实例a放在栈 对象放在堆中。堆中的常量池似乎有点static的味道，把成员方法都放在里面而不是每次都复制一次。
	 */

	public int age = 10;

	final int happy(int a) {
		return a + 10;
	}

	/**
	 * 抽象方法不能有 body
	 */
	abstract void eat();
}