package hyuk.kakao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Kakao_MapHotelNum {
	public static void main(String[] args) {
		long[] ans = new Kakao_MapHotelNum().solution(10L, new long[] {1,3,4,1,3,1});
		print(ans);
	}
	
	public long[] solution(long k, long[] room_number) {
        long[] answer;
        Scanner scn = new Scanner(System.in);
        
        Map<Long, Long> map = new HashMap<Long, Long>();
        int len = room_number.length;
        answer = new long[len];
        int ansPoint = 0;
        for(int i = 0; i < len; i++) {
        	long next = find(map, room_number[i]);
        	answer[ansPoint++] = next;
        }
        
        scn.close();
        
        return answer;
    }
	private long find(Map<Long, Long> map, long num) {
		if(map.containsKey(num)) {
			long next = find(map, map.get(num));
			map.put(num, next);
			return next;
		}else {
			map.put(num, num+1);
			return num;
		}
	}
	
	private static void print(long[] ans) {
		for(int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println();
	}
}
