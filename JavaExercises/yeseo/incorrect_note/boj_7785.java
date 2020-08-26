package incorrect_note;

import java.util.*;

public class boj_7785 {
//회사에 있는 사람 
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int log=scan.nextInt();
		
		scan.nextLine();
		
		boolean in;
		
		Set<String> set=new HashSet();
		ArrayList<String> list=new ArrayList<>();
		
		//1)로그정보 전부 Set (이름/기록 나눠서) 
		for(int i=0;i<log;i++) {
			
			
			String name=scan.next();
			String stat=scan.next();
			//set.add(scan.nextLine());
			
			//2) 기록이 enter만 남아있으면 add/ leave면 remove 
			if(stat.contains("leave"))
				set.remove(name);
			else
				set.add(name);
		}
		
		//소팅위한 리스트 
		for(String j:set)
			list.add(j);
		
		//3) DESC 	
		Collections.sort(list);
		
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(set.size()-i-1));

	}
	
}
