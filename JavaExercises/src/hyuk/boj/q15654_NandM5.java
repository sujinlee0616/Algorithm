package hyuk.boj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class q15654_NandM5 {
	
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static int N,M;
	private static int[] input = new int[10];
	private static int[] output = new int[10]; // 값 저장
	private static int[] visited = new int[10];
	public static void main(String[] args) throws IOException{
		Scanner scn = new Scanner(System.in);
		
		N = scn.nextInt();
		M = scn.nextInt();
		for(int i = 0; i < N; i++) {
			input[i] = scn.nextInt();
		}
		
		// 1. 정렬한다
		sort();
		// 2. 시작
		nAndM(0);
		
		bw.flush();
		bw.close();
	}
	
	//오름차순
	private static void sort() {
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
	
	private static void nAndM(int pos) throws IOException{
		if(pos == M) {
			print();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i] == 0) {
				visited[i] = 1;
				output[pos] = input[i];
				nAndM(pos+1);
				visited[i] = 0;
			}
		}
	}
	
	private static void print() throws IOException{
		for(int i = 0; i < M; i++) {
			bw.write(output[i] + " ");
		}
		bw.newLine();
	}
}
