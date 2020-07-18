package boj;

import java.util.Scanner;

public class boj_q1629_2 {
	
	// 풀었음. 
	
	// 자연수 A를 B번 곱한 수를 C로 나눈 나머지
	// B승이라서... 수가 급격히 커짐 
	// 재귀함수로 풀려고 했으나 비용이 너무 큼.
	// 재귀함수로 풀면 a^n 하려면 O(n)이므로, n이 크면 성능이 안 좋음.
	// 분할정복 쓰자. 
	// a^8=a^4*a^4 ===> n이 짝수일 때, a^n=a^(n/2)*a^(n/2)
	// a^15=a^7*a^7*a ===> n이 홀수일 때, a^n=a^((n-1)/2)*a^((n-1)/2)*a
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		
		System.out.println(pow(a,b,c));
		// solution(a,b,c);
	}
	
	
	// 범위 조심. 범위 커서.. 잘못하면 틀림. 
	static long pow(int a,int b,int c) {
		if(b==0) {
			return 1;
		}else if(b%2==0){ // 짝수일 때 
			long n=pow(a,b/2,c);
			return n*n%c;
		}else { // 홀수일 때 
			long n=pow(a,(b-1)/2,c);
			// return n*n*a%c; // <== 이렇게 하면 long이 소화 못함 ㅠㅠ 
			return ((n*n%c)*a)%c;  // <=== ★★★★★ 이렇게 해줘야 범위 안 넘음 ★★★★★
		}
	}
	
}
