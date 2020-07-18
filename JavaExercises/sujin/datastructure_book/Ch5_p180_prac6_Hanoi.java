package datastructure_book;

import java.util.Scanner;

public class Ch5_p180_prac6_Hanoi {
	
	static void move(int no, int x, int y) {
		// no-1개를 시작기둥에서 중간기둥으로 옮김 
		if(no>1)
			move(no-1, x, 6-x-y); // 6-x-y: 중간기둥. 왜냐면 기둥 번호를 1,2,3 으로 해놔서.
		// no-1개를 중간기둥에서 목표기둥으로 옮김. 
		if(no>1)
			move(no-1,6-x-y,y); 
		System.out.println("원반["+no+"]을(를) "+x+"기둥에서 "+y+"기둥으로 옮겼습니다. ");
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("하노이의 ");
		System.out.println("원반개수:");
		int n=sc.nextInt();
		
		move(n,1,3);
	}

}
