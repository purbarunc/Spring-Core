package com.purbarun.spring.sortutil;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class QuickSortImpl implements Sort {
	@Override
	public int[] sort(int[] array) {
		int low = 0;
		int high = array.length - 1;
		return quickSort(array, low, high);
	}

	private int[] quickSort(int[] array, int low, int high) {
		if (low < high) {
			int mid = partition(array, low, high);
			quickSort(array, low, mid - 1);
			quickSort(array, mid + 1, high);
		}
		return array;
	}

	private int partition(int[] array, int low, int high) {
		int pivot = array[high];
		/* index of smaller element */
		int i = (low - 1); //
		for (int j = low; j < high; j++) {
			/*
			 * If current element is smaller than or equal to pivot
			 */
			if (array[j] <= pivot) {
				i++;
				/* swap arr[i] and arr[j] */
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}

		/* swap arr[i+1] and arr[high] (or pivot) */
		int temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;
		return i + 1;
	}

	@Override
	public String toString() {
		return "Using Quick Sort as the Primary Implementation Component";
	}
	
}
