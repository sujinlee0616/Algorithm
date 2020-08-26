package hyuk.swea;

import java.util.Scanner;

public class Q1288_SheepCount {
	public static void main(String[] args) {
		new Q1288_SheepCount().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		int tc = scn.nextInt();
		for(int t = 1; t <= tc; t++) {
			int N = scn.nextInt();
			int[] visited = new int[10];
			int count = 0;
			int myN = 0;
			while(true) {
				if(isFullVisited(visited)) {
					N = myN;
					break;
				}
				myN = N * (++count);
				visit(visited, myN);
			}
			System.out.println("#" + t +" " +  N);
		}
		
		scn.close();
	}
	private boolean isFullVisited(int[] visited) {
		for(int i = 0; i < 10; i++) {
			if(visited[i] == 0) return false;
		}
		return true;
	}
	private void visit(int[] visited, int N) {
		while(N > 0) {
			visited[N%10] = 1;
			N /= 10;
		}
	}
}
