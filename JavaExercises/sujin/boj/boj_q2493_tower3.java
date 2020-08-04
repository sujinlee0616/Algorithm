package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

// 이 방법이 best인듯. 
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

/* 0. 전체 아이디어  
 *  - 왼쪽 탑부터 보면서, 왼쪽 탑인데 자기보다 바로 오른쪽에 위치한 애보다 높이가 높으면 쓸모가 있는 애니까 스택에 넣자. 
 * 1. 경우의 수 
 *  1) 스택이 비어 있을 경우
 *   - 지금 보고 있는 탑보다 왼쪽에 있는 탑에서 신호 받아 주는 애가 없단 뜻 ==> 0 출력 
 *   - 지금 보고 있는 탑이 제일 높다는 뜻임. 스택에 넣자. 
 *  2) 내가 지금 보고 있는 탑의 높이가, 이 탑의 왼쪽에 위치한 어떤 탑보다 더 작다 
 *   - arr[i] < stk.peek.height 
 *   -  
 *   - 
 *  3) 내가 지금 보고 있는 탑의 높이가, 이 탑의 왼쪽에 위치한 어떤 탑보다도 더 높다 
 *   - arr[i] > stk.peek.height 
 *   - stk.peek.height는 이제 쓸모없는 놈임. 
 *     왜냐면 내가 오른쪽에 있는데 내가 더 크니까. 
 *     ==> 원래 있던 애를 뺀다. 
 *         (1) 스택이 빈다면 
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
			arr[i]=Integer.parseInt(s2[i-1]);
			//System.out.println("arr["+i+"]="+arr[i]);
		}
		
		// Top 클래스로 Stack을 만들자 
		Stack<Top> stk = new Stack<Top>();
		
		for(int i=1; i<=n; i++) {
			System.out.println("========== i="+i+"==========");
			while(true) {
				if(stk.size()==0) {
					System.out.println("1. stk.size()==0");
					System.out.println("stk.add(new Top("+i+","+arr[i]+"))");
					System.out.println("0 출력 ");
					
					System.out.print(0+" ");
					stk.add(new Top(i, arr[i]));
					break;
				}
				else if(stk.peek().height < arr[i]) { // 스택에 들어가있는 애(왼쪽)이 나보다 작으면 
					System.out.println("2. stk.peek().height="+stk.peek().height+" < "+"arr["+i+"]="+arr[i]);
					System.out.println("stk.pop() ==> Top("+stk.peek().index+","+stk.peek().height+") 제거됨");
					
					stk.pop(); // break 걸지 X!! 왜냐면,1) pop해서 stk.size==0 되면 위의 if문으로 돌아가야함. 2) 여러번 pop 될 수 있음  
				}
				else if(stk.peek().height > arr[i]) { // 스택에 들어가있는 애(왼쪽)이 나보다 크면 
					System.out.println("3. stk.peek().height="+stk.peek().height+" > "+"arr["+i+"]="+arr[i]);
					System.out.println(stk.peek().index+" 출력");
					System.out.println("stk.add(new Top("+i+","+arr[i]+"))");
					
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


