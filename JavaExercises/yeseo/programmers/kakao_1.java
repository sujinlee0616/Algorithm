package programmers;

import java.util.Scanner;
import java.util.StringTokenizer;

/*
키패드 누르기


2개만 맞고 나머지 틀림.... 



엄지손가락 상하좌우 4가지 방향 이동만 가능 
1   3
4   6
7   9
*   #
왼  오
2580 = 더 가까운 엄지순 / 만약 같다면 ? 오른손잡이 왼손잡이 

prev의 왼/오 위치 저장 
어떻게? → ‘상/하’로 이동시 숫자가 3차이 나고, ‘좌/우’로 이동시 숫자가 1차이 나는 것을 이용해서
현재 버튼과 목적지 버튼의 차이값에 각각 3으로 나눈 몫과 나머지 값을 더해주면 거리가된다

*/



class kakao_1 {

    public static void solution(int[] numbers, String hand) {
        String answer = "";
    	int left=1; //*
    	int right=0; //# 
        int curLeft=10; 
        int curRight=12;
        for(int i=0;i<numbers.length;i++){
        	//현재버튼 = i | 상|하 =3 ; 좌|우=1 
        if(i==1||i==4||i==7) {
        	curLeft=i;
        	answer+="L";
        	
        }else if(i==3||i==6||i==9){
        	curRight=i;
        	answer+="R";
        	
        }else { //중간번호 
        	
        	if(i==0) i+=11;  //0+11 0 == prev 11
        	//거리 차이 구하기 
        	//만약 지금 4이고 다음에 누를게 5라면 왼쪽이 되겠지 
        	int distanceLeft=Math.abs(i-curLeft);
        	int distanceRight=Math.abs(i-curRight);
        	
        	int current; //지금 손 위치 
        	if(distanceLeft==distanceRight) current=hand=="right"?right:left;
        	else if(distanceLeft<distanceRight) current=left;
        	else current=right; //0 
        	
        	if(current==0) {
        		curRight=i;
        		answer+="R";
        	}else {
        		curLeft=i;
        		answer+="L";
        	}      	
        }
     }
        System.out.println(answer);
        //return answer;
    }
    
    public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		String temp=scan.nextLine();
		StringTokenizer st=new StringTokenizer(temp, ", ");
		int numbers[]=new int[st.countTokens()];
		while(st.hasMoreTokens()) {			
			for(int i=0;i<st.countTokens();i++) {
				numbers[i]=Integer.parseInt(st.nextToken());
				//System.out.println(numbers[i]);
			}
		}
		String hand=scan.next();
    	solution(numbers,hand);
	}
}