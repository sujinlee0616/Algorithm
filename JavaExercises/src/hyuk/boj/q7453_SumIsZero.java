package hyuk.boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class q7453_SumIsZero {
	
	private static int[][] totalArr;
	private static int N;
	private static List<Integer> arrA, arrB;
	
	public static void main(String[] args) {
		new q7453_SumIsZero().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		N = scn.nextInt();
		totalArr = new int[4][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 4; j++) {
				totalArr[j][i] = scn.nextInt();
			}
		}
		
		//1. arrA만들기
		arrA = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int sum = totalArr[0][i] + totalArr[1][j];
				arrA.add(sum);
			}
		}
		Collections.sort(arrA);
		//2. arrB만들기
		arrB = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int sum = totalArr[2][i] + totalArr[3][j];
				arrB.add(-1 * sum);
			}
		}
		Collections.sort(arrB);
		// 이진탐색
		int cnt = 0;
		int len = arrA.size();
		for(int i = 0; i < len; i++) {
			int target = arrA.get(i);
			int first = binarySearch(-1, len, target);
			int second = binarySearch(-1, len, target+1);
			cnt += (second - first);
		}
		System.out.println(cnt);
		scn.close();
	}
	private int binarySearch(int start, int end, int target) {
		int mid = (start + end) / 2;
		if(start + 1 >= end) {
			return end;
		}
		
		if(arrB.get(mid) < target) {
			return binarySearch(mid, end, target);
		}else {
			return binarySearch(start, mid, target);
		}
	}
}
