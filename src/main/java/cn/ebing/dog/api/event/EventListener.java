package cn.ebing.dog.api.event;

/**
 * 事件监听器
 *
 * @param <E> 当前监听器感兴趣的事件类型
 */
public interface EventListener<E extends AbstractEvent> {
  /**
   * 此方法负责处理事件 如果是 spring import org.springframework.context.ApplicationListener;
   *
   * @param event 要响应的事件对象
   */
  void onEvent(E event);
}

/**
 * Spring为了简化事件的使用，提供了2种使用方式
 *
 * <p>面相接口的方式 面相@EventListener注解的方式
 *
 * <p>监听器支持排序功能
 *
 * <p>SimpleApplicationEventMulticaster，这个类是支持监听器异步调用的，里面有个字段：
 * <p>private Executor taskExecutor; 高并发比较熟悉的朋友对Executor这个接口是比较熟悉的，可以用来异步执行一些任务。
 * 异步事件的模式，通常将一些非主要的业务放在监听器中执行，因为监听器中存在失败的风险，所以使用的时候需要注意。如果只是为了解耦，但是被解耦的次要业务也是必须要成功的，可以使用消息中间件的方式来解决这些问题。
 */
