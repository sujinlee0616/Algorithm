package programmers;

import java.util.HashMap;

// 조합
// 옷의 종류(Key)가 나중에 들어옴..

public class q42578_Disguise {
	
	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"}, 
				{"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
	}
	
	public int solution(String[][] clothes) {

		HashMap<String,Integer> map = new HashMap<String, Integer>(); 
        // Key : 옷의 종류, Value : 해당 옷 종류의 수 
        
        for(String[] arr : clothes) {  // ★★★
        	// String[] arr : clothes = {"yellow_hat", "headgear"}
        	// 							{"blue_sunglasses", "eyewear"}
        	 if(map.containsKey(arr[1])){ // arr[1] = headgear
                 map.put(arr[1], map.get(arr[1])+1); // 이미 있으면 +1
             }
             else {
                 map.put(arr[1],1);
             }
        }

        // 경우의 수 구하기) 
        // 안경 3개 / 모자 2개 / 신발 4개 ==> 4 * 3 * 5 - 1
        // (안경 3개 + 안경 안 쓰는 경우1) * (모자 2개 + 모자 안 쓰는 경우1) * (신발 4개 + 신발 안 신는 경우1) - 1 
        // -1: 모든 종류의 옷을 안 입는 것은 안되므로. 
        int answer = 1;
        for (int val : map.values()) {
            answer*=(val+1);
        }
        return answer-1;
        
    }

	
}
