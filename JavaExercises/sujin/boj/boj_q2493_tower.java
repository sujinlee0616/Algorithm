package boj;

import java.util.Scanner;
import java.util.Stack;

// 왼쪽으로 신호 쏘는데, 자기보다 높이 높은 가장 최초의 탑이 수신함. 
// 각각의 탑들에서 발사한 레이저 신호를 수신한 탑들의 번호를 출력 
// 수신 가능한 탑이 없는 경우는 0 리턴. 

// idea) 세가지로 나눌 수 있다. 
// 1. 스택에 아무 것도 없을 때 
// 2. 앞의 값보다 작을 때 
// 3. 앞의 값보다  때 

public class boj_q2493_tower {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(); // 탑의 수 
		
		int height[]=new int[n]; // 각 탑의 높
		// 값 입력 
		for(int i=0;i<n;i++) {
			height[i]=sc.nextInt();
			//System.out.println("height["+i+"]="+height[i]);
		}

		Stack<Integer> stk=new Stack<Integer>();
		
		for(int i=0;i<n;i++) {
			stk.push(height[i]);
		}
		for(int i=n-1;i>1;i--) {
			for(int j=1;j<i;j++) {
				if(height[i]<height[i-j]) {
					stk.push(i-j+1);
					break;
				}
					
			}
		}
		// 첫번째 탑은 무조건 0. 
		
		for(int i=0;i<n;i++)
			System.out.print(stk.pop());
		

		// 결과 만드는걸 스택으로 처리하는 것 같은데...
		// 1. height 배열 맨 마지막 원소부터 검사 
		// 2. 자기보다 앞선 원소가 자기보다 높이가 높으면 그 원소의 index를 저장한다. 
		// 3. 자기보다 앞선 원소에서 자기보다 높이가 높은 원소가 없으면 0을 저장한다. 
		
		// 1. height 배열을 Stack에 넣는다. 
		// 2. 자기보다 앞선 원소가 자기보다 높이가 높으면, index를  ans[] 배열에 넣는다. 
		// 3. 
		
	
		
	}

}
