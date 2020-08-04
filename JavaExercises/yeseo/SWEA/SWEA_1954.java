package SWEA;

import java.util.Scanner;

public class SWEA_1954 {
/*
달팽이 숫자 
1)우회전 방향으로 +1 
2)N*N정방행렬일 경우 출력되는 달팽이

규칙을 찾자)

2x2
12
43

3x3
123 
894 (7)
765 (-1)
 (우)
  (하)
   (좌)
     (2우)
4x4
1234 
1213145 (+11)
1116156 (-1)(-3)(-1)
10987	(-1)(-7)(-8)
   
   
NxN		 1 ~ NxN 		
123N     1
   N+1   2
   N+2   3
   N+3   N  
 */
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int T=scan.nextInt();
		for(int c=1;c<=T;c++) {
		int N=scan.nextInt();
		int res[][]=new int[N][N];
		/////우하좌 (2우)/////
		int turn=1;
		///////////
		int x=0;
		int y=-1;
		int cnt=1; //삽입 1 ~ N*N 
		//3X3가정 
		while(true) {
			for(int i=0;i<N;i++) {
				y=y+turn; //좌 
				res[x][y]=cnt; //01 02 03 
				cnt++;
			}
			N--;//돌때마다 출력할 개수가 하나씩 줄지 
			for(int i=0;i<N;i++) {
				x=x+turn;
				res[x][y]=cnt;
				cnt++;
			}
			turn *=-1;
			if(N==0)
				break;
		}
		System.out.println("#"+c);
		
		for(int i=0;i<res.length;i++) {
			for(int j=0;j<res.length;j++) {
				//res[0][0]=1;
				//res[i][j]+=1;//00=1 01=2 02=3 0n=N
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
		
	  }	
	}
}
