package incorrect_note;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;



/*
그림 
1)그림개수 리턴 
2)square 리턴
 
3) 크기 = 이어져 있는1의 개수 
-1하나만 있으면 그림이 아니다
-대각선에 위치한 1은 별도의 그림이다
 */


//플러드 필 ? (시작,목표,대체) 
//Flood-fill (node, target-color, replacement-color):
//1. If target-color is equal to replacement-color, return.
//2. If the color of node is not equal to target-color, return.
//3. Set the color of node to replacement-color.

/*
1) 전체 배열을 순회
2) 방문하지 않고 1이면 DFS
   방문 하고 갯수를 따로 저장
   꺼내온 데이터에서 인접한 노드가 있다면 dfs 
3) temp의 사이즈와 가장 많은 갯수를 출력
 */
 class boj_1926 {
	    static int[] x = {-1,1,0,0};
	    static int[] y = {0,0,-1,1};
	    static int N,M; //세로 가로 
	    static int[][] map;
	    static boolean[][] visited;
	    
	    
	    static int count;
	    static int temp;
	    static ArrayList<Integer> square = new ArrayList<Integer>();
	 
	    public static void main(String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        //N __ M 세로 가로 두개만 들어오니까 0,1 
	        String[] k = br.readLine().split(" ");
	        N= Integer.parseInt(k[0]);  
	        M= Integer.parseInt(k[1]);
	        
	        map = new int[N][M];
	        visited = new boolean[N][M];
	        
	        for(int i=0; i<N; i++) {
	            String[] line = br.readLine().split(" ");
	            for(int j=0; j<M; j++) {
	                map[i][j] = Integer.parseInt(line[j]);
	            }
	        } 
	        
	        
	        //visited 여부 확인 해서 새로운 map을 그려줌 
	        for(int i=0; i<N; i++) {
	            for(int j=0; j<M; j++) {
	            	
	                if(map[i][j] == 1 && !visited[i][j]) {
	                	
	                    temp = 1;
	                    
	                    dfs(i,j);
	                    count++;
	                    
	                    square.add(temp); //사이즈가 됨 
	                    
	                }
	            }
	        }
	        
	        System.out.println(count);
	        
	        //최대 출력 
	        // Collections.max(square);
	        // try catch 절 없으면 런타임 에러 
	        try {
	            System.out.println(Collections.max(square));
	        } catch (Exception e) {
	            System.out.println(0);
	        }
	        
	    }
	    
	    
	    
	   static void dfs(int a, int b) {
	      
		   visited[a][b] = true;
	        
	        for(int i=0; i<4; i++) {
	            if(a+x[i] >= 0 && a+x[i] < N && b+y[i] >= 0 && b+y[i] < M 
	            	&& map[a+x[i]][b+y[i]] == 1 && !visited[a+x[i]][b+y[i]]) 
	            {
	                temp++;
	                dfs(a+x[i],b+y[i]);
	            }
	        }
	    }
	 
	}
	
	