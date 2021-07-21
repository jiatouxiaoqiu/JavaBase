package cn.ebing.dog.api.test;

/**
 * @Author qhb
 * @Date 2021/7/20 8:28 下午
 * @Version 1.0
 */
public class Fake {

    class Inner {
        public String  v1 = "Fake News";
        public String v2 = "Go ahead";
    }

    private static String GetVal() {
        try {
            return Inner.class.newInstance().v1;
        } catch (Exception e) {
            try {
                return Inner.class.getDeclaredConstructor(Fake.class).newInstance((Fake)null).v2;
            } catch (Exception ee) {
                ee.printStackTrace();
                return "Fake News, Go ahead";
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(GetVal());
    }
}
