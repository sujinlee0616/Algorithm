package swea;

import java.util.Scanner;

// 스도쿠 검증 문제. 소요시간: 3시간 
public class q1974_sudoku {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(); // n=2 ==> 18줄 
		
		int[][] a=new int[9][9];
				
		for(int x=0;x<n;x++) { // 스도쿠판(9x9) n개 
			// 스도쿠판(9X9) 한 판에 대해 - x번째 스도쿠판 
			
			// 1. 배열에 입력  // i번째 줄 j번째 열 
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					a[(j/3)+3*(i/3)][3*(i%3)+j%3]=sc.nextInt();
					// test
					// System.out.print("a["+ ( (j/3) + 3*(i/3) ) + "][" + ( 3*(i%3) + j%3 ) + "]= "+a[(j/3)+3*(i/3)][3*(i%3)+j%3]+ " ");
				}
				// System.out.println();
			}
			// System.out.println();
			
			// 2. 판정결과 출력 
			System.out.println("#"+(x+1)+" "+judge(n,a));
		}
	}
	
	public static int judge(int n, int[][] a) {
		int res=1;
		boolean[] used=new boolean[9]; // used[0] ~ used[8]
		// used[i]: 숫자 (i+1)가 이미 사용되었는지   
		
		// 겹치는 숫자가 없을 경우 1, 겹치는 숫자가 있을 경우 0
		
		// 1. 3X3 미니 스도쿠 안에서 겹치는게 있는지 
		for(int i=0;i<9;i++) {
			// i번째 3X3 스도쿠 내부 조사
			for(int j=0;j<9;j++) {
				int temp = a[i][j]; // temp=1~9
				used[temp-1]=true; // 1~9까지 다 있다면 used[0]~used[8] 모두가 다 true가 된다. 
			}
			for(int j=0;j<9;j++) {
				if(used[j]==false) // used[]가 false인 게 있다면 (즉, 겹치는게 있다면) 
					res=0;
			}
			// 초기화 
			for(int j=0;j<9;j++)
				used[j]=false;
		}
		
		// 2. 세로줄에 겹치는게 있는지 
		for(int k=0;k<3;k++) {
			for(int l=0;l<3;l++) {
				// 세로 한 줄 검사 
				// System.out.println((3*k+l)+"번째 세로줄 검사");
				int temp1 = a[k][0+l];  used[temp1-1]=true;
				int temp2 = a[k][3+l];  used[temp2-1]=true;
				int temp3 = a[k][6+l];  used[temp3-1]=true;
				int temp4 = a[k+3][0+l];  used[temp4-1]=true;
				int temp5 = a[k+3][3+l];  used[temp5-1]=true;
				int temp6 = a[k+3][6+l];  used[temp6-1]=true;
				int temp7 = a[k+6][0+l];  used[temp7-1]=true;
				int temp8 = a[k+6][3+l];  used[temp8-1]=true;
				int temp9 = a[k+6][6+l];  used[temp9-1]=true;
				
				for(int j=0;j<9;j++) {
					if(used[j]==false) // used[]가 false인 게 있다면 (즉, 겹치는게 있다면) 
						res=0;
				}
				// 초기화 
				for(int j=0;j<9;j++)
					used[j]=false;
			}
		}
		
		// 3. 가로줄에 겹치는게 있는지 
		for(int k=0;k<3;k++) {
			for(int l=0;l<3;l++) {
				// 가로 한 줄 검사 
				// System.out.println((3*k+l)+"번째 세로줄 검사");
				int temp1 = a[3*k][3*l];  used[temp1-1]=true;
				int temp2 = a[3*k][3*l+1];  used[temp2-1]=true;
				int temp3 = a[3*k][3*l+2];  used[temp3-1]=true;
				int temp4 = a[3*k+1][3*l];  used[temp4-1]=true;
				int temp5 = a[3*k+1][3*l+1];  used[temp5-1]=true;
				int temp6 = a[3*k+1][3*l+2];  used[temp6-1]=true;
				int temp7 = a[3*k+2][3*l];  used[temp7-1]=true;
				int temp8 = a[3*k+2][3*l+1];  used[temp8-1]=true;
				int temp9 = a[3*k+2][3*l+2];  used[temp9-1]=true;
				
				for(int j=0;j<9;j++) {
					if(used[j]==false) // used[]가 false인 게 있다면 (즉, 겹치는게 있다면) 
						res=0;
				}
				// 초기화 
				for(int j=0;j<9;j++)
					used[j]=false;
			}
		}
		
		return res;
	}
	
	
}




// idea) 3X3 스도쿠를 쉽게 검사하기 위하여 입력값을 아래와 같은 배열로 만들었음
// 첫번째 9X9 스도쿠																			 // [가로줄 중복값 비교 for문] 														
// a[0][0], a[0][1], a[0][2], | a[1][0], a[1][1], a[1][2], | a[2][0], a[2][1], a[2][2],     k=0, l=0 
// a[0][3], a[0][4], a[0][5], | a[1][3], a[1][4], a[1][5], | a[2][3], a[2][4], a[2][5],     k=0, l=1
// a[0][6], a[0][7], a[0][8], | a[1][6], a[1][7], a[1][8], | a[2][6], a[2][7], a[2][8],     k=0, l=2
// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
// a[3][0], a[3][1], a[3][2], | a[4][0], a[4][1], a[4][2], | a[5][0], a[5][1], a[5][2],     k=1, l=0 
// a[3][3], a[3][4], a[3][5], | a[4][3], a[4][4], a[4][5], | a[5][3], a[5][4], a[5][5],     k=1, l=1
// a[3][6], a[3][7], a[3][8], | a[4][6], a[4][7], a[4][8], | a[5][6], a[5][7], a[5][8],     k=1, l=2
// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
// a[6][0], a[6][1], a[6][2], | a[7][0], a[7][1], a[7][2], | a[8][0], a[8][1], a[8][2],     k=2, l=0 
// a[6][3], a[6][4], a[6][5], | a[7][3], a[7][4], a[7][5], | a[8][3], a[8][4], a[8][5],     k=2, l=1 
// a[6][6], a[6][7], a[6][8], | a[7][6], a[7][7], a[7][8], | a[8][6], a[8][7], a[8][8],     k=2, l=2 
// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
// 두번째 9X9 스도쿠
// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
//a[0][0], a[0][1], a[0][2], | a[1][0], a[1][1], a[1][2], | a[2][0], a[2][1], a[2][2],     
//a[0][3], a[0][4], a[0][5], | a[1][3], a[1][4], a[1][5], | a[2][3], a[2][4], a[2][5],     
//a[0][6], a[0][7], a[0][8], | a[1][6], a[1][7], a[1][8], | a[2][6], a[2][7], a[2][8],      
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-
//a[3][0], a[3][1], a[3][2], | a[4][0], a[4][1], a[4][2], | a[5][0], a[5][1], a[5][2],     
//a[3][3], a[3][4], a[3][5], | a[4][3], a[4][4], a[4][5], | a[5][3], a[5][4], a[5][5],      
//a[3][6], a[3][7], a[3][8], | a[4][6], a[4][7], a[4][8], | a[5][6], a[5][7], a[5][8],      
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-
//a[6][0], a[6][1], a[6][2], | a[7][0], a[7][1], a[7][2], | a[8][0], a[8][1], a[8][2],
//a[6][3], a[6][4], a[6][5], | a[7][3], a[7][4], a[7][5], | a[8][3], a[8][4], a[8][5],
//a[6][6], a[6][7], a[6][8], | a[7][6], a[7][7], a[7][8], | a[8][6], a[8][7], a[8][8],  
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
// [세로줄 중복값 비교 for문]  
// k=0      k=0       k=0       k=1       k=1      k=1        k=2      k=2     k=2  
// l=0      l=1       l=2       l=0       l=1      l=2        l=0      l=1     l=2


// [3*(i/3)][j%3]
// ==>  [3*(i/3)][ 3*(i%3) + j%3]   // <== 참고) 1/3=0 (정수/정수=정수) 임에 유의 
// ==>  [ 3*(i/3) + j/3 ][ 3*(i%3) + j%3]

