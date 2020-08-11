package incorrect_note;

import java.util.Arrays;
import java.util.Scanner;

public class boj_treasure {
/*
1026q


S = A[0]*B[0] + ... + A[N-1]*B[N-1]
S의 값을 가장 작게 만들기 위해 A의 수를 재배열
S의 최솟값을 출력

입력)
첫째 줄에 N이 주어진다. 둘째 줄에는 A에 있는 N개의 수가 순서대로
B에 있는 수가 순서대로 주어진다. N<=50
0<=A와 B의 원소 <=100


테스트케이스)
5
1 1 1 6 0
2 7 8 3 1

?)
그리디인가.
곱함+더함 
곱할때 최소가 되게 해야겠다 =>sortArray 


!)
A ASC
B DESC 
 */
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int A[]=new int[N]; //N+1!!! 
		int B[]=new int[N];
		
		for(int i=0;i<N;i++) {
			A[i]=scan.nextInt();
		}		
		for(int i=0;i<N;i++) {
			B[i]=scan.nextInt();
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		
		int result=0;
		for(int i=0;i<N;i++) {
			result+=A[i]*B[N-1-i]; //마지막 인덱스를 거꾸
		}
		
		System.out.println(result);
		
	}
}
