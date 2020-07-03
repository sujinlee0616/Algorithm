package boj;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
// 오름차순 문제 - Arrays.sort() 이용했음. 
public class boj_q2750_ascending_arraysort {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		int arr[]=new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
			//System.out.println(arr[i]);
		}
		
		// arr[] 을 정렬 
		Arrays.sort(arr);
		//Arrays.sort(arr,Collections.reverseOrder()); // 불가능. 안 됨. 
		
		//Integer arr2[]=new Integer[n];
		// reverse 쓰려면 int 배열이 아니라 Integer 배열이어야함!
		//Arrays.sort(arr2,Collections.reverseOrder());
		
		
		for(int i=0;i<n;i++) {
			System.out.println(arr[i]);
		}
	}
}
