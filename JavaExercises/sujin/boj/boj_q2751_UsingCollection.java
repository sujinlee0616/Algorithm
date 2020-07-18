package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 시간초과뜸 ㅠㅠ 

public class boj_q2751_UsingCollection {
	
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		
		ArrayList<Integer> list=new ArrayList<Integer>();
		
		for(int i=0;i<N;i++) {
			list.add(scan.nextInt());
		}
		
		Collections.sort(list);
		
		for(int n:list)
		{
			System.out.println(n);
		}

	}
	

}
