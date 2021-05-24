package cn.ebing.dog.api.algorithm;

import java.util.Arrays;

public class BubboSort {
  public static void main(String[] args) {
      int[] array = {1,3,2,7,88,11,8};
      bubboSort(array);
      System.out.println("array: " + Arrays.toString(array));
  }

  private static void bubboSort(int[] array) {
        if (array.length <= 1) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
