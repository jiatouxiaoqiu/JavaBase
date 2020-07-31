package cn.ebing.dog.api.utils.sort;

/**
 * 睡眠排序
 * 优化方案：还可以起多线程，时间复杂度取决于最大的那个值。。
 * 你粗克
 */
public class SleepSort {

	public static void main(String[] args) {
		int[] nums = new int[]{1, 3, 4, 8, 5, 2, 6};
		for(int i=0; i<nums.length; i++) {
			sortLikeGod(nums[i]);
		}
	}

	private static void sortLikeGod(final int num) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(num);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(num);
			}
		}).start();
	}
}
