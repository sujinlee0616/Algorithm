package CodeTest;

import java.util.Scanner;

public class Q2 {

/*
email validation check 

 */
	
	public static void main(String[] args) {

		Scanner scn=new Scanner(System.in);
		String []emails={"abc.def@x.com", "abc", "abc@defx", "abc@defx.xyz"};
		int cnt=0;
		for(int i=0;i<emails.length;i++) {
			if(solution(emails[i])) {
				cnt++;  //true일때만 ++ 
			}
			System.out.println(cnt);
		}
		
	}
	public static boolean solution(String email) {

			int at1=email.indexOf("@");
			int atN=email.lastIndexOf("@");
			
			if(at1==-1 || at1!=atN) // 아예 @이 없거나 두개 이상 있으면 
			{
				return false;
			}
			for(int i=0;i<at1;i++) {
				if(!(email.charAt(i)>='a'&&email.charAt(i)<='z')|| email.charAt(i)=='.') // 들어오는 값이 영문이거나 . 이 아니라
				{
					return false;
				}
			}
			
			
			if(!(email.endsWith(".com") || email.endsWith(".net") ||email.endsWith(".org"))) 
			{ 
				return false;
			}
			
			else {
				return true;
			}

		}

	}


