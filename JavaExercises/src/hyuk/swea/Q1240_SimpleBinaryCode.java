package hyuk.swea;

import java.util.Scanner;

public class Q1240_SimpleBinaryCode {

	private static int[][] fixedCode = { { 0, 0, 0, 1, 1, 0, 1 }, { 0, 0, 1, 1, 0, 0, 1 }, { 0, 0, 1, 0, 0, 1, 1 },
			{ 0, 1, 1, 1, 1, 0, 1 }, { 0, 1, 0, 0, 0, 1, 1 }, { 0, 1, 1, 0, 0, 0, 1 }, { 0, 1, 0, 1, 1, 1, 1 },
			{ 0, 1, 1, 1, 0, 1, 1 }, { 0, 1, 1, 0, 1, 1, 1 }, { 0, 0, 0, 1, 0, 1, 1 } };

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 1; t <= test; t++) {
			int res = 0;
			int height = scn.nextInt();
			int width = scn.nextInt();
			int[][] arr = new int[height][width];
			String[] tmpArr = new String[height];
			for(int i = 0; i < height; i++) {
				tmpArr[i] = scn.next();
				for(int j = 0; j < width; j++) {
					arr[i][j] = tmpArr[i].charAt(j) - '0';
				}
			}
			//print(arr,height,width);
			for (int i = 0; i < height - 4; i++) {
				//System.out.println("height : " + i);
				for (int j = 0; j < width - 55; j++) {
					boolean suc = isSameHeight(arr, i, j);
					if (!suc)
						continue;
					suc = isCanEncoding(arr, i, j);
					if (!suc)
						continue;
					int[] tmp = makeCode(arr, i, j);
					suc = isCheckCode(tmp);
					if (!suc)
						continue;
					res = makeAns(tmp);
				}
			}
			System.out.println("#" + t + " " + res);
		}
		scn.close();
	}

	private static int makeAns(int[] tmp) {
		int res = 0;
		for (int i = 0; i < 8; i++) {
			res += tmp[i];
		}
		return res;
	}

	private static boolean isCheckCode(int[] tmp) {
		int first = 0;
		for (int i = 0; i < 7; i += 2) {
			first += tmp[i];
		}
		first *= 3;
		for (int i = 1; i < 7; i += 2) {
			first += tmp[i];
		}
		first += tmp[7];
		if (first % 10 == 0) {
			return true;
		}
		return false;
	}

	private static int[] makeCode(int[][] arr, int height, int width) {
		int count = 0;
		int[] res = new int[8];
		for (int i = 0; i < 8; i++) {
			int startIndex = width + i * 7;
			for (int k = 0; k < 10; k++) {
				count = 0;
				for (int j = startIndex; j < startIndex + 7; j++) {
					if (arr[height][j] == fixedCode[k][j - startIndex]) {
						count++;
					}
				}
				if (count >= 7) {
					res[i] = k;
				}
			}
		}
		return res;
	}

	private static boolean isSameHeight(int[][] arr, int height, int width) {
		for (int i = width; i < width + 56; i++) {
			for (int j = height + 1; j < height + 5; j++) {
				if (arr[j][i] != arr[j - 1][i]) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isCanEncoding(int[][] arr, int height, int width) {
		boolean suc = false;
		int count = 0;
		for (int i = 0; i < 8; i++) {
			int startIndex = width + i * 7;
			suc = false;
			for (int k = 0; k < 10; k++) {
				count = 0;
				for (int j = startIndex; j < startIndex + 7; j++) {
					if (arr[height][j] == fixedCode[k][j - startIndex]) {
						count++;
					}
				}
				if (count >= 7) {
					suc = true;
				}
			}
			if (suc == false) {
				return false;
			}
		}
		return true;
	}
	
	private static void print(int[][] arr, int height, int width) {
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
