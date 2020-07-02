package datastructure_book;

import java.util.Scanner;
import java.util.Stack;

// int형 스택의 사용 예 

public class Ch4_IntStackTester {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Ch4_IntStack s=new Ch4_IntStack(64); // 만들어놓은 애.. 사용...
		
		while(true) {
			System.out.println("현재 데이터 수:"+s.size()+"/"+s.capacity());
			System.out.println("(1)푸시 (2)팝 (3)피크 (4)덤프 (0)종료 ");
			
			int menu=sc.nextInt();
			if(menu==0) break;
			
			int x;
			switch(menu) {
				case 1: // 푸시 
					System.out.println("데이터: ");
					x=sc.nextInt();
					try {
						s.push(x);
					} catch (Ch4_IntStack.OverflowInstackException e) {
						System.out.println("스택이 가득찼습니다.");
					}
				break;
					
				case 2: // 팝 
					try {
						x=s.pop();
						System.out.println("팝한 데이터는 "+x+"입니다. ");
					} catch (Ch4_IntStack.EmptyInStackException e) {
						System.out.println("스택이 비어 있습니다. ");
					}
				break;
				
				case 3: // peek
					try {
						x=s.peek();
						System.out.println("peek한 데이터는 "+x+"입니다. ");
						
					} catch (Ch4_IntStack.EmptyInStackException e) {
						System.out.println("스택이 비어 있습니다. ");
					}
				break;
				
				case 4: // dump
					s.dump();
				break;
			}

			
		}
		
		
		
	}
}
