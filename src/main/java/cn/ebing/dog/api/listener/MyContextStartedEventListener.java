package cn.ebing.dog.api.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

/**
 * @Author qhb
 * @Date 2021/6/23 9:23 上午
 * @Version 1.0
 *
 * 这种情况，是我们误读了 ContextStartedEvent，在 springboot 启动并不会有这个事件的发生，而是
 *
 */
@Component
public class MyContextStartedEventListener implements ApplicationListener<ContextStartedEvent> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        logger.info("this: " + this.toString() + "; event: " + event);
    }
}
