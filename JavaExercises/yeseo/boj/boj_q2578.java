package boj;

import java.util.Scanner;

public class boj_q2578 {

	/*
	 1. 빙고
	 2. 1회 - 1.5h+a 2회 - ? 3회 - 55'+a 4회 - 55'
	 3. 어려운 점 : 빙고 초기화 
	 4. 유의점 : 줄 자체를 카운팅하는 메소드 
	 */

	private static int plr[][]=new int[5][5];
	// 사회자가 부른 값은 초기화 
	public static void reset(int r) {
		for(int i=0;i<5;i++)
			for(int j=0;j<5;j++) {
				if(r==plr[i][j])
				{
					plr[i][j]=0;

				}
			}
	}
	
	public static boolean Bingo(int n) {
		
		int count=0;		
		//가로탐색 
		for(int i=0;i<5;i++) 
		{
			int xcnt=0;
			for(int j=0;j<5;j++)
			{	xcnt+=plr[i][j]; }
			if(xcnt==0) count++;
		}
		
		//세로 탐색 
		for(int i=0;i<5;i++) {
			int ycnt=0;
			for(int j=0;j<5;j++)
			{	ycnt+=plr[j][i]; }
			if(ycnt==0) count++;
			
		}
		
		//대각선 탐색 
		for(int i=0;i<5;i++) {
			
		int zcnt=0;
				zcnt+=plr[i][i];
			if(zcnt==0) count++;
		
		
		//우상향 탐색 
		int zcnt2=0;
				zcnt2+=plr[i][4-i];
			if(zcnt2==0) count++;
	    }
	
		if(count>=3)
			return true;
		else 
			return false;
	}
	
	public static void main(String[] args) {	
		
		int com[]=new int[25];
		Scanner scn=new Scanner(System.in);
		//철수의빙고 
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				plr[i][j]=scn.nextInt();
			}
		}
		System.out.println("===================");
		int res=0;
		//사회자의 빙고 
		for(int i=0;i<25;i++)
		{
			com[i]=scn.nextInt();
			reset(com[i]);
			if(Bingo(com[i])==true) {
				res=i+1;
				break;
			}
		}
		System.out.println(res);
	 }
 }