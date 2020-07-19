package boj;

import java.io.*;

// 푸는 중 
public class boj_q15649_NandM {
	
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println("N="+N);
		int M = Integer.parseInt(br.readLine());
		System.out.println("M="+N);
		boolean[] visited=new boolean[N];
		int count=0;
		recursion(N,M, visited,count);
	}
	
	public static void recursion(int N, int M, boolean[] visited, int count) {
		
		while(count<M) {
			for(int i=0;i<N;i++) {
				if(visited[i] == true) continue;
				else {
					visited[i] = true;
					recursion(N,M,visited,count);
					System.out.print((i+1)+" ");
				}
				visited[i] = false;
			}
			count++;
		}
			
	}
	
	
	
	// N=4, M=4일 때 
	/* public static void main(String[] args) {
		
		boolean[] visited = new boolean[4];
		
		for(int i=0; i<4; i++) {
			if(visited[i] == true) continue;
			else { 
				visited[i] = true; 
				for(int j=0; j<4; j++) {
					if(visited[j] == true) continue;
					else {
						visited[j] = true;
						for(int k=0; k<4; k++) {
							if(visited[k] == true) continue;
							else {
								visited[k] = true;
								for(int l=0; l<4; l++) {
									if(visited[l] == true) continue;
									else {
										visited[l] = true;
										System.out.println((i+1)+" "+(j+1)+" "+(k+1)+" "+(l+1));
									}
									visited[l] = false;
								}
							}
							visited[k]=false;
						}
					}
					visited[j]=false;
				}
			}
			visited[i]=false;
		}
	}
	*/
	
}
