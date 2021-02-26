package cn.ebing.dog.api.utils.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class NIO {
  public static void readFile(String pathname) {
        FileInputStream fin = null;
        try {
          fin = new FileInputStream(new File(pathname));
          FileChannel channel = fin.getChannel();
          int capacity = 100;
          ByteBuffer bf = ByteBuffer.allocate(capacity);
          System.out.println("限制是：" + bf.limit() + "容量是：" + bf.capacity() + "位置是：" + bf.position());
          int length = -1;
          while ((length = channel.read(bf)) != -1) {
            bf.clear();
            byte[] bytes = bf.array();
            System.out.write(bytes, 0, length);
            System.out.println();// 可以空一行
            System.out.println("限制是-1：" + bf.limit() + "容量是：" + bf.capacity() + "位置是：" + bf.position());
          }
            channel.close();
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        } finally {
          if (fin != null) {
            try {
              fin.close();
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
        }
  }

    public static void writeFile(String filename) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File(filename));
            FileChannel channel = fos.getChannel();
            ByteBuffer src = Charset.forName("utf8").encode("你好你好你好你好你好");
            System.out.println("初始化容量和 limit：" + src.capacity() + "," + src.limit());
            int length = 0;
            while ((length = channel.write(src)) != 0) {
                System.out.println("写入长度:" + length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filepath = "/Users/mx/Documents/java/dog_api/src/main/java/cn/ebing/dog/api/utils/io/nio.text";
        writeFile(filepath);
        readFile(filepath);
    }
}
