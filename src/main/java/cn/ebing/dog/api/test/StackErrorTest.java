package cn.ebing.dog.api.test;

/** Execution failed for task ':StackErrorTest.main()'.
 *  StackOverflowError
 *
 *  在 method 里面，如果是 void 返回值，可以 return 省略，其实是有的，可以省而已。
 *  在 stack frame 里面，一个 method 对应一个栈帧，代码写了后，javap -v 回去查看字节码
 *
 *  javap 对字节码进行解析，也可以 view-jclasslib 这个 plugin 来查看
 *
 *  javap是JDK自带的反汇编器，可以查看java编译器为我们生成的字节码
 *  dreturn == double return; ireturn == int return
 */
public class StackErrorTest {
  public static void main(String[] args) {
    main(args);
  }
}
