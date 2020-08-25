package boj;

import java.util.Scanner;

// - 틀렸음. 시간초과. ==> 이진탐색으로 풀어보자.
public class boj_q1072_game {
	
	public static void main(String[] args) {
		// X: 게임 횟수, Y : 이긴 게임 수.   X는 10억 이하. 
		// Z : 승률(%). 소수점은 버린다. 
		// - 게임을 몇 판 더 해야 승률 Z가 변하는지를 출력. 만약, Z가 절대 변하지 않는다면 -1 출력. 
		// - Z가 절대 변하지 않는지를... 어떻게 판단해야할까? more이 10억보다 커지면? 
		
		Scanner sc = new Scanner(System.in);
		long X = sc.nextInt();
		long Y = sc.nextInt();
		int Z = (int) (Y * 100 / X);
		long more=0;
		long aim=0;
		
		while(aim <= Z) {
			
			more++;
			aim = (Y + more) * 100 / (X + more);
			// System.out.println("more="+more);
			// System.out.println("aim="+aim);
			
			if(more > 1000000000) {
				more = -1;
				break;
			}
				
		}
		
		System.out.println(more);
		
	}

}
