package datastructure_book;

import java.util.*;

// 비재귀적으로 퀵정렬 구현하기 
public class Ch6_p232_prac10 {
	
	public static void main(String[] args) {
		int[] a= {3,4,5,2,1};
		quickSort(a, 0, 4);
	}

	// 배열 요소 a[idx1]과 a[idx2]의 값을 바꿉니다.
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
	}
		
	static void quickSort(int[] a, int left, int right) {
		
		Ch4_p136_prac1_IntStack lstack=new Ch4_p136_prac1_IntStack(right-left+1);
		Ch4_p136_prac1_IntStack rstack=new Ch4_p136_prac1_IntStack(right-left+1);
		
		lstack.push(left);
		rstack.push(right);
		
		while(lstack.isEmpty()!=true) {
			int pl=left=lstack.pop(); // 왼쪽 커서 
			int pr=right=rstack.pop(); // 오른쪽 커서 
			int x=a[(left+right)/2]; // 피벗 
			
			do {
				while(a[pl]<x) pl++;
				while(a[pr]>x) pr--;
				if(pl<=pr)
					swap(a, pl++, pr--);
			}while(pl<=pr);
			
			if(left<pr) {
				lstack.push(left);
				rstack.push(pr);
			}
			if(pl<right) {
				lstack.push(pl);
				rstack.push(right);
			}
		}
		
	}
	
}
