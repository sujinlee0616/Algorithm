package boj;

import java.util.Scanner;

public class boj_1074_Z {
//Z
	/*
	 1)2^N , 2^N 입력받을 배열 받는다
	 2)방문시마다 count++하고
	 3)Z모양으로 탐색한 원소 (r,c)를 Solution에 넣으면 값 도출 
	
	 [재귀 / 분할정복] 
	 
	 Z 모양으로 간다는 것 
	 = 4등분으로 나눔 
	 0  1   = 1면 2면 
	 2  3	  3면 4면 
	 */
	public static void main(String[] args) {

	 Scanner sc=new Scanner(System.in);
	    int n = sc.nextInt();
	    int r = sc.nextInt();
	    int c = sc.nextInt();
	    int ans = 0;
	    int y = (int) Math.pow(2, n) / 2; //2 
	    int x = y;//2 
	 
	    while (n-- > 0) {
	        int temp = (int) Math.pow(2, n) / 2;
	        int skip = (int) Math.pow(4, n);
	        // 4등분으로 나눌 map 필요 
	  
	        //y좌표가 열 끝까지 가기전 + x좌표가 행끝까지가기 전 
	        if (r < y && c < x) {
	            // 1
	            x -= temp;
	            y -= temp;
	        } else if (r < y && x <= c) {
	            // 2
	            x += temp;
	            y -= temp;
	            ans += skip;
	        } else if (y <= r && c < x) {
	            // 3
	            x -= temp;
	            y += temp;
	            ans += skip * 2;
	        } else {
	            // 4
	            x += temp;
	            y += temp;
	            ans += skip * 3;
	        }
	    }
	    System.out.println(ans);
	}
}