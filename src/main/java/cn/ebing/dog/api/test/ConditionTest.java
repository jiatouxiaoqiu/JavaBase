package cn.ebing.dog.api.test;

/**
 * @Author qhb @Date 2021/8/8 4:10 下午 @Version 1.0
 *
 * <p>Q: Condition 和 AQS 有什么关系？
 *
 * <p>A: Condition 是基于 AQS 实现的，Condition 的实现类 ConditionObject 是 AQS 的一个内部类，在里面共用了一部分 AQS 的逻辑。
 *
 * <p>Q: Condition 的实现原理是什么？
 *
 * <p>A: Condition 内部维护一个条件队列，在获取锁的情况下，线程调用 await，线程会被放置在条件队列中并被阻塞。直到调用 signal、signalAll
 * 唤醒线程，此后线程唤醒，会放入到 AQS 的同步队列，参与争抢锁资源。
 *
 * <p>Q: Condition 的等待队列和 AQS 的同步队列有什么区别和联系？
 *
 * <p>A: Condition 的等待队列是单向链表，AQS 的是双向链表。二者之间并没有什么明确的联系。仅仅在节点从阻塞状态被唤醒后，会从等待队列挪到同步队列中。
 */
public class ConditionTest {}
