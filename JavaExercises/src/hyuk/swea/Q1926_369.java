package hyuk.swea;

import java.util.Scanner;

public class Q1926_369 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		for(int i = 1; i <= N; i++) {
			int[] arr = makeArr(i);
			int res = getNumber(arr);
			if(res < 0) {
				for(int j = 0; j < -1 * res; j++) {
					System.out.print("-");
				}
			} else {
				System.out.print(res);
			}
			System.out.print(" ");
		}
	}
	
	private static int getNumber(int[] makeArr) {
		int res = 0;
		int count = 0;
		int ten = 1;
		for(int i = makeArr.length-1; i >= 0; i--) {
			if(makeArr[i] == 3 || makeArr[i] == 6 || makeArr[i] == 9) {
				count++;
			} else {
				res += makeArr[i] * ten;
				ten *= 10;
			}
			
		}
		if(count != 0) {
			return -1 * count;
		}
		return res;
	}
	private static int[] makeArr(int num) {
		int len = 0;
		int copyNum = num;
		while(copyNum != 0) {
			len++;
			copyNum /= 10;
		}
		int[] arr = new int[len];
		for(int i = len-1 ; i >= 0; i--) {
			arr[len-1-i] = getNumPos(num, i);
		}
		return arr;
	}
	private static int getNumPos(int num, int pos) {
		for(int i = 0; i < pos; i++) {
			num /= 10;
		}
		num %= 10;
		return num;
	}
}
