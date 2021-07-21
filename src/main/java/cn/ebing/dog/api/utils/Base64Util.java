package cn.ebing.dog.api.utils;

import java.net.URLEncoder;

/**
 * @Author qhb
 * @Date 2021/7/15 9:12 上午
 * @Version 1.0
 */
public class Base64Util {

//    public static String base64(String text) {
//        final BASE64Encoder encoder = new BASE64Encoder();
//        final BASE64Decoder decoder = new BASE64Decoder();
//        byte[] textByte = null;
//        try{
//            textByte = text.getBytes("UTF-8");
//        } catch (Exception e) {
//
//        }
////编码
//        return encoder.encode(textByte);
//    }

    public static String url(String text) {
        return URLEncoder.encode(text);
    }


  public static void main(String[] args) {
    // String a = base64("[{a: 1.00}]'");
    String b = url("[{\"a\": \"1.00\"}]");
      System.out.println(b);
  }
}
