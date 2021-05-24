package cn.ebing.dog.api.algorithm;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = { 1,3,5,7,9,11 };
        int key = 0;
        int position = binarySearch(array, key);
        System.out.println("position=" + position);
    }

    private static int binarySearch(int[] arr,int key) {
        if (arr.length == 0) {
            return -1;
        }

        int low = 0;
        int high = arr.length - 1;
        int middle = 0;
        if(key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }
        while (low <= high) {
            middle = (low + high) / 2;
            if(arr[middle] > key) {
                high = middle - 1;
            } else if (arr[middle] < key) {
                low = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}
