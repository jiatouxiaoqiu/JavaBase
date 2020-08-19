package cn.ebing.dog.api.thread.threadmethod;

/**
 * 因为，我们知道，正常情况下，调用start方法之后，是不能控制线程的执行顺序的
 * 最终，我们会看到，线程会按照t1，t2，t3顺序执行。因为，主线程main总会等调用join方法的那个线程执行完之后，才会往下执行。
 */
public class TestJoin {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new MultiT("a"));
		Thread t2 = new Thread(new MultiT("b"));
		Thread t3 = new Thread(new MultiT("c"));

		t1.start();
		t1.join();

		t2.start();
		t2.join();

		t3.start();
		t3.join();
	}

}

class MultiT implements Runnable{
	private String s;
	private int i;

	public MultiT(String s){
		this.s = s;
	}

	@Override
	public void run() {
		while(i<10){
			System.out.println(s+"===="+i++);
		}
	}
}