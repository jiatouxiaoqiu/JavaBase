package cn.ebing.dog.api.utils.queue;

public class QueueTest {
	public static void main(String[] args) {
        arrayQueue();
        linkQueue();
        circularQueue();
        priorityQueue();
		doubleEndsQueue();
	}

	public static void arrayQueue(){
		ArrayQueue queue = new ArrayQueue(20);
		for (int i = 0;i<30;i++){
			System.out.println("arrayQueue 入队操作："+ queue.enqueue("数据"+(i+1)));
		}

		for (int i = 0;i<30;i++){
			System.out.println("arrayQueue 出队操作："+ queue.dequeue());
		}
	}

	public static void linkQueue(){
		LinkQueue queue = new LinkQueue();
		for (int i = 0;i<30;i++){
			System.out.println("linkQueue 入队操作："+ queue.enqueue("数据"+(i+1)));
		}

		for (int i = 0;i<30;i++){
			System.out.println("linkQueue 出队操作："+ queue.dequeue());
		}
	}

	public static void circularQueue(){
		CircularQueue queue = new CircularQueue(20);
		for (int i = 0;i<30;i++){
			System.out.println(i+"circularQueue  环形队列入队操作："+ queue.enqueue("数据"+(i+1)));;
		}

		for (int i = 0;i<30;i++){
			System.out.println(i+"circularQueue 环形队列出队操作："+ queue.dequeue());;
		}
	}

	private static void priorityQueue(){
		PriorityQueue queue = new PriorityQueue(10);
		queue.enqueue(60);
		queue.enqueue(30);
		queue.enqueue(50);
		queue.enqueue(10);
		queue.enqueue(70);
		Integer[] items = queue.getItems();
		for (int i = 0;i<items.length;i++){
			System.out.println("priorityQueue" + items[i]);
		}
	}

	private static void doubleEndsQueue(){
		DoubleEndsQueue queue = new DoubleEndsQueue();
		queue.enqueueFirst("1111");
		queue.enqueueFirst("3333");
		queue.enqueueLast("2222");
		queue.enqueueLast("4444");
		System.out.println("doubleEndsQueue" + queue.dequeueFirst());
		System.out.println("doubleEndsQueue" + queue.dequeueLast());
		queue.displayAll();
	}
}
