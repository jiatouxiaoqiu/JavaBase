package cn.ebing.dog.api.test;

import java.math.BigInteger;

/**
 * @Author qhb
 * @Date 2021/6/23 10:47 上午
 * @Version 1.0
 */
public class Big {
  public static void main(String[] args) {
      BigInteger n = new BigInteger("999999").pow(99);
      float f = n.floatValue();
      /**
       * Infinity 结果是这个，无穷大。
       * 大数，也就是比 Long 还大的数字，底层是 int[]
       * 还可以和 {@link java.math.BigDecimal } 做比较看看
       */
      System.out.println(f);
  }
}
