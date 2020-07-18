package incorrect_note;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class boj_q1181 {
	
/*
 단어 정렬 
1)count Method --integer.compare 
2)inOrder Method -- arrays.sort

Comparator - user interface 
Comparable - based on primitive sorting method

ex)
13
but
i
wont
hesitate
no
more
no
more
it
cannot
wait
im
yours
 */

	//카운팅하는 메소드 
	public static int[] count(String A[]) {
		int cnt=0;
		int res[]=new int[A.length];
		for(int i=0;i<A.length;i++) {
			String target=A[i];
			for(int j=0;j<A[i].length();j++) {
				cnt++;
			}
			res[i]=cnt;
			cnt=0;
			//System.out.println(res[i]);
		}
		
		
		return res;
	}
		
	//수가 같을 경우 알파벳 순으로 - 기존 sort로 해결가능 
	public static void inOrder(String B[]) {
		Arrays.sort(B);
		for(int i=0;i<B.length;i++) {
			System.out.println(B[i]);
		}
	}
	
	
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		String []A=new String [N];
		
		
		// 중복처리
		List list=new ArrayList();
		for(int i=0; i<N; i++) {
			A[i]=scan.next();
			if(!list.contains(A[i]))
				list.add(A[i]);
		}
		
	
		// same as count method
		Comparator<String> comp=new Comparator<String>() {
			public int compare(String x, String y) {
				if(x.length()>y.length()) {
					return 1;
				}else if(x.length()==y.length()) {
					return x.compareTo(y);
				}return -1;
			}
			
		};
		
		Collections.sort(list,comp);
		//	System.out.println(list);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		//count(A);
		//inOrder(A);
		

	}
}
