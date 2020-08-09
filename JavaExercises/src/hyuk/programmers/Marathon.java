package hyuk.programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Marathon {
	public static void main(String[] args) {
		new Marathon().service();
	}
	private void service() {
		String[] participant = {"leo", "kiki", "eden"}; 
		String[] completion = {"eden", "kiki"};
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i < participant.length; i++) {
			if(map.containsKey(participant[i])) {
				map.put(participant[i], map.get(participant[i]) + 1);
			} else {
				map.put(participant[i], 1);
			}
		}
		for(int i = 0; i < completion.length; i++) {
			map.put(completion[i], map.get(completion[i]) -1);
		}
		Set<Map.Entry<String, Integer>> entry = map.entrySet();
		for(Map.Entry<String, Integer> entries : entry) {
			if(entries.getValue() > 0) {
				System.out.println(entries.getKey());
				break;
			}
		}
	}
}
