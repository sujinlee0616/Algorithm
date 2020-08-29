package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_7562 {
//Knight 
	// 목표 위치까지 몇번만에 이동하는지
		// 나이트 (대각선으로 이동 = 8개의 경우의 수) 
		static int T,len,cx,cy,resX,resY;
		static int dx[]= {-2,-1,1,2,-2,-1,2,1};
		static int dy[]= {-1,-2,-2,-1,1,2,1,2};
		static int res[][];
		public static void main(String[] args) {
			
			
			//dfs로 길이만큼 돌면서 체크 후 경우의 수 리턴? 
			//왠지 안풀려서 bfs로 다시 시도 (재귀 X) 
			//따로 빼려 했으나 실패 
			Scanner scan=new Scanner(System.in);
			T=scan.nextInt();
			
			
			//for(int tc=1;tc<=T;tc++) {
			while(T-->0) {
				
				len=scan.nextInt();//한변의 길이(lenXlen)
				cx=scan.nextInt(); //current 행 
				cy=scan.nextInt(); //current 열
				resX=scan.nextInt();
				resY=scan.nextInt(); // 가려고 하는 위치 
				
				res=new int [len][len];
				//배열에 같은 것 채우는 라이브러리 (**) 
				for(int i=0;i<len;i++)
					Arrays.fill(res[i], -1);
				
				Queue<Integer> q=new LinkedList<>();
				q.add(cx);
				q.add(cy);
				
				//초기화 
				res[cx][cy]=0;
				
				while(!q.isEmpty()) {
					//int x=q.peek();
					//q.poll();
					//한번에 하는법 
					int x=q.remove();
					int y=q.remove();//그다음 = 열의 좌표니까 
					
					
					//나이트 움직이는 경우가 8개 방향 
					for(int i=0;i<8;i++) {
						int nx=x+dx[i];
						int ny=y+dy[i];
						//1) 범위에 있는 경우에만 
						if(nx>=0 && nx<len && ny>=0 && ny<len) {
							if(res[nx][ny]==-1)//초기화 되지 않은 부분  
							{
								res[nx][ny]=res[x][y]+1;
								q.add(nx);
								q.add(ny);
							}
						}
						//2)
						//if(nx<0 || nx>=len || ny<0 || ny>=len) continue;
						//if(res[nx][ny]==1) continue;
						//res[nx][ny]=res[x][y]+1;
						//q.add(nx);
						//q.add(ny);
					}
				}
				//목표 좌표를 배열 자체 인덱스에 넣어서 리턴하는 방식 
				System.out.println(res[resX][resY]);
				
			}
			//모든 테케 출력 후 닫기 
			scan.close();
		}
}
