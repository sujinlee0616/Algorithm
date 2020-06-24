package algorithm;

import java.util.Scanner;

public class boj_q2578_bingo {
	
	// 소요시간: 약 2시간 
	// 문제: 사회자가 몇 번째 수를 부른 후 철수가 "빙고"를 외치게 되는지 출력한다.
	
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		// 철수가 쓴 빙고 
		int [][]a=new int[5][5];
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				a[i][j]=sc.nextInt();
				//System.out.print(a[i][j]+",");
			}
			//System.out.println("");
		}
		//System.out.println("=== 철수가 쓴 빙고 ====");
		
		// 사회자가 부르는 답안지 순서 
		int []b=new int[25];
		for(int i=0;i<25;i++) {
			b[i]=sc.nextInt();
			//System.out.print(b[i]+",");
		}
		//System.out.println("=== 사회자의 답안 ====");
		// 사회자가 부르는거 부터 체크해야하니까 기준이 b 겠네 
		// 사회자가 순서대로 답을 부름 
		
		for(int i=0; i<25; i++) {
			int bingo=0; 
			//System.out.println("============"+(i+1)+"번째 정답 불렀음 ============");
			// 지금 부른 정답이 철수한테 있는지 체크 ==> 일치하면 값을 100으로 바꿈 
			for(int m=0; m<5; m++) {
				for(int n=0; n<5; n++) {
					if(a[m][n]==b[i]) {
						a[m][n]=100;
						//System.out.println("맞았음: m="+m+", n="+n);
						//System.out.println("a["+m+"]["+n+"]="+a[m][n]);
					}
				}
			}
			
			// 빙고가 있는지 확인 
			// 1. 행 체크 
			for(int m=0; m<5; m++) {
				int row=0;
				//System.out.println(m+1+"번째 행 체크 ");
				for(int n=0; n<5; n++) {
					row+=a[m][n];
					if(row==500) {
						bingo++;
						//System.out.println(m+1+"번째 행 빙고!");
					}
						
				}
			}
			// 2. 열 체크 
			for(int m=0; m<5; m++) {
				int col=0;
				//System.out.println(m+1+"번째 열 체크 ");
				for(int n=0; n<5; n++) {
					col+=a[n][m];
					if(col==500) {
						bingo++;
						//System.out.println(m+1+"번째 행 빙고!");
					}
						
				}
			}
			
			// 3. cross X자 체크 - (0,0)(1,1)(2,2)(3,3)(4,4)
			for(int m=0; m<5; m++) {
				int cross1=0; 
				cross1+=a[m][m];
				if(cross1==500) {
					bingo++;
					//System.out.println("크로스1 빙고!");
				}
			}
			// 3. cross X자 체크 - (0,0)(1,1)(2,2)(3,3)(4,4)
			int cross2=0; 
			cross2+=a[0][4]+a[1][3]+a[2][2]+a[3][1]+a[4][0];
			if(cross2==500) {
				bingo++;
				//System.out.println("크로스2 빙고!");
			}
			//System.out.println(i+1+"번째 정답 불렀을 때 빙고의 수="+bingo);
			
			if(bingo>=3) {
				//System.out.println((i+1)+"번째에서 빙고가 됩니다!!");
				System.out.println(i+1);
				break;
			}
			
		}
		
		
	}

}
