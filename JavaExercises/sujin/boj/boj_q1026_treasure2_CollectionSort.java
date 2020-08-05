package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// [풀이2] Collection 사용해서 내림차순/오름차순 정렬. 
// 배경지식) 배열/리스트 오름차순/내림차순 정렬 
// - Arrays.sort(arr); : 배열 오름차순 정렬 
// - Arrays.sort(arr, Comparator.reverseOrder()); : 배열 내림차순 정렬 
// - Collections.sort(arr); : 리스트 오름차순 정렬 
// - Collections.sort(arr, Comparator.reverseOrder()); : 리스트 내림차순 정렬 
// - Collections.reverse(arr); : 내림차순 아님!! 리스트의 원소 순서를 반대로 뒤집는 것 !!! 

public class boj_q1026_treasure2_CollectionSort {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		for(int i=0;i<n;i++)
			a.add(i, sc.nextInt());
		for(int i=0;i<n;i++)
			b.add(sc.nextInt());
		
		Collections.sort(a); // 오름차순으로 정렬
		Collections.sort(b, Comparator.reverseOrder()); // 내림차순으로 정렬 

		/* test
		for(int i=0;i<n;i++) 
			System.out.print(a.get(i)+" ");
		System.out.println();
		for(int i=0;i<n;i++) 
			System.out.print(b.get(i)+" ");*/
		
		int S=0;
		for(int i=0;i<n;i++)
			S += a.get(i) * b.get(i);
		
		System.out.println(S);
	}
	
}
