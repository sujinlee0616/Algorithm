package etc;

import java.util.Scanner;

// Q. n>1인 십진수 n을 2진수로 변환하라. (String/배열 모두 ok. 재귀적으로 풀 것.) 
// 거꾸로 나오게 해야..

public class etc_200629_recursion1_decimal_to_binary {

	public static String change(int n, String answer) {
		
		int remnant=0;
		
		while(n>1) {
			//String change=change(n/2);
			remnant=n%2;
			//System.out.println("n="+n);
			//System.out.println("remnant="+remnant);
			
			//answer+=Integer.toString(remnant); 
			answer=Integer.toString(remnant)+answer;
			change(n/2,answer);
			//System.out.println("when n="+n+", answer="+answer);
			break;
		}
		if(n==1) {
			remnant=1;
			//System.out.println("n="+n);
			//System.out.println("remnant="+remnant);
			//answer+=Integer.toString(remnant);
			answer=Integer.toString(remnant)+answer;
			System.out.println(answer);
		}
			
		if(n==0) {
			remnant=0;
			//System.out.println("n="+n);
			//System.out.println("remnant="+remnant);
			System.out.println(answer);
		}
		
		//System.out.println("answer="+answer);
		//System.out.println(answer);
		
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		String answer="";
		change(n,answer);
		//System.out.println(change(n));
		
	}
	
}
