package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// [풀이3] mergeSort
public class boj_q1026_treasure3_MergeSort {
	
	static int[] buff; // 작업용 배열 
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		for(int i=0;i<n;i++)
			b[i]=sc.nextInt();
		
		// 정렬a는 오름차순으로, 정렬b는 내림차순으로 정렬해서 각각 원소 곱하면 S값 최소. 
		// 정렬 알고리즘 중 복잡도 좋은 합병정렬(mergeSort) 써보자. 
		mergeSort(a,n,"ASC");
		mergeSort(b,n,"DESC");
		
		/* for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
		System.out.println();
		for(int i=0;i<n;i++)
			System.out.print(b[i]+" "); */
		
		int S=0;
		for(int i=0;i<n;i++)
			S += a[i] * b[i];
		
		System.out.println(S);
	}
	
	// [mergeSort]
	// - 정렬을 계속 반으로 쪼개서 합친다. 
	static void mergeSort(int[] arr, int n, String s) {
		buff = new int[n];
		
		__mergeSort(arr,0,n-1,s); // 배열 전체를 병합 정렬 
		
		buff = null; // 작업용 배열 해제 
	}
	
	// arr[left] ~ arr[right]을 재귀적으로 병합 정렬 
	static void __mergeSort(int[] arr, int left, int right, String s) {
		
		if(left < right) {
			int i;
			int center = (left + right) / 2;
			int p=0;
			int j=0;
			int k=left;
			
			__mergeSort(arr, left, center, s); // 배열의 앞부분 병합 정렬 
			__mergeSort(arr, center+1, right, s); // 배열의 뒷부분 병합 정렬 
				
			for(i=left; i<=center; i++)
				buff[p++] = arr[i];
				
			while(i<=right && j<p) {
				if(s.equals("ASC"))
					arr[k++] = (buff[j] <= arr[i] ? buff[j++] : arr[i++]);
				else if(s.equals("DESC"))
					arr[k++] = (buff[j] <= arr[i] ? arr[i++] : buff[j++]);
			}
			
			while(j<p)
				arr[k++] = buff[j++];
		}
	}

}





