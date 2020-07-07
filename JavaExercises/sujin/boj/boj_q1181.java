package boj;

import java.util.Scanner;

public class boj_q1181 {

	public static void solution(String[] arr) {
		
		// 배열을... 원소의 글자수대로 정렬시키자...오름차순으로...
		// 다시 풀어야 함. 
		int n=arr.length;
		for(int i=0;i<n-1;i++) {
			int min=i;
			for(int j=i+1;j<n;j++) {
				if(arr[j].length()<arr[min].length())
					min=j;
				swap(arr,i,min);
			}
		}
		
		for(int i=0;i<n;i++)
			System.out.println(arr[i]);
	}
	
	public static void swap(String[] arr, int idx1, int idx2) {
		String s=arr[idx1];
		arr[idx1]=arr[idx2];
		arr[idx2]=s;
	}
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String[] arr=new String[n];
		
		for(int i=0;i<n;i++) 
			arr[i]=sc.next();
			
		solution(arr);
	}
	
}
