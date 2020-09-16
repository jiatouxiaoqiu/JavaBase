package cn.ebing.dog.api.test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MXBeanDemo {
	/**
	 * 此外，如果使用的IDE是IDEA 直接运行会多一个Monitor Ctrl-break线程，这个是IDE的原因。debug模式下不会有这个线程。
	 */
	public static void main(String[] args) {
		System.out.println("below is thread info:");
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		long[] threadIds = threadMXBean.getAllThreadIds();
		ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(threadIds);
		for (ThreadInfo threadInfo : threadInfos) {
			System.out.println(threadInfo.getThreadId()+": "+threadInfo.getThreadName());
		}
		System.out.println("-----------------");
		System.out.println("hello world");
		ThreadGroup group = Thread.currentThread().getThreadGroup();
		ThreadGroup topGroup = group;
		while (group != null) {
			topGroup = group;
			group = group.getParent();
		}
		int nowThreads = topGroup.activeCount();
		Thread[] lstThreads = new Thread[nowThreads];
		topGroup.enumerate(lstThreads);
		for (int i = 0; i < nowThreads; i++) {
			System.out.println("线程number：" + (i+1) + " = " + lstThreads[i].getName());
		}
	}
}
