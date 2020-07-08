package boj;

import java.util.Scanner;

public class boj_q1181 {
	
	// 아직 다 못풀었음. 
	// 얘도 안정적인 정렬로 풀어야 ==> 병합정렬로 풀어보자. 
	// 1. 알파벳순으로 정렬시키고  
	// 2. 길이대로 정렬시키자. 

	static int[] buff1; // 작업용 배열
	static int[] buff2;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String[] arr=new String[n];
		int[] leng=new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.next();
			leng[i]=arr[i].length();
		}
	}
	
}
