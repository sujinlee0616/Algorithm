package programmers;

/*
크레인인형뽑기 

문제이해)
스택
board (인형뽑기기계) 5차 ~ 30차 정방행렬 
- 0 :void
- 1~100 인형 type 

moves (매개변수) 1~1000
열 번호 peek을 pop함 

if)
같은 타입의 인형이 연속해서 쌓이면 터짐 

사라진 인형 개수 반환 (터진개수) 


어려운점)
입력값 자르는 것 부터가 문제 [[,,],[]] => [,]로 자르면 해결  
=> 재사용이 필요 없다?? (main함수 무시하고 일단 코드를짜는게 맞대)
 */

import java.util.Stack;

public class kakao_2 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> s = new Stack<Integer>();
        for(int i=0; i<moves.length; i++) {
            for(int j=0; j<board.length; j++) {
                /* 
                 * 해당 칸에 인형이 존재하는경우
                 * ↓ 아래로 내려가므로 행의 값이 계속 바껴야함 (0,0), (1,0), (2,0) ...
                 * moves배열에 있는 요소를 board[][] 배열의 '열' 값에 넣어서 비교
                 * 배열의 인덱스는 0부터 시작하므로 -1
                 */ 
                if(board[j][moves[i]-1] != 0) {

                    //push !!!!
                    if(s.isEmpty())
                        s.push(board[j][moves[i]-1]);

                    // 스택이 비어있지 않는경우 -> 인형이 동일한지 아닌지 비교
                    else {
                        // 인형이 동일하면 제거 후 사라진 인형개수 +2
                        if(s.peek() == board[j][moves[i]-1]) {
                            s.pop();
                            answer += 2;
                        }
                        // 인형이 동일하지 않으면 스택에 인형 넣기
                        else {
                            s.push(board[j][moves[i]-1]);
                        }
                    }
                    // 해당 작업 끝난 후에는 인형을 빼냈으므로 0으로 만든다.(인형이 없다는 표시)
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
    
    public static void main(String[] args) {
    	//입력값을받는Scanner로 받는 과정 필요 없는지..? 
    	//입력값 예시
		int board[][]= {
				{0,0,0,0,0},
				{0,0,1,0,3},
				{0,2,5,0,1},
				{4,2,4,4,2},
				{3,5,1,3,1}
		};
		
		int moves[]= {1,5,3,5,1,2,1,4};
		System.out.println(solution(board,moves));
		
	}
}