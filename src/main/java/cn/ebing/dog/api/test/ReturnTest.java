package cn.ebing.dog.api.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author qhb
 * @Date 2021/7/20 8:02 下午
 * @Version 1.0
 */
public class ReturnTest {
    public static void main(String[] args) {
        //System.out.print(method(0));
        //System.out.print(calc(10));
//        int i = 10;
//        while (i>0) {
//            thread();
//            System.out.println("");
//            i--;
//        }
        //hash();
        //booleanTest();
        byteLength();
    }

    public static void byteLength() {
        char[] chars = "没人比我更懂java".toCharArray();
        System.out.println(chars.length);
    }

    public static void booleanTest() {
        String s = new String(new char[] {'没','人','比','我','更','懂','j','a','v','a'});
        String si = "没人比我更懂java";
        System.out.println(s == si);
        System.out.println(s.intern() == "没人比我更懂java");
        System.out.println(s == si.intern());
    }

    public static void hash() {
        Map<String, Object> map = new HashMap<>();
        String str = "没人比我更懂java";
        StrObject obj = new StrObject("没人比我更懂java");
        map.put("str", str);
        map.put("obj", obj);

        str = "真的没人比我更懂java";
        System.out.printf(map.get("str").toString()+"; ");

        StrObject new_obj = (StrObject) map.get("obj");
        new_obj.setStr("真的没人比我更懂java");
        System.out.printf(map.get("obj").toString()+"; ");
    }

    static class StrObject {
        String str;
        public StrObject(String str){
            this.str = str;
        }
        public void setStr(String str){
            this.str = str;
        }
        @Override
        public String toString() {
            return str;
        }
    }


    public static void thread() {
        Thread t = new Thread() {
            @Override
            public void run() {
                cnn();
            }
        };

        t.run();
        System.out.print("FakeNews ");
        System.out.print("; ");
//        t.start();
//        System.out.print("FakeNews ");
    }
    static void cnn() {
        System.out.print("CNN ");
    }

    private static Integer method(Integer i){
        try{
            if(i++ > 0)
                throw new IOException();
            return i++;
        } catch (IOException e){
            i++;
            return i++;
        } catch (Exception e){
            i++;
            return i++;
        } finally {
            return i++;
        }
    }

  public static int calc(int n) {
    try {
      n += 1;
      if (n / 0 > 0) {
        n += 1;
      } else {
        n -= 10;
      }
      return n;
    } catch (Exception e) {
      n++;
    }
    n++;
    return n++;
 }
}
