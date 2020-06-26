package yeseo;

import java.util.Scanner;

public class boj_q2578 {

	/*
	 1.사용자가 사용할 빙고 2차원 배열 5x5선언, 값채움 
	 2.사회자가 호명할 숫자 배열 공간 25 선언 
	 3.가로 세로 대각선의 count++ 	 
	 */

	private static int plr[][]=new int[5][5];
	public static int check (int n) {
		int cnt=0;
		
		for (int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(plr[i][j]==n) plr[i][j]=0;
			}

			
		}
		//가로빙고 카운팅
		for(int i=0;i<5;i++)
		{
			int xcnt=0;
			for(int j=0;j<5;j++)
			{
				xcnt +=plr[i][j];
			}
			if(cnt==0){
				cnt++;
			}
		}
		//세로  
		for(int i=0;i<5;i++)
		{
			int ycnt=0;
			for(int j=0;j<5;j++)
			{
				ycnt +=plr[j][i];
			}
			if(cnt==0){
				cnt++;
			}
		}
		//대각선 
		int zcnt=0;
		for(int i=0;i<5;i++)
		{
			zcnt+=plr[i][i];
		}
		if(zcnt==0) {
			cnt++;
		}
		zcnt=0;
		for(int i=0;i<5;i++)
		{
			zcnt+=plr[0+i][5-1-i];
		}
		if(zcnt==0) {
			cnt++;
		}
		
		return cnt;
	}
	
	public static void main(String[] args) {
	
	int []com=new int[25];
	Scanner scn=new Scanner(System.in);
	//철수 빙고판 만들기 
	for (int i=0;i<plr.length;i++)
	{
		for(int j=0;j<plr.length;j++)
		{	
			plr[i][j]=(int)(Math.random()*25)+1;
			//중복되면 다시 연산 
			for(int k=0; k<j;k++) {
				if(plr[i][j]==plr[i][j-1]) {
					j--;
					break;
				}
			}
			System.out.print(plr[i][j]+"\t");
		}
			
		System.out.println();
	}
	
	//심판 
	int count=0;
	for (int i=0;i<25;i++)
	{
		com[i]=scn.nextInt();
		if(check(com[i])>=3) {
			System.out.println(count);
		}
		count++;
	}
	
  }
}
