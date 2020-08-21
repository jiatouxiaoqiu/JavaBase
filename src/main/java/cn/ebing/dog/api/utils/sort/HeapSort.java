package cn.ebing.dog.api.utils.sort;

import java.util.Arrays;

/**
 * 堆排序
 * 堆排序就是利用大顶堆或者小顶堆的特性来进行排序的。
 * 二叉树又有满二叉树和完全二叉树。而二叉堆，就是基于完全二叉树的一种数据结构。它有以下两个特性。
 * 1、首先它是一个完全二叉树
 * 2、其次，堆中的任意一个父节点的值都大于等于（或小于）它的左右孩子节点。
 *
 * 完全二叉树一般用数组来存储
 *
 * 堆排序，每次调整为大顶堆的时间复杂度为 O(logn)，而 n 个元素，总共需要循环调整 n-1 次 ，所以堆排序的时间复杂度就是 O(nlogn)
 * 由于没有占用额外的内存空间，因此，堆排序的空间复杂度为 O(1)
 */
public class HeapSort {
	/**
	 * 调整为大顶堆
	 * @param arr   待调整的数组
	 * @param parent   当前父节点的下标
	 * @param length   需要对多少个元素进行调整
	 */
	private static void adjustHeap(int[] arr, int parent, int length) {
		//临时保存父节点
		int temp = arr[parent];
		//左子节点的下标
		int child = 2 * parent + 1;
		//如果子节点的下标大于等于当前需要比较的元素个数，则结束循环
		while(child < length) {
			//判断左子节点和右子节点的大小,若右边大，则把child定位到右边
			if(child + 1 < length && arr[child] < arr[child + 1]){
				child ++;
			}
			//若child大于父节点，则交换位置，否则退出循环
			if(arr[child] > temp) {
				//父子节点交换位置
				arr[parent] = arr[child];
				//因为交换位置之后，不能保证当前的子节点是它子树的最大值，所以需要继续向下比较，
				//把当前子节点设置为下次循环的父节点，同时，找到它的左子节点，继续下次循环
				parent = child;
				child = 2 * parent + 1;
			} else {
				//如果当前子节点小于等于父节点，则说明此时的父节点已经是最大值了，
				//因此无需继续循环
				break;
			}
		}
		//把当前节点值替换为最开始暂存的父节点值
		arr[parent] = temp;
	}

	public static void main(String[] args) {
		int[] arr = {4,1,9,3,7,8,5,6,2};
		//构建一个大顶堆，从最下面的非叶子节点开始向上遍历
		for (int i = arr.length/2 - 1 ; i >= 0; i--) {
			System.out.println("i: " + i);
			adjustHeap(arr,i,arr.length);
		}
		System.out.println("构建一个大顶堆" + Arrays.toString(arr));

		for (int i = arr.length - 1; i > 0; i--) {
//		for (int i = 1; i < arr.length - 1; i++) {
				//将堆顶最大的元素与末尾元素互换，则数组中最后的元素变为最大值
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			//从堆顶开始重新调整结构，使之成为大顶堆
			// i代表当前数组需要调整的元素个数，是逐渐递减的
			adjustHeap(arr,0,i);
		}

		System.out.println("堆排序的结果" + Arrays.toString(arr));
	}
//打印结果：[9, 7, 8, 6, 1, 4, 5, 3, 2]。和我们分析的结果一模一样
}
