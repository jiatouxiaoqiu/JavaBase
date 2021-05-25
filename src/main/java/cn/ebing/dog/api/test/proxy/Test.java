package cn.ebing.dog.api.test.proxy;

import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) throws Exception {
        // 传入三大参数，就能够创建出一个代理对象
        HelloWorld helloWorld = (HelloWorld) Proxy.newProxyInstance(
                Test.class.getClassLoader(),
                new Class<?>[]{HelloWorld.class},
                new MyInvocationHandler(new HelloWorldImpl())); //此处目标实现为HelloworldImpl
        helloWorld.sayHello();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloWorldImpl.class); // 注意此处的类型必须是实体类
        enhancer.setCallback(new MyMethodInterceptor());

        HelloWorldImpl helloService = (HelloWorldImpl) enhancer.create();
        helloService.sayHello();
    }
}
