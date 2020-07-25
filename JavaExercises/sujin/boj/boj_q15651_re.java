package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

// - 1부터 N까지 자연수 중에서 M개를 고른 수열
// - ★★ 같은 수를 여러 번 골라도 된다. ★★ 

public class boj_q15651_re {

	static int m,n;
	static int[] list,visited;
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken()); // 공백 기준으로 자른다 
		m=Integer.parseInt(st.nextToken());
		
		list=new int[m];
		dfs(0);
		
		// 얘네 해줘야 결과 나옴...
		br.close();
		bw.flush();
		bw.close();
		
	}
	
	static void dfs(int k) throws IOException {
		
		// 1. 끝까지 탐색을 다 끝냈다면 
		if(k==m) {
			for(int i=0;i<m;i++) {
				bw.write(String.valueOf(list[i])+" "); // 이전의 sysout 개념
			}
			bw.newLine(); // 이전의 한 줄 띄우기용 sysout 대용 
			return;
		}
		// 2. 그게 아니라면  
		for(int i=1;i<=n;i++) {
			// 중복허용하므로 중복여부를 체크할 필요가 없음!!!
			list[k]=i;
			dfs(k+1);
			
		}
	}
	
}











