package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class boj_q1181 {
	
	static int N;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		String[] letters = new String[N];
		
		for(int i=0;i<N;i++) {
			letters[i] = sc.next();
		}
		
		sort(letters);
	}
	
	static void sort(String[] letters) {
		
		// 1. 길이에 따른 정렬 
		int[] len = new int[N];
		for(int i=0;i<N;i++)
			len[i]=letters[i].length();
		
		for(int i=0;i<N;i++) {
			int min=i;
			for(int j=i+1;j<N;j++)
				if(len[j] < len[min])
					min=j;
			swap(len,i,min);
			swap(letters,i,min);		
		}
		
		// [test] 길이에 따른 정렬 결과 확인 - 완료 
		for(int i=0;i<N;i++)
			System.out.println(letters[i]);
		
		// 2. 글자수가 같을 때 사전 순 정렬 
		// 문자열의 길이는 50을 넘지 않는다. 
		
	}
	
	static void dictSort(String[] letters, int idx1, int idx2) {
		
	}
	
	public static void swap(int[] arr, int idx1, int idx2) {
		int t=arr[idx1];
		arr[idx1]=arr[idx2];
		arr[idx2]=t;
	}
	public static void swap(String[] arr, int idx1, int idx2) {
		String t=arr[idx1];
		arr[idx1]=arr[idx2];
		arr[idx2]=t;
	}
	
}
