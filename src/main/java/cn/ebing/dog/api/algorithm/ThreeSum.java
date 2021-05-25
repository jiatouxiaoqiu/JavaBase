package cn.ebing.dog.api.algorithm;

import java.util.ArrayList;
import java.util.List;

public class ThreeSum {
    private static List<String> threeSum(int[] array) {
        int length = array.length;
        if (length <= 3) {
            return null;
        }

        List<String> result = new ArrayList<String>();

        for (int i=0; i<length; i++) {
            for (int j=i+1; j<length; j++) {
                for (int k=i+2; k<length; k++) {
                    if (array[i]+array[j]+array[k] == 0) {
                        String value = i + "," + j + "," + k + ";";
                        result.add(value);
                    }
                }
            }
        }
        return result;
    }

  public static void main(String[] args) {
    int[] array = {-1, 0, 1, 2, -1, -4};
    System.out.println("threeSum(array)" + threeSum(array));
  }
}
