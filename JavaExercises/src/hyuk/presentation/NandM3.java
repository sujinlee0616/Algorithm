package hyuk.presentation;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class NandM3 {
	private static int N;
	private static int M;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		N = scn.nextInt();
		M = scn.nextInt();
		int[] ans = new int[10];
		getNandM(ans, 0);

		try {
			bw.flush();
			bw.close();
		} catch (Exception e) {

		}

	}

	private static void getNandM(int[] ans, int pos) {

		if (pos >= M) {
			printArr(ans);
			return;
		}
		for (int i = 1; i <= N; i++) {
			ans[pos] = i;
			getNandM(ans, pos + 1);
		}
	}

	private static void printArr(int[] ans) {
		try {
			for (int i = 0; i < M; i++) {
				bw.write(String.valueOf(ans[i]) + " ");
			}
			bw.newLine();
		} catch (Exception e) {
		}
	}
}
