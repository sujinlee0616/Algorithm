package incorrect_note;

import java.io.*;
import java.util.*;
public class boj_NM_4 {


	static int N,M;
	static int[] list;

	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		list=new int[N+1];

		dfs(0,-1);
		
	
		br.close();
		bw.flush();
		bw.close();
		
	}
	
	static void dfs(int depth, int prev) throws IOException {
		
		
		if(depth==M) {
			for(int i=0;i<M;i++) {
				bw.write(list[i]+" "); 
			}
			bw.newLine();  
			return;
		}

		for(int i=1;i<=N;i++) {
			if(prev>i) continue;

			list[depth]=i;
			dfs(depth+1,list[depth]);

			
		}
	}
	
}