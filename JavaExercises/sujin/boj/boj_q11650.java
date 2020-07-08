package boj;

import java.util.Scanner;

public class boj_q11650 {
	
	// 잘못 풀었음. 제대로 푼건 q11650_3 임. 
	// 일단 x좌표는 퀵정렬 쓰면 됨 . 
	// x좌표 정렬은 하겠는데, x가 같을 때 y좌표 정렬하는걸 못하겠음...
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[][] arr=new int[n][2];
		
		for(int i=0;i<n;i++) {
			arr[i][0]=sc.nextInt();
			arr[i][1]=sc.nextInt();
		}
		
		quickSort1(arr, 0, n-1);
		
		for(int i=0;i<n;i++) {
			System.out.print(arr[i][0]+" ");
			System.out.print(arr[i][1]);
			System.out.println();
		}
		
	}                                                                       
	
	// 1. arr[i][0]과 arr[j][0]을 바꾸고
	// 2. arr[i][1]과 arr[j][1]도 바꿔야 
	static void swap1(int[][] a,int idx1,int idx2) {
		int m=a[idx2][0];
		a[idx2][0]=a[idx1][0];
		a[idx1][0]=m;
		
		int n=a[idx2][1];
		a[idx2][1]=a[idx1][1];
		a[idx1][1]=n;
	}
	
	// 퀵정렬 
	static void quickSort1(int[][] a,int left, int right) {
		int pl=left;
		int pr=right;
		int x=a[(pl+pr)/2][0]; // 피벗 
		
		do {
			while(a[pl][0]<x) pl++;
			while(a[pr][0]>x) pr--;
			if(pl<=pr)
				swap1(a,pl++,pr--);
		}while(pl<=pr);
		
		if(left<pr) quickSort1(a, left, pr);
		if(pl<right) quickSort1(a, pl, right);
	}
	
	
	/* public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] x=new int[n];
		int[] y=new int[n];
		
		for(int i=0;i<n;i++) {
			x[i]=sc.nextInt();
			y[i]=sc.nextInt();
		}
		
		quickSort(x,0,n-1);
		quickSort(y,0,n-1);
		for(int i=0;i<n;i++) {
			System.out.print(x[i]+" ");
			System.out.print(y[i]);
			System.out.println();
		}
			
	}
	
	static void swap(int[] a,int idx1,int idx2) {
		int t=a[idx2];
		a[idx2]=a[idx1];
		a[idx1]=t;
	}
	
	// 퀵정렬 
	static void quickSort(int[] a,int left, int right) {
		int pl=left;
		int pr=right;
		int x=a[(pl+pr)/2]; // 피벗 
		
		do {
			while(a[pl]<x) pl++;
			while(a[pr]>x) pr--;
			if(pl<=pr)
				swap(a,pl++,pr--);
		}while(pl<=pr);
		
		if(left<pr) quickSort(a, left, pr);
		if(pl<right) quickSort(a, pl, right);
	}
	*/
	
	
}
