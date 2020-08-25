package swea;

import java.util.Scanner;

//[정답] - 해결방법2
// - DFS로 구현. 이 방법이 더 깔끔!! 

public class q1244_max_prize_money3 {
	
	static int result, maxCount;
    static boolean[][] check;

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int tc = sc.nextInt();
    
    	for ( int i=1; i<=tc; i++ ) {
    		String number = sc.next(); // 숫자. 10만 이하 
    		maxCount = sc.nextInt(); // 최대 교환 횟수. 10 이하. 
   
    		check = new boolean[maxCount+1][1000000]; // 같은 교환횟수에 같은 숫자를 탐색했는지 체크
    		result = 0;
    
    		changeNumber(number.toCharArray(), 0);
    		System.out.println("#" + i + " " + result);
    	}
    }

    // DFS로 탐색 
    public static void changeNumber(char[] numberChar, int nowCount) {
    	if ( maxCount == nowCount ) { //횟수만큼 바꿨으면 결과 입력하고 종료
    		result = result > getInteger(numberChar) ? result : getInteger(numberChar);
    		return;
    	}
    
    	int leng = numberChar.length;
    	for (int i=0; i<leng-1; i++ ) {
    		for ( int j=i+1; j<leng; j++ ) {
    			char[] tempNumber = swap(numberChar, i, j);
    			//해당 자리 바꾼 char[] 받아오기
    			if ( !check[nowCount+1][getInteger(tempNumber)] ) {
    				//같은 횟수이면서 같은 숫자를 탐색하지 않았으면 탐색
    				check[nowCount+1][getInteger(tempNumber)] = true;
    				changeNumber(tempNumber, nowCount+1);
    			}
    		}
    	}
    }
    
    public static int getInteger(char[] numberChar) {
    	return Integer.valueOf(String.valueOf(numberChar));
    }
   
    public static char[] swap(char[] numberChar, int point1, int point2) {
    	//해당 자리의 숫자 바꾸기
    	char[] tempNumber = numberChar.clone();
    	char num = tempNumber[point1];
    	tempNumber[point1] = tempNumber[point2];
    	tempNumber[point2] = num;
    	return tempNumber;
    }
}
