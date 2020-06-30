package hyuk.presentation;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class NandM1 {

	private static int N;
	private static int M;
	private static int[] visited = new int[10];
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static int[] ans = new int[10];

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		N = scn.nextInt();
		M = scn.nextInt();
		
		getNandM(0);
		try {
			bw.flush();
			bw.close();
		} catch (Exception e) {

		}
	}

	private static void getNandM(int pos) {
		if (pos >= M) {
			printNandM();
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(visited[i] == 0) {
				visited[i] = 1;
				ans[pos] = i;
				getNandM(pos+1);
				visited[i] = 0;
			}
		}
	}

	private static void printNandM() {
		try {
			for (int i = 0; i < M; i++) {
				bw.write(String.valueOf(ans[i]) + " ");
			}
			bw.newLine();
		} catch (Exception e) {

		}

	}
}
