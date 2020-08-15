package programmers;

import java.util.Arrays;
//완주하지 못한 선수 
public class runners {
	public static void main(String[] args) {
		String [] p= {"marina", "josipa", "nikola", "vinko", "filipa"};
		String [] c= {"josipa", "filipa", "marina", "nikola"};
		System.out.println(solution(p,c));
		
	}
	
	public static String solution(String [] p,String[]c) {
		// p-c=1 만큼 차이 남 .
		Arrays.sort(p);
		Arrays.sort(c);
		int i;
		for(i=0;i<c.length;i++) {
			if(!p[i].equals(c[i]))
				return p[i];
		}
		return p[i];
	}
}
