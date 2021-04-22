package day01;

public class Test01_이주연 {
	public static void main(String[] args) {
		
		int[] arr = {4,6,9,11,55,77,78,79,90,84,85,88,99,100};
		int N= arr.length;
		int key = (int)(Math.random()*100+1);
		
		int idx = f(arr,N,key,0,N-1);
		System.out.printf("key = %d, index = %d",key,idx);
		
			
	}
	public static int f(int[] arr, int N, int key, int start, int end) {
		
		
		if(start>end) return -1;
		
		
		int center = (start+end)/2;
		if(arr[center]==key) return center;
		else if(arr[center]<key) return f(arr,N,key,center+1,end);
		else return f(arr,N,key,start,center-1);
		
	}
}
