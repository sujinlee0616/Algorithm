package test;

import java.sql.Array;
import java.util.ArrayList;

// arrayA,B가 공집합일 떄의 처리 안 했음. 

public class test2_200705_q2 {
	
	public static int[] solution(int[] arrayA, int[] arrayB) {
		int[] answer= {makeSet(arrayA).size(),makeSet(arrayB).size(),
						sum(arrayA, arrayB).size(), complement(arrayA, arrayB).size(),
						intersect(arrayA, arrayB).size()};
		
		for(int i=0;i<5;i++)
			System.out.print(answer[i]+",");
		
		return answer;
	}
	
	// 배열A를 집합A로 만드는 메소드 
	public static ArrayList<Integer> makeSet(int[] arr) {
		
		int n=arr.length;
		ArrayList<Integer> set=new ArrayList<Integer>();
		set.add(arr[0]); // 우선 첫번째 원소를 넣고 
		
		for(int i=1;i<n;i++) {
			// arr[i]가 이전에 set에 들어간 원소와 중복되는지 검사 
			if(!set.contains(arr[i]))
				set.add(arr[i]);
		}
		
		// test 
		//for(int i=0;i<set.size();i++)
		//	System.out.print(set.get(i)+",");
		
		return set;
	}
	
	// 합집합 만드는 메소드 sum
	public static ArrayList<Integer> sum(int[] arr1, int[] arr2) {
		
		ArrayList<Integer> res=new ArrayList<Integer>();
		
		// 배열1을 집합으로 만든 것을 res에 추가 
		res.addAll(makeSet(arr1));
		
		for(int i=0;i<arr2.length;i++) {
			// arr2[i]가 이전에 res에 들어간 원소와 중복되는지 검사 
			if(!res.contains(arr2[i]))
				res.add(arr2[i]);
		}
		
		// test 
		//for(int i=0;i<res.size();i++)
		//	System.out.print(res.get(i)+",");
		
		return res;
	}
	
	// 차집합 만드는 메소드 complement
	public static ArrayList<Integer> complement(int[] arr1, int[] arr2) {
		
		ArrayList<Integer> res=new ArrayList<Integer>();
		// 배열1을 집합으로 만든 것을 res에 추가 
		res.addAll(makeSet(arr1));
		
		// 집합1에 배열2의 원소가 있으면 집합1에서 그 원소를 제거 
		for(int i=0;i<res.size();i++) {
			// arr2[i]가 이전에 res에 들어간 원소와 중복되는지 검사 
			for(int j=0;j<arr2.length;j++) {
				if(res.get(i)==arr2[j]) {
					res.remove(i);
				}
			}
		}
		
		// test
		//for(int i=0;i<res.size();i++)
		//	System.out.print(res.get(i)+",");
		
		return res;
	}
	
	
	// 교집합 만드는 메소드 intersect
	public static ArrayList<Integer> intersect(int[] arr1, int[] arr2) {
		
		ArrayList<Integer> res=new ArrayList<Integer>();
		
		ArrayList<Integer> ARR1=makeSet(arr1);
		ArrayList<Integer> ARR2=makeSet(arr2);
		
		for(int i=0;i<ARR1.size();i++) {
			for(int j=0;j<ARR2.size();j++) {
				if(ARR1.get(i)==ARR2.get(j))
					res.add(ARR1.get(i));
			}
		}
		
		// test
		//for(int i=0;i<res.size();i++)
		//	System.out.print(res.get(i)+",");
		
		return res;
	}
	
	
	public static void main(String[] args) {
		
		int[] arrayA= {1,2,3,2};
		int[] arrayB= {1,3};
		int[] arrayC= {1,2,3,1,2,3,4,5,5,5,6,7};
		int[] arrayD= {1,2,3,5,7};
		int[] arrayE= {1,2,3,4,6};
		int[] arrayF= {4};
		
		 solution(arrayC,arrayE);
		// makeSet(arrayC);
		// sum(arrayA,arrayC);
		// complement(arrayC, arrayA);
		// intersect(arrayF, arrayE);
		
	}

}
