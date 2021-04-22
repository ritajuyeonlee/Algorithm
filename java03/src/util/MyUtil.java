package util;

public class MyUtil {
	public static int countSeq = 0;
	public static int countBin = 0;
	//선형검색
	public static int seqSearch(int[] arr, int N, int key) {
		countSeq = 0;
		for(int i=0;i<N;i++) {
			countSeq++;
			if(arr[i] == key) {
				return i;
			}
		}
		
		
		return -1;
	}
	//이진검색
	public static int binSearch(int[] arr, int N, int key) {
		int start = 0;
		int end =N-1;
		countBin = 0;
		while(start<=end) {
			countBin++;
			int center = (start+end)/2;
			if(arr[center]==key) return center;
			else if(arr[center]<key) start = center+1;
			else end = center-1;
			
		}
		
		
		
		return -1;
	}
	
	public static int count(int num) {
		int count = 0;
		//3 & 1 ==> 11 && 1 ==>1
		
		while(num>0) {
			if((num & 1) ==1) count++;
			num = num>>1;
		}
		
		return count;
		
	}

	public static void print(char [] arr, int n) {
		
		for(int i=0 ; i < (1<<n);i++) {
			if(count(i)==3) {//원소의 갯수가 3인 부분집합
				System.out.print("{");
				
				for(int j=0;j<n;j++) {
					if((i & (1<<j)) != 0) {
						System.out.print(arr[j]);
					}
				}
				System.out.println("}");
			}
		}
	}
}
