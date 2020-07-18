package incorrect_note;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
// 집합의 표현  
// 55'
// Set사용법/트리 구조 이해가 어려웠음 + 메소드 2개 
public class boj_q1717 {

	public static void link(int arr[],int a,int b) {
		arr[find(arr,b)]=find(arr,a);
	}
	
	public static int find(int arr[],int a) {	
		if(arr[a]==a) return a;  //그 순서가 곧 원소 
		else return arr[a]=find(arr,arr[a]);		
	}
	
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt(); //0<=a,b<=N
		int M=scan.nextInt(); //입력 개수 <=100,000 
		
		int arr[]=new int[N+1];
		for(int k=0;k<=N;k++)  //{0}~{n}
			arr[k]=k;	
		
		
		for(int i=0;i<M*3;i++) {
			int command=scan.nextInt();
			int a=scan.nextInt();
			int b=scan.nextInt();
			
			if(command==0) {
				//합집합 addAll
				link(arr,a,b);
			}else {
				//교집합 retainAll
				if(find(arr,a)==find(arr,b))
					System.out.println("YES");
				else
					System.out.println("NO");
			}
			
			
		}
		
		

	}
}
