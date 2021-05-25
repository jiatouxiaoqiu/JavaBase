package cn.ebing.dog.api.test.proxy;

public class HelloWorldImpl implements HelloWorld {
    @Override
    public void sayHello() {
        System.out.print("hello world");
    }
}
