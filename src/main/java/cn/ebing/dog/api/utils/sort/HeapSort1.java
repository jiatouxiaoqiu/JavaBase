package cn.ebing.dog.api.utils.sort;

import java.util.Arrays;

public class HeapSort1 {

	private static void heapSort(int[] array, int length) {
		buildMaxHeap(array, length);

		for (int i = length - 1; i > 0; i--) {
			swap(array, 0, i);
			length--;
			sortCore(array, 0, length);
		}
	}

	private static void buildMaxHeap(int[] array, int length) {
		for (int i = length / 2; i >= 0; i--) {
			sortCore(array, i, length);
		}
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] =  array[j];
		array[j] =  temp;
	}

	private static void sortCore(int[] array, int i, int length) {
		int left = i * 2 + 1;
		int right = i * 2 + 2;
		int largest = i;
		if (left < length && array[left] > array[largest]) {
			largest = left;
		}
		if (right < length && array[right] > array[largest]) {
			largest = right;
		}
		if (largest != i) {
			swap(array, i, largest);
			sortCore(array, largest, length);
		}
	}

	public static void main(String[] args) {
		int[] array = {9,2,4,6,1,5,7};
		int length = array.length;
		heapSort(array, length);
		System.out.println("堆排序结果: " + Arrays.toString(array));
	}

}
