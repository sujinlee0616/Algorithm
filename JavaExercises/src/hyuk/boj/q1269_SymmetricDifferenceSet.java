package hyuk.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class q1269_SymmetricDifferenceSet {
	
	public static int[] arr;
	public static int[] brr;
	public static int N,M;
	public static int[] tmp = new int[200020];
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException{
		Scanner scn = new Scanner(System.in);
		//N = (br.read() - '0');
		//M = br.read() - '0';
		N = scn.nextInt();
		M = scn.nextInt();
		arr = new int[N];
		brr = new int[M];
		for(int i = 0; i < N; i++) {
			//arr[i] = br.read();
			arr[i] = scn.nextInt();
		}
		for(int j = 0; j < M; j++) {
			//brr[j] = br.read();
			brr[j] = scn.nextInt();
		}
		//System.out.println("a");
		mergeSort(arr, 0, N-1);
		mergeSort(brr, 0, M-1);
		
		int a = binarySearch(arr, brr, N, M);
		int b = binarySearch(brr, arr, M, N);
		System.out.println(a+b);
		br.close();
	}
	
	public static int binarySearch(int[] arr, int[] brr, int N, int M) {
		//arr에서 brr들을 찾는다
		int count = N;
		for(int i = 0; i < M; i++) {
			int start = -1; int end = N-1;
			boolean suc = true;
			while(start + 1 < end) {
				int mid = (start + end) / 2;
				if(arr[mid] > brr[i]) {
					end = mid;
				} else if(arr[mid] < brr[i]) {
					start = mid;
				} else {
					suc = false;
					break;
				}
			}
			if(suc == false || arr[end] == brr[i]) {
				count--;
			}
		}
		return count;
	}
	public static void mergeSort(int[] arr, int start, int end) {
		if(start >= end) {
			return;
		}
		
		int mid = (start + end ) / 2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid+1, end);
		
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