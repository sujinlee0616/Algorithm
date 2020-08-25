package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_8016 {
//홀수 피라미드 
// '홀수'정렬시  N^2번 반복 되는 규칙
// 반복문 사용 x  (범위 넘어감) -동일한 이유로 BufferedReader -long사용 
// 1   
// 3 5 7  
// 9 11 13 15 17 
	
	public static void main(String[] args)throws IOException {
		//Scanner scan=new Scanner(System.in);
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T=Integer.valueOf(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			long N=Integer.valueOf(br.readLine())-1;
			//int N=Integer.valueOf(br.readLine());
			//int a,b;
			//a=(N-1)*(N-1)*2+1;
			//b=N*N*2-1;
			//System.out.println("#"+tc+" "+a+" "+b);
		
		//OR
		long L=1;
		long R=1;
		if(N!=0) {//왼쪽 오른쪽의 규칙을 찾아서 리턴 
			
			L= 1+ 2*N *(N+1)- 2*N;
			R= 1+ 2*N *(N+1)+ 2*N;
		}
		System.out.println("#"+tc+" "+L+" "+R);
		}
	}
}
