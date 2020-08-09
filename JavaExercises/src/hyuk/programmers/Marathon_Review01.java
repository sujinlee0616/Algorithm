package hyuk.programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Marathon_Review01 {
	
	public static void main(String[] args) throws Exception{
		new Marathon_Review01().service();
	}
	private String service() throws Exception{
		
		String[] participant = {""}; String[] completion = {""};
		
		String answer = "";
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 0; i < participant.length; i++) {
        	map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }
        for(int i = 0; i < completion.length; i++) {
        	map.put(completion[i], map.getOrDefault(completion[i], 0) - 1);
        }
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        for(Map.Entry<String, Integer> entries : entry ) {
        	if(entries.getValue() > 0) {
        		answer = entries.getKey();
        	}
        }
        
        return answer;
	}
}
