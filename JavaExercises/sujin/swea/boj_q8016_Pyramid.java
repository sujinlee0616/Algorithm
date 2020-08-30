package swea;

import java.util.Scanner;
// 그냥 수학으로 풀었음
// 1층 - 1개 = 2*1-1개 
// 2층 - 3개 = 2*2-1개 
// 3층 - 5개 = 2*3-1개 
// 4층 - 7개 = 2*4-2개 
// N층까지의 누적 = 2*(1+2+...+N)-1*N = N(N+1)-N=N^2개 -->  N층의 맨 오른쪽 끝 원소는 2*(N^2)-1
// N-1층까지의 원소 개수는 (N-1)^2개 --> N층의 맨 왼쪽 끝 원소는 2*((N-1)^2+1)-1
public class boj_q8016_Pyramid {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int i=0; i<TC; i++) {
			long N = sc.nextInt();
			long start = 2 * ((N-1) * (N-1) + 1) - 1;
			long end = 2 * N * N - 1;
			System.out.println("#"+(i+1)+" "+start+" "+end);
		}
	}
}
