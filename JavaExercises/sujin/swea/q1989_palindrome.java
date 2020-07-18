package swea;

import java.util.Scanner;

public class q1989_palindrome {
	
	public static int solution(String s){

		int ans=1; 
		int leng=s.length();
		
		for(int i=0;i<=leng/2;i++) {
			//System.out.println("i="+i);
			if(s.charAt(i)!=s.charAt(leng-1-i)) {
				//System.out.println("s.charAt(+"+i+")="+s.charAt(i));
				//System.out.println("s.charAt(+"+(leng-1-i)+")="+s.charAt(leng-1-i));
				ans=0;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		for(int i=0;i<n;i++) {
			String s=sc.next();
			System.out.print("#"+(i+1)+" ");
			System.out.println(solution(s));
		}
	}
}
