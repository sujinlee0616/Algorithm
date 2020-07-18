package incorrect_note;

import java.util.Scanner;

public class boj_q10828 {
  //스택 구현 

	private int max;
	private int ptr;
	private int[] stk;
	
	public class EmptyIntStackException extends RuntimeException{
		public EmptyIntStackException() {}
	}
	
	public class OverflowIntStackException extends RuntimeException{
		public OverflowIntStackException() {}
	}
	
	public int push(int x) throws OverflowIntStackException {
		if(ptr>=max)
			throw new OverflowIntStackException();
		return stk[ptr++]=x;
	}
	
	public int pop() throws EmptyIntStackException{
		if(ptr<=0)
			throw new EmptyIntStackException();
		return stk[--ptr];
	}
	
	public int size() {
		return ptr;
	}
	
	public boolean empty() {
		return ptr<=0;
	}
	
	public int top() throws EmptyIntStackException{
		if(ptr<=0)
			throw new EmptyIntStackException();
		return stk[ptr-1];  
	}
	
	public static void main(String[] args) {
		boj_q10828 stack=new boj_q10828();
		Scanner scn=new Scanner(System.in);
		int cnt= scn.nextInt();
		
		for(int i=0;i<cnt;i++) {
			String input=scn.next();
			if(input.contains("push")) {
				int tmp=scn.nextInt();
				stack.push(tmp);
			}else if(input.equals("pop")) {
				System.out.println(stack.empty()?-1:stack.pop());
			}else if(input.equals("size")) {
				System.out.println(stack.size());
			}else if(input.equals("empty")) {
				System.out.println(stack.empty()?1:0);
			}else if(input.equals("top")) {
				System.out.println(stack.empty()?-1:stack.top());
			}
				
		}
	}

}
