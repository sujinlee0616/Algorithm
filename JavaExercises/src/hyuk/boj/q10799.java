package hyuk.boj;

import java.util.Scanner;
import java.util.Stack;

public class q10799 {
	public static void main(String[] args) {
		String input;
		Scanner scn = new Scanner(System.in);
		input = scn.nextLine();
		
		Stack<Character> stack = new Stack<Character>();
		
		int stickNum = 0;
		boolean fire = false;
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if(c == '(') {
				fire = false;
				stack.push('(');
				stickNum++;
			} else if(c == ')') {
				if(fire == false) {
					//레이져다
					
				}
			}
		}
	}
}
