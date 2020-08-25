package incorrect_note;

import java.util.Arrays;
import java.util.Scanner;

public class boj_1059_Number2 {
	/*
	 수2
	 
	 LuckySet 1,7,10,14
	 N=4
	 답) 4 

직관적 해석
1. 들어오는 N보다 럭키셋이 큰지 작은지 판별 , A~B 정하기
2. sorting하는게 유리 
2. 1~end 2~end 조건에 맞으면 count+=1;
	 
이분탐색으로도 가능 	 
1.	 N의 상대위치를 찾아내면 됨
2.   left ==N -> 0 아니면 경우의 수 출력 ?	 
	 */
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	int N=scan.nextInt();
	int []lucky=new int[N];
	for(int i=0;i<N;i++) lucky[i]=scan.nextInt();
	int unlucky=scan.nextInt();
	
	
	int A=1;//0
	int B=0;
	
	
	Arrays.sort(lucky); 
	
	for(int i=0;i<N;i++) {
		

		if(lucky[i]>=unlucky) {
			B=lucky[i]; break;
		}
		if(lucky[i]<unlucky) A=lucky[i]+1;
	}
	
	
	int count=0;
	for(int i=A;i<B;i++) {
		for(int j=i+1;j<B;j++) { //start+1 ~ B(end)
			if(i<=unlucky && j>=unlucky) 
				count++;
		}
	}
	System.out.println(count);
}
}
