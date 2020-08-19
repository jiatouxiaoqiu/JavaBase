package cn.ebing.dog.api.thread.threadmethod;

public class TestFlag {
	static volatile boolean flag = true;

	public static void main(String[] args) throws InterruptedException {

		Thread t = new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("线程中断标志:"+Thread.currentThread().isInterrupted());
				while (flag){

				}
				System.out.println("标志flag为:" + flag);
				System.out.println("线程中断标志:"+Thread.currentThread().isInterrupted());
				System.out.println("我还在继续执行");
			}
		});

		t.start();
		Thread.sleep(100);
		flag = false;
		t.interrupt();
	}
}