package hyuk.boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class q1874 {
	public static void main(String[] args) {
		int N; 
		int[] arr = new int[100010];
		List<Character> ans = new ArrayList<Character>();
		Stack<Integer> stack = new Stack<Integer>();
		
		Scanner scn = new Scanner(System.in);
		N = scn.nextInt();
		for(int i = 0; i < N; i++) {
			arr[i] = scn.nextInt();
		}
		
		int num = 1;
		int index = 0;
		while(index < N) {
			if(stack.empty() || arr[index] > stack.peek()) {
				stack.push(num++);
				ans.add('+');
			} else if(arr[index] == stack.peek()) {
				ans.add('-');
				index++;
				stack.pop();
			} else {
				System.out.println("NO");
				return;
			}
		}
		for(int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}
}
