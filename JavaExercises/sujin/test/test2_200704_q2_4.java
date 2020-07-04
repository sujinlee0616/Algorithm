package test;

import java.util.HashSet;

public class test2_200704_q2_4 {
	
	public int[] solution(int[] arrayA, int[] arrayB) {
		int[] answer= {};
		return answer;
	}
	
	
	public static int[] set(int[] arrayA) {
		
		HashSet<Integer> hs=new HashSet<Integer>();
		
		for(int i=0;i<arrayA.length;i++)
			hs.add(arrayA[i]);
		
		int[] set=(int[]) hs.clone();
		
		for(int i=0;i<set.length;i++)
			System.out.print(set[i]+",");
		
		return set;
	}
	
	
	
	
	public static void main(String[] args) {
		
		int[] arrayA= {1,2,3,4};
		set(arrayA);
	}

}
