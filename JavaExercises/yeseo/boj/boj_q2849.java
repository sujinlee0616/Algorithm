package boj;

import java.util.Scanner;

public class boj_q2849 {
/*
게임 만든 동준
=1씩줄여서 몇번 수행하면 오름차순 되는가 
=입력받고 - 배열 돌면서 count세기 
=뒤에서부터 세며 감소 
 */
	
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int N=scn.nextInt();
		//level = N = i 
		int count=0;
		int arr[]=new int[N];
		
		for(int i=0;i<N;i++)
			arr[i]=scn.nextInt();
		// 0 1 2 3 (배열은index가 하나 작음) 
		for(int i=N-1;i>=0;i--) {
			//레벨은낮은데 점수가큼 
			if(arr[i]>=arr[i+1]) {
				//count=count+arr[i]-arr[i+1]+1;
				count+=(arr[i]-arr[i+1])+1;
				//1감소 
				arr[i]=arr[i+1]-1;
			}
		}
		
		System.out.println(count);
	}
}
