package day01;

import java.util.Arrays;
import java.util.stream.Stream;

import util.Sort;

public class Test01_Sort {
public static void main(String[] args) throws Exception{
	
	int[] arr = new int[100];
	
	for(int i= 0 ; i<arr.length;i++) {
		arr[i] = (int)(Math.random()*100);
	}
//	Stream.of(arr).forEach(i-> System.out.println(i));//[I@2a098129 주소찍힘
	
	long start = 0;
	long end = 0;
	
	start = System.currentTimeMillis();
	
//	util.Sort.selectioinSort(arr);	
//	util.Sort.bubbleSort(arr);
//	util.Sort.mergeSort_(arr, 0, arr.length-1);
	
	util.Sort.quickSort(arr, 0, arr.length-1);
	end = System.currentTimeMillis();
	
	
	System.out.printf("sort 수행시간 %d ms",end-start);
//	System.out.println(Sort.count);
	
}
}
