package boj;

import java.util.*;

public class boj_6603 {
//Lottery (조합) 
//in = k , out = 6 
// k = 7~12 
// if) k=7 S=1,2,3,4,5,6,7 
// 1)중복 x 2) 조합 3) 오름차순 
// 주의) while 위치, bufferedReader/Writer, 런타임에러 
	
	static int K;
	static int[] S=new int [14];
	static int[] res=new int [14];
	//static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		K=scan.nextInt();
		
		while(true) {
			//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			//StringTokenizer st=new StringTokenizer(br.readLine()," ");
			//K=Integer.parseInt(st.nextToken());

			if(K==0) break;
			for(int i=0;i<K;i++) {
				//S[i]=Integer.parseInt(st.nextToken());
				//bw.write(S[i]);
				S[i]=scan.nextInt();
			}
			
			dfs(0,0);
			//bw.write("\n");
			System.out.println();
		} 
	
	}
	
	public static void dfs(int s,int depth){
		int i;
		if(depth==6) {
			for(i=0;i<6;i++) {
				//bw.write(res[i]);
				System.out.print(res[i]+" ");
				
			}
			System.out.println();
			//bw.write("\n");
			return;
			
		}
		else {
			for(i=s;i<K;i++) {
				res[depth]=S[i];
				dfs(i+1,depth+1);
			}
		}
	}
	
	
	
}
