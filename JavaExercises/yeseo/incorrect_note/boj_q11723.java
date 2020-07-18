package incorrect_note;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class boj_q11723 {
/*
집합 (55')
1) 입력값 받기 M,S생성 List로 하기
2) if(command.equals(명령어) 
 	contains , !contains, remove, return, sort, removeAll 사용
3) check메소드 결과만 출력한다 

remove 메소드의 index호출 문제. 

 */
	
	public static void main(String[] args) throws Exception {
		Scanner scan=new Scanner(System.in);
		int M=scan.nextInt();
		
		List S=new ArrayList();
		for(int i=0;i<M;i++) {
			String command=scan.next();
			int x=scan.nextInt();
			
			if(command.equals("add")&& !S.contains(x)) {
				S.add(x);
				continue;
			}else if( S.contains(x) && S.size()!=0 && command.equals("remove") ) {
				//S.remove(S.get(i));
				//System.out.println(S);
				S.remove(x);

				
				continue;
			}else if(command.equals("check")) {
				if(S.contains(x)) {
					System.out.println(1);
					continue;
				}else {
					System.out.println(0);
					continue;
				}
			}else if(command.equals("toggle")) {
				if(S.contains(x)) {
					S.add(x);
					continue;
				}else {
					S.remove((int)x);
					continue;
				}
			}else if(command.equals("all") && !S.isEmpty()) {
				Collections.sort(S);
				System.out.println(S);
				continue;
			}else if(command.equals("empty") && !S.isEmpty()) {
				S.removeAll(S);
				continue;
			}
			
		}
		
	}
	
}
