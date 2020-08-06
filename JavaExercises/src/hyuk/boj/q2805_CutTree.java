package hyuk.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class q2805_CutTree {

	public static void main(String[] args) {
		new q2805_CutTree().service();
	}

	private void service() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);

			String[] strArr = br.readLine().split(" ");
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(strArr[i]);
			}

			// 컷 : 1~ 20억
			int res = binarySearch(N, M, arr, 0, 1000000000);
			System.out.println(res);
			br.close();
		} catch (Exception e) {

		}
	}

	private int binarySearch(int N, int M, int[] arr, int start, int end) {
		int mid = (int) (((long) start + end) / 2);
		long value = tree(arr, mid);

		if (value == M) {
			return mid;
		}
		if (start + 1 >= end) {
			return start;
		}
		if (value < M) {
			return binarySearch(N, M, arr, start, mid);
		} else {
			return binarySearch(N, M, arr, mid, end);
		}
	}

	private long tree(int[] arr, int mid) {
		long res = 0;
		int value;
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			value = arr[i] - mid;
			if (value < 0)
				value = 0;
			res += value;
		}
		return res;
	}
}
