package com.purbarun.spring.sortutil;

import org.springframework.stereotype.Service;

@Service
public class BubbleSortImpl implements Sort {

	@Override
	public int[] sort(int[] array) {
		int n = array.length;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (array[j - 1] > array[j]) {
					int temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}

	@Override
	public String toString() {
		return "Using Bubble Sort as the Primary Implementation Component";
	}
}
