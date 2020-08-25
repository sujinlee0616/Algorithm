package incorrect_note;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj_13460 {
//구슬탈출 2 
	
// 맵이 주어지는 형태를 모르니까 완전탐색  필요함
	// 공 2개 = visited 확인에 두 공의 좌표 모두 확인해야 함
		// 4^10 안에 수행가능
	/*
	 1. 상대 공 무시하고 두 공을 굴려 어디로 가는지 확인
	 2. B out = 버린다
	 3. 두 공이 겹치는 경우 ..? 
	 
	 종료조건) 
	 최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지 출력한다. 
	 만약, 10번 이하로 움직여서 빨간 구슬을 구멍을 통해 빼낼 수 없으면 -1
	 */

	static int N,M,rx,ry,bx,by,ans=Integer.MAX_VALUE;
	static char[][]map;

	//direction dx/dy말고 다른 방식 
	static int[][]dir= {{},{0,1},{0,-1},{1,0},{-1,0}};
	
	
	public static void main(String[] args) throws IOException{
		//Scanner scan=new Scanner(System.in);
		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		//N=scan.nextInt();
		//M=scan.nextInt();
	
		map=new char[N][M];
		for(int i=0;i<N;i++) {
			String line=br.readLine();
			for(int j=0;j<line.length();j++) {
				map[i][j]=line.charAt(j);
				//System.out.println(map[i][j]);
				if(map[i][j]=='R') {
					rx=i;ry=j;
				}else if(map[i][j]=='B') {
					bx=i;by=j;
				}
			}
		}
		//동서남북 
		for(int i=1;i<=4;i++)play(rx,ry,bx,by,1,i);
		
		//출력조건 
		if(ans==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}	
	
	public static void play(int rx,int ry,int bx,int by,int count,int d) {
		if(count>=ans) return;
		if(count>10) return;
		
		int cur_rx=rx;
		int cur_ry=ry;
		
		int cur_bx=bx;
		int cur_by=by;
		
		boolean RIn=false;
		boolean BIn=false;
		
		
		//*********RED Ball Move
		while(map[cur_rx][cur_ry]!='#') {
			if(map[cur_rx][cur_ry]=='O') {
				RIn=true;
				break;
			}
			cur_rx+=dir[d][0];
			cur_ry+=dir[d][1];
		}
		cur_rx-=dir[d][0];
		cur_ry-=dir[d][1];
		
		//***BLUE BALL 
		while(map[cur_bx][cur_by]!='#') {
			if(map[cur_bx][cur_by]=='O') {
				RIn=true;
				break;
			}
			cur_bx+=dir[d][0];
			cur_by+=dir[d][1];
		}
		cur_bx-=dir[d][0];
		cur_by-=dir[d][1];
		
		//파란공이 빠졌을 경우
		if(BIn)return;
		else {
			if(RIn) {
				//파란공 안빠졌을 때 | 빨간공은 빠짐 , 둘 중 작은 것 반환 
				ans=Math.min(ans, count);
				return;
			}
		}
		
		//빨간공, 파란공이 같은 위치에 있을 경우
		if(cur_rx==cur_bx && cur_ry==cur_by) {
			int Rlen=Math.abs(cur_rx-rx)+Math.abs(cur_ry-ry);
			int Blen=Math.abs(cur_bx-bx)+Math.abs(cur_by-by);
			//움직인 거리가 많음 = 더 뒤에 있는 공
			
			if(Rlen>Blen) {
				cur_rx-=dir[d][0];
				cur_ry-=dir[d][1];
			}else {
				cur_bx-=dir[d][0];
				cur_by-=dir[d][1];
			}
		}
		
		for(int i=1;i<=4;i++) {
			if(i==d || i==reverse (i))continue;
			play(cur_rx,cur_ry,cur_bx,cur_by,count+1,i);
		}
	}
		
		public static int reverse(int x) {
			if(x==1)return 2;
			else if(x==2) return 1;
			else if(x==3) return 4;
			else if(x==4) return 3;
			return x;
		}
	
}
