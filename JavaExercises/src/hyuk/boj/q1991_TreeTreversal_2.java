package hyuk.boj;

import java.util.Scanner;

public class q1991_TreeTreversal_2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();

		int[][] tree = new int[30][2];

		for (int i = 0; i < N; i++) {
			String parent = scn.next();
			String left = scn.next();
			String right = scn.next();

			int p = (int) (parent.charAt(0) - 'A' + 1);
			int l = (int) (left.charAt(0) - 'A' + 1);
			int r = (int) (right.charAt(0) - 'A' + 1);

			if (left.charAt(0) >= 'A' && left.charAt(0) <= 'Z') {
				tree[p][0] = l;
			}
			if (right.charAt(0) >= 'A' && right.charAt(0) <= 'Z') {
				tree[p][1] = r;
			}
		}
		preorder(tree, 1);
		System.out.println();
		inorder(tree, 1);
		System.out.println();
		postorder(tree, 1);
	}
	
	public static void preorder(int[][] tree, int node) {
		if(node == 0) {
			return;
		}
		
		System.out.print((char)(node + 'A' - 1));
		preorder(tree, tree[node][0]);
		preorder(tree, tree[node][1]);
	}
	public static void inorder(int[][] tree, int node) {
		if(node == 0) {
			return;
		}
		
		inorder(tree, tree[node][0]);
		System.out.print((char)(node+'A'-1));
		inorder(tree, tree[node][1]);
	}
	public static void postorder(int[][] tree, int node) {
		if(node == 0) {
			return;
		}
		postorder(tree, tree[node][0]);
		postorder(tree, tree[node][1]);
		System.out.print((char)(node+'A'-1));
	}
}
