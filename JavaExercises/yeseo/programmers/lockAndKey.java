package programmers;

public class lockAndKey {
	//자물쇠와 열쇠 
	
	//문제 이해 ) 
	// T = 열 수 있음 F = 안맞음 
	// 돌기/홈이 정확히 맞아야 열쇠를 풀 수 있음 
	// 한 칸만 겹치는 경우도 고려해야 되는데 
	
	// 어떻게 푸는지 감이 안잡힘 .풀이로 해석 어려움 
	public static void main(String[] args) {
		int [][]key= {{0,0,0},{1,0,0},{0,1,1}};
		int [][]lock= {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		System.out.println(solution(key,lock));
	}

		
		static int N,M;
	    public static boolean solution(int[][] key, int[][] lock) {
	        //MxM key 90도 회전 
	        M=key.length;
	        N=key.length;
	        
	        //3차원배열 *****************************
	        int [][][]res=new int[4][N][N];
	        
	        for(int i=0;i<M;i++)
	        	for(int j=0;j<M;j++)
	        		res[0][i][j]=key[i][j]; 
	        
	        for(int k=1;k<4;k++)
	        	for(int i=0;i<N;i++)
	        		for(int j=0;j<N;j++)
	        			res[k][j][N-i-1]=res[k-1][i][j];
	        
	        //res돌면서 답찾는 로직 .. 
	        for(int i=0;i<4;i++)
	        	for(int j=1-N;j<N;j++)
	        		for(int k=1-N;k<N;k++) {
	        			
	        			//임시 저장 배열 
	        			int temp[][]=new int[N][N];
	        			//true로 초기화해서 
	        			boolean check=true;
	        			//조건에 안맞으면 false로 바꾸는 식 
	        			for(int t=0;t<N;t++) {
	        				for(int l=0;l<N;l++) {
	        					int x=t+j;
	        					int y=l+k;
	        					//종료조건 
	        					if(x>=0 && x<N && y>=0 && y<N)
	        						temp[t][l]=res[i][x][y];
	        					
	        					// 임시 ~ 자물쇠랑 비교해서 t/f 출력 
	        					if(temp[t][l]==lock[t][l]) {
	        						check=false;
	        						break;
	        					}
	        				}
	        				//결과 출력 
	        				if(!check)
	        					break;
	        				
	        			}
	        			if(check) return true;
	        		
	        		}
	        
	        return false;
	    }
	}
	
