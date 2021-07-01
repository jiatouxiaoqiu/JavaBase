package cn.ebing.dog.api;


import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author qhb
 * @Date 2021/7/1 11:11 上午
 * @Version 1.0
 * 泛型擦除，泛型研究:不过JDK依然提供了一个技巧让我们可以获得泛型的具体类型。
 */
public class GenericTest {
    /**
     * 虽然泛型会在字节码编译过程中被擦除，但是Class对象会通过java.lang.reflect.Type记录其实现的接口和继承的父类信息。
     * {@link java.lang.reflect.Type }
     */
    private static void generic() {
        ArrayList<String> strings = new ArrayList<>();
        Type genericSuperclass = strings.getClass().getGenericSuperclass();
        /**
         * 第一步
         */
        // 泛型的占位符E, E的具体类型，也就是String。这个拿不到
        System.out.println("genericSuperclass = " + genericSuperclass);
        /**
         * 第二步，看具体 Type 的实现，都是实现类，然后一个个比对
         */
        // ParameterizedType 用来描述参数化类型。
         System.out.println(genericSuperclass instanceof ParameterizedType); // true
        System.out.println( genericSuperclass instanceof Class); // false
        System.out.println( genericSuperclass instanceof WildcardType); // false
        System.out.println( genericSuperclass instanceof GenericArrayType); // false
        /**
         * 第三步，对 ParameterizedType 做具体探究
         */
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        // [E]
        System.out.println("actualTypeArguments = " + Arrays.toString(actualTypeArguments));
        /**
         * 大括号{}就可以：1、重写实现父类的方法。2、指定父类的泛型具体类型。
         *
         * 我们可以借助这一特性来获取父类的具体泛型类型，我们还拿ArrayList来试试：
         * */
        ArrayList<String> string = new ArrayList<String>(){};
        Type genericSuperclass2 = string.getClass().getGenericSuperclass();
        // 泛型的占位符E, E的具体类型，也就是String。这个拿不到
        System.out.println("genericSuperclass2 = " + genericSuperclass2);
        /**
         * ParameterizedTypeReference 这就是上面的实现
         * 参考 RestTemplate 就是用了 ParameterizedTypeReference 这个特性来获得实际的返回值，所以泛型擦除之后也不慌~
         */
  }

  public static void main(String[] args) {
      generic();
  }
}
