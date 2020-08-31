package hyuk.swea;

import java.util.Scanner;

public class Q1244_MaxReward_Review02_WithBitMasking {
	
	private int[] arr;
	private int K, ans;
	private final static int INT_SIZE = 32;
	private int[][] visited;
	private int[] selectedArr;
	
	public static void main(String[] args) {
		new Q1244_MaxReward_Review02_WithBitMasking().solution();
	}
	public void solution() {
		Scanner scn = new Scanner(System.in);
		
		int tc = scn.nextInt();
		for(int t = 1; t <= tc; t++) {
			String input = scn.next();
			arr = new int[input.length()];
			for(int i = 0; i < arr.length; i++) {
				arr[i] = input.charAt(i) - '0';
			}
			K = scn.nextInt();
			visited = new int[1000000 / INT_SIZE + 1][20];
			selectedArr = new int[2];
			ans = 0;
			dfs(0,0,0,selectedArr);
			
			System.out.println("#" + t + " " + ans);
		}
		
		scn.close();
	}
	private void dfs(int depth, int k, int start, int[] selectedArr) {
		if(k >= K) {
			ans = max(ans, makeNum(arr));
			return;
		}
		if(depth >= 2) {
			swap(selectedArr);
			k++;
			if(!isVisited(k)) {
				toVisit(k);
				dfs(0,k,0, new int[2]);
			}
			k--;
			swap(selectedArr);
			return;
		}
		for(int i = start; i < arr.length; i++) {
			selectedArr[depth] = i;
			dfs(depth+1, k, i+1,selectedArr);
		}
	}
	private int makeNum(int[] arr) {
		int res = arr[0];
		for(int i = 1; i < arr.length; i++) {
			res *= 10;
			res += arr[i];
		}
		return res;
	}
	private int max(int a, int b) {
		if(a > b)	return a;
		return b;
	}
	private void swap(int[] selectedArr) {
		int a = selectedArr[0];
		int b = selectedArr[1];
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	private boolean isVisited(int k) {
		int visitNum = makeNum(arr);
//		System.out.println("k : " + k);
//		System.out.println("visitNum : " + visitNum);
		int myVisited = visited[visitNum/32][k];
		if((myVisited & (1 << (visitNum%32))) != 0) return true;
		return false;
	}
	private void toVisit(int k) {
		int visitNum = makeNum(arr);
		if((visited[visitNum/32][k] & (1 << (visitNum%32))) == 0) { 
			visited[visitNum/32][k] = (visited[visitNum/32][k] | (1 << (visitNum%32)));
		} else {
			visited[visitNum/32][k] = (visited[visitNum/32][k] - (1 << (visitNum%32)));
		}
	}
}
