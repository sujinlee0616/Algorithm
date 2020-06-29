package etc;

import java.util.Scanner;

public class etc_200629_recursion2_mountain {
	// Q. 좌우대칭인 산을 만들어라. 
	// https://m.blog.naver.com/PostView.nhn?blogId=khrock89&logNo=220698623738&proxyReferer=https:%2F%2Fwww.google.com%2F

	public static String mt(int n, String answer) {
		if(n>1) {
			answer=mt(n-1,answer)+n+mt(n-1,answer);
		}
		if(n==1) {
			answer="1";
		}
		//System.out.println("answer="+answer);
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String answer="";
		mt(n,answer);
		System.out.println(mt(n,answer));
		
	}

}
