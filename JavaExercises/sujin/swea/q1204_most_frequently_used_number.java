package swea;

import java.util.ArrayList;
import java.util.Scanner;

// 최빈수 구하는 문제 
// 학생 수 1000명. 점수는 0~100점. 
// 최빈수(점수)를 출력하라. 만약, 최빈수가 여러개일떄는 가장 큰 정수 출력.  
public class q1204_most_frequently_used_number {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		
		for(int i=0;i<TC;i++) {
			// 1. 하나의 Test Case 입력받는다  
			int now=sc.nextInt();
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			for(int j=0;j<1000;j++) {
				list.add(sc.nextInt());
			}
			// 2. 판정결과 출력
			System.out.println("#"+now+" "+solution(list));
		}
	}
	
	public static int solution(ArrayList<Integer> list) {
		int res = 0;
		int[] count = new int[101]; // count[i]: 점수가 i점인 학생의 수 ==> count[0] ~ count[100] 까지 존재.

		for (int i=0; i<1000; i++) {
			count[list.get(i)]++; // list.get(i)=65 ==> count[65]++;
		}

		int max=count[100]; // count[] 배열의 최대값 구하기    
		for (int i=100; i>=0; i--)  // 학생수가 같으면 높은 점수를 우선적으로 출력해야하니까 100부터 시작해서 -- 시켰음 
			if (count[i] > max) {
				max = count[i];
				res = i;
			}
		return res;
	}
	 
	
}
