package com.purbarun.spring.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.purbarun.spring.sortutil.Sort;

@Component
public class BinarySearch {
	@Autowired
	private Sort sortAlgorithm;

	public int binarySearch(int[] array, int numberToSearch) {
		int[] sortedArray = sortAlgorithm.sort(array);
		System.out.println(sortAlgorithm);

		/* search the array */
		int r = sortedArray.length - 1;
		int l = 0;
		while (l <= r) {
			int m = l + (r - l) / 2;

			/* Check if x is present at mid */
			if (array[m] == numberToSearch)
				return m;

			/* If x greater, ignore left half */
			if (array[m] < numberToSearch)
				l = m + 1;

			/* If x is smaller, ignore right half */
			else
				r = m - 1;
		}

		/* if we reach here, then element was not present */
		return -1;
	}
	@Override
	public String toString() {
		return "Binary Search Bean Successfully Created";
	}
}
