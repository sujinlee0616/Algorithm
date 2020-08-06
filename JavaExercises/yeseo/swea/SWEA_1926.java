package swea;

import java.util.Scanner;

public class SWEA_1926 {
	/*
	 * 간단한369
	 * 
	 * (10<N<1000)자연수 3N의 부분에 - 를 출력 3 ~ 999 (총 333번) 자리수가 10이상 = 2 100이상 =3 -->
	 * 3N3의 경우 문제발생 charAt 사용해서 풀이
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			//Integer=> String
			String str = String.valueOf(i);

			//count ++ == "-" ++
			int cnt = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9')
					cnt++;
			}
			
			// 3, 6, 9 X
			
			if (cnt == 0)
				System.out.print(str); // ==i 
			
			//cnt = 자리수 = i = str.length();
			
			else if (cnt == str.length()) {
				// 33, 333, -- , ---
				for (int j = 0; j < str.length(); j++) {
					System.out.print("-");
				}
			}
			//한번만 출
			else
				System.out.print("-");
			//한칸 띄우기 
			System.out.print(" ");
		}
		
	}

}
