package programmers;

//import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class q42576_Marathon {

	
	  
    public static void main(String[] args) {
    	String []p= {"leo", "kiki", "eden"};
		String []c= {"eden","kiki"};
		
	}
	/*
	 완주하지 못한 선수
	 1) participant를 Map에 담는다 .... 
	 2) 비교해서 P엔 있는데 C엔 없는애를 ++ 
	 3) 단) String이니까 equals를 사용 

	 
	 *
	 *
	 */
	
	 public class Solution {
	    public String solution(String[] participant, String[] completion) {
	        String answer = "";
	        Map<String, Integer> hash = new HashMap<>();
	    	        for (String arg : participant) hash.put(arg, hash.getOrDefault(arg, 0) + 1);
	    	        for (String arg : completion) hash.put(arg, hash.get(arg) - 1);
	    	 
	    	        for (String key : hash.keySet()) {
	    	            if (hash.get(key) != 0) return key;
	    	        }
	    	 
	    	        return null;
	    	   
	    	
	    	

	        
	        //B 이렇게 풀면 안되는 이유
	        //1) 동명이인 처리 불가능
	        //2) for문 두번 돌면서 overflow 
	      //Arrays.sort(participant);
	      //Arrays.sort(completion); //사전순으로 넣는게 = index주는 거랑 같으니까 
	       /*
	        for(int i=0;i<participant.length;i++) {
	        	for(int j=0;j<completion.length;j++) {
	        		if(!participant[i].equals(completion[j]))
	        			answer= participant[i];
	        	}
	        }
	        return answer;
	    }*/
	  
	}
  }
}
	
