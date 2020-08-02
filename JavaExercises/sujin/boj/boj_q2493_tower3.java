package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

// idea) 
// 1. 위치와 높이 한 번에 다루기 힘드니까... 클래스로 만들어버리자. 
//  - 위치(index)와, 높이(height)를 한 방에 처리할 수 있도록 Top 클래스를 만들자. 
// 2. 탐색하는 경우의 수를 나눠보자. 
//  - 탑을 1번부터 조사하는데.. 스택에다가 탑을 1번부터 넣어보고.. 
// 1) 스택이 비어있다 ==> 왼쪽놈부터 집어넣자 
// 2) 스택에 있는 놈(왼쪽)보다 내가 더 height가 크다 ==>  
// 3) 스택에 있는 놈(왼쪽)보다 내가 더 height가 작다 ==> 

/*
 *1) current 탑을 저장 스택에 저장하는 이유? LIFO하면서 안에 있는값이 큰지 작은지 판단 해야 함 .
  2) 작은 쪽 인덱스 (왼쪽)에 current보다 큰 값이 있으면
  3) stack에서 꺼내
  4) 작은 값이라면
  5) stack에 current를 담
  6) 같은 값이라면
  7) 무시  
*/


public class boj_q2493_tower3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 탑의 수는 1~50만개
		// 탑의 높이는 1~천만 
		// ==> 숫자가 크네... ==> Scanner 말고 BufferedReader쓰자 
		// 입력값이 최대 50만개이니까, stack에서 최악의 경우에 peek/pop/push 한번씩 일어난다고 치면 150만번 ==> BufferedReader 사용했음 
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
		// 1. 탑의 수 
		int n = Integer.parseInt(bf.readLine());
		// 2. 탑들의 높이값을 저장 
		int[] arr=new int[n+1]; // 
		String s=bf.readLine();
		String[] s2=s.split(" ");
		
		for (int i=1; i<=n; i++) { // 1부터 n까지 
			arr[i]=Integer.parseInt(s2[i]);
			//System.out.println("arr["+i+"]="+arr[i]);
		}
		
		// Tower 클래스로 Stack을 만들자 
		Stack<Top> stk = new Stack<Top>();
		
		for(int i=1;i<=n;i++) {
			if(stk.size()==0) {
				stk.push(new Top(i,arr[i]));
			}
			if(stk.peek().height < arr[i]) { // 스택에 들어가있는 애(왼쪽)이 나보다 작으면 
				stk.pop(); 
			}
			else if(stk.peek().height > arr[i]) { // 스택에 들어가있는 애(왼쪽)이 나보다 크면 
				
			}
				
		}
	}
	
	
	static class Top {  // 탑의 위치와, 높이를 저장하는 클래스 -> 위치: index, 높이 : height 
		public int index;
		public int height;

		Top(int i, int v) {
			index = i;
			height = v;
		}
	}
}


