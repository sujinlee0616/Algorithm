package hyuk.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1928_Base64_Decoder {
	public static void main(String[] args) {
		try {
			new Q1928_Base64_Decoder().service();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void service() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			String input = br.readLine();
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < input.length(); i += 4) {
				long number = 0;
				for(int j = i; j < i+4; j++) {
					number += (lookTable(input.charAt(j)) << (18-(j-i)*6));
				}
				//decoding start
				getDecoding(number, sb);
			}
			
			System.out.println("#" + t + " " + sb);
		}
		
		br.close();
	}
	private long lookTable(char ch) {
		if(ch >= 'A' && ch <= 'Z') {
			return ch - 'A';
		} else if(ch >= 'a' && ch <= 'z') {
			return ch - 'a' + 26;
		} else if(ch >= '0' && ch <= '9') {
			return ch - '0' + 52;
		} else if(ch == '+') {
			return 62;
		}
		return 63;
	}
	private void getDecoding(long number, StringBuilder sb) {
		char[] tmp = new char[3];
		for(int i = 0; i < 3; i++) {
			tmp[2-i] = (char)(number & ((1<<8) - 1));
			number = (number >> 8);
		}
		for(int i = 0; i < 3; i++) {
			sb.append(tmp[i]);
		}
	}
}
