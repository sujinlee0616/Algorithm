package format;

import java.util.Scanner;

public class SelectionSort {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		// 선택정렬 - 오름차순 
		selectionSort(arr,"ASC");
		for(int i=0;i<n;i++) // 결과확인 
			System.out.print(arr[i]+" ");
		System.out.println();
		
		// 선택정렬 - 내림차순
		selectionSort(arr,"DESC"); 
		for(int i=0;i<n;i++)  // 결과확인 
			System.out.print(arr[i]+" ");
		
	}
	
	
	public static void selectionSort(int[] arr, String s) {
		if(s.equals("DESC")) { // 내림차순 
			for(int i=0;i<arr.length-1;i++) {
				int min=i; 
				for(int j=i+1;j<arr.length;j++)
					if(arr[j]>arr[min]) 
						min=j; // 
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
	
}
