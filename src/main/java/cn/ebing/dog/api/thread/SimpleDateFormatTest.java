//package cn.ebing.dog.api.thread;
//
//import com.google.common.util.concurrent.ThreadFactoryBuilder;
//
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.ThreadFactory;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
///**
// * 如何解决 SimpleDateFormat 的线程安全问题
// * 1、使用局部变量
// * 2、加同步锁
// * 3 使用 ThreadLocal
// * 4 DateTimeFormatter,java8 里面的线程安全类
// *
// * 所以，当我们要表示日期的时候，一定要使用 yyyy-MM-dd 而不是 YYYY-MM- dd ，这两者的返回结果大多数情况下都一样，但是极端情况就会有问题了。
// */
//public class SimpleDateFormatTest {
//    /*** 定义一个全局的 SimpleDateFormat */
//    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss");
//
//    private static ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>() {
//        @Override
//        protected SimpleDateFormat initialValue() {
//            return new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss");
//        }
//    };
//    private static ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal2 = ThreadLocal.withInitial(
//            () -> new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss")
//    );
//
//
//
//    /*** 使用 ThreadFactoryBuilder 定义一个线程池 */
//    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
//            .setNameFormat("demo-pool-%d")
//            .build();
//    private static ExecutorService pool = new ThreadPoolExecutor(
//            5, 200, 0L, TimeUnit.MILLISECONDS,
//            new LinkedBlockingQueue<>(1024),
//            namedThreadFactory,
//            new ThreadPoolExecutor.AbortPolicy()
//    );
//
//    /*** 定义一个 CountDownLatch，保证所有子线程执行完之后主线程再执行 */
//    private static CountDownLatch countDownLatch = new CountDownLatch(100);
//
//    public static void main(String[] args) {
//        //定义一个线程安全的 HashSet
//        Set<String> dates = Collections.synchronizedSet(new HashSet<String>());
//
//        for (int i = 0; i < 100; i++) {
//            //获取当前时间
//            Calendar calendar = Calendar.getInstance();
//            /**
//             * 1 使用局部变量
//             */
//            // SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss");
//            int finalI = i;
//            pool.execute(() -> {
//                /**
//                 * 2 加同步锁
//                 */
////                synchronized (simpleDateFormat) {
////                    calendar.add(Calendar.DATE, finalI);
////                    //通过 simpleDateFormat 把时间转换成字符串
////                    String dateString = simpleDateFormat.format(calendar.getTime());
////                    //把字符串放入 Set 中
////                    dates.add(dateString);
////                    // countDown
////                    countDownLatch.countDown();
////                }
//
//                calendar.add(Calendar.DATE, finalI);
//                //通过 simpleDateFormat 把时间转换成字符串
//                String dateString = simpleDateFormatThreadLocal2.get().format(calendar.getTime());
//                //把字符串放入 Set 中
//                dates.add(dateString);
//                // countDown
//                countDownLatch.countDown();
//            });
//        }
//
//        try{
//            countDownLatch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(dates.size());
//    }
//}
