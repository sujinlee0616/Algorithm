package incorrect_note;

import java.io.*;
import java.util.*;
public class boj_NM_3 {

	//중복을허용한다 visited가 필요 없음 (다시 같은 node로 들어가서 출력해줘야 되니까) 
	static int m,n;
	static int[] list;
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		list=new int[m];
		dfs(0);
		
	
		br.close();
		//bw.flush(); //쓰레기통 비우기 (close만) 
		bw.close(); //권장사항 ()!!!
		
	}
	
	static void dfs(int depth) throws IOException {
		
		
		if(depth==m) {
			for(int i=0;i<m;i++) {
				bw.write(list[i]+" "); 
			}
			bw.newLine();  
			return;
		}

		for(int i=1;i<=n;i++) {
		
			list[depth]=i;
			dfs(depth+1);
			
		}
	}
	
}