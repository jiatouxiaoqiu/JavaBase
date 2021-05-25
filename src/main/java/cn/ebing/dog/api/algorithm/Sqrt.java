package cn.ebing.dog.api.algorithm;

import java.text.DecimalFormat;

/**
 * 二分法
 *
 * 比如求根号5
 *
 * <p>第一步:折半： 5/2=2.5
 *
 * <p>第二步:平方校验: 2.5*2.5=6.25>5，并且得到当前上限2.5，记录。
 *
 * <p>第三步:再次向下折半:2.5/2=1.25
 *
 * <p>第四步:平方校验：1.25*1.25=1.5625<5,得到当前下限1.25，记录
 *
 * <p>第五步:再次折半:2.5-(2.5-1.25)/2=1.875
 *
 * <p>第六步:平方校验：1.875*1.875=3.515625<5,得到当前下限1.875，替换下限值
 *
 * <p>......
 *
 * <p>一直到与5的差值在你定义的误差范围内才结束循环
 */
public class Sqrt {
    public static double sqrt(double num) {
        if(num<0) {
            return -1;
        }

        double low = 0;
        double high = num/2;
        double precision = 0.000001;
        //格式化，保证输出位数
        DecimalFormat df = new DecimalFormat("#.00");
        double res = high;

        while(Math.abs(num-(res*res)) > precision) {
            if(high*high > num) {
                double n= high - (high-low)/2;
                if(n*n>num) {
                    high = n;
                } else if(n*n<num){
                    low = n;
                }else {
                    return Double.valueOf(df.format(n));
                }
                res = n;

            } else if(high*high < num) {
                double m = high + (high-low)/2;
                if(m*m>num) {
                    low = high;
                    high = m;
                } else if(m*m<num){
                    low = high;
                    high = m;
                }else {
                    return Double.valueOf(df.format(m));
                }
                res = m;
            } else {
                return Double.valueOf(df.format(high));
            }
        }

        return Double.valueOf(df.format(res));
    }

  public static void main(String[] args) {
      double a = 2;
      System.out.println(sqrt(a));
  }
}
