package hyuk.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class q10816_NumberCard2 {
	
	private static int N,M;
	private static int[] arr, searchArr;
	
	public static void main(String[] args) throws Exception{
		new q10816_NumberCard2().service();
	}
	private void service() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		String[] input = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		M = Integer.parseInt(br.readLine());
		input = br.readLine().split(" ");
		searchArr = new int[M];
		for(int i = 0; i < M; i++) {
			searchArr[i] = Integer.parseInt(input[i]);
		}
		
		//1. 정렬
		int[] tmp = new int[N];
		mergeSort(arr, 0, N-1, tmp);
		//2. M번 반복하는 binary search
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			int resL = binarySearchLeft(-1,N, searchArr[i]);
			int resR = binarySearchRight(-1,N, searchArr[i]);
			sb.append((resR - resL + 1) + " ");
		}
		System.out.println(sb.toString());
		br.close();
	}
	private int binarySearchLeft(int start, int end, int target) {
		int mid = (start + end) / 2;
		if(start + 1 >= end) {
			return end;
		}
		if(arr[mid] >= target) {
			return binarySearchLeft(start, mid, target);
		}else {
			return binarySearchLeft(mid, end, target);
		}
	}
	private int binarySearchRight(int start, int end, int target) {
		int mid = (start + end) / 2;
		if(start + 1 >= end) {
			return start;
		}
		if(arr[mid] > target) {
			return binarySearchRight(start, mid, target);
		}else {
			return binarySearchRight(mid, end, target);
		}
	}
	private void mergeSort(int[] arr, int start, int end, int[] tmp) {
		if(start >= end) return;
		int mid = (start + end) / 2;
		
		mergeSort(arr, start, mid, tmp);
		mergeSort(arr, mid+1, end, tmp);
		
		int ps = start; int pe = mid+1; int ts = start;
		while(ps <= mid && pe <= end) {
			if(arr[ps] <= arr[pe]) {
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
		for(int i = start; i <= end; i++) {
			arr[i] = tmp[i];
		}
	}
}
