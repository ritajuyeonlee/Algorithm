package day01;

import java.util.Arrays;

import util.MyUtil;
import util.Sort;

public class Test02 {

	public static void main(String[] args) {

		int[] arr = new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
		temp = new int[arr.length];
		
		quickSort(arr, 0, arr.length);
	}

	static int[] temp = null;

	public static void quickSort(int[] arr, int start, int end) {

		
		if (start < end) {
			int p = start;
			int i = start + 1;
			int j = end;

			while (i <= j) {
				while (arr[p] >= arr[i])
					i++;
				while (arr[p] < arr[j])
					j--;
				if(i<j) 
					Sort.swap(arr, i, j);
			}
			Sort.swap(arr, p, j);
			
			quickSort(arr, start, j-1);
			quickSort(arr, j+1, end);
			
		}
	}
}
