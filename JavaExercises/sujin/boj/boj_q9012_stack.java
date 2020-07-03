package boj;

import java.util.Scanner;
import java.util.Stack;

// 괄호 VPS 
/* 
 * 1. (만 스택에 담는다. 
 * 2. )가 나오면 스택에 (가 들어있는지 확인한다. ==> 없으면 isVPS=false 
 *    (가 있으면 스택에서 pop한다. 즉, (와 )를 짝지어줌 
 * 3. 문자열의 수만큼 2~3을 반복했을 때 스택이 완전히 비면 isVPS=true 
 */

/*
 * 코드리뷰
 * 1. 메소드로 만들자
 * 2. nextInt(), next(), nextLine()관련
 *  - https://medium.com/@kimddub/java-scanner-%EB%B2%84%ED%8D%BC-%EB%B9%84%EC%9A%B0%EA%B8%B0-913c652cc144
 */

public class boj_q9012_stack {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		// sc.nextLine();
		String[] arr = new String[n];
		Stack<Character> stk = new Stack<Character>();

		// 배열에 집어넣는다. ex. arr[0]=(())())
		for(int i=0; i<n; i++) {
			arr[i]=sc.next();
			boolean isVPS=true;
			//System.out.println("arr["+i+"]="+arr[i]);
			
			// arr[i] 하나에 대하여 push/pop
			for(int j=0; j<arr[i].length(); j++) {
				if(arr[i].charAt(j)=='(') // (가 나온 경우 
					stk.push('(');
				else { // )가 나온 경우 
					if(!stk.isEmpty()) { // 스택이 비어 있지 않다면 
						stk.pop();  // pop한다 
					}
					else { // 스택이 비어있다면 false 
						isVPS=false;
						break;
						// 근데 이게 또 밑에 가면 isEmpty일때 무조건 true가 됨 
					} 
				}
			}
			// arr[i] 하나에 대하여 push/pop 끝났으니 스택이 비었는지 검사
			if(isVPS==true && stk.isEmpty()) { // 
				isVPS=true;
				System.out.println("YES");
			}
			else {
				isVPS=false;
				System.out.println("NO");
			}
			stk.clear(); // 다음 i에 대해 검사할 수 있게 스택 비워줌 
		}
	}
}
