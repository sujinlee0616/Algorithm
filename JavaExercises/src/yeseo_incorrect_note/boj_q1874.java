package yeseo_incorrect_note;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
public class boj_q1874 {
	
	 /*
	  스택 수열 
	  1회 - 30+a 2회 - 1.5h
	  문제 해석 (예제 해석)
	  peek()호출 
	  */ 
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Stack<Integer> st = new Stack<Integer>();
		ArrayList<String> ans = new ArrayList<String>();
		int n = sc.nextInt();
		int[] a = new int[100001]; 
		
		int m = 1; //자연수 1~하나씩 출력 
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}

		for (int i = 1; i <= n; i++) {
			st.push(i);
			ans.add("+");		//top = a[1]
			while (!st.empty() && st.peek() == a[m]) {
				st.pop();
				ans.add("-");
				m++;
			}
		}

		if (st.empty()) {
			for (String s : ans) {
				System.out.println(s);
			}
		} else {
			System.out.println("NO");
		}

	}
}


