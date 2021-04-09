package cn.ebing.dog.api.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * 1、需要多线程执行，才能碰到句柄被占用吧
 * 2、file FileOutputStream wirte 为什么不是 append ？之前的数据怎么办？
 */
public class TryCatchFinally {
    public static void copyFileNoClose(String src, String dst, Integer waitTimeSecond) {
        try {
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dst);
            try{
                Thread.sleep(waitTimeSecond * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            byte[] buff = new byte[1024];
            int n;
            while ((n = in.read(buff)) >= 0) {
                out.write(buff, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendFile(String src, String content) {
        File file = new File(src);
        byte[] b = content.getBytes();
        OutputStream out = null;
        try {
            out = new FileOutputStream(file);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        //写入
        try {
            out.write(b);
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            try{
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

  public static void main(String[] args) {
        String sourceFilePath = "/Users/mx/Desktop/a.js";
//      ThreadPoolTaskExecutor executor = ExecutorsTest.buildThreadPoolTaskExecutor();
      ExecutorService executor = Executors.newFixedThreadPool(10);

      System.out.println("1");
      Runnable copyRunnable = () -> {
        copyFileNoClose(sourceFilePath, "/Users/mx/Desktop/b.js", 20);
      };
      System.out.println("2");
      Runnable writeRunnable = () -> {
          appendFile(sourceFilePath, "new_content");
      };
      System.out.println("3");
      Future<?> copyFuture = executor.submit(copyRunnable);
      System.out.println("4");
      try{
          copyFuture.get();
          System.out.println("5");
      } catch (Exception e) {
          e.printStackTrace();
      }
      executor.execute(writeRunnable);
      /**
       * 线程池要关闭，shutdown 才跑完，不然的话，main 跑完了，但是整个工程没完成。
       */
//      executor.shutdown();
      System.out.println("6");
  }

}
