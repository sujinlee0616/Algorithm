package boj;

import java.util.Scanner;

public class boj_q1629 {
/*
곱셈
시간: 35' -> 제출 후 오류 : 1h  
재귀함수 (짝/홀) 
라이브러리 사용 방법 
O(N) -> O(log N) 
 */
	public static int power(int a, int b,int c) {
		if(b==0)
			return 1;
		if(b==1)
			return a%c;
		if(b%2==0) {
			 int res=power(a,b/2,c);
			return res*res%c;
			//res=(int)Math.pow(a, b);
		}else {
			 int res=power(a,b-1,c);
			return (res*res)%c*a%c; //여기가 핵심 a*res%c 도결과는 동일 코드는 틀림 
		}
	}
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		int b=scan.nextInt();
		int c=scan.nextInt();
		System.out.println(power(a,b,c));
		
	}
}
