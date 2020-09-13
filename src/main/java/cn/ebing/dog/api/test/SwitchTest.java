package cn.ebing.dog.api.test;

/**
 * 支持的基本类型：
 * 8 种基本类型已经支持了char、byte、short、int 这4 种，而这 4 种都是可以转化为 int 类型的。
 * char[] 就是 String 嘛, String hashcode，如果冲突了就再配一个 if-else 。
 *
 * enum 呢？？
 * 数组里面的参数是枚举的类型，然后调用了枚举的 ordinal 方法
 *
 * 因为 long 类型 64 位了，而tableswitch 和 lookupswitch 指令只能操作 32 位的 int 。这两个指令对于 long 是搞不动的。
 *
 * Expression 需要一个
 * 表达式就是 switch 后面的括号里面的东西。比如说，这个东西可以是一个方法。
 * 那么如果这个表达式的计算结果是 null，那么就抛出空指针异常。这个 switch 语句也就算完事了。
 * 另外，如果这个表达式的结果是一个引用类型，那么还需要进行一个拆箱的处理。
 *
 * switch 代码块中匹配的 case 语句之后的所有语句 （如果有）就按照顺序执行。
 * 如果所有语句都正常完成，或者在匹配的 case 语句之后没有语句，那么整个 switch  代码块就将正常完成。
 * 如果没有和表达式匹配的 case 语句，但是有一个 default 语句，那么 switch 代码块中 default 语句后面的所有语句（如果有）将按顺序执行。
 * 如果所有语句都正常完成，或者如果 default 标签之后没有语句了，则整个 switch 代码块就将正常完成。
 *
 * switch 支持 String 类型的原因
 * 1 是先取的 String 的 hashCode 进行 case 匹配，
 * 2 然后在每个 case 里面给 var3 这个变量赋值。
 * 3 然后再对 var3 进行一次 switch 操作。
 *
 * javap 奇怪了，同样的 switch 语言，却对应两个指令：lookupswitch 和 tableswitch。
 *
 * 当 switch 语句里面 case 的值比较“稀疏”（sparse）的时候，用 tableswitch 指令的话空间利用率就会很低下。
 * 在源码里面有个公式可以知道是不是稀疏的，从而知道使用什么指令。
 *
 * Java 虚拟机的 tableswitch 和 lookupswitch 指令，只支持 int 类型。
 *
 * tableswitch：
 * 当 switch 里面的 case 可以用偏移量进行有效表示的时候，我们就用 tableswitch 指令。
 * 如果 switch 语句的表达式计算出来的值不在这个偏移量的有效范围内，那么就进入 default 语句。
 * tableswitch 由于是直接根据偏移量定位，所以时间复杂度是 O(1)。
 *
 * lookupswitch：
 * 排序之后的查找比线性查找快。用的是二分查找，时间复杂度为O(log n)。
 *
 * 分析：
 * 1、先 Java文件
 * 2 javac 得到class 文件
 * 3 javap 得到 字节码
 */
public class SwitchTest {
	public static void main(String[] args) {
		//当default在中间时,且看输出是什么？
		int a = 5;
		switch (a) {
			case 2:
				System.out.println("print 2");
			case 1:
				System.out.println("print 1");
			default:
				System.out.println("first default print");
			case 3:
				System.out.println("print 3");
		}

		//当switch括号内的变量为String类型的外部参数时,且看输出是什么？
		String param = null;
		switch (param) {
			case "param":
				System.out.println("print param");
				break;
			case "String":
				System.out.println("print String");
				break;
			case "null":
				System.out.println("print null");
				break;
			default:
				System.out.println("second default print");
		}
	}
}