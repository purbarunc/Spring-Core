package com.purbarun.ProfilesDemo.sort;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("bubble-sort")
public class BubbleSortImpl implements SortService {

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
}
