package datastructure_book;

import java.util.Arrays;
import java.util.Scanner;

// [Java에서 제공하는 binarySerach 메소드]
//  - Java는 배열에서 이진 검색을 하는 메서드를 표준 라이브러리로 제공함. 
//  - java.util.Arrays 클래스의 binarySearch 메소드.
//  1) 검색 성공 시: key와 일치하는 요소의 인덱스를 반환
//  2) 검색 실패 시: -x-1 반환. (x: 삽입 포인트.) 

// Arrays.binarySearch로 이진 검색 
public class Ch3_p120_prac5_BinarySearchMethodTester {
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
		
		int idx=Arrays.binarySearch(x, key); // Arrays.binarySearch 이용 ★★★
		
		if(idx==-1)	System.out.println("찾는 값이 이 배열에 없습니다. ");
		else System.out.println(key+"는 x["+idx+"]에 있습니다.");
		
	}
}
