package programmers;

import java.util.Arrays;
import java.util.HashSet;

public class q42577_phoneNumber {

	// 결과확인 
	public static void main(String[] args) {
		// String[] phone_book = {"119", "97674223", "1195524421"};
		// String[] phone_book = {"123", "456", "789"};
		String[] phone_book = {"12", "123", "1235", "567", "88"};
		System.out.println(solution(phone_book));
	}

	public static boolean solution(String[] phone_book) {
		boolean ans = true;
		int n = phone_book.length;
		
		Arrays.sort(phone_book);
		
		HashSet<String> set = new HashSet<String>();

		boolean suc = true;
		outer: // <== outer!! ★★★ for문 두 번 빠져나올 때 사용 
			for(int i=0; i<n; i++) {
				String prefix="";
				for(int j=0; j<phone_book[i].length(); j++) {
					char c = phone_book[i].charAt(j);  
					String s = Character.toString(c); 
					prefix+=s; // 9 91 911 
					//System.out.println("prefix="+prefix);
					if(set.contains(prefix)) {
						suc = false;
						break outer; // <== outer!! ★★★ for문 두 번 빠져나올 때 사용 
					}
						 
				}
				set.add(phone_book[i]); // set에 없으면 얘는 prefix로 넣을 수 있어! 
			}
			if(suc == true) 
				ans = true;
			else 
				ans = false;
		
		
		return ans;
	}
	
}
