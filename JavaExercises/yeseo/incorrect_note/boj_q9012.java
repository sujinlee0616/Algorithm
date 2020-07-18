package incorrect_note;

import java.util.Scanner;
import java.util.Stack;

public class boj_q9012 {
  /*
  괄호 
  vps올바른괄호  x->(x) VPS
  실패... 
  */
	
	public static boolean Check(String str[]) {
		int length=str.length;
		Stack<String> s=new Stack<String>();
		
		for(int i=0;i<length;i++) {
			String sth=str[i];
			
			if(sth=="(") {
				s.push(str[i]);
			}else {
				if(!s.empty()) {
					s.pop();
				}else {
					return false; 
				}
			}
		}
		return s.empty(); //스택 초기화 
	}
	public static void main(String[] args) {
		
		int N;//입력받을 개수 
		Scanner scan=new Scanner(System.in);
		N=scan.nextInt();
		
		for(int i=0;i<N;i++) {
			String str[]=new String [N];
			str[i]=scan.next();
			
			if(Check(str)) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
		
		
		
		
		

	}

}
