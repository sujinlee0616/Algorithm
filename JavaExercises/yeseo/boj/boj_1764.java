package boj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class boj_1764 {
//듣보잡 
	public static void main(String[] args) {
		//1)듣지못한  다 받아서 Set에 저장  
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int M=scan.nextInt();
		scan.nextLine();//!!
		
		//Scanner문제 해결 필요 
		
		ArrayList<String> list=new ArrayList<>();
		Set<String> set=new HashSet<>();
		
		int i,j;
		//듣지 못한 사람들 
		for(i=0;i<N;i++) 
			set.add(scan.nextLine());
		
		//Collections.sort(list);
		//처음엔 다 담고 set에서 비교하려... 
		
		
		//2) (중복 알아서 제거)
		int count=0;
		//3) 보지못한사람이 이미 set에 존재하면 카운팅+ 리스팅
		for(j=0;j<M;j++) {
			//scan.next()를 하나의 변수로 잡아야 함
			String input=scan.next();
			if(set.contains(input)){
				count++;
				list.add(input);
			}	
		}
		
		//4)출력
		System.out.println(count);
		
		for(String sth:list) {
			System.out.println(sth);
		}
	}
}
