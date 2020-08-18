package cn.ebing.dog.api.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 1 可以运行，2不行运行。因为在 remove 的时候 修改了 xx
 *
 * foreach循环是Java的语法糖，我们可以从编译后的class文件中看出
 * 文中多次提到了"fail-fast"机制(快速失败)，与其对应的还有"safe-fast"机制(失败安全)。
 */
public class FastFailTest {
	public static void main(String[] args) {
		iterable3();
//		testFor2();
	}

	static void testFor1() {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		for (String str: list) {
			if (str.equals("2")) {
				list.remove(str);
			}
		}
		System.out.println("after list:" + list);
	}

	static void testFor2() {
		List<String> list = new CopyOnWriteArrayList<String>();
		list.add("1");
		list.add("2");
		for (String str: list) {
			if (str.equals("2")) {
				list.remove(str);
			}
		}
		System.out.println("after list:" + list);
	}

	static void iterable1() {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		Iterator<String> iterable = list.iterator();
		while (iterable.hasNext()) {
			System.out.println("loop");
			String next = iterable.next();
			if (next.equals("2")) {
				iterable.remove();
			}
		}
		System.out.println("after list:" + list);
	}


	static void iterable3() {
		List<String> list = new ArrayList <String>();
		list.add("1");
		list.add("2");
		Iterator<String> iterable = list.iterator();
		while (iterable.hasNext()) {
			String next = iterable.next();
			System.out.println("loop   " + next);
			iterable.remove();
		}
		System.out.println("after list:" + list);
	}

	static void iterable2() {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.removeIf("2"::equals);
		System.out.println("after list:" + list);
	}

}
