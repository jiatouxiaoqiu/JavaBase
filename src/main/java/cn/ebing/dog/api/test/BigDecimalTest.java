package cn.ebing.dog.api.test;

import java.math.BigDecimal;

public class BigDecimalTest {
	public static void main(String[] args) {
		/**
		 * 居然全部都是 true
		 */
		BigDecimal b1 = new BigDecimal(1.0);
		BigDecimal b2 = new BigDecimal(1);
		BigDecimal b3 = new BigDecimal(1.00);
		System.out.println("b1 b2" + b1.equals(b2));
		System.out.println("b1 b3" + b1.equals(b3));
		System.out.println("b2 b3" + b2.equals(b3));

		BigDecimal b4 = new BigDecimal(0.1);
		BigDecimal b5 = new BigDecimal(0.10);
		System.out.println("b4 b5" + b4.equals(b5));

		/**
		 * string 要注意
		 */
		BigDecimal b6 = new BigDecimal("1");
		BigDecimal b7 = new BigDecimal("1.0");
		System.out.println("b6 b7" + b6.equals(b7) + b6.compareTo(b7));
	}
}
