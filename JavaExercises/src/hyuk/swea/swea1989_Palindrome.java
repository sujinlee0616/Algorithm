package hyuk.swea;
import java.util.Scanner;

public class swea1989_Palindrome {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		for(int i = 0; i < N; i++) {
			String s = scn.next();
			if(checkPalindrome(s)) {
				System.out.println("#" + (i+1) + " 1");
			}else {
				System.out.println("#" + (i+1) + " 0");
			}
		}
	}
	
	public static boolean checkPalindrome(String s) {
		for(int j = 0; j < s.length()/2; j++) {
			if(s.charAt(j) != s.charAt(s.length()-1-j)) {
				return false;
			}
		}
		return true;
	}
}
