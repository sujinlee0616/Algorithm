package incorrect_note;

import java.util.Scanner;

public class boj_q5582 {
/*
 공통부분문자열
 2시간 +a 
 문제 이해 시간 오래 걸림 
 
 1) 문자열은 순서대로 탐색
 2) 모음+자음규칙 ?
 3) 모든 문자열은 AON 
 
 
 점화식 코드 :  ** octobirth
 A[i] == B[j] , LCS[i-1][j-1]+1
 A[i] != B[j] , 0
 */
	
	
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		
		char[]A=scn.next().toCharArray();
		char[]B=scn.next().toCharArray();
		int [][] LCS=new int[A.length+1][B.length+1];
		
		int answer=Integer.MIN_VALUE;
		for(int i=1;i<=A.length;i++) {
			for(int j=1;j<=B.length;j++) {
				if(A[i-1]==B[j-1]) {
					LCS[i][j]=LCS[i-1][j-1]+1;
				}
				answer=Math.max(answer, LCS[i][j]);
			}
		}
		System.out.println(answer);
		
	}
}
