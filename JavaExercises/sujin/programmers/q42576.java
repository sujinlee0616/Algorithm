package programmers;

import java.util.HashMap;
import java.util.Map;

// Hint) 
// - hash.getOrDefault : 찾는 키가 존재한다면 찾는 키의 값을 반환하고, 없다면 기본 값을 반환. 

// 배경지식) Map
// https://coding-factory.tistory.com/556
public class q42576 {

	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		System.out.println(solution(participant,completion));
	}
	
	public static String solution(String[] participant, String[] completion) {
        
		Map<String, Integer> map = new HashMap<>();
        
        // 1. 참가자 명단을 Map에다가 넣는다. - key는 이름, value는 1로.  
		// - 참가자/완주자가 같은지 체크하는 기준이 이름이니까 key가 이름...
        for(String a : participant) {
        	//map.put(a, 1);  // <== 이렇게 하면 같은 이름이 두 번 들어가는 경우 불가. 
        	map.put(a, map.getOrDefault(a, 0)+1);  // <== 같은 이름이 두 번 들어가는 경우에는 값이 2가 된다. ==> 처리 완료 
        }
        // test 
        // System.out.println(map);
        
        // 2. 완주자 명단을 Map에 넣는다. - key는 이름(그대로), value는 0으로 바꿈.  
        for(String b : completion) {
        	//map.put(b, 0);  // <== 이렇게 하면 같은 이름이 두 번 들어가는 경우 불가.
        	map.put(b, map.get(b)-1); // 
        }
        // test
        // System.out.println(map);
        
        // 저장된 key값 확인 --> map.keySet()
        for(String key : map.keySet()) {
        	//System.out.println("key="+key+", value="+map.get(key));
        	if(map.get(key)==1) {
        		//System.out.println("참석했으나 완주하지 못한 자="+key);
        		return key;
        	}
        }
		return null;
    }
	
}
