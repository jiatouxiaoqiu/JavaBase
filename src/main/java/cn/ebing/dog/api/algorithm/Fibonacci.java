package cn.ebing.dog.api.algorithm;

public class Fibonacci {
    public static class FibonacciN {
        public int output(int num){
            if(num == 1 || num == 2){
                return 1;
            }else{
                return output(num-1) + output(num-2);
            }
        }
    }


    public static void main(String[] args) {
        FibonacciN fb = new FibonacciN();
      for(int i = 1 ; i <= 20 ; i ++) {
          System.out.println("第"+i+"项为："+fb.output(i));
      }
  }
}
