package boj;

import java.util.Scanner;

public class boj_1956 {
//운동 
	//Floyd Warshall 응용  = 거쳐가는 node를 기준으로 최단 거리 
		//1) map[][] 출발 , INF 로 초기화 , !INF= 일때만 최단길이 반환 
		//2) i,j와 j,i가 모두 길이 있을 때만 사이클이 존재 
		//단,  INF ==-1 
		//3) 결과가 가장 작은 사람 출력 
		
		
		static int INF=4000000;
		static int map[][]=new int [400][400];
		
		public static void main(String[] args) {
			Scanner scan=new Scanner(System.in);
			int n,m,a,b;
			int c; //temp 
			n=scan.nextInt();
			m=scan.nextInt();
			for(int i=0;i<400;i++) {
				for(int j=0;j<400;j++)
					map[i][j]=INF; //initialize 
			}
			for(int i=0;i<m;i++) {
				a=scan.nextInt();
				b=scan.nextInt();
				c=scan.nextInt();
				
				map[a-1][b-1]=c;
			}
			
			//FW 3바퀴 
			for(int j=0;j<n;j++) {
				for(int i=0;i<n;i++) {
					for(int h=0;h<n;h++) {
						if(map[i][j]>map[i][h]+map[h][j])
							map[i][j]=map[i][h]+map[h][j];
					}
				}
			}
			
			int temp=INF;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(i==j)continue;
					if(map[i][j]!=INF && map[j][i] !=INF)
						temp=Math.min(temp, map[i][j]+map[j][i]);
				}
			}
			
			if(temp==INF) System.out.println("-1");
			else System.out.println(temp);
		}
}
