package hyuk.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class q1920_FindNum {
	
	private static int N,M;
	private static Set<Integer> set;
	
	public static void main(String[] args) {
			new q1920_FindNum().service();
	}
	private void service(){
		Scanner scn = new Scanner(System.in);
		N = scn.nextInt();
		set = new HashSet<Integer>();
		for(int i = 0; i < N; i++) {
			set.add(scn.nextInt());
		}
		M = scn.nextInt();
		for(int i = 0; i < M; i++) {
			int num = scn.nextInt();
			if(set.contains(num)) System.out.println(1);
			else System.out.println(0);
		}
		
		scn.close();
	}
}
