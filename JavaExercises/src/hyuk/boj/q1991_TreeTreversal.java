package hyuk.boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q1991_TreeTreversal {
	public static void main(String[] args) {
		int[][] arr = new int[30][3];
		
		// A = 1,  ~  ,Z = Z - A + 1
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		
		for(int i = 0; i < N; i++) {
			int index = (int)(scn.next().charAt(0) - 'A');
			int left = (int)(scn.next().charAt(0) - 'A' + 1);
			int right = (int)(scn.next().charAt(0) - 'A' + 1);
			
			if(left >= 1 && left <= (int)('Z' - 'A' + 1)) {
				arr[index][0] = left;
			}
			if(right >= 1 && right <= (int)('Z' - 'A' + 1)) {
				arr[index][1] = right;
			}
		}
		preorder(arr, 1);
		System.out.println();
		inorder(arr, 1);
		System.out.println();
		postorder(arr, 1);
	}
	
	public static void preorder(int[][] arr, int value) {
		if(value == 0) {
			return;
		}
		
		System.out.print((char)('A' + value - 1));
		for(int i = 0; i < 2; i++) {
			preorder(arr, arr[value-1][i]);
		}
	}
	public static void inorder(int[][] arr, int value) {
		if(value == 0) {
			return;
		}
		
		inorder(arr, arr[value-1][0]);
		System.out.print((char)('A' + value - 1));
		inorder(arr, arr[value-1][1]);
	}
	public static void postorder(int[][] arr, int value) {
		if(value == 0) {
			return;
		}
		for(int i = 0; i < 2; i++) {
			postorder(arr, arr[value-1][i]);
		}
		System.out.print((char)('A' + value - 1));
	}
}
