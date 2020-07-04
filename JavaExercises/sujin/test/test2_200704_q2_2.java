package test;

import java.util.Stack;

public class test2_200704_q2_2 {
	
	//public static int[] solution(int[] arrayA, int[] arrayB) {
		//int[] answer= {makeSet(arrayA), number(arrayB), number(sum(arrayA, arrayB)), number(complement(arrayA, arrayB)), number(intersect(arrayA, arrayB))};
		
		// 결과확인
		/* for(int i=0;i<5;i++) {
			System.out.print(answer[i]+",");
		}
		return answer; */
	//}
	
	
	// 리턴값1: 배열A를 집합A로 만든다.
	public static int makeSet(int[] arrayA) {
		int n=arrayA.length;
		// int[] set=new int[n];
		int duplicated=0;
		
		/*
		 * for(int i=0;i<n;i++){ set[i]=-100; }
		 */
		
		// 중복검사 
		for(int i=0;i<n;i++) {
			for(int j=1;j<n-i;j++) {
				if(arrayA[i+j]==(arrayA[i])) { // arrayA[i]는 중복됨 
					for(int k=0;k<n-i;k++) {
						arrayA[i+k]=arrayA[i+k+1];
						//arrayA.
					}
				}
			}
		}
		
		//int[] set=new int[n-duplicated];
		for(int i=0;i<n;i++) {
		}
		
		
		return n-duplicated;
	}
	
	// 리턴값3: 집합A,B의 "합집합"
	public static int[] sum(int[] arrayA, int[] arrayB) {
		// 배열을 합쳤음
		int[] plus=new int[arrayA.length+arrayB.length];
		System.arraycopy(arrayA, 0, plus, 0, arrayA.length);
		System.arraycopy(arrayB, 0, plus, arrayA.length, arrayB.length);
		// 잘 합쳤는지 확인  
		//for(int i=0;i<plus.length;i++)
			//System.out.print(plus[i]+",");
		return plus;
	}
	
	
	// 리턴값4: 집합A,B의 "차집합"
	public static int[] complement(int[] arrayA, int[] arrayB) {
		
		int[] minus= {1};
		Stack<Integer> stk=new Stack<Integer>();
		
		
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
		//return3(arrayA,arrayB);
	}
}
