package hyuk.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class q10815_NumCard {
	public static void main(String[] args) {
		new q10815_NumCard().service();
	}
	private void service() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			String[] inputArr = br.readLine().split(" ");
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(inputArr[i]);
			}
			int M = Integer.parseInt(br.readLine());
			int[] search = new int[M];
			String[] searchArr = br.readLine().split(" ");
			for(int i = 0; i < M; i++) {
				search[i] = Integer.parseInt(searchArr[i]);
			}
			
			int[] tmp = new int[N];
			mergeSort(arr, 0, N-1, tmp);
			
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < M; i++) {
				sb.append(binarySearch(arr, search[i], -1, arr.length) + " ");
			}
			System.out.println(sb.toString());
			br.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	private String binarySearch(int[] arr, int value, int start, int end) {
		int mid = (start + end) / 2;
		if(value == arr[mid]) {
			return "1";
		}
		if(start+1 >= end) {
			return "0";
		}
		
		if(arr[mid] > value) {
			return binarySearch(arr, value, start, mid);
		}else {
			return binarySearch(arr, value, mid, end);
		}
	}
	private void mergeSort(int[] arr, int start, int end, int[] tmp) {
		if(start >= end) {
			return;
		}
		int mid = (start + end) / 2;
		mergeSort(arr, start, mid,tmp);
		mergeSort(arr, mid+1,end,tmp);
		
		int ps = start; int pe = mid+1; int ts = start;
		while(ps <= mid && pe <= end) {
			if(arr[ps] <= arr[pe]) {
				tmp[ts++] = arr[ps++];
			}else {
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
}
