package swea;

import java.util.Scanner;

// - 소요시간: 40분  
public class q1215_palindrome {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(int TC=1;TC<=10;TC++) {
			int n=sc.nextInt();
			char[][] arr=new char[8][8];
			for(int i=0;i<8;i++) {
				String s=sc.next();
				for(int j=0;j<8;j++) {
					arr[j][i]=s.charAt(j);
					//System.out.print("arr["+j+"]["+i+"]="+arr[j][i]+" ");
				}
				//System.out.println();
			}
			System.out.println("#"+TC+" "+findPal(n,arr));
		}
	}
	
	static int findPal(int n,char[][] arr) {
		int res=0;
		
		// 입력 시에 n<=8 이라고 하자. 
		
		// 1. 행 검사
		for(int i=0;i<8;i++) { 
			// i번째 행 검사 
			//System.out.println(i+"번째 행 ");
			for(int j=0;j<=8-n;j++) { 
				// x=j일때 검사 
				boolean isPal=true;
				for(int k=0;k<n/2;k++) {
					if(arr[j+k][i]!=arr[j+(n-1)-k][i]) {
						isPal=false;
					}
				}
				if(isPal==true) {
					res++;
					//System.out.println("x="+j);
				}
			}
		}
		
		// 2. 열 검사
		for (int i=0;i<8;i++) {
			// i번째 열 검사
			//System.out.println(i+"번째 열 ");
			for (int j=0;j<=8-n;j++) {
				// y=j일때 검사
				boolean isPal = true;
				for (int k=0; k<n/2; k++) {
					if (arr[i][j+k] != arr[i][j+(n-1)-k]) {
						isPal = false;
					}
				}
				if(isPal==true) {
					res++;
					//System.out.println("y="+j);
				}
			}
		}
		
		return res;
	}
	
}





