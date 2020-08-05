package presentation;

public class NandM {
 public static void main(String[] args) {
	 int M=4;
	 int N=4;
	 boolean[] visited = new boolean[4];
		
		for(int i=0; i<N; i++) {
			
			if(visited[i] == true) continue;
			
			else { 
				
				visited[i] = true; 
				
				for(int j=0; j<N; j++) {
					
					if(visited[j] == true) continue;
					
					else {
						visited[j] = true;
						
						for(int k=0; k<N; k++) {
							
							if(visited[k] == true) continue;
							
							else {
								
								visited[k] = true;
								
								for(int l=0; l<N; l++) {
									
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

}
