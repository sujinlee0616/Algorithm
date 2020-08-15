package boj;

import java.util.Scanner;

public class boj_1389 {
//KevinBacon
//node간의 가장 작은 정점을 찾는 문제 
// INF로 node간 연결관계 나타냄 
	// node 수 =관계 ++ ;
//Floyd Warshall = 거쳐가는 node를 기준으로 최단 거리
//Dijkstra = 정점의 최단 경로 구하기 = single destination shortest path
	
	
	static int INF=10000000;
	static int n,m,a,b;
	static int idx=0;
	static int map[][]=new int[101][101];
	
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		m=scan.nextInt();
		for(int i=1;i<=n;i++)//1~N 
			for(int j=1;j<=n;j++)
				map[i][j]=INF; //initialization
	
		for(int i=1;i<=m;i++) {
			a=scan.nextInt();
			b=scan.nextInt();
			map[a][b]=1;
			map[b][a]=1; // 인접행렬 1로 초기화 *map 재사용 
		}
		floyd();
		System.out.println(idx);
	}
	
	
	//3바퀴 돌면서 자기 자신에게 돌아오는 노드는 제외하고 최소값(최단거리) 를 찾는 방식 
	public static void floyd() {
		for(int f=1;f<=n;f++) {
			for(int g=1;g<=n;g++) {
				for(int h=1;h<=n;h++) {
					if(g==h) continue;
					map[g][h]=Math.min(map[g][h], map[g][f]+map[f][h]);
				}
			}
		}
	
		int val=10000000;
		for(int i=1;i<=n;i++) {
			int temp=0;
			for(int j=1;j<=n;j++) {
				if(i==j)continue;
				temp+=map[i][j];
			}
			if(val>temp) {
				val=temp;
				idx=i;
			}
		}
	}
}
