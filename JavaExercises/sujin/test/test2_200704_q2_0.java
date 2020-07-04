package test;

import java.util.Stack;

public class test2_200704_q2_0 {
	
	public static int[] solution(int[] arrayA, int[] arrayB) {
		int[] answer= {number(arrayA), number(arrayB), number(sum(arrayA, arrayB)), number(complement(arrayA, arrayB)), number(intersect(arrayA, arrayB))};
		
		// 결과확인
		for(int i=0;i<5;i++) {
			System.out.print(answer[i]+",");
		}
		return answer;
	}
	
	
	// 리턴값1: 집합A의 원소 개수 
	public static int number(int[] arrayA) {
		int n=arrayA.length;
		int duplicated=0;
		
		// 중복검사 
		for(int i=0;i<n;i++) {
			for(int j=1;j<n-i;j++) {
				if(arrayA[i+j]==(arrayA[i]))
					duplicated++;
			}
		}
		return n-duplicated;
	}
	
	
	public static int[] makeSet(int[] arrayA) {
		int n=arrayA.length;
		int count=0;
		
		for(int i=0;i<n;i++) {
			boolean duplicated=false;
			
			for(int j=1;j<n-i;j++) {
				if(arrayA[i+j]!=(arrayA[i]))
					duplicated=true;
			}
			if(duplicated==false) {
				count++;
			}
		}
		
		int[] set=new int[count];
		
		for(int i=0;i<n;i++) {
			boolean duplicated=false;
			
			for(int j=1;j<n-i;j++) {
				if(arrayA[i+j]!=(arrayA[i]))
					duplicated=true;
			}
			if(duplicated==false) {
				set[count]=arrayA[i];
			}
		}
		
		for(int i=0;i<set.length;i++)
			System.out.print(set[i]+",");
		
		return set;
	}
	
	
	// 리턴값3: 집합A,B를 합쳤음 
	public static int[] sum(int[] arrayA, int[] arrayB) {
		// 배열을 합쳤음
		int[] plus=new int[arrayA.length+arrayB.length];
		System.arraycopy(arrayA, 0, plus, 0, arrayA.length);
		System.arraycopy(arrayB, 0, plus, arrayA.length, arrayB.length);
		// test - 잘 합쳤는지 확인  
		//for(int i=0;i<plus.length;i++)
			//System.out.print(plus[i]+",");
		return plus;
	}
	
	
	// 리턴값4: 집합A,B의 "차집합"
	public static int[] complement(int[] arrayA, int[] arrayB) {
		
		int[] minus= arrayA.clone();
		
		for(int i=0;i<arrayB.length;i++) {
			boolean duplicated=false;
			// arrayB의 i번째 원소가 arrayA와 겹치는지 검사
			for(int j=0;j<arrayA.length;j++) {
				if(arrayB[i]==arrayA[j])
					duplicated=true;
			}
			if(duplicated==false)
				minus[arrayA.length]=arrayB[i];
		}
		
		// test 
		for(int i=0;i<minus.length;i++)
			System.out.print(minus[i]+",");
		
		return minus;
	}
	
	
	// 리턴값5: 집합A,B의 "교집합"
	public static int[] intersect(int[] arrayA, int[] arrayB) {
		
		int[] common= {1};
		
		return common;
	}
	
	
	public static void main(String[] args) {
		
		int[] arrayA= {1,2,3,2};
		int[] arrayB= {1,3};
		
		//solution(arrayA,arrayB);
		//complement(arrayA,arrayB);
		makeSet(arrayA);
		
	}

}
