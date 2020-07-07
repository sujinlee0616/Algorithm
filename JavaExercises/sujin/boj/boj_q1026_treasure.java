package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_q1026_treasure {
	
	public static int solution(int[] arr1, int[] arr2) {
		
		// 이거 그냥 S값만 구하는 거니까
		// 하나는 오름차순으로, 하나는 내림차순으로 정렬하면 되겠네 
		
		int S=0;
		
		selectionSort(arr1,"DESC");
		selectionSort(arr2,"ASC");
		
		for(int i=0;i<arr1.length;i++) {
			S+=arr1[i]*arr2[i];
		}
		
		System.out.println(S);
		
		return S;
	}
	
	public static void selectionSort(int[] arr, String s) {
		
		if(s.contentEquals("DESC")) { // 내림차순 
			for(int i=0;i<arr.length-1;i++) {
				int min=i;
				for(int j=i+1;j<arr.length;j++)
					if(arr[j]>arr[min])
						min=j;
				swap(arr,i,min);
			}
		}
		else { // 오름차순 
			for(int i=0;i<arr.length-1;i++) {
				int min=i;
				for(int j=i+1;j<arr.length;j++)
					if(arr[j]<arr[min])
						min=j;
				swap(arr,i,min);
			}
		}
		
	}
	
	public static void swap(int[] arr, int idx1, int idx2) {
		int t=arr[idx1];
		arr[idx1]=arr[idx2];
		arr[idx2]=t;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
		int n = Integer.parseInt(bf.readLine());
		
		int[] arrA=new int[n];
		String s=bf.readLine();
		String[] s2=s.split(" ");
		for (int i=0; i<n; i++) {
			arrA[i]=Integer.parseInt(s2[i]);
		}
		
		int[] arrB=new int[n];
		String a=bf.readLine();
		String[] a2=a.split(" ");
		for(int i=0; i<n; i++) {
			arrB[i]=Integer.parseInt(a2[i]);
		}
		
		solution(arrA,arrB);
	}
	
	
}
