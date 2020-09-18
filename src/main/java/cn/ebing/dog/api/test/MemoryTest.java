package cn.ebing.dog.api.test;

public class MemoryTest {
	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		System.out.println("runtime.freeMemory()" + runtime.freeMemory());
		System.out.println("runtime.totalMemory()" + runtime.totalMemory());
	}
}
