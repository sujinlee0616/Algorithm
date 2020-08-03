package hyuk.boj;

import java.util.Scanner;

public class q1920_Find_Num {
	public static void main(String[] args) {
		new q1920_Find_Num().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt();
		int[] arr = new int[N];
		int[] tmp = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = scn.nextInt();
		}
		int M = scn.nextInt();
		int[] input = new int[M];
		for(int i = 0; i < M; i++) {
			input[i] = scn.nextInt();
		}
		
		// 정렬
		mergeSort(arr, tmp, 0, N-1);
		//print(arr);
		for(int i = 0; i < M; i++) {
			int res = binarySearch(arr, input[i],-1,N-1);
			System.out.println(res);
		}
		
		scn.close();
	}
	
	private int binarySearch(int[] arr, int target, int start, int end) {
		int mid = (start + end) / 2;
		if(arr[mid] == target) return 1;
		if(start + 1 >= end) {
			return 0;
		}
		
		if(arr[mid] > target) {
			return binarySearch(arr, target, mid+1, end);
		} else {
			return binarySearch(arr, target, start, mid);
		}
	}
	private void mergeSort(int[] arr, int[] tmp, int start, int end) {
		if(start >= end) {
			return;
		}
		int mid = (start + end) / 2;
		mergeSort(arr, tmp, start, mid);
		mergeSort(arr, tmp, mid+1, end);
		
		int ps = start; int pe = mid+1; int ts = start;
		while(ps <= mid && pe <= end) {
			if(arr[ps] >= arr[pe]) {
				tmp[ts++] = arr[ps++];
			} else {
				tmp[ts++] = arr[pe++];
			}
		}
		while(ps <= mid) {
			tmp[ts++] = arr[ps++];
		}
		while(pe <= end) {
			tmp[ts++] = arr[pe++];
		}
		for(int i = start; i <= end; i++ ) {
			arr[i] = tmp[i];
		}
	}
	private void print(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
