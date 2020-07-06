package boj;

import java.util.Scanner;
import java.util.Stack;

public class boj_q2493_tower {
	
	// 이클립스에선 OK but 백준에선 메모리초과됨 
	// 1. 왼쪽 탑이 나보다 크다면 
	//  - top에 왼쪽 탑의 높이를 넣고, top_index에 왼쪽 탑의 인덱스를 넣는다 
	// 2. 왼쪽 탑이 나보다 작다면
	//  - 내가 top에 들어가야 하고, 왼쪽 탑은 pop해야 함. 
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] input=new int[n];
		
		for(int i=0;i<n;i++)
			input[i]=sc.nextInt();
		
		Stack<Integer> top=new Stack<Integer>();
		Stack<Integer> top_index=new Stack<Integer>();
		top.push(input[0]);
		top_index.push(1);
		System.out.print(0);
		
		for(int i=1;i<n;i++) {
			if(top.peek()>input[i]) { 
				System.out.print(top_index.peek());
				top.push(input[i]);
				top_index.push(i+1);
			}
			else {
				top.pop();
				top_index.pop();
				if(top.isEmpty())
					System.out.print(0);
				else
					System.out.print(top_index.peek());
				top.push(input[i]);
				top_index.push(i+1);
				
			}
		}
		
	}


}
