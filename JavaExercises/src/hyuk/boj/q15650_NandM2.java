package hyuk.boj;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class q15650_NandM2 {
	private static int N;
	private static int M;
	private static int[] ans = new int[10];
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		N = scn.nextInt();
		M = scn.nextInt();
		
		getNandM(0, 0);
		try {
			bw.flush();
			bw.close();
		} catch (Exception e) {
		}
	}

	private static void getNandM(int start, int pos) {
		if(pos >= M) {
			printNandM();
			return;
		}
		
		for(int i = start+1; i <= N; i++) {
			ans[pos] = i;
			getNandM(i,pos+1);
		}
	}

	private static void printNandM() {
		try {
			for(int i = 0; i < M; i++) {
				bw.write(String.valueOf(ans[i]) + " ");
			}
			bw.newLine();	
		}catch(Exception e) {
			
		}
		
	}
}
