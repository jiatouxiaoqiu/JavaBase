package cn.ebing.dog.api.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author qhb
 * @Date 2021/8/20 5:13 下午
 * @Version 1.0
 */
public class EventTest {
  public static void main(String[] args) {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config0.class);
      //获取用户注册服务
      UserRegisterService userRegisterService = context.getBean(UserRegisterService.class);
      //模拟用户注册
      userRegisterService.registerUser("QHB");
  }
}
