package boj;

import java.util.LinkedList;
import java.util.Scanner;

public class boj_q1158 {
//요세푸스 
	public static void main(String[] args) { 
		Scanner scn=new Scanner(System.in);
		int N=scn.nextInt();
		int K=scn.nextInt();
		
		LinkedList<Integer> list=new LinkedList<>();
		LinkedList<Integer> res=new LinkedList<>();
		
		
		for(int i=0;i<N;i++) 
			list.add(i+1);
		
		int temp=0;
		
		
		while(!list.isEmpty()) {
			temp=(temp+K-1)%list.size();
			res.add(list.remove(temp));
		}
		
		System.out.print("<");
		
		for(int j=0;j<N;j++) {
			System.out.print(res.get(j));
			
			if(j!=N-1) {
				System.out.print(",");
			}
		}
		System.out.print(">");
	}
}
