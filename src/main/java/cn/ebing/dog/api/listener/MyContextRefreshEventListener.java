package cn.ebing.dog.api.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Author qhb
 * @Date 2021/6/23 9:23 上午
 * @Version 1.0
 *
 * 这种情况，是我们误读了 ContextStartedEvent，在 springboot 启动并不会有这个事件的发生，而是 ContextRefreshedEvent
 * {@link MyContextStartedEventListener }
 *
 */
@Component
public class MyContextRefreshEventListener implements ApplicationListener<ContextRefreshedEvent> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
    /**
     * 2021-06-23 09:29:32.003 INFO 17873 --- [ main] c.e.d.a.l.MyContextRefreshEventListener :
     * this: cn.ebing.dog.api.listener.MyContextRefreshEventListener@d109c4f; event:
     * org.springframework.context.event.ContextRefreshedEvent[source=org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@394df057:
     * startup date [Wed Jun 23 09:29:28 CST 2021]; root of context hierarchy]
     */
    logger.info("this: " + this.toString() + "; event: " + event);
    }
}
