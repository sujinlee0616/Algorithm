package boj;


import java.util.PriorityQueue;
import java.util.Scanner;

public class boj_2667 {
/*
단지 번호 붙이기 

인접한 행렬에 1이 존재하면 카운팅해라
=> 위,아래,좌,우만 탐색

1)깊이 우선 탐색 
2)count만 저장해서 출력
3)오름차순으로 소팅 
=> priortyqueue 는 오름차순 소팅을 알아서 해준다? 

입) N, 행렬의 원소 입력 
출) 그룹의 개수, 각 그룹의 단지수를 출력
 */
	
	static int N;
	static int map[][];
	static int []dx= {1,-1,0,0};
	static int []dy= {0,0,1,-1};
	static int count; //군집이몇개 
	static int size[]; //원소 개수 ******* 2)방법에서 씀.. 
	
	
	
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		N=scan.nextInt();
		map=new int[N][N];
		size=new int [323];
		// n*n/2  +1  
		// 3*3 => 5 
		// 크키가n일때 최대 개수 
		// 대각선일 경우 빼서 , 사실 정의하는 공간은 충분하기만 하면 됨 .
	
		
		//map부터 채우자
		for(int i=0;i<N;i++) {
			String line=scan.next();
			for(int j=0;j<N;j++) {
				map[i][j]=line.charAt(j)-'0';
			}
		}
		
		//1) PriorityQueue 구현 
		int group = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();	 
     
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 1) {
                    count = 0;
                    group++; 
                    
                    dfs(i, j);
 
                    pq.add(count);
                }
            }
        }
 
        System.out.println(group);
 
        while(!pq.isEmpty())
            System.out.println(pq.poll());
	    }
	 
	    // visited 대신 단지를 0으로 바꿔가면서 체크
	    static void dfs(int x, int y) {
	        map[x][y] = 0;
	        count++;
	 
	        for(int i=0; i<4; i++) {
	            int nx = x + dx[i];
	            int ny = y + dy[i];
	 
	            if( (nx>=0 && nx<N) && (ny>=0 && ny<N)) {
	            	if( map[nx][ny] == 1)
	  
	                    dfs(nx, ny);
	            }
	        }
	    }
     }
	
		/*
		재혁스 코드 
		//원소 중에 1과 만나는 애들은 카운팅하는 메소드 
		for(int i=0;i<N;i++) {
			String line=scan.next();
			for(int j=0;j<N;j++) {
				map[i][j]=line.charAt(j)-'0';
				if(map[i][j]==1) {
					count++;  //원소 +1 ;
					dfs(i,j,count+1);
			}
		  }
	   }
		
		//2) key 구하는 메소드 
		for(int i=0;i<N;i++) {
			String line=scan.next();
			for(int j=0;j<N;j++) {
				if(map[i][j]>1)
					size[map[i][j]-2]++;
			}
		  }
		
		 Arrays.sort(size);
	   }

	  public static void dfs(int x,int y,int key) {
		/////////////////////
		map[x][y]=key; //조건과 맞으면 그룹1 - 원소 key 1 그룹2 - 원소 key 2 .... 
		/////////////////////
		for(int i=0;i<4;i++) {
				int cx=x+dx[i]; 
				int cy=y+dy[i];
				
				if( (x>=0 && x<N) && (y>=0 && y<N) && (map[cx][cy]==1)) //조건이 일치? 1과 만난다 
					dfs(cx,cy,key);
			}
		}
	}
	*/

