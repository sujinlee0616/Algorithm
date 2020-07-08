package boj;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class boj_q1026 {
/*
보물
자연수 수열 최소화
이슈)구현 
1) A의 최소 * B의 최대 (B는 고정)
2) A의 최대 & B의 최소 -Sort

 */
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int N=scn.nextInt();
		int []B=new int[N];
		int []A=new int[N];
		
		int res=0;
		for(int i=0;i<N;i++) {
			A[i]=scn.nextInt();
		}
		for(int i=0;i<N;i++) {
			B[i]=scn.nextInt();
		}
		Arrays.sort(A);
		Arrays.sort(B);
		
		//1)A는 재배열 할 수 있어 
		//Arrays.sort(Collections.reverseOrder(A));
		
		//2)B의 역방향과곱해줌 
		for(int i=0;i<A.length;i++) {
			res+=A[i]*B[A.length-1-i];
		}
		System.out.println(res);
	}
	
}
