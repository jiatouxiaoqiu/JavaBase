//package cn.ebing.dog.api.thread;
//
//import java.util.Scanner;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * 对于线程同步的问题，通过前面的学习，实际上有三种方式可以实现。分别是：
// *
// * <p>synchronized + wait + notify/notifyAll ReentrantLock + Condation:await/signal LockSupport:park
// * / unpark 以上三种方式都可以实现同步，我们可以根据实际需求可以选择合适的方式来实现。
// */
//public class ThreeThreadTest {
//
//    private static final ReentrantLock lock = new ReentrantLock();
//
//    private static final Condition con1 = lock.newCondition();
//    private static final Condition con2 = lock.newCondition();
//    private static final Condition con3 = lock.newCondition();
//
//    private static int count = 0;
//
//    public static void main(String[] args) throws InterruptedException{
//        Thread t1 = new Thread(() -> {
//            lock.lock();
//            try {
//                while (true) {
//                    if((count%3) == 0) {
//                        System.out.println(Thread.currentThread().getName()+":A");
//                        TimeUnit.MILLISECONDS.sleep(500);
//                        con2.signal();
//                        count ++;
//                    }else {
//                        con1.await();
//                    }
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }finally {
//                lock.unlock();
//            }
//        }, "t1");
//        Thread t2 = new Thread(() -> {
//            lock.lock();
//            try {
//                while (true) {
//                    if((count%3) == 1) {
//                        System.out.println(Thread.currentThread().getName()+":L");
//                        TimeUnit.MILLISECONDS.sleep(500);
//                        con3.signal();
//                        count ++;
//                    }else {
//                        con2.await();
//                    }
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }finally {
//                lock.unlock();
//            }
//        });
//        Thread t3 = new Thread(() -> {
//            lock.lock();
//            try {
//                while (true) {
//                    if((count%3) == 2) {
//                        System.out.println(Thread.currentThread().getName()+":I");
//                        TimeUnit.MILLISECONDS.sleep(500);
//                        con1.signal();
//                        count ++;
//                    }else {
//                        con3.await();
//                    }
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }finally {
//                lock.unlock();
//            }
//        });
//
//        t1.setDaemon(true);
//        t2.setDaemon(true);
//        t3.setDaemon(true);
//
//        t1.start();
//        TimeUnit.MILLISECONDS.sleep(100);
//        t2.start();
//        TimeUnit.MILLISECONDS.sleep(100);
//        t3.start();
//
//        Scanner scan = new Scanner(System.in);
//        String input;
//        do{
//            input = scan.next();
//        }while (input == null);
//        System.out.println("exit");
//    }
//}