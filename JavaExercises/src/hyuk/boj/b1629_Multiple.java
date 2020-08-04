package hyuk.boj;

import java.util.Scanner;
//아하!!
public class b1629_Multiple {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		long A = scn.nextLong();
		long B = scn.nextLong();
		long C = scn.nextLong();
		
		long res = getMultiple(A,B,C)%C;
		System.out.println(res);
	}
	
	private static long getMultiple(long A, long B, long C) {
		if(B <= 1) {
			return A;
		}
		
		long res = getMultiple(A, B/2, C) % C;
		if(B % 2 != 0) {
			return (((A%C * res%C)%C * res%C) % C);
		}else {
			return (res%C * res%C) % C;
		}
	}
}
