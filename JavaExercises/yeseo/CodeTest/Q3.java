package CodeTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Q3 {
/*
STACK !! 
0,1 짝지어 제거 
1011
2
0110011
1
000111
0
 */
	public static void main(String[] args) {
		Stack<Character> s=new Stack<Character>();
		
		Scanner scn=new Scanner(System.in);
		String input=scn.nextLine(); // Line으로 한줄 받기도 가능함.. 공백 포함 한 줄에 쓴거 다 받아옴 
	
		for(int i=0;i<input.length();i++) {
			if(s.size()==0) {
				s.push(input.charAt(i));
			}else if(s.peek()==input.charAt(i)) {
				s.push(input.charAt(i));
			}else {
				s.pop();
			}
		}
		System.out.println(s.size());
	}
}
