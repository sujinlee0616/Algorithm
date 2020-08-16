package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class camouflage {
	//위장 

	public static void main(String[] args) {
        // 조합  
        String clothes[][]={{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        // 서로 다른 옷 조합
        //getOrDefault = get하거나 default로 지정한 값을 가져오는 메소드다 .
        // Map 옷 종류 : 개수 를 이용한 경우의 수 출력 
        // 모든 경우의수 + 1 => 착용하지 않을 경우 포함 
        // 종류1+1 * 종류2+1 -1 => 모두 착용하지 않을 경우 제외(불가능) 
		
		System.out.println(solution(clothes));
	
	}

	    public  static int solution(String[][] clothes) {
	       //일단, 1로 초기화(최소 한가지경우가 존재..?해서인가) 
	    	int answer = 1;
	        Map<String, Integer> map=new HashMap<>();
	        
	        //map에 담기 
	        for(int i=0;i<clothes.length;i++)
	        	//의상 종류 : 개별 의상 
	        	map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);//이 종류를 안입을 경우의 수 ++
	        
	        for(int i:map.values())
	        	//모든 조합을 곱해간다 
	        	answer*=(i+1);
	        
	        // +1 +1 -1 (모두 안 입는경우는 없으니 제외) 
	        return answer-1;
	        
	        
	        //다른 풀이 (람다식)
			/*
			 * return Arrays.stream(clothes) .collect(groupingBy(p -> p[1], mapping(p ->
			 * p[0], counting()))) .values() .stream() .collect(reducing(1L, (x, y) -> x *
			 * (y + 1))).intValue() - 1;
			 */
	        
	        //getOrDefault안쓰는 경우 = 코드 길어진다 + Iterator도 불러와야 함 
	        /*
	         for(int i=0; i<clothes.length; i++){
	         
	            String key = clothes[i][1];
	            if(!map.containsKey(key)) {
	                map.put(key, 1);
	            } else {
	                map.put(key, map.get(key) + 1);
	            }
	        }
	        Iterator<Integer> it = map.values().iterator();
	        while(it.hasNext()) {
	            answer *= it.next().intValue()+1;
	        }
	        return answer-1;
			*/
	    }

}
