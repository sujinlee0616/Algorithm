package test;

import java.util.Stack;

public class test2_200704_q2_1 {

	
	// 배열A를 집합A로 만든다
	public static int[] makeSet(int[] arrayA) {
		
		Stack<Integer> stk=new Stack<Integer>();
		
		int n=arrayA.length;
		for(int i=0;i<n;i++) {
			if(!stk.contains(arrayA[i]))
				stk.push(arrayA[i]);
		}
		
		int[] set= {};
		
		if(!stk.isEmpty()) {
			for(int i=0;i<stk.size();i++) {
				set[i]=stk.peek();
				stk.pop();
			}
		}
		else {
			System.out.println("스택이 비었습니다.");
		}

		
		// 테스트 
		for(int i=0;i<set.length;i++)
			System.out.print(set[i]+",");
		
		return set;
		
	}
	
	
	
	public static void main(String[] args) {
	
		int[] arrayA= {1,2,3,2};
		makeSet(arrayA);
		
	}
	
}
