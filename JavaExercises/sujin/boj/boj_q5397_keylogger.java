package boj;

import java.util.ArrayList;
import java.util.Scanner;

// 다 못 풀었음!!
// 입력: 테스트 케이스의 수, 테스트 케이스. 
// - 입력 문자열의 크기: L (1 ≤ L의 길이 ≤ 1,000,000) 백만...
// - 백스페이스: '-'
// - 화살표: '<', '>'
// 출력: 정확한 비밀번호. 

public class boj_q5397_keylogger {
	
	
	
	public static void solution(ArrayList<String> TC, int N) {
		
		for(int i=0;i<N;i++) {
			
			// i번째 테스트 케이스에 대하여 검사 
			// 검사 결과가 부정확한 것 같은데... 다시 생각해보자 
			
			// 1. 백스페이스 있는지 
			String s=TC.get(i); 
			int l=s.length();
			
			while(s.contains("-")) {
				int p=s.indexOf("-"); // i번째 테스트케이스의 p번째 글자는 '-'이다.
				// indexOf: -가 여러개인 경우 위치넘버중 랜덤하게 하나를 리턴함 
				
				if(p==0) // 백스페이스가 맨 앞에 있다면 걍 백스페이스만 없애면 됨 
					s=s.substring(1);
				else if(p==1) 
					s=s.substring(2);
				else { 
					String before = s.substring(0, p-2);
					String after = s.substring(p+1);
					s=before.concat(after);
				}
			}
			
			System.out.println(s);
		}
		
		
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N = sc.nextInt();
		ArrayList<String> TC = new ArrayList<String>();
		
		for(int i=0;i<N;i++)
			TC.add(sc.nextLine());
		
		solution(TC,N);
	}
	
	class TestCase {
		String input;
		int length;
	}
}
