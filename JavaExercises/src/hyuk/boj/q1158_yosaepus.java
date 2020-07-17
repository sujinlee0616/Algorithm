package hyuk.boj;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class q1158_yosaepus {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int M = scn.nextInt();
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i = 0; i < N; i++) {
			que.add(i+1);
		}
		List<Integer> ans = new LinkedList<Integer>();
		int pos = 0;
		
		while(que.size() != 0) {
			for(int i = 1; i < M; i++) {
				int a = que.poll();
				que.offer(a);
			}
			ans.add(que.poll());
		}
		System.out.print("<");
		int i = 0;
		for(i = 0; i < ans.size()-1; i++) {
			System.out.print(ans.get(i) + ", ");
		}
		System.out.print(ans.get(i));
		System.out.print(">");
	}
}
