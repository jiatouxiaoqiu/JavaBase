package cn.ebing.dog.api.thread;

class DeadThread {
    static {
        if (true) {
            System.out.println(Thread.currentThread().getName() + "初始化");
            while (true) {}
        }
    }
}

public class DeadThreadTest {

    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + "START");
            DeadThread deadThread = new DeadThread();
            System.out.println(Thread.currentThread().getName() + "END");
        };

        Thread t1 = new Thread(r, "a");
        Thread t2 = new Thread(r, "b");
        t1.start();
        t2.start();
    }
}
