package boj;

import java.util.Scanner;

public class boj_1072 {
//게임
	// 승, 패 비율에 따른 승률을 조절하려면 어떤 조건이 되어야 되는지 묻는 문제
	// 1) 진횟수 > 이긴횟수 
	// 2) 이긴횟수 < 진횟수
	// 3) 100%= 종료 
	
	public static void main(String[] args) {
	     Scanner scan=new Scanner(System.in);
	     long X=scan.nextLong();
	     long Y=scan.nextLong();
	     
	    //진 횟수 = X - Y
	 	//승률 = Y / X
	  	 long winrate=getRate(X,Y);
	        System.out.println(binarySearch(X, Y, winrate));
	    }
	    
	    private static int binarySearch(long x, long y, long target) {
	        int start = 1, end = (int) x, result = 0;
	        if(getRate(x + x, y + x) == target) return -1; 
	        
	        while(start <= end) {
	            int mid = (start + end) / 2;
	            long z = getRate(x + mid, y + mid);        
	            
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
	    //백분율 표현 함수 = 승리횟수 *100 / 게임횟수 
	    private static long getRate(long x, long y) {
	        return y*100 / x;                      
	    }
	
	    
	    /* 다른풀이 
	    long x = sc.nextInt();
		long y = sc.nextInt();
		
		long z = (y*100/x);
		
		int left = 0;
		int right = 1000000000; 
		
		int result = -1;
		
		while(left <= right) {
			int mid = (left + right) /2;
			
			
			//승률이란 전체 횟수에서 이긴 횟수의 비율 + 50% (최대 10억번 중 50%) 
			long temp = ((y+mid) * 100)/(x+mid);
			
			if (z < temp) {
				result = mid;
				right = mid -1;
			} else {
				left = mid +1;
			}
		}
	     */
}
