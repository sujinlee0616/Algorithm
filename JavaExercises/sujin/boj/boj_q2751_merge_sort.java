package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// 시간초과 뜸 ㅠㅠ ==> 해결 
// <오늘의 교훈>
// 1. 입력이 크면 BufferedReader
// 2. 출력이 크면 BufferedWriter
// 3. 배열을 만드는 것도 비싼 연산이었어... ==> 배열을 뺐음 

public class boj_q2751_merge_sort {
	
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언

	private static int[] tmp = new int[1000100];


	public static void main(String[] args) throws IOException{
		int N= Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		mergeSortArr(arr, 0, arr.length-1, "aa");
		
		for(int i = 0; i < N; i++) {
			bw.write(arr[i] + "\n");
			//bw.append(arr[i]+"\n");
		}		
		
		try {
			bw.flush();
			bw.close();
		} catch (Exception e) {

		}
	}

	
	private static void mergeSortArr(int[] arr, int start, int end, String mode) {
		if(start >= end) {
			return;
		}
		
		int mid = (start + end) / 2;
		mergeSortArr(arr, start, mid, mode);
		mergeSortArr(arr, mid+1, end, mode);
		
		//start부터 end까지 정렬
		// int[] tmp = new int[arr.length];
		int ps, pe, pt;
		ps = start;
		pe = mid+1;
		pt = start;
		
		if(mode.equals("DESC")) {
			while(ps <= mid && pe <= end) {
				if(arr[ps] < arr[pe]) {
					tmp[pt++] = arr[pe++];
				} else {
					tmp[pt++] = arr[ps++];
				}
			}
			while(ps <= mid) {
				tmp[pt++] = arr[ps++];
			}
			while(pe <= end) {
				tmp[pt++] = arr[pe++];
			}
			
			for(int i = start; i <= end; i++) {
				arr[i] = tmp[i];
			}
			return;
		}
		while(ps <= mid && pe <= end) {
			if(arr[ps] > arr[pe]) {
				tmp[pt++] = arr[pe++];
			} else {
				tmp[pt++] = arr[ps++];
			}
		}
		while(ps <= mid) {
			tmp[pt++] = arr[ps++];
		}
		while(pe <= end) {
			tmp[pt++] = arr[pe++];
		}
		
		for(int i = start; i <= end; i++) {
			arr[i] = tmp[i];
		}
		
		return;
	}


	
}




