package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [이진탐색] ★★★
public class boj_q1072_game2_binarySearch {
	
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());
        
        long winRate = getWinRate(X, Y);
        System.out.println(binarySearch(X, Y, winRate));
    }
    
    private static long getWinRate(long X, long Y) {
        return Y * 100 / X;
    }
	
    private static int binarySearch(long X, long Y, long target) {
        int start = 1;
        int end = (int) X;
        int result = 0;
        if(getWinRate(X + X, Y + X) == target) return -1;        // 승률이 안오르는 경우 <==?? 
        
        while(start <= end) {
            int mid = (start + end) / 2;
            long z = getWinRate(X + mid, Y + mid);        // 승률이 오른건지 체크
            
            if(z > target) {
                end = mid - 1;
                result = mid;
            }
            else {
                start = mid + 1;
            }
        }
        
        return result;
    }
    


}
