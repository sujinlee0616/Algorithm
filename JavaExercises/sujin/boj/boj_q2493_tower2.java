package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class boj_q2493_tower2 {
	
	// idea1. 두 개의 경우로 나눌 수 있음. 
	// 1) 스택에 마지막으로 쌓인 높이 > 현재 탑의 높이 
	// 2) 스택에 마지막으로 쌓인 높이 < 현재 탑의 높이 													
	// idea2. 높이를 비교하지만 index+1값을 반환 ==> index와 height 저장하는 두 값이 있어야. 
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		String s = bf.readLine();
		String[] s2 = s.split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(s2[i]);
		}
		Stack<Top> stack = new Stack<Top>();

		for (int i = 0; i < N; i++) { // 탑을 0부터 끝까지 조사한다 - 선형탐색
			while (true) { // pop은 여러번 할 수도 있기 때문에 
				if (stack.size() == 0) {
					System.out.print(0 + " ");
					stack.push(new Top(i, arr[i]));
					break; // pop을 한 것이 아니라면, while문을 계속 돌 필요가 없다
				} else if (stack.peek().value > arr[i]) {
					System.out.print(stack.peek().index+1 + " ");
					stack.push(new Top(i, arr[i]));
					break;
				} else if (stack.peek().value < arr[i]) {
					stack.pop();
				}
			}
		}
	}
}

class Top {  //위치와, 높이를 저장하는 클래스 -> 위치 : index, 높이 : value
	public int index;
	public int value;

	Top(int i, int v) {
		index = i;
		value = v;
	}
}
