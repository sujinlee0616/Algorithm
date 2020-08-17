package hyuk.swea;

import java.util.Scanner;

public class Q1244_MaxReward_Review01 {

	private static int ans, totalCnt;
	private static int changeCount;
	private static int[] arr, res;
	private static int[][] visited;

	public static void main(String[] args) {
		new Q1244_MaxReward_Review01().service();
	}

	private void service() {
		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();
		for (int t = 1; t <= tc; t++) {

			ans = 0;
			totalCnt = 0;
			String input = scn.next();
			arr = new int[input.length()];
			res = new int[2];
			visited = new int[1000000][15];
			for (int i = 0; i < input.length(); i++) {
				arr[i] = input.charAt(i) - '0';
			}
			changeCount = scn.nextInt();

			dfs(0, 0);

			System.out.println("#" + t + " " + ans);
		}
		scn.close();
	}

	private void dfs(int cnt, int start) {
		if (totalCnt >= changeCount) {
			ans = max(ans, getNum(arr));
			return;
		}
		if (cnt >= 2) {
			swap(res[0], res[1]);
			int tmp = getNum(arr);
			if(visited[tmp][totalCnt] != 0) {
				swap(res[0],res[1]);
				return;
			}
			visited[tmp][cnt] = 1;
			totalCnt++;
			dfs(0,0);
			totalCnt--;
			swap(res[0],res[1]);
		} else {
			for (int i = start; i < arr.length; i++) {
				int tmp = res[cnt];
				res[cnt] = i;
				dfs(cnt + 1, i + 1);
				res[cnt] = tmp;
			}
		}
	}

	private int max(int a, int b) {
		if (a > b)
			return a;
		return b;
	}

	private int getNum(int[] arr) {
		int res = arr[0];
		for (int i = 1; i < arr.length; i++) {
			res *= 10;
			res += arr[i];
		}
		return res;
	}

	private void swap(int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
