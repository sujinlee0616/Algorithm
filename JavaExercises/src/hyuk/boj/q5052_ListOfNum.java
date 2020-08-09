package hyuk.boj;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class q5052_ListOfNum {
	public static void main(String[] args) {
		new q5052_ListOfNum().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		int tc = scn.nextInt();
		for(int t = 1; t <= tc; t++) {
			String ans = "";
			int N = scn.nextInt();
			String[] arr = new String[N];
			Set<String> set = new HashSet<String>();
			for(int i = 0; i < N; i++) {
				arr[i] = scn.next();
			}
			Arrays.sort(arr);
			outer:
			for(int i = 0; i < N; i++) {
				String prefix = "";
				for(int j = 0; j < arr[i].length(); j++) {
					prefix += arr[i].charAt(j) + "";
					if(set.contains(prefix)) {
						ans = "NO";
						break outer; 
					}
				}
				set.add(arr[i]);
			}
			if(!ans.equals("NO")) {
				ans = "YES";
			}
			System.out.println(ans);
		}
		
		scn.close();
	}
}
