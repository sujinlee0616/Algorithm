package boj;

import java.util.Scanner;

public class boj_q3052_remainder {
	
	// 문제: 10개의 수 입력받은 후, 이 수들을 42로 나눴을 때 나머지가 몇 가지가 나오는지 
	// 19min 소요 

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int[] a=new int[10]; // 입력받은 10개의 숫자 
		int[] b=new int[42]; // 나머지가 0~41인 숫자의 수 
		int[] c=new int[10]; // 배열a의 원소를 42를 나눈 나머지를 저장하는 배열 
		int count=0;
		
		for(int i=0; i<10; i++) {
			a[i]=sc.nextInt();		
			c[i]=a[i]%42; // 42로 나눈 나머지를 저장하는 배열 ex) c[2]=40 
			//System.out.print("c["+i+"]="+c[i]+",");
			//System.out.println();
			
			for(int j=0; j<42; j++) {
				if(c[i]==j)
					b[j]++;
				//System.out.print("b["+j+"]="+b[j]+",");
			}
			//System.out.println();
			
		}		
		
		for(int j=0; j<42; j++) {
			if(b[j]!=0)
				count++;
		}
		
		System.out.println(count);
		
	}
}





