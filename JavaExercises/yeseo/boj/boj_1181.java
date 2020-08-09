package boj;
/*
 단어 정렬
 SET 없는 버전  
 */
	import java.util.List;
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Comparator;
	import java.util.Scanner;

	public class boj_1181 {
	/*
	 단어정렬
	 1) tescase를 배열로 받되 중복은 제거 
	 2) Comparator로 길이가 짧은것 선순위 , 긴것 후순위, 길이가 같다면, 알파벳순 정
	 3) Collections.sort로 알파벳 순 정

	 */

		public static void main(String[] args) {
			Scanner scn= new Scanner(System.in);
			int T=scn.nextInt();
			String input[]=new String[T];
			List<String> list=new ArrayList<String>();
			for(int i=0;i<T;i++) {
				input[i]=scn.next();
				if(!list.contains(input[i])) //리스트에 이미 그 단어가 없다면 
				list.add(input[i]); // 추가해라
			}
			
			//사용자 정의 Comparator 만들기 
			Comparator<String> compare=new Comparator<String>() {
				
				public int compare(String a, String b) {
					if(a.length()>b.length()) //길이가크면 1  
						return 1;
					else if(a.length()==b.length()) //길이가 같다면 알파벳 순서로 출력
						return a.compareTo(b); //a,b를 메소드에 넣고 돌린 후 -1 
					return -1;
					
				}
				
			};
			
			Collections.sort(list,compare); //정의한 메소드 사용 
			
			for(int i=0;i<list.size();i++) {
				System.out.println(list.get(i));
			}
		}

	}


