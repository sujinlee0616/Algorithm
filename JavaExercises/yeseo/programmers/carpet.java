package programmers;

public class carpet {

	public static void main(String[] args) {
		
		solution(10,2);
		
		//solution(8,1);
		//solution(24,24);
		
	}
	//Brute-Force
	//= 모든 경우를 다 탐색하는 것
	//강력한 방식 but 시간 많이 듦
	// * 접근 *
	// (1)for 반복문
	// (2)순열 / 조합 사용
	// (3)재귀함수 사용
	// (4)비트마스크 ** 
	
	//완탐 < 수학지식 
	
	
	//brown + yellow = x * y 
	public static int[] solution(int brown, int yellow) {
       
        int height=0;
        int total=brown+yellow;
        //식1:너비 
        //x*y=brown+yellow;
        
        //식2:2x+2(y-2) = brown 
        //x+y=(brown+4)/2;
        
        //식3 ************* 
        // yellow=(x-2)*(y-2) 
       
        for(height=3;height<=(brown+4)/2; height++) {
        	total=((brown+4)/2)-height;
        	if(total<height) break;
        	
        	int Ycnt=(total-2)*(height-2);
        	if(yellow==Ycnt) break;
        }
       
        // x=total(너비) y=height(높이), 값 바로 넣어주는 법 ******* 
        int [] answer=new int[] {total,height};
       
        for(int i=0;i<answer.length;i++)
			System.out.print(answer[i]+ " ");
       
        return answer;
    }
}
