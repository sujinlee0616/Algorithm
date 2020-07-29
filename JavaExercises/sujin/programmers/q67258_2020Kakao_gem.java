package programmers;

import java.util.ArrayList;

public class q67258_2020Kakao_gem {
	
	// test 
	public static void main(String[] args) {
		String[] gems= {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		solution(gems);
	}
	
	public static int[] solution(String[] gems) {
		int start=0;
		int end=0;
        int[] answer = {start+1,end+1};
        
        
        // 모든종류가 포함되도록 싹쓸이 
        ArrayList<String> uniqueList=new ArrayList<String>();
        for(int i=0;i<gems.length;i++) {
        	if(!uniqueList.contains(gems[i]))
        		uniqueList.add(gems[i]);
        }

        // test 
        //for(int i=0;i<uniqueList.size();i++) 
        //	System.out.println(uniqueList.get(i));
        
        int s=uniqueList.size(); 
        int[] visited=new int[s];
        int cnt=0;
        // index a~b까지를 리스트에 집어넣으면서, list의 i번째 인덱스에 방문했으면, visited[i]=1로 한다.
        // visited 배열의 원소의 합이 s와 일치하면 모든 유니크한 애들을 다 집어넣은거임. 
        
        int min=gems.length;
        
        for(int i=0;i<gems.length;i++) {
        	while(cnt<s) {
        		cnt=0;
        		for(int k=0;k<s;k++)
            		cnt+=visited[k];
        		for(int j=0;j<100;j++) {
        			
        		}
        	}
        }
        
        
        
        
        return answer;
    }
	
	
	
}
