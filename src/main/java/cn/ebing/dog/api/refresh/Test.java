package cn.ebing.dog.api.refresh;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @Author qhb
 * @Date 2021/8/20 4:22 下午
 * @Version 1.0
 */
public class Test {
  public static void main(String[] args) {
      try{
          test();
      } catch (Exception e) {
          e.printStackTrace();
      }
  }

    public static void test() throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getBeanFactory().registerScope(BeanRefreshScope.SCOPE_REFRESH, BeanRefreshScope.getInstance());
        context.register(MainConfig4.class);
        //刷新mail的配置到Environment,第一次 uuid 出现在这里
        RefreshConfigUtil.refreshMailPropertySource(context);
        context.refresh();

        MailService mailService = context.getBean(MailService.class);
        System.out.println("配置未更新的情况下,输出3次");
        for (int i = 0; i < 3; i++) { //@1
            System.out.println(mailService);
            TimeUnit.MILLISECONDS.sleep(200);
        }

        System.out.println("模拟3次更新配置效果");
        for (int i = 0; i < 3; i++) { //@2
            /**
             * update 更新 uuid
             */
            RefreshConfigUtil.updateDbConfig(context); //@3
            System.out.println(mailService);
            TimeUnit.MILLISECONDS.sleep(200);
        }
    }
}
