package hyuk.boj;

import java.util.Scanner;

public class q1929 {

	//100������ �����佺�׳׽�
	public static void primeTable(boolean[] arr) {
		for(int i = 2; i <= 1000000; i++) {
			if(arr[i]) {
				int pos = i;
				int j = 2;
				while(pos*j <= 1000000) {
					arr[pos*(j++)] = false;
				}
			}
		}
	}
	public static void init(boolean[] arr) {
		for(int i = 0; i <= 1000000; i++) {
			arr[i] = true;
		}
		arr[0] = false;
		arr[1] = false;
	}
	
	public static void main(String[] args) {
		int M,N;
		Scanner scn = new Scanner(System.in);
		M = scn.nextInt();
		N = scn.nextInt();
		boolean[] arr = new boolean[1000010];
		
		init(arr);
		primeTable(arr);
		for(int i = M; i <= N; i++) {
			if(arr[i]) {
				System.out.println(i);
			}
		}
	}
}
