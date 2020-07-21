package hyuk.boj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q15656_NandM7 {
	
	private static int N,M;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static int[] res = new int[10];
	private static int[] input = new int[10];
	
	public static void main(String[] args) throws IOException{
		
		Scanner scn = new Scanner(System.in);
		N = scn.nextInt();
		M = scn.nextInt();
		
		for(int i = 0; i < N; i++) {
			input[i] = scn.nextInt();
		}
		
		//1. input 정렬
		sort(input);
		//3. 재귀
		nAndM(0, 0);
		
		bw.flush();
		bw.close();
	}
	
	private static void sort(int[] input) {
		int min = 0;
		for(int i = 0; i < N-1; i++) {
			min = i;
			for(int j = i+1; j < N; j++) {
				if(input[min] > input[j]) {
					min = j;
				}
			}
			int tmp = input[min];
			input[min] = input[i];
			input[i] = tmp;
		}
	}
	
	private static void nAndM (int start, int pos) throws IOException{
		if(pos == M) {
			if(dedupl()) {
				print();
			}
			return;
		}
		
		for(int i = 0; i < N; i++) {
			res[pos] = input[i+1];
			nAndM(i, pos+1);
		}
	}
	
	private static void print() throws IOException{
		for(int i = 0; i < M; i++) {
			bw.write(res[i] + " ");
		}
		bw.newLine();
	}
	
	private static boolean dedupl() {
		int value = 0;
		for(int i = 0; i < M-1; i++) {
			value = res[i];
			for(int j = i+1; j < M; j++) {
				if(value == res[j])
					return false;
			}
		}
		return true;
	}
}
