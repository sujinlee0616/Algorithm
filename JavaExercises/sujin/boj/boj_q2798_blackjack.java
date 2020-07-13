package boj;

import java.util.ArrayList;
import java.util.Scanner;

//입력 첫 줄 : 카드의 개수 N, 딜러가 부르는 수 M. (3 ≤ N ≤ 100, 10 ≤ M ≤ 300,000) 
//입력 둘쨰줄 : 카드에 쓰여 있는 수. (카드에 쓰여있는 수는 100,000을 넘지 않는다.) 
//출력:  M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력 

public class boj_q2798_blackjack {
public static long solution(int[] arr, int N, int M) {
		
		long two;
		long three;
		
		ArrayList<Long> ans = new ArrayList<Long>();
		
		for(int i=0;i<=N-2;i++) {
			for(int j=i+1;j<=N-1;j++) {
				int first=arr[i];
				int second=arr[j];
				two=first+second;
				if(two <= M) {
					for(int k=0;k<N && k!=i && k!=j;k++) {
						int third=arr[k];
						three=two+third;
						if(three <= M)
							ans.add(three);
					}
					
				}
				
			}
		}
		
		long max=ans.get(0);
		
		for(int i=0;i<ans.size();i++)
			if(ans.get(i) > max)
				max=ans.get(i);
		
		return max;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		
		int[] arr=new int[N];
		
		for(int i=0;i<N;i++)
			arr[i]=sc.nextInt();
		
		System.out.println(solution(arr, N, M));
	}
}
