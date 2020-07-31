package cn.ebing.dog.api.utils.bloomfilter;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class SimpleBloomFilterTest {

	// bit 数组的大小
	private static final int DEFAULT_SIZE = 1000;

	private static final int DATA_SIZE = 500;

	// 用来生产三个不同的哈希函数的
	private static final int[] seeds = new int[]{7, 31, 61,};
	// bit 数组
	private BitSet bits = new BitSet(DEFAULT_SIZE);
	// 存放哈希函数的数组
	private SimpleHash[] func = new SimpleHash[seeds.length];

	public static void main(String[] args) {
		SimpleBloomFilterTest filter = new SimpleBloomFilterTest();
		// 先向布隆过滤器中添加 10000 个url
		for (int i = 0; i < DATA_SIZE; i++) {
			String url = "https://voice.hupu.com/nba/" + i;
			filter.add(url);
		}
		// 前10000个url不会出现误判
		for (int i = 0; i < DATA_SIZE; i++) {
			String url = "https://voice.hupu.com/nba/" + i;
			if (!filter.contains(url)) {
				System.out.println("该 url 被采集过了" + i);
			}
		}

		List<String> list = new ArrayList<String>(200);
		// 再向布隆过滤器中添加 2000 个 url ，在这2000 个中就会出现误判了
		// 误判的个数为 2000 * fpp
		for (int i = DATA_SIZE; i < DATA_SIZE + 200; i++) {
			String url = "https://voice.hupu.com/nba/" + i;
			if (filter.contains(url)) {
				list.add(url);
			}
		}
		System.out.println("误判数量：" + list.size());

	}
	public SimpleBloomFilterTest() {
		for (int i = 0; i < seeds.length; i++) {
			func[i] = new SimpleHash(DEFAULT_SIZE, seeds[i]);
		}
	}
	/**
	 * 向布隆过滤器添加元素
	 * @param value
	 */
	public void add(String value) {
		for (SimpleHash f : func) {
			bits.set(f.hash(value), true);
		}
	}
	/**
	 * 判断某元素是否存在布隆过滤器
	 * @param value
	 * @return
	 */
	public boolean contains(String value) {
		if (value == null) {
			return false;
		}
		boolean ret = true;
		for (SimpleHash f : func) {
			ret = ret && bits.get(f.hash(value));
		}
		return ret;
	}

	/**
	 * 哈希函数
	 */
	public static class SimpleHash {
		private int cap;
		private int seed;
		public SimpleHash(int cap, int seed) {
			this.cap = cap;
			this.seed = seed;
		}
		public int hash(String value) {
			int result = 0;
			int len = value.length();
			for (int i = 0; i < len; i++) {
				result = seed * result + value.charAt(i);
			}
			return (cap - 1) & result;
		}
	}
}
