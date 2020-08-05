package boj;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// [풀이4] 좀 더 깔끔한 버전의 mergeSort 
public class boj_q1026_treasure4_MergeSort2 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		for(int i=0;i<n;i++)
			b[i]=sc.nextInt();
		
		mergeSort(a,0,n-1,"ASC");
		mergeSort(b,0,n-1,"DESC");
		
		int S=0;
		for(int i=0;i<n;i++)
			S += a[i] * b[i];
		
		System.out.println(S);
	}
	
	public static void mergeSort(int[] arr, int start, int end, String s) {
		
		int[] tmp=new int[arr.length]; // 작업용 배열 (임시배열)  
				
		if(start >= end) 
			return;
		
		int mid = (start + end ) / 2;
		mergeSort(arr, start, mid, s); // 배열의 앞의 절반을 mergeSort
		mergeSort(arr, mid+1, end, s); // 배열의 뒤의 절반을 mergeSort 
		
		int ps = start; // 원래 배열의 앞부분 - 인덱스 시작 
		int pe = mid+1; // 원래 배열의 뒷부분 - 인덱스 시작 
		int ts = start; // 임시배열의 인덱스 시작 
		
		// 내림차순인지 오름차순인지에 따라 다르게 처리해줌 
		while(ps <= mid && pe <= end) { 
			// 오름차순 (디폴트)
			if(s.equals("ASC")) {
				if(arr[ps] <= arr[pe]) // 배열의 앞부분 첫번째 원소가  배열의 뒷부분 첫번째 원소보다 작으면 
					tmp[ts++] = arr[ps++]; 
						// 1. 임시배열에다가  배열의 앞부분 첫번째 원소 넣고 (내림차순이니까 작은 수를 넣어야 하니까) 
						// 2. 임시배열의 첫번째 원소 index를 증가시키고(ts++) 배열의 앞부분 첫번째 원소가 다음 인덱스가 되게 한다 (ps++) 
				else { // 위의 반대로 하면 됨. 
					tmp[ts++] = arr[pe++];
				}
			}
			// 내림차순 - 위와 동일한 원리. 
			else if(s.equals("DESC")) {
				if(arr[ps] <= arr[pe]) 
					tmp[ts++] = arr[pe++];
				else 
					tmp[ts++] = arr[ps++];
			}
		}
		
		while(ps <= mid) 
			tmp[ts++] = arr[ps++];
		
		while(pe <= end)
			tmp[ts++] = arr[pe++];
		
		for(int i = start; i <= end; i++) 
			arr[i] = tmp[i];
	}
	
}














