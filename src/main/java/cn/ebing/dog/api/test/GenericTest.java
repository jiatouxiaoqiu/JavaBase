package cn.ebing.dog.api.test;

import java.util.ArrayList;
import java.util.List;

class Fruit{
    public int getWeigth(){
        return 0;
    }
}
//Apple是水果Fruit类的子类
class Apple extends Fruit {
    @Override
    public int getWeigth(){
        return 5;
    }
}

public class GenericTest {

    //数组的传参
    static int sumWeigth(Fruit[] fruits) {
        int weight = 0;
        for (Fruit fruit : fruits) {
            weight += fruit.getWeigth();
        }
        return weight;
    }

    static int sumWeight1(List<? extends Fruit> fruits) {
        int weight = 0;
        for (Fruit fruit : fruits) {
            weight += fruit.getWeigth();
        }
        return weight;
    }
    static  int sumWeigth2(List<Fruit> fruits){
        int weight = 0;
        for (Fruit fruit : fruits) {
            weight += fruit.getWeigth();
        }
        return weight;
    }

    public static void main(String[] args) {
        //报错，List<?>不能添加任何类型
//        List<?> list3 = new ArrayList<>();
//        list3.add(666);


//        Fruit[]与Apple[]是兼容的。
// List<Fruit>与List<Apple>不兼容的，集合List是不能协变的，会报错，
// List<Fruit>与List<?  extends Fruits> 是OK的
        Fruit[] fruits = new Apple[10];
        sumWeigth(fruits);
        List<Apple> apples = new ArrayList<>();
        sumWeight1(apples);
        //报错
//        sumWeigth2(apples);

        // Java泛型在编译期完成，它是依赖编译器实现的, 类型擦除
        Class c1 = new ArrayList<Integer>().getClass();
        Class c2 = new ArrayList<String>().getClass();
        System.out.println(c1 == c2); // true
    }
}
