package datastructure_book;

import java.util.Scanner;

public class Ch6_p229_QuickSort {
	static void swap(int[] a, int idx1, int idx2) {
		int t=a[idx1];
		a[idx1]=a[idx2];
		a[idx2]=t;
	}
	
	static void quickSort(int[] a, int left, int right) {
		int pl=left; // 왼쪽 커서 
		int pr=right; // 오른쪽 커서 
		int x=a[(pl+pr)/2]; // 피벗 
		
		do {
			while(a[pl]<x) pl++;
			while(a[pr]>x) pr--;
			if(pl<=pr)
				swap(a, pl++, pr--);
		}while(pl<=pr);
		
		if(left<pr) quickSort(a, left, pr);
		if(pl<right) quickSort(a, pl, right);
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("퀵 정렬 ");
		System.out.println("요솟수: ");
		int n=sc.nextInt();
		int[] x=new int[n];
		
		for(int i=0;i<n;i++) {
			System.out.println("x["+i+"]:");
			x[i]=sc.nextInt();
		}
		
		quickSort(x,0,n-1); // 퀵 정렬 수행 
		
		System.out.println("오름차순으로 정렬했습니다. ");
		for(int i=0;i<n;i++)
			System.out.println("x["+i+"]="+x[i]);
	}
}
