package yeseo_incorrect_note;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_q1966 {
	 /*
	 프린트 큐 
	 1회 - ? 2회 - 
	 큐 동작에 대한 기본적 이해가 어려움 
	 LinkedList() + peek() 활용 
	  */
	
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int a,b,cnt;
		for(int i=0;i<n;i++) {
			Queue<int[]> queue=new LinkedList<>();
			cnt=0;
			a=scn.nextInt();
			b=scn.nextInt();
			for(int j=0;j<a;j++)
				queue.add(new int[] {j,scn.nextInt()});
			while(!queue.isEmpty()) {
				int[] now=queue.poll();
				boolean check=true;
				for(int[]q:queue)
					if(q[1]>now[1])
						check=false;
				if(check) {
					cnt++;
					if(now[0]==b) break;
				}
				else queue.add(now);
			}
			System.out.println(cnt);
		}
	}
}
