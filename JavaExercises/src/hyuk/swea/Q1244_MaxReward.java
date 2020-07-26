package hyuk.swea;

import java.util.Scanner;

public class Q1244_MaxReward {
	
	private static int[][] visited = new int[1000000][20];
	private static int ans;
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for(int t= 1; t <= test; t++) {
			int inputNumber = scn.nextInt();
			int[] arr = makeArr(inputNumber);
			//print(arr);
			int count = scn.nextInt();
			init(count);
			
			dfs(arr, 0,count);
			
			//출력
			System.out.print("#" + t + " " + ans);
			
			System.out.println();
		}
		scn.close();
	}
	private static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	private static int[] makeArr(int num) {
		int len = 0;
		int numCopy = num;
		while(numCopy != 0) {
			len++;
			numCopy /= 10;
		}
		int[] arr = new int[len];
		for(int i = len-1; i >= 0; i--) {
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
	private static int[] getMax(int[] arr, int start ) {
		int[] maxArr = {arr[start],start};
		for(int i = start; i < arr.length; i++) {
			if(maxArr[0] < arr[i]) {
				maxArr[0] = arr[i];
				maxArr[1] = i;
			} else if(maxArr[0] == arr[i]) {
				int[] copyArr = getArr(arr);
				swap(copyArr, maxArr[1], start);
				int[] copyArr2 = getArr(arr);
				swap(copyArr2, i, start);
				int a = makeNum(copyArr);
				int b = makeNum(copyArr2);
				if(a < b) {
					maxArr[0] = arr[i];
					maxArr[1] = i;
				}
			}
		}
		return maxArr;
	}
	private static void print(int[] arr) {
		System.out.print("print:");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println();
	}
	private static int makeNum(int[] arr) {
		int num = 0;
		int pos = 1;
		for(int i = 0; i < arr.length; i++) {
			num += arr[arr.length-1-i] * pos;
			pos *= 10;
		}
		return num;
	}
	private static int[] getArr(int[] arr) {
		int[] res = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}
	private static void init(int count) {
		ans = 0;
		for(int i = 0; i < 1000000; i++) {
			for(int j = 0; j < count; j++) {
				visited[i][j] = 0;
			}
		}
	}
	private static void dfs(int[] arr, int pos, int inputNumber) {
		if(pos == inputNumber) {
			//print(arr);
			int tmp = makeNum(arr);
			ans = max(ans, tmp);
			return;
		}
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = i+1; j < arr.length; j++) {
				swap(arr, i, j);
				int tmp = makeNum(arr);
				if(visited[tmp][pos+1] == 0) {
					visited[tmp][pos+1] = 1;
					dfs(arr, pos+1, inputNumber);
				}
				swap(arr,i,j);
			}
		}
	}
	private static int max(int a, int b) {
		if(a > b)	return a;
		return b;
	}
}
