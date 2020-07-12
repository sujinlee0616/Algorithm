package incorrect_note;

import java.util.Scanner;
import java.util.Stack;
/*
 * LIFO 왼쪽으로 탐색하면서 
 * 6, 9, 5, 7, 4 -->pop하면 4부터 out 됨.
 * index()
 */
public class boj_q2493 {

	public static void solution(int []input)
	{
		Stack<Integer> s=new Stack<>();
		
		int []res=new int[input.length];
		for(int i=0;i<input.length;i++) {
			s.push(input[i]);
			System.out.print(i+1+"("+s.peek()+")");
		}
		
		for(int j=0;j<input.length;j++) {
			
			if(j==0)
			{
				res[j]=0;  //앞에 검색할 것이 없음
			}else {
			
			for(int i=j;i<input.length;i++) {
				
				if(s.peek()<input[j])	
				{	
					s.pop();
				}else if(input[j]==s.peek())
				{	
					continue;
				}else
				{	
					s.push(s.peek());
				}	
				
				res[j]=s.peek();
			 }
			
			}
			
			System.out.println(j+"("+res[j]+")"); //? 왜 9만 출력...
		}
		

	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
        int N=scan.nextInt();
        int []input=new int[N];
        for(int i=0;i<N;i++){
        	
        	input[i]=scan.nextInt();
        	
        }
        solution(input);
	}
}
