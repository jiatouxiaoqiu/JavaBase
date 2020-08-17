package cn.ebing.dog.api.test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest {
	public static void main(String[] args) {
		testFor2();
	}

	/**
	 * 它是可以为 NULL 的
	 */
	static void hashMap() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put(null, 2);
		map.put("s", 1);
		System.out.println("null" + map.get(null));
	}

	/**
	 * ConcurrentHashMap 的 key 不能为 null，这种是运行时报错啊
	 *
	 * ConcurrentHashMap为什么不能存值为null的value？
	 * ConcurrentHashMap为什么不能放值为null的key?
	 *
	 * 线程A调用concurrentHashMap.get(key)方法,返回为null，我们还是不知道这个null是没有映射的null还是存的值就是null？？？
	 *
	 * 在邮件的最后，Doug对Tutika遇到的问题给出了自己的建议
	 * 可以定义一个名称为NULL的全局的Object。当需要用null值的时候，用这个NULL来代替，以假乱真。
	 *
	 * 我只想说，NULL 真垃圾。如果 表结构里面有 NULL，真是灾难！！！
	 */
	static void testFor2() {
		ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
		map.put(null, 2);
		map.put("s", 1);
		System.out.println("null" + map.get(null));
	}

}
