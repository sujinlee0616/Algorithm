package hyuk.swea;

import java.util.Scanner;

public class swea1231_InOrder {


	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			char[] value = new char[110];
			int[][] tree = new int[110][2];
			int N = Integer.parseInt(scn.nextLine());
			for (int i = 0; i < N; i++) {
				String[] input = scn.nextLine().split(" ");
				//System.out.println("input len : " + input.length);
				if(input.length > 2) {
					tree[Integer.parseInt(input[0])][0] = Integer.parseInt(input[2]);
				}
				if(input.length > 3) {
					tree[Integer.parseInt(input[0])][1] = Integer.parseInt(input[3]);
				}
				value[Integer.parseInt(input[0])] = input[1].charAt(0);
			}
			System.out.print("#" + t + " ");
			inorder(value, tree, 1);
			System.out.println();
		}

	}

	public static void inorder(char[] value, int[][] tree, int node) {
		if (node == 0) {
			return;
		}

		// 왼쪽 보자!
		inorder(value, tree,tree[node][0]);
		// 출력
		System.out.print(value[node]);
		// 오른쪽
		inorder(value, tree, tree[node][1]);
	}
}
