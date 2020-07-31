package cn.ebing.dog.api.utils.stack;

public class StackTest {
	public static void main(String[] args) {
        arrayStackTest();
		linkStackTest();
	}

	public static void arrayStackTest(){
		ArrayStack arrayStack = new ArrayStack(10);
		for (int i = 0;i<20;i++) {
			System.out.println(arrayStack.push("李四"+i));
		}
		for (int i = 0;i<20;i++) {
			System.out.println(arrayStack.pop());
		}
		System.out.println("arrayStackTest 完成");
	}

	public static void linkStackTest(){
		LinkStack linkStack = new LinkStack();
		for (int i = 0;i<20;i++) {
			System.out.println(linkStack.push("张三"+i));
		}
		for (int i = 0;i<20;i++) {
			System.out.println(linkStack.pop());
		}
	}
}
