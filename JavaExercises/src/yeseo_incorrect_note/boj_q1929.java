package yeseo_incorrect_note;

import java.util.Scanner;

public class boj_q1929 {
public static void main(String[] args) {
		
		/*
		 소수 구하기
		 1회 - 25'
		 에라토스테네스의 체 개념 유의  
		 */
		Scanner scn=new Scanner(System.in);
		int M=scn.nextInt();
		int N=scn.nextInt();
		
		int a[]=new int[1000001]; // max 
		
		for(int i=2;i<=N;i++) {
			a[i]=i;
		}
		
		for(int i=2;i<=N;i++)
		{
			if(a[i]==0) continue; //
			for(int j=i+i;j<=N;j+=i)
			{
				a[j]=0;				
			}
		}
	
		for(int i=M;i<=N;i++)
		{
			if(a[i]!=0)
				System.out.println(a[i]);
		}
	}
}
