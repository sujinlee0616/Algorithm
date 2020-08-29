package datastructure;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class NextPermutation {
	
	private int N;
	private Integer[] arr;
	
	public static void main(String[] args) {
		new NextPermutation().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		N = scn.nextInt();
		arr = new Integer[N];
		for(int i = 0; i < N; i++) {
			arr[i] = scn.nextInt();
		}
		
		//Arrays.sort(arr);
		Comparator<Integer> comp = (i,j) -> {return (i - j) * -1;};
		Arrays.sort(arr, (i,j) -> {return (i - j) * -1;});
		do {
			print(arr);
		} while(nextPermutation());
		
		scn.close();
	}
	
	private boolean nextPermutation() {
		int i = N-1;
		while(i > 0 && arr[i] <= arr[i-1]) {
			i--;
		}
		if(i == 0) return false;
		
		int j = N-1;
		while(arr[i-1] >= arr[j]) {
			j--;
		}
		
		swap(arr, i-1, j);
		
		int k = N-1;
		while(i < k) {
			swap(arr, i++, k--);
		}
		return true;
	}
	
	private void print(Integer[] arr) {
		System.out.println("\n----------");
		for(int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n----------");
	}
	private void swap(Integer[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
