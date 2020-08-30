package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 단방향 그래프 ★
// 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호 출력 
// --> 단방향 그래프의 길이가 가장 길어지는 출발점을 찾아라. 
public class boj_q1325_EfficientHacking {
	
	static int N,M;
	static boolean visited[];
    static int[] arr; // arr은 int로 구성된 array ==> arr[0]=1, arr[1]=1, ...
    static ArrayList<Integer>[] listArr; 
    // listArr는 ArrayList<Integer>로 구성된 array ==> listArr[0]={0,1,2,3,...} (ArrayList하나)
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		listArr = new ArrayList[N+1];
		arr = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			listArr[i] = new ArrayList<Integer>();
		}
		
		// A B : A가 B를 신뢰한다 ==> B->A 해킹가능 (B에서 A로 해킹 가능.) 
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			listArr[u].add(v);
			// listArr[i] : Node i가 신뢰하는 Node의 집합 
		}
		br.close();
		
		for(int i=1; i<=N; i++) {
            visited = new boolean[N+1];
            bfs(i);
        }
		
		int max = 0;
        
        for(int i=1; i<=N; i++) {
            max = Math.max(max, arr[i]);
        }
        StringBuffer sb = new StringBuffer();
        for(int i=1; i<=N; i++) {
            if(arr[i] == max)
                sb.append(i+" ");
        }
        System.out.println(sb.toString());
	}
	

	public static void bfs(int index) {	
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(index);
        visited[index] = true;
        
        while(!q.isEmpty()) {
            int val = q.poll();
            for(int i=0; i<listArr[val].size(); i++) {
                int v = listArr[val].get(i);
                if(!visited[v]){
                    visited[v] = true;
                    arr[v]++;
                    q.add(v);
                }
            }
        }
    }

}
