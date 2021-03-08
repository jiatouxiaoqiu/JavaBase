package cn.ebing.dog.api.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 已知一个业务查询操作涉及 3 个 RPC 服务调用 : query1, query2, query3, 其中
 * query1 耗时约 1 秒， query2 耗时约 0.5 秒，query3 耗时约 0.6 秒，且 query3
 * 查询条件依赖 query2 的查询结果，
 * 请编写代码，使该业务查询总体耗时最小。
 *
 */
public class SomeRPC {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(2);
        Long s = System.currentTimeMillis();
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1000);
                    countDownLatch.countDown();
                    System.out.println(Thread.currentThread().getName()+"执行结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"query1").start();

        Thread query2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                    System.out.println(Thread.currentThread().getName()+"执行结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "query2");
        query2.start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    query2.join();
                    Thread.sleep(600);
                    System.out.println(Thread.currentThread().getName()+"执行结束");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"query3").start();


        try {
            countDownLatch.await();
            System.out.println("请求结束 耗时 "+(System.currentTimeMillis()-s)+" ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

