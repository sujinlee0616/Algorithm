package boj;

import java.util.Scanner;

public class boj_1182 {
//부분수열의 합 
	//tip : 재귀함수 
	//호출방법 )더하는 경우 / 다음으로 건너뛰는 경우 
	//매개변수 (n,sum) n=끝까지 다 도는지 확인 sum=조건에 부합?
	//틀린이유 ) 범위설정 
	static int N,S;
	static int arr[];
	static int sum,count=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		arr= new int [N];
		for (int i = 0; i <N; i++)
			arr[i] = sc.nextInt();

		solution(0,0);//초기화 
		System.out.println(count);//결과 (경우의 수 출력) 
		sc.close();
	}

	public static void solution(int n, int sum) {
		if(n==N)return; //종료조건
		
		if(sum+arr[n]==S) count++; //조건에 맞는 경우(부분 수열의 합) 
		
		solution(n+1,sum);//1,0
		///////////부분집합의 합 == S와 부합/////
		solution(n+1,sum+arr[n]);
	}
	
}
