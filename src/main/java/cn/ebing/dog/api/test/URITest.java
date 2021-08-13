package cn.ebing.dog.api.test;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Author qhb
 * @Date 2021/8/9 5:21 下午
 * @Version 1.0
 */
public class URITest {
  public static void main(String[] args) {
    String s = "https://cn.bing.com/search?q=Redis&form=QBLH&sp=-1&pq=redis&sc=8-5&qs=n&sk=&cvid=C4BF3AE94022484889BB8FE16F4EDB14";
      String encode = URLEncoder.encode(s);
      String decode = URLDecoder.decode(encode);
      System.out.println("result  " + decode.equals(s));
  }
}
