package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_q10799 {
//쇠막대기 
	// ()레이저 (   ) 막대
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc=new Scanner(System.in);
			String stick=sc.next();
			int ans=0;
			
			List<Character> stack =new ArrayList<>();
			for(int i=0;i<stick.length();i++) {
				if(stick.charAt(i)=='(') {
					stack.add('(');
				}else {
					stack.remove(stack.size()-1);
					
					if(stick.charAt(i-1)=='(') {
						ans+=stack.size();
					}else {
						ans+=1;
					}
				}
			}
			System.out.println(ans);
	}

}
