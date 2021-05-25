package cn.ebing.dog.api.algorithm;

public class RingQueue {
        private int size;
        private int front;
        private int rear;
        private int[] array;

        public RingQueue(int arraySize) {
            size = arraySize;
            array = new int[size];
            front = 0;
            rear = 0;
        }

        public boolean isFull() {
            return (rear + 1) % size == front;
        }

        public boolean isEmpty() {
            return rear == front;
        }

        public void addQueue(int n){
            if(isFull()) {
                System.out.println("队列已满~");
                return;
            }
            array[rear] = n;
            rear = (rear + 1) % size;
        }

        public int getQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列空，不能取数据");
            }

            int value = array[front];
            front = (front + 1) % size;
            return value;
        }

        public void showQueue(){
            if(isEmpty()) {
                System.out.println("队列空");
                return;
            }
            for(int i = front; i<front+getSize(); i++){
                System.out.println("showQueue: "+ array[i % size]);
            }
        }

        public int getSize(){
            return (rear + size - front) % size;
        }

    public static void main(String[] args) {
        RingQueue ringQueue = new RingQueue(4);
        
        ringQueue.addQueue(1);
        ringQueue.addQueue(3);
        ringQueue.addQueue(2);
        ringQueue.addQueue(8);
        ringQueue.addQueue(11);


        System.out.println("getSize: " + ringQueue.getSize());
        System.out.println("======");
        ringQueue.showQueue();
        System.out.println("======");
        System.out.println("getQueue: " + ringQueue.getQueue());
        System.out.println("getQueue: " + ringQueue.getQueue());

        System.out.println("getSize: " + ringQueue.getSize());
        System.out.println("======");
        ringQueue.showQueue();

        /**
         * 使用快慢指针，快指针每次走2步，慢指针每次走1步，如果快指针追上了慢指针，则说明存在环
         */
//        public boolean hasCycle(ListNode head) {
//            if (head == null || head.next == null) {
//                return false;
//            }
//
//            ListNode fast = head;
//            ListNode slow = head;
//            while (fast != null && fast.next != null) {
//                fast = fast.next.next;
//                slow = slow.next;
//                if (fast == slow) {
//                    return true;
//                }
//            }
//
//            return false;
//        }
    }
}
