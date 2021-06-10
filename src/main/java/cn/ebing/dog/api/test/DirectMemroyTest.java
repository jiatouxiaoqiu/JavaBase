package cn.ebing.dog.api.test;

import java.nio.ByteBuffer;

/**
 * @Author qhb
 * @Date 2021/6/1 9:15 上午
 * @Version 1.0
 */
public class DirectMemroyTest {
  public static void main(String[] args) {
      ByteBuffer buffer = ByteBuffer.allocateDirect(1000);
  }
}
