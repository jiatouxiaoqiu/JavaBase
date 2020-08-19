package cn.ebing.dog.api.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FutureCook {
	static class Chuju {}
	static class Shicai {}

	public static void cook(Chuju chuju, Shicai shicai) {
		System.out.println("success");
	}

	public static void main(String[] args) {
		Callable<Chuju> shoppingFuture = new Callable<Chuju>() {
			@Override
			public Chuju call() throws Exception {
				System.out.println("第一步:下单");
				System.out.println("第一步:等待送货");
				Thread.sleep(5000); //模拟送货时间
				System.out.println("第一步:快递送到");
				return new Chuju();
			}
		};

		FutureTask<Chuju> task = new FutureTask<Chuju>(shoppingFuture);
		new Thread(task).start();

		//第二步,购买食材
		try {
			Thread.sleep(2000);
		} catch (Exception e) {

		}
		Shicai shicai = new Shicai();
		System.out.println("第二步:食材到位");
		if(!task.isDone()){ //是否厨具到位
			System.out.println("第三步:厨具还没到,请等待,也可以取消");
        }
		try {
			Chuju chuju = task.get();
			System.out.println("第三步:厨具到位,可以烹饪了");
			cook(chuju,shicai);
		} catch (Exception e) {

		}
	}
}
