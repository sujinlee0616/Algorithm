package hyuk.boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class q7453_SumIsZero {
	
	private static int[][] totalArr;
	private static int N;
	private static long[] arrA, arrB;
	
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
		arrA = new long[N*N];
		int index = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				long sum = totalArr[0][i] + totalArr[1][j];
				arrA[index++] = sum;
			}
		}
		Arrays.sort(arrA);
		//2. arrB만들기
		arrB = new long[N*N];
		index = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int sum = totalArr[2][i] + totalArr[3][j];
				arrB[index++] = sum * -1;
			}
		}
		Arrays.sort(arrB);
		// 이진탐색
		long cnt = 0;
		int len = arrA.length;
		for(int i = 0; i < len; i++) {
			long target = arrA[i];
			long first = binarySearch(-1, len, target);
			long second = binarySearch(-1, len, target+1);
			cnt += (second - first);
		}
		System.out.println(cnt);
		scn.close();
	}
	private long binarySearch(long start, long end, long target) {
		long mid = (start + end) / 2;
		if(start + 1 >= end) {
			return end;
		}
		
		if(arrB[(int)mid] < target) {
			return binarySearch(mid, end, target);
		}else {
			return binarySearch(start, mid, target);
		}
	}
}
