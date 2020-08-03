package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/* idea) 
 1. 위치와 높이 한 번에 다루기 힘드니까... 클래스로 만들어버리자. 
  - 위치(index)와, 높이(height)를 한 방에 처리할 수 있도록 Top 클래스를 만들자. 
 2. 탐색하는 방식을 분석해보자.
  - 나보다 (1) 왼쪽에 있고 (2) 높이가 더 높으면 ===> 그 index를 출력한다. 
  - 나보다 (1) 왼쪽에 있고 (2) 높이가 더 높더라도 (3) 더 가까운 쪽에 있는 탑의 index를 출력한다. 
    ==> 높은 탑이면 저장해놨다가 저장하면 되겠네 
    ==> Q. 높은 탑인걸 어떻게 판단할건데? 
        A. arr[i]랑 비교하면 되겠네
        Q. 높이가 높더라도 더 가까운 쪽에 있는 탑의 index 출력하는건 어떻게 할건데? 
        A. Stack써서 하면 되겠네.  
*/  

// 이 풀이방식은 평소 내 사고방식이랑은 크게 맞지 않는듯...
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
			arr[i]=Integer.parseInt(s2[i-1]);
			//System.out.println("arr["+i+"]="+arr[i]);
		}
		
		// Top 클래스로 Stack을 만들자 
		Stack<Top> stk = new Stack<Top>();
		
		for(int i=1; i<=n; i++) {
			while(true) {
				if(stk.size()==0) {
					System.out.print(0+" ");
					stk.push(new Top(i, arr[i]));
					break;
				}
				else if(stk.peek().height < arr[i]) { // 스택에 들어가있는 애(왼쪽)이 나보다 작으면 
					stk.pop();
					// pop은 여러번 할 수 있으니까 break 걸지 X 
				}
				else if(stk.peek().height > arr[i]) { // 스택에 들어가있는 애(왼쪽)이 나보다 크면 
					System.out.print(stk.peek().index+" ");
					stk.add(new Top(i, arr[i]));
					break;
				}
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


