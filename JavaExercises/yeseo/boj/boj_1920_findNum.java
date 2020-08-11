package boj;

import java.util.Arrays;
import java.util.Scanner;

public class boj_1920_findNum {
//수 찾기
// A=int [N] / B=int [M] 
// for문 돌며 찾기 
	static int A[];
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		A=new int [N];
		for(int i=0;i<N;i++)
			A[i]=scan.nextInt();
		
		//***SORT
		Arrays.sort(A);
		
		int target=0;
		int M=scan.nextInt();
		for(int i=0;i<N;i++) {
			target=scan.nextInt();
			binarySearch(N, target);
		}
			
		//IDE o ,제출 x .. 
		
			
	}
	
	static void binarySearch(int len,int target) {
		
		int left=0;
		int mid;
		int right=len-1;
		
		//종료조건
		while(right-left>=0) {
			mid=(left+right)/2;
			
			if(target==A[mid]) {
				System.out.println(1);
				return;
			}else if(target<A[mid]) {
				right=mid-1;
			}else {
				left=mid+1;
			}
		}
		System.out.println(0);
		return;
		
	}
}
