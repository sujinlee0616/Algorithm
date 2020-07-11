package hyuk.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class q10820_StringAnalysis {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		String input = "";
		
		while((input = br.readLine()) != null) {
			int[] arr = new int[4];
			for(int i = 0; i < input.length(); i++) {
				if(input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
					arr[0]++;
				} else if(input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
					arr[1]++;
				} else if(input.charAt(i) >= '0' && input.charAt(i) <= '9') {
					arr[2]++;
				} else if(input.charAt(i) == ' ') {
					arr[3]++;
				}
			}
			for(int i = 0; i < 4; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}
}
