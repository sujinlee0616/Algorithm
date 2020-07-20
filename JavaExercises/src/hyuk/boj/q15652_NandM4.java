package hyuk.boj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class q15652_NandM4 {
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static int[] res = new int[10];
	private static int N,M;
	public static void main(String[] args) throws IOException{
		Scanner scn = new Scanner(System.in);
		N= scn.nextInt();
		M= scn.nextInt();
		nAndM(0, 0);
		
		bw.flush();
	}
	
	private static void nAndM(int start, int pos) throws IOException{
		if(pos == M) {
			print();
			return;
		}
		for(int i = start; i <N; i++) {
			res[pos] = i+1;
			nAndM(i, pos+1);
		}
	}
	private static void print() throws IOException{
		for(int i = 0; i < M; i++) {
			bw.write(res[i] + " ");
		}
		bw.newLine();
	}
}
