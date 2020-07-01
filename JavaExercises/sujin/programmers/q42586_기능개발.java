package programmers;

import java.util.Queue;
import java.util.LinkedList;

public class q42586_기능개발 {
	
	
	// 이 코드의 문제점
	// 1. 배열의 끝에 갔을 때를 저장을 못 함. 
	// 2. while문이 한 번만 돈다. 
	
	 public static int[] solution(int[] progresses, int[] speeds) {

		 int[] finish_day= new int[progresses.length]; // 완료되는데 걸리는 일자 
		 Queue<Integer> result=new LinkedList<Integer>(); // 배포되는 수 
		 
		 for(int i=0; i<progresses.length; i++) {
			 finish_day[i]=(int) Math.ceil((100-progresses[i])/speeds[i]); 
			 //System.out.println(finish_day[i]);
		 }
		 
		 int distribute_index=0; // 새로운 배포가 시작되는 인덱스 번호 
		 
		 while(distribute_index<progresses.length) {
			System.out.println("Hello"); // while문이 한 번만 돈다. 
			 int count=1;
			 for(int j=1; j<=progresses.length-distribute_index; j++) {
				 System.out.println("j="+j);
				 
				 // 인덱스 초과됨 
				 if(finish_day[distribute_index]>finish_day[distribute_index+j]) {
					 System.out.println("finish_day["+distribute_index+"] > finish_day["+(distribute_index+j)+"]");
					 count++;
				 }
				 else {
					 System.out.println("finish_day["+distribute_index+"] < finish_day["+(distribute_index+j)+"]");
					 distribute_index=j;
					 
				 }
				 System.out.println("count="+count);
				 System.out.println("distribute_index="+distribute_index);
				 
			 }
			 result.offer(count);
			 break;
		 }
		 

		 
		 int[] answer=new int[result.size()];
		 
		 // 뒤에 3,1,1 을 실행을 해줘야...
		 
		 for(int i=0; i<answer.length; i++) {
			 answer[i]=result.poll();
			 System.out.print(", ansewr["+i+"]="+answer[i]);
		 }
	     
		 return answer;
	        
	    }
	 
	 
	 public static void main(String[] args) {
		
		 //int[] progresses= {93,30,55};
		 //int[] speeds= {1,30,5};
		 // ==> finish_day={7,3,9};
		 // ==> result= {2,1}
		 int[] progresses= {97,98,99,95,93};
		 int[] speeds= {1,1,1,1,1};
		 // ==> finish_day={3,2,1,5,7};
		 // ==> result= {3,1,1}
		 
		 solution(progresses,speeds);
		 
	 }
	

}
