package hyuk.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q1697_HideOnBush {
	
	private static int N,K;
	private static int[] arr;
	private static int res;
	
	public static void main(String[] args) {
		new q1697_HideOnBush().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		N = scn.nextInt();
		K = scn.nextInt();
		arr = new int[100010];
		
		bfs();
		System.out.println(res);
		scn.close();
	}
	
	private void bfs() {
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(N);
		int[] dx = {-1,1};
		arr[N] = 1;
		if(N == K) return;
		arr[K] = 2;
		
		while(que.size() != 0) {
			int len = que.size();
			res++;
			while(len-- > 0) {
				int node = que.poll();
				for(int i = 0; i < 2; i++) {
					int nx = node + dx[i];
					if(nx < 0 || nx > 100000) continue;
					if(arr[nx] == arr[node]) continue;
					if(arr[nx] != 0 && arr[node] != 0) return;
					arr[nx] = arr[node];
					que.offer(nx);
				}
				int nx = node * 2;
				if(nx < 0 || nx > 100000) continue;
				if(arr[nx] == arr[node]) continue;
				if(arr[nx] != 0 && arr[node] != 0) return;
				arr[nx] = arr[node];
				que.offer(nx);
				
			}
		}
	}
}
