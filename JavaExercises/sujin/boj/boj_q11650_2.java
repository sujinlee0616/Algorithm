package boj;

import java.util.Scanner;

public class boj_q11650_2 {
	
	// 잘못 풀었음. 제대로 푼건 q11650_3 임. 
	// 퀵정렬로 y좌표 먼저 정렬하고 x좌표 정렬하려고 했으나 안 됨. 
	// 불안정한 정렬이기 떄문. 
	// 불안정한 정렬 - 퀵정렬, 선택정렬. 나머지는 안정된 정렬임. 
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] x=new int[n];
		int[] y=new int[n];
		
		for(int i=0;i<n;i++) {
			x[i]=sc.nextInt();
			y[i]=sc.nextInt();
		}
		
		quickSort(x,y,0,n-1);
		quickSort1(x,y,0,n-1);
		
		for(int i=0;i<n;i++) {
			System.out.print(x[i]+" ");
			System.out.print(y[i]);
			System.out.println();
		}
			
	}
	
	static void quickSort2(int[] b,int left, int right) {
		int pl=left;
		int pr=right;
		int x=b[(pl+pr)/2]; // 피벗 
		
		do {
			while(b[pl]<x) pl++;
			while(b[pr]>x) pr--;
			if(pl<=pr)
				swap2(b,pl++,pr--);
		}while(pl<=pr);
		
		if(left<pr) quickSort2(b, left, pr);
		if(pl<right) quickSort2(b, pl, right);
	}
	
	static void swap2(int[] b,int idx1,int idx2) {
		int t=b[idx2];
		b[idx2]=b[idx1];
		b[idx1]=t;
	}
	
	static void swap1(int[] a,int[] b,int idx1,int idx2) {
		int m=a[idx2];
		a[idx2]=a[idx1];
		a[idx1]=m;
		
		int n=b[idx2];
		b[idx2]=b[idx1];
		b[idx1]=n;
	}
	
	// 퀵정렬 
	static void quickSort1(int[] a,int[] b,int left, int right) {
		int pl=left;
		int pr=right;
		int x=a[(pl+pr)/2]; // 피벗 
		
		do {
			while(a[pl]<x) pl++;
			while(a[pr]>x) pr--;
			if(pl<=pr) {
				swap1(a,b,pl++,pr--);
			}
		}while(pl<=pr);
		
		if(left<pr) quickSort1(a, b, left, pr);
		if(pl<right) quickSort1(a, b, pl, right);
	}
	
	
	static void quickSort(int[] a, int[] b, int left, int right) {
		int pl=left;
		int pr=right;
		int x=b[(pl+pr)/2]; // 피벗 
		
		do {
			while(b[pl]<x) pl++;
			while(b[pr]>x) pr--;
			if(pl<=pr)
				swap1(a,b,pl++,pr--);
		}while(pl<=pr);
		
		if(left<pr) quickSort(a, b, left, pr);
		if(pl<right) quickSort(a, b, pl, right);
	}
	
}
