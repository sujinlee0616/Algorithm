package programmers;

import java.util.HashMap;

// [배경지식] map의 메소드 
// 1. getOrDefault(key,default값) 메소드 : 
//  - 이미 map에 해당 key가 들어가 있는 경우 key의 value를 리턴. 
//  - map에 해당 key가 들어있지 않았다면 지정한 default값을 리턴. 
// 2. map.keySet() 메소드 : 
//  - 이 map의 key값들을 리턴함. 
public class q42576_2 {
	
	public static void main(String[] args) {
		
		// String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		// String[] completion = {"josipa", "filipa", "marina", "nikola"};
		
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
	
		
		System.out.println(solution(participant,completion));
	}
	
	
	static String solution(String[] participant, String[] completion) {
        String ans = "";
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        int lengP = participant.length;
        int lengC = lengP - 1;
        
        // 참가자 중에 ★동명이인★이 있을 수 있다 
        // 참가자 : X명 
        for(String a : participant) {
        	map.put(a, map.getOrDefault(a, 0)+1); 
        	// getOrDefault 메소드 : 
        	//  - 이미 map에 해당 key가 들어가 있는 경우 key의 value를 리턴. 
        	//  - map에 해당 key가 들어있지 않았다면 지정한 default값을 리턴. 
        	// ===> (동명이인이 아닌 경우) 0+1 = 1이 값으로 들어감
        	//      (동명이인이 2명인 경우) 이미 1이 들어가 있었음 ==> 1+1 = 2가 값으로 들어감.  
        }
        for(String b : completion) {
        	map.put(b, map.get(b)-1);
        	// 참가도 했고 완주도 했으면 0이 값으로 들어감 
        }
        
        for(String element : map.keySet()) // map.keySet() ★★★
        	if(map.get(element) != 0)
        		ans = element;
        
        return ans;
    }

}
