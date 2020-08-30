package swea;

import java.util.Scanner;
// 함정) 수가 클 때는 long으로 해야!! 

//1층 : 1개 = 2*1-1개 
//2층 : 3개 = 2*2-1개 
//3층 : 5개 = 2*3-1개 
//4층 : 7개 = 2*4-2개 
// ==> N층까지의 개수 = 2*(1+2+...+N) - 1*N = 2*N*(N+1)/2 - N = N^2
// ==> N층 마지막 숫자 = N^2 번째 수 ==> 2*N^2 - 1
// ==> N층 첫번째 숫자 = (N-1)^2 +1 번째 수 ==> 2*(N^2-2N+2) - 1 = 2N^2 - 4N + 3  
public class boj_q8016_Pyramid2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int i=0; i<TC; i++) {
			long N = sc.nextInt();
			long start = 2 * N * N - 4 * N + 3;
			long end = 2 * N * N - 1;
			System.out.println("#"+(i+1)+" "+start+" "+end);
		}
		
	}
}
