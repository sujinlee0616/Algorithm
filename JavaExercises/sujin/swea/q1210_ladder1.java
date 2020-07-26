package swea;

import java.util.Scanner;

// [사다리 문제]
// - 소요시간: 약 2시간 
// - 도착지점: 2 
// - 2로 표시된 도착지점에 도착하기 위해서는 어떤 출발점에서 출발해야하는지 출력. ex) data[4][0]에서 출발해야 ==> 4 출력 
// - 아래에서 위로 거슬러 올라가면 되겠네. 

public class q1210_ladder1 {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc=new Scanner(System.in);
		for(int TC=1;TC<=10;TC++) {
			int t=sc.nextInt();
			int[][] arr=new int[100][100];
			
			for(int i=0;i<100;i++)   
				for(int j=0;j<100;j++)
					arr[j][i]=sc.nextInt();   // <== 2차원 배열 입력 받을 때 [i][j] 아니라 [j][i]임에 유의!!! ★★★
			System.out.println("#"+TC+" "+findStartPt(arr));
		}
	}
	
	static int findStartPt(int[][] arr) throws InterruptedException {
		int start=0;
		int x_pt=0;
		int y_pt=99;
		
		int cnt=0;
		
		// 1. 도착점의 위치를 파악한다. 
		for(int i=0;i<100;i++) 
			if(arr[i][99]==2) 
				x_pt=i; //System.out.println("x_pt="+x_pt);

		// 2. 도착점에서 위로 올라가면서 체크한다. 
		while(y_pt>0) {
			cnt++;
			//System.out.println(cnt+"번째 while문");
			
			// 위로 올라가면서 좌우를 살핀다. 
			// 내 현재 위치: (x_pt, y_pt) 
			// ==> 3개를 체크. 좌1상1우0(x_pt-1,y_pt-1), 좌0상1우0(x_pt, y_pt-1), 좌0상1우1(x_pt+1,y_pt-1)
			// ==> 상은 언제나 1이므로 좌우만 살피면 될듯
			
			// 1. 맨왼쪽 또는 맨 오른쪽에 있지 않을 때 
			if(x_pt>0 && x_pt<99) {
				
				// 1) 위로 가는 길이 있을 때 
				if(arr[x_pt][(y_pt-1)] == 1) {
					arr[x_pt][y_pt]=3; // 이미 지나온 길은 3으로 만들자. 
					
					// 위로 1칸 좌로 1칸 이동 
					if( arr[(x_pt-1)][(y_pt-1)] == 1) {
						y_pt--;
						arr[x_pt][y_pt]=3;
						x_pt--; 
						//System.out.println("위로 1칸, 좌로 1칸 이동");
						//System.out.println("x_pt="+x_pt+", y_pt="+y_pt);
					}
					// 위로 1칸 우로 1칸 이동 
					else if( arr[(x_pt+1)][(y_pt-1)] == 1) {
						y_pt--;
						arr[x_pt][y_pt]=3;
						x_pt++; 
						//System.out.println("위로 1칸, 우로 1칸 이동");
						//System.out.println("x_pt="+x_pt+", y_pt="+y_pt);
					}
					// 위로 1칸이동 
					else if( arr[(x_pt-1)][(y_pt-1)] == 0 && arr[(x_pt+1)][(y_pt-1)] == 0 ) {
						y_pt--;
						//System.out.println("위로 1칸 이동");
						//System.out.println("x_pt="+x_pt+", y_pt="+y_pt);
					}	
				}
				// 2) 위로 가는 길이 없고, 좌우로만 갈 수 있을 때 
				else if(arr[x_pt][(y_pt-1)] == 0) {
					arr[x_pt][y_pt]=3; // 이미 지나온 길은 3으로 만들자. 
					
					// 위는 없고 좌우만 있을 때, 우로 이동 
					if(arr[(x_pt+1)][y_pt] == 1) {
						x_pt++;
						//System.out.println("우로 1칸 이동");
						//System.out.println("x_pt="+x_pt+", y_pt="+y_pt);
					}
					// 위는 없고 좌우만 있을 때, 좌로 이동 
					else if( arr[(x_pt-1)][y_pt] == 1) {
						x_pt--;
						//System.out.println("좌로 1칸 이동");
						//System.out.println("x_pt="+x_pt+", y_pt="+y_pt);
					}
				}
				
				
			}
			
			// 2. 맨 왼쪽에 있을 때 
			else if(x_pt==0) {
				
				// 1) 위로 가는 길이 있을 때 <== 항상 있음 
				if(arr[x_pt][(y_pt-1)] == 1) {
					arr[x_pt][y_pt]=3; // 이미 지나온 길은 3으로 만들자. 
					
					// 위로 1칸 우로 1칸 이동 
					if( arr[(x_pt+1)][(y_pt-1)] == 1) {
						y_pt--;
						arr[x_pt][y_pt]=3;
						x_pt++; 
						//System.out.println("위로 1칸, 우로 1칸 이동");
						//System.out.println("x_pt="+x_pt+", y_pt="+y_pt);
					}
					// 위로 1칸이동 
					else if( arr[(x_pt+1)][(y_pt-1)] == 0 ) {
						y_pt--;
						//System.out.println("위로 1칸 이동");
						//System.out.println("x_pt="+x_pt+", y_pt="+y_pt);
					}	
				}
				
			}
			
			// 3. 맨 오른쪽에 있을 때 
			else if(x_pt==99) {

				// 1) 위로 가는 길이 있을 때 <== 항상 있음 
				if(arr[x_pt][(y_pt-1)] == 1) {
					arr[x_pt][y_pt]=3; // 이미 지나온 길은 3으로 만들자. 
					
					// 위로 1칸 좌로 1칸 이동 
					if( arr[(x_pt-1)][(y_pt-1)] == 1) {
						y_pt--;
						arr[x_pt][y_pt]=3;
						x_pt--; 
						//System.out.println("위로 1칸, 좌로 1칸 이동");
						//System.out.println("x_pt="+x_pt+", y_pt="+y_pt);
					}
					// 위로 1칸이동 
					else if( arr[(x_pt-1)][(y_pt-1)] == 0 ) {
						y_pt--;
						//System.out.println("위로 1칸 이동");
						//System.out.println("x_pt="+x_pt+", y_pt="+y_pt);
					}	
				}
			}
			
				
			if(y_pt==0) {
				//System.out.println("x_pt="+x_pt+", y_pt="+y_pt);
				break;
			}
				
			
			//Thread.sleep(500);
		}
		
		start=x_pt;
		
		return start;
	}
}








