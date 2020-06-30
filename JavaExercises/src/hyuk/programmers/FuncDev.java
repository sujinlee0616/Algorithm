package hyuk.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FuncDev {
	public static void main(String[] args) {
		int[] arr = { 93, 30, 55 };
		int[] speeds = { 1,30,5 };

		
		int[] ans = solution(arr, speeds);
		
		for(int i = 0; i < ans.length; i++) {
			if(ans[i] == 0) {
				break;
			}
			System.out.print(ans[i] + " ");
		}
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		//int[] answer = new int[110];
		ArrayList list = new ArrayList();
		
		//1. 큐에 넣기
		Queue<Integer> que = new LinkedList<Integer>();
		Queue<Integer> sque = new LinkedList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		boolean deploy = true; // 배포가 발생
		int pos = 0;
		
		for(int i = 0; i < progresses.length; i++) {
			que.offer(progresses[i]);
			sque.offer(speeds[i]);
		}
		
		//2. 동작
		while(que.size() != 0) {
			int len = que.size();
			int count = 0;
			for(int i = 0; i < len; i++) {
				int speed = sque.poll();
				int nextData = que.poll() + speed;
				que.offer(nextData);
				sque.offer(speed);
			}
			
			deploy = true;
			for(int i = 0; i < len; i++) {
				int progress = que.poll();
				int speed = sque.poll();
				if(deploy == true && progress >= 100) {
					count++;
				} else if(deploy == true && progress < 100){
					deploy = false;
					que.offer(progress);
					sque.offer(speed);
				} else if(deploy == false) {
					que.offer(progress);
					sque.offer(speed);
				}
			}
			if(count != 0) {
				//answer[pos++] = count;
				list.add(count);
			}
		}
		int[] answer = new int[list.size()];
		for(int i = 0; i < answer.length; i++) {
			answer[i] = (int)list.get(i);
		}
		return answer;
	}
}
