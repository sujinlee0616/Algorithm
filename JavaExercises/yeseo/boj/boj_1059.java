package boj;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class boj_1059 {
/*
수2

A<=N<=B
(B>A)
1. 럭키셋에 있는 숫자가 N보다 작을 경우 처리 
2. L에 담겨있는 숫자와 만나면 멈춰야 됨  
3. count를 리턴

1,2 => x -1 
2,7 => 3456
2,14 => 3456 89 111213 -1 1 1   ==> 그래서 4?
2,10 => 3456 89   

 */
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int L=scan.nextInt();
		
		//set에 넣으면 중복이 제거되지 
		//Set<Integer> luckyset=new HashSet<>();
		//for(int i=0;i<L;i++) {
			//luckyset.add(scan.nextInt()); // luckey set에 포함된 숫자 
			//1 7 14 10은 럭키셋에 포함된다 
			// a = 1 b>14 
		//}
		int luckyset[]=new int[50];
		for(int i=0;i<L;i++)
			luckyset[i]=scan.nextInt();
		int N=scan.nextInt();
			luckyset[L+1]=N;
			
		int A,B;
		int count=0;
		
		Arrays.sort(luckyset);
		
		int idx=0;
		for(int d=0;d<luckyset.length;d++) {
			if(luckyset[d]==N)
				luckyset[d+1]=idx;
		}
	

		count=Math.abs(idx-L);
		System.out.println(count);
		
		
		
	}
}
