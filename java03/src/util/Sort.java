package util;

public class Sort {

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	public static int count = 0;

	// O(n2) :시간복잡도
	// 이중포문이라 n의 제곱만큼 시간걸림
	public static void selectioinSort(int[] arr) {
		// 10000개 이상의 배열 처리 불가능 시간 너무 오래걸림
		// 오름차순
		for (int i = 0; i < arr.length - 1; i++) {
			int minindex = i;
			for (int j = i + 1; j < arr.length; j++) {

				if (arr[minindex] > arr[j]) // swap 횟수 최소화
					minindex = j;
			}
			if (minindex != i) {// or arr[i]>arr[minindex]
				swap(arr, i, minindex);
				count++;
			}
		}
	}

	// O(n2)
	public static void bubbleSort(int arr[]) {
		int N = arr.length;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1 - i; j++) {
				if (arr[j] < arr[j + 1])
					swap(arr, j, j + 1);
			}
		}
	}

	// O(NlongN)
	static int[] temp = null;

	public static void mergeSort_(int[] arr, int start, int end) {
		temp = new int[arr.length];
		mergeSort(arr, start, end);
	}

	public static void mergeSort(int[] arr, int start, int end) {

		// 배열 쪼개기
		if (start == end)
			return;
		int mid = (start + end) / 2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid + 1, end);

		// 쪼개진 배열을 temp에 저장
		for (int i = start; i < end; i++) {
			temp[i] = arr[i];
		}

		int i = start, j = mid + 1, k = start;
		// i = 앞배열 인덱스
		// j = 뒷배열 인덱스
		// k = 통합배열 덱스

		while (i <= mid && j <= end) {
			arr[k++] = temp[i] < temp[j] ? temp[i++] : temp[j++];
		}

		while (i <= mid)
			arr[k++] = temp[i++];
		while (j <= end)
			arr[k++] = temp[j++];

	}

	public static void quickSort(int[] arr, int start, int end) {

		if (start < end) {
			int p = start;
			int i = start + 1;
			int j = end;

			while (i <= j) {
				while (arr[p] >= arr[i]) //중복데이터 앞쪽으로들어감
					i++;
				while (arr[p] < arr[j])
					j--;
				if (i < j)
					Sort.swap(arr, i, j);
			}
			Sort.swap(arr, p, j);

			quickSort(arr, start, j - 1);
			quickSort(arr, j + 1, end);

		}
	}

}
