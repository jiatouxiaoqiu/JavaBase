package cn.ebing.dog.api.thread;

import sun.security.ec.CurveDB;

import java.net.URL;
import java.security.Provider;

public class ClassLoaderTest {
  public static void main(String[] args) {
      URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
      for (URL url: urls) {
          System.out.println("url ->" + url);
      }
      // Bootstrap so is null
      ClassLoader classLoader = Provider.class.getClassLoader();
      System.out.println("classLoader ->" + classLoader);

      String extDirs = System.getProperty("java.ext.dirs");
      for (String dir: extDirs.split(";")) {
          System.out.println("dir ->" + dir);
      }

      ClassLoader classLoader2 = CurveDB.class.getClassLoader();
      // sun.misc.Launcher$ExtClassLoader@232204a1 扩展类加载器
      System.out.println("classLoader2 -> " + classLoader2);
  }
}