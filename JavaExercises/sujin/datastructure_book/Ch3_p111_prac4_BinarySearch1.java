package datastructure_book;

import java.util.Scanner;

// [이진검색1] 
public class Ch3_p111_prac4_BinarySearch1 {

	// 크기가 n인 배열a에서 key와 값이 동일한 요소를 이진 검색 
	static int binSearch(int[] a, int n, int key) {
		int pl=0;
		int pr=n-1;
		
		do {
			int pc=(pl+pr)/2; 
			if(a[pc]==key) // 검색 성공 
				return pc;
			else if(a[pc]<key) // 뒤쪽 부분 탐색 
				pl=pc+1;
			else 
				pr=pc-1; // 앞쪽 부분 탐색 
		} while(pl<=pr);
		return -1; // 검색 실패 
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("요소 수:");
		int num=sc.nextInt();
		int[] x=new int[num];
		
		System.out.println("오름차순으로 입력하세요.");
		System.out.println("x[0]:");
		x[0]=sc.nextInt();
		
		for(int i=1;i<num;i++) {
			do {
				System.out.println("x["+i+"]:");
				x[i]=sc.nextInt();
			}while(x[i]<x[i-1]); // 바로 앞의 요소보다 작으면 다시 입력 
		}
		
		System.out.println("검색할 값:"); // 키 값 입력
		int key=sc.nextInt();
		
		int idx=binSearch(x, num, key);
		
		if(idx==-1)	System.out.println("찾는 값이 이 배열에 없습니다. ");
		else System.out.println(key+"는 x["+idx+"]에 있습니다.");
	}
}







