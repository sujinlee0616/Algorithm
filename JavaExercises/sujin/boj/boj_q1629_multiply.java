package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj_q1629_multiply {
	
	// 자연수 A를 B번 곱한 수를 C로 나눈 나머지
	// B승이라서... 수가 급격히 커짐 
	// 재귀함수로 풀려고 했으나 비용이 너무 큼.
	// 재귀함수로 풀면 a^n 하려면 O(n)이므로, n이 크면 성능이 안 좋음.
	// 분할정복 쓰자. 
	// a^8=a^4*a^4 ===> n이 짝수일 때, a^n=a^(n/2)*a^(n/2)
	// a^15=a^7*a^7*a ===> n이 홀수일 때, a^n=a^((n-1)/2)*a^((n-1)/2)*a

	private void solve() {
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		System.out.println(pow(A, B, C));
	}

	public static long pow(int a, int b, int c) {
		if (b == 0) {
			return 1;
		}

		long n = pow(a, b / 2, c);
		long temp = n * n % c;

		if (b % 2 == 0) {
			return temp;
		} else {
			return a * temp % c;
		}
	}

	public static void main(String[] args) {
		sc.init();
		new boj_q1629_multiply().solve();
	}

	static class sc {
		private static BufferedReader br;  
		private static StringTokenizer st;

		static void init() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}

		static String readLine() {
			try {
				return br.readLine();
			} catch (IOException e) {
			}
			return null;
		}

		static String readLineReplace() {
			try {
				return br.readLine().replaceAll("\\s+", "");
			} catch (IOException e) {
			}
			return null;
		}

		static String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
				}
			}
			return st.nextToken();
		}

		static long nextLong() {
			return Long.parseLong(next());
		}

		static int nextInt() {
			return Integer.parseInt(next());
		}

		static double nextDouble() {
			return Double.parseDouble(next());
		}
	}
	  
		

		/* 
		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			
			// System.out.println(pow(a,b,c));
			// solution(a,b,c);
		}
		*/ 
		
		// 틀렸다고 나옴  ===> Why? ㅠㅠ ==> 넘 커서 그럼. 
		/* 
		static long pow(int a,int b,int c) {
			if(b==0) {
				return 1;
			}else if(b%2==0){ // 짝수일 때 
				long n=pow(a,b/2,c);
				return n*n%c;
			}else { // 홀수일 때 
				long n=pow(a,(b-1)/2,c);
				return n*n*a%c;
			}
		}
		*/ 
		
		// 틀렸다고 나옴  ===> Why? ㅠㅠ 
		/* 
		 * static void solution(int a,int b,int c) {
			long d_a=a;
			long d_b=b;
			long d_d=c;
			int ans=(int) (Math.pow(d_a, d_b)%c);
			System.out.println(ans);
		}
		 */
		
		
		
}








