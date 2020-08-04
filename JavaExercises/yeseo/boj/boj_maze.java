package boj;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


public class boj_maze {
/*
 2178q
 미로
 
 시작 끝 점도 계수하여 행렬끝까지 도달하는 최소의 거리를 도출하라
 
 너비 우선 탐색 BFS 
 
 tc)
4 6
101111
101010
101011
111011
 */
	static int N,M;
	static boolean visited[][];
	static int map[][];
	static int dx[]= {1,-1,0,0}; //우 좌 하 상 
	static int dy[]= {0,0,-1,1};
	
	public static void main(String[] args){
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
		//StringTokenizer st = new StringTokenizer(br.readLine());
		Scanner scan=new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M]; //t/f 

	   for(int i=0;i<N;i++) {
		   String linial=scan.next();
		   for(int j=0;j<M;j++) {
			   //////문자를 숫자로 변환 //////////////////////////
			   map[i][j]=linial.charAt(j)-'0'; //ASCII코드값 빼 
		   }
	   }
	   
	   bfs(0,0); //start에서 계속 호출 
	   System.out.println(map[N-1][M-1]); // 범위 조심 !! 
	}
	
	
	public static void bfs(int x,int y) {
		
		Queue<Integer> qx=new LinkedList<>();
		Queue<Integer> qy=new LinkedList<>();
		
		
		//좌표 
		qx.add(x);
		qy.add(y);
		
		while(!qx.isEmpty()&&!qy.isEmpty())
		{
			x=qx.poll();
			y=qy.poll();
			visited[x][y]=true;
			
			for(int i=0;i<4;i++) { //방향4군데 
				int cx=x+dx[i];
				int cy=y+dy[i];
				
				if(cx>=0 && cy>=0 && cx<N && cy<M) { //0~N사이를 돌면서 
					if(map[cx][cy]==1 && visited[cx][cy]==false) {
						qx.add(cx); 
						qy.add(cy);
						visited[cx][cy]=true;
						
						map[cx][cy]=map[x][y]+1;//방문좌표 -> 이동횟수 * 이동횟수 리턴해야 되니깐 이걸 좌표에 넣어주움 
				   }
				}
			}
		}
	}
	////재사용 고려했으나 잘 안됨 ....///////////
	static class scan{
		private static BufferedReader br;
		private static StringTokenizer st;
		
		static void init() {
			br=new BufferedReader(new InputStreamReader(System.in));
			st=new StringTokenizer("");
		}
		
		static String next(){
			while(!st.hasMoreTokens()) {
				try {
					st=new StringTokenizer(br.readLine());
				}catch(IOException e) {}
			}
			return st.nextToken();
		}
		
		static int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
