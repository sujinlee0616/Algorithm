package algorithm;

import java.util.Scanner;

public class etc_prime_number {

	// 문제: 1~1000 사이의 하나의 수를 입력받아서 그 수가 소수인지(true) 아닌지(false) 출력하라
	// 소요시간: 7분 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		boolean result=true;
		
		for(int i=2; i<n; i++) {
			if(n%i==0)
				result=false;	
		}
		if(n==1)
			result=false;
		
		System.out.println(result);
	}
}
