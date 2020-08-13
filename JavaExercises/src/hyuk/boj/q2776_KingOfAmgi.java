package hyuk.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class q2776_KingOfAmgi {

	private static int N, M;
	private static Set<Integer> set;

	public static void main(String[] args) {
		try {
			new q2776_KingOfAmgi().service();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void service() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			N = Integer.parseInt(br.readLine());
			set = new HashSet<Integer>();
			String[] input = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				set.add(Integer.parseInt(input[i]));
			}
			M = Integer.parseInt(br.readLine());
			String[] output = br.readLine().split(" ");
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				int num = Integer.parseInt(output[i]);
				if (set.contains(num))
					sb.append(1 + "\n");
				else
					sb.append(0 + "\n");
			}
			System.out.print(sb.toString());
		}
		br.close();
	}
}
