package cn.ebing.dog.api.test.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object intercept = methodProxy.invokeSuper(o, objects); // 注意这里调用的是methodProxy.invokeSuper
        System.out.println("中介：该房源已发布！");
        return intercept;
    }
}
