package incorrect_note;
import java.util.*;
public class boj_q1269 {
/*
 	대칭 차집합
 	1)A ~ N
 	2)B ~ M
 	3)A-B
 	4)B-A
 
 	HashSet 쓰기  
 	1h
  
 */
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int M=scan.nextInt();
		
		int A[]=new int[N+1]; //비교가 용이 
		HashSet B=new HashSet();
		
		for(int i=0;i<N;i++) {
			A[i]=scan.nextInt();
		}
		
		for(int j=0;j<M;j++) {
			B.add(scan.nextInt());
		}
		
		
		//(A-B)U(B-A) 
		//addAll
		
		//***대칭차집합 = 합집합에서 - 겹치는 수를 2번제거. 
		int count=0;
		for(int k=0;k<N;k++) {
			if(B.contains(A[k])) 
				count++;
		}
		
		System.out.println(N+M-(count*2));
		
	}
}
