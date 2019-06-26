package com.dsa.sorting;

public class MergeSort {
	public static void main(String[] args) {
		int arr[] = new int[] {9,3,7,6,6,4,8,2};
		mergeSort(arr, 0, 7);
		for (int a: arr) {
			System.out.println(a);
		}
	}
	
	public static void mergeSort(int arr[], int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid + 1, right);
		}
	}
	
	public static void merge(int arr[], int left, int mid, int right) {
		int left_end = mid - 1, 
			i = 0,
			j = 0,
			k = 0,
			size = right-left + 1;
		int starting_point = left;
		int ending_point = right;
		int temp[] = new int[size];
		
		while (left <= left_end && mid <= right) {
			if (arr[left] <= arr[mid]) { 
				temp[i++] = arr[left++];
			} else {
				temp[i++] = arr[mid++];
			}
		}
		
		while (left <= left_end) {
			temp[i++] = arr[left++];
		}
		
		while (mid <= right) {
			temp[i++] = arr[mid++];
		}

		for (j = starting_point; j <= ending_point && k<=size; ) {
			arr[j++] = temp[k++];
		}
	}
}
