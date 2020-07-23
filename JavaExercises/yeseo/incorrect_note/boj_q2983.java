package incorrect_note;

import java.util.*;


public class boj_q2983 {
/*
 * 개구리 공주  1'30"
 * 1)개구리는 가장 가까운 꽃으로 뛴
 * 2)고른방향에 식물(N)이 없으면 제자리
 * 3)개구리 점프가 끝나는 좌표를 출력하라(정답은 식물좌표 중 하나)
 * 4)최초의 개구리 좌표 =N최초값
 
		int flower[][]=new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				flower[i][0]=scn.nextInt();
				flower[0][j]=scn.nextInt();
				System.out.println(i+","+j+"="+flower[i][j]);
			}			
		}
 
 
  		for(int j=1;j<K;j++) {				
			if(command[i]=="A") {
				resX[i]+=x[j];
				resY[i]+=y[j];	
			}
			else if(command[i]=="B") {
				resX[i]+=x[j];
				resY[i]-=y[j];	
			}
			else if(command[i]=="C") {
				resX[i]-=x[j];
				resY[i]+=y[j];	
			}else if(command[i]=="D"){
				resX[i]-=x[j];
				resY[i]-=y[j];	
			}
 
 */
	
	private static Edge[] list = new Edge[100005];
	private static Integer[] sorted = new Integer[100005];
	private static int N,K;
	private static char command[]=new char[100005];
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		N=scn.nextInt();
		K=scn.nextInt();
		
		String jump=scn.next();
		for(int i=0;i<jump.length();i++) {
			if(jump.charAt(i)=='A')
				command[i]='A';
			if(jump.charAt(i)=='B')
				command[i]='B';
			if(jump.charAt(i)=='C')
				command[i]='C';
			if(jump.charAt(i)=='D')
				command[i]='D';
		}
		
		
		int x[]=new int[N];
		int y[]=new int[N];
		for(int i=0;i<N;i++)
		{
			x[i]=scn.nextInt();
			y[i]=scn.nextInt();
			list[i]=new Edge(x[i],y[i]);
			sorted[i]=i;
		}

		Arrays.sort(sorted, 0, N, new Comparator<Integer>() {
			@Override
			public int compare(Integer i, Integer j) {
				return (list[i].d1 != list[j].d1) ? list[i].d1 - list[j].d1 : list[i].d2 - list[j].d2;
			}
		});
		for (int i = 1; i < N; ++i) {
			if (list[sorted[i - 1]].d1 == list[sorted[i]].d1) {
				list[sorted[i - 1]].direction[1] = sorted[i];
				list[sorted[i]].direction[2] = sorted[i - 1];
			}
		}

		Arrays.sort(sorted, 0, N, new Comparator<Integer>() {
			@Override
			public int compare(Integer i, Integer j) {
				return (list[i].d2 != list[j].d2) ? list[i].d2 - list[j].d2 : list[i].d1 - list[j].d1;
			}
		});
		for (int i = 1; i < N; ++i) {
			if (list[sorted[i - 1]].d2 == list[sorted[i]].d2) {
				list[sorted[i - 1]].direction[0] = sorted[i];
				list[sorted[i]].direction[3] = sorted[i - 1];
			}
		}

		solve();
	}
	
	public static void solve() {
		int jump = 0;

		for (int i = 0; i < K; ++i) {
			int c =(int)command[i] - (int) 'A';
			int next = list[jump].direction[c];

			if (next == -1)
				continue;

			for (int j = 0; j < 4; ++j) {
				if (list[jump].direction[j] != -1) {
					list[list[jump].direction[j]].direction[3 - j] = list[jump].direction[3 - j];
				}
			}

			jump = next;
		}

		System.out.printf("%d %d\n", list[jump].x, list[jump].y);
	}
	
	static class Edge {
		private int x, y, d1, d2;
		private int[] direction = { -1, -1, -1, -1 };

		public Edge(int x, int y) {
			this.x = x;
			this.y = y;
			this.d1 = x + y;
			this.d2 = x - y;
		}	
	}
}
