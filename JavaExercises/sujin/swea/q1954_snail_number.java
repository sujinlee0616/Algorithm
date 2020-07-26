package swea;

import java.util.Scanner;

// 걸린 시간: 2시간 
// idea) 규칙을 발견해서 for문으로 구현하였음
// 1) x좌표 증가 --> 2) y좌표 증가 --> 3) x좌표 감소 --> 4) y좌표 감소 이렇게 반복된다. 횟수에 유의해서 코드로 바꾸면 됨. 
// ex) N=5
//     x++ X 4     x++ X 3    x++ X 1
//     y++ X 4     y++ X 2
//     x-- X 4     x-- X 2
//     y-- X 3     y-- X 1
// ex) N=6
//     x++ X 5     x++ X 4    x++ X 2
//     y++ X 5     y++ X 3    y++ X 1  
//     x-- X 5     x-- X 3    x-- X 1
//     y-- X 4     y-- X 2

public class q1954_snail_number {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		for(int i=0;i<TC;i++) {
			int n=sc.nextInt();
			System.out.println("#"+(i+1));
			snail_num(n);
		}
	}
	
	static void snail_num(int n) {
		
		int[][] arr=new int[n+1][n+1];
		arr[1][1]=1;
		int cnt=1;
		
		// 1. n이 홀수일 때 
		if(n%2==1) {
			// 0) x++ X (n-1) 번 
			for(int i=1;i<=n;i++) {
				arr[i][1]=i;
			}
			cnt=n;
			 
			int x_pt=n; 
			int y_pt=1;
			
			for(int i=n-1;i>=1;i--) {
				// 1) y++
				if(i%2==0) {
					for(int j=1;j<=i;j++) {
						cnt++;
						arr[x_pt][(y_pt+j)]=cnt;
					}
					y_pt+=i;
				}
				// 2) x--
				if(i%2==0) {
					for(int j=1;j<=i;j++) {
						cnt++;
						arr[(x_pt-j)][y_pt]=cnt;
					}
					x_pt-=i;
				}
				// 3) y--
				if(i%2==1) {
					for(int j=1;j<=i;j++) {
						cnt++;
						arr[x_pt][(y_pt-j)]=cnt;
					}
					y_pt-=i;
				}
				// 4) x++
				if(i%2==1) {
					for(int j=1;j<=i;j++) {
						cnt++;
						arr[(x_pt+j)][y_pt]=cnt;
					}
					x_pt+=i;
				}
			}
			
			
		}
		// 2. n이 짝수일 때 
		else {
			// 0) x++ X (n-1) 번
			for (int i=1; i<=n; i++) {
				arr[i][1] = i;
			}
			cnt = n;

			int x_pt = n;
			int y_pt = 1;

			for (int i = n- 1; i >= 1; i--) {
				// 1) y++
				if (i % 2 == 1) {
					for (int j = 1; j <= i; j++) {
						cnt++;
						arr[x_pt][(y_pt + j)] = cnt;
					}
					y_pt += i;
				}
				// 2) x--
				if (i % 2 == 1) {
					for (int j = 1; j <= i; j++) {
						cnt++;
						arr[(x_pt - j)][y_pt] = cnt;
					}
					x_pt -= i;
				}
				// 3) y--
				if (i % 2 == 0) {
					for (int j = 1; j <= i; j++) {
						cnt++;
						arr[x_pt][(y_pt - j)] = cnt;
					}
					y_pt -= i;
				}
				// 4) x++
				if (i % 2 == 0) {
					for (int j = 1; j <= i; j++) {
						cnt++;
						arr[(x_pt + j)][y_pt] = cnt;
					}
					x_pt += i;
				}
			}
		}
		
		
		// 출력
		for(int y=1;y<=n;y++) {
			for(int x=1;x<=n;x++) {
				//System.out.print("["+x+"]["+y+"]="+arr[x][y]+" ");
				System.out.print(arr[x][y]+" ");
			}
				
			System.out.println();
		}
			
		
	}

}
