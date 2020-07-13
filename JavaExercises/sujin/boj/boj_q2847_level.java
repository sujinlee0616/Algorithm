package boj;

import java.util.Scanner;

// 맨 마지막 원소부터 체크 
// 앞의 원소가 나보다 크거나 같다면, 나보다 1 작게 감소시켜야 함. 
// 뒤에서부터 체크. 
// N: 레벨의 수. (1 ≤ N ≤ 100)
// 점수:  점수는 20,000보다 작은 양의 정수. 

public class boj_q2847_level {

	public static int solution(int[] grades, int N) {
		
		int count=0;
		
		for(int i=N-1;i>0;i--) {
			if(grades[i-1]>=grades[i]) {
				int diff = grades[i-1] - grades[i];
				grades[i-1] -= (diff+1);
				count += (diff+1);
			}
		}
		System.out.println(count);
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] grades = new int[N];
		
		for(int i=0;i<N;i++)
			grades[i] = sc.nextInt();
		
		solution(grades,N);
	}
}
