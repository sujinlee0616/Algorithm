package incorrect_note;


import java.util.*;

public class boj_1920_SetVer {
//SET
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		Set<Integer> set=new HashSet();
		int N=scan.nextInt();
		while(N-->0)
			set.add(scan.nextInt());
		
		//SET에 담으면 중복제거도 되고 비교도 한번에 할 수 있음 ! 
		N=scan.nextInt();
		while(N-->0)
			System.out.println(set.contains(scan.nextInt())?1:0);
	}
}
