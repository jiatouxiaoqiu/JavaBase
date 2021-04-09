package cn.ebing.dog.api.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 什么都可以 copy，牛逼
 * 当一个外部资源的句柄对象（比如FileInputStream对象）实现了AutoCloseable接口
 * 都说IO流用完了要关闭，不关闭会占据系统资源，文件句柄、端口、数据库连接。
 */
public class TryWithResources {
    public static void copyFile(String src, String dst) {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buff = new byte[1024];
            int n;
            while ((n = in.read(buff)) >= 0) {
                out.write(buff, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  public static void main(String[] args) {
      copyFile("/Users/mx/Desktop/a.pdf", "/Users/mx/Desktop/b.pdf");
  }
}
