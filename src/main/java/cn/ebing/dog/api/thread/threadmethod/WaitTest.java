package cn.ebing.dog.api.thread.threadmethod;

import java.util.ArrayList;
import java.util.List;

/**
 * 首先，它们都是Object类中的方法。需要配合 Synchronized关键字来使用。
 * 调用线程的wait方法会使当前线程等待，直到其它线程调用此对象的notify/notifyAll方法。如果，当前对象锁有N个线程在等待，则notify方法会随机唤醒其中一个线程，而notifyAll会唤醒对象锁中所有的线程。需要注意，唤醒时，不会立马释放锁，只有当前线程执行完之后，才会把锁释放。
 * 另外，wait方法和sleep方法不同之处，在于sleep方法不会释放锁，而wait方法会释放锁。
 * yield方法和sleep方法一样，也是不释放锁资源的
 */

/**
 * 以上，就是创建一个t2线程，判断list长度是否为5，不是的话，就一直阻塞。
 * 然后，另外一个t1线程不停的向list中添加元素，当元素长度为5的时候，就去唤醒阻塞中的t2线程。
 * 然而，我们会发现，此时的t1线程会继续往下执行。直到方法执行完毕，才会把锁释放。t1线程去唤醒t2的时候，只是让t2具有参与锁竞争的资格。
 * 只有t2真正获得了锁之后才会继续往下执行。
 */
public class WaitTest {

	private static Object obj = new Object();

	/**
	 * 当调用 Thread.sleep(long millis) 睡眠方法时，就会使当前线程进入阻塞状态。
	 * millis参数指定了线程睡眠的时间，单位是毫秒。当时间结束之后，线程会重新进入就绪状态。
	 * 如果当前线程获得了一把同步锁，则 sleep方法阻塞期间，是不会释放锁的。
	 *
	 */
	public static void main(String[] args) throws InterruptedException {
		ListAdd listAdd = new ListAdd();

		Thread t1 = new Thread(() -> {
			synchronized (obj){
				try {
					for (int i = 0; i < 10; i++) {
						listAdd.add();
						System.out.println("当前线程:"+Thread.currentThread().getName()+"添加了一个元素");
						Thread.sleep(300);
						if(listAdd.getSize() == 5){
							System.out.println("发出通知");
							obj.notify();
						}
					}
				} catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(() -> {
			synchronized (obj){
				try {
					if(listAdd.getSize() != 5){
						obj.wait();
					}
				} catch(InterruptedException e){
					e.printStackTrace();
				}
				System.out.println("线程:"+Thread.currentThread().getName()+"被通知.");
			}

		});

		t2.start();
		Thread.sleep(1000);
		t1.start();
	}
}

class ListAdd {
	private static volatile List<String> list = new ArrayList<>();

	public void add() {
		list.add("abc");
	}

	public int getSize() {
		return list.size();
	}
}