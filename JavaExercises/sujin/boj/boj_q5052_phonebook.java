package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class boj_q5052_phonebook {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt(); 
		
		for(int t=0; t<tc; t++) {
			
			int n = sc.nextInt();
			ArrayList<String> list = new ArrayList<String>();
			
			for(int j=0; j<n; j++) 
				list.add(sc.next());
			
			// 2. 정렬 - 안 하면 틀림... Why? 이유는 아래와 같음. 
			// ex) 9113456 <== set에 저장됨 
			// ex) 911 <=== set에 저장됨 
			// ==> prefix 겹치는걸 제대로 캐치하지 못함 
			// ==> 이걸 길이순 혹은 사전순으로 정렬하면
			//     911 <== set에 저장됨 
			//     9113456 <=== set에 911이 이미 있으므로 set에 저장되지 않음
			//     즉, 결과적으로  prefix 겹치는 거 체크 가능 
			Collections.sort(list); 
			// 내가 의도했던 것: 숫자크기 순. 113 12340 12345 98346 123440 
			// 실제로 정렬된 것: 사전순. 113 12340 123440 12345 98346
			// - 길이순으로 정렬하든 사전순으로 정렬하든 위와 같은 경우가 방지되어서 결과를 출력할 수 있음.  
			// test
			//for(int j=0; j<n; j++)
				//System.out.println(list.get(j));
			
			// 3. 첫번째 숫자부터, 앞 글자를 자르게(prefix) set에 이미 있는지 확인 
			Set<String> set = new HashSet<String>();
			
			boolean suc = true;
			outer: // <== outer!! ★★★ for문 두 번 빠져나올 때 사용 
				for(int i=0; i<n; i++) {
					String prefix="";
					for(int j=0; j<list.get(i).length(); j++) {
						char c=list.get(i).charAt(j);  
						String s = Character.toString(c); 
						prefix+=s; // 9 91 911 
						//System.out.println("prefix="+prefix);
						if(set.contains(prefix)) {
							suc = false;
							break outer; // <== outer!! ★★★ for문 두 번 빠져나올 때 사용 
						}
							 
					}
					set.add(list.get(i)); // set에 없으면 얘는 prefix로 넣을 수 있어! 
				}
				if(suc == true) System.out.println("YES");
				else System.out.println("NO");
		}
	}
}
