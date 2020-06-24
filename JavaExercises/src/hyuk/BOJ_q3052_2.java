package hyuk;


import java.util.Scanner;

public class BOJ_q3052_2 {
	private final static int MAX_SIZE = 10;
	private final static int REST = 42;
	
	public static void main(String[] args) {
		
		int[] arr = new int[10];
		
		Scanner scn = new Scanner(System.in);
		for(int i = 0; i < MAX_SIZE; i++) {
			arr[i] = scn.nextInt();
		}
		
		int[] ans = new int[50];
		for(int i = 0; i < MAX_SIZE; i++) {
			ans[arr[i]%42]++;
		}
		
		int count = 0;
		for(int i = 0; i < 42; i++) {
			if(ans[i] != 0) {
				count++;
			}
		}
		System.out.println(count);
	}
}
