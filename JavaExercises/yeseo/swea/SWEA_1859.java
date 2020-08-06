package swea;

import java.util.Scanner;

public class SWEA_1859 {
	/*
	 * 백만장자 
	 * -T는 테스트 케이스 개수 
	 * -N일이 주어짐 
	 * -sell : 무제한 
	 * -buy : 하루에 1개 -입력값이 매매값으로 주어짐
	 * *마지막 시점에서 무조건 팔고 (+) 배열이 가장 큰 부분에서도 판다(+)
	 * (어려웠던 점) = 비교시점 
	 */

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		
		for (int k = 0; k < T; k++) 
		{	
			int N = scan.nextInt();
			int price[] = new int[N];
			int comp[]=new int[N]; //max찾는 배열 
			for(int i=0;i<N;i++)
				price[i]=scan.nextInt();
			//마지막 시점에서 무조건 팔고 (+) 배열이 가장 큰 부분에서도 판다(+)
			int max=0;
			for(int i=N-1;i>=0;i--) { //마지막 시점 이전부터 ~ 0 (무조건 파니까) 
				max=max<price[i]?price[i]:max;
				comp[i]=max; //비교시점을 저장  (비교시점이 max)
			}
			int sum=0;
			for(int i=0;i<N;i++) 
				sum+=comp[i]-price[i];
			System.out.println("#"+k+" "+sum);
		}
	
		// 배열중에 가장 큰 수일때 sell 된다 - max (+)
		// 그 다른 날들엔 buy - 나머지 (-)
		//ex 1) + - - 10<7+6 =!
		//ex 2) - - + 9>8 (O) max>나머지 둘 
		//ex 3) - - + - + 3시점에서 2개를 팔고 (판날은 사지 못함) 
		
	}
}
