package cn.ebing.dog.api.test;

/**
 * 函数式接口
 */
@FunctionalInterface
interface FunctionInterface {
    boolean funcMethod(String s);
}


public class Lambda {
    public void lambda(FunctionInterface functionInterface) {
        return;
    }

  public static void main(String[] args) {
      Lambda lambda = new Lambda();

      // 方案1-创建接口实例，实际上是 lambda 可以赋值为变量了，即为函数式编程 invokedynamic
      /**
       * 现在JVM的规范的设定，要求很高，新增的东西可能是为了动态语言比如 jython 这样的，而Java本身已经很稳定了
       */
      FunctionInterface functionInterface = s -> {
          return true;
      };
      lambda.lambda(functionInterface);

      // 方案2，匿名
      lambda.lambda(s -> {
          return false;
      });
  }
}
