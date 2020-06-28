package hyuk.boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q1966 {
	public static void main(String[] args) {
		int tc;
		Scanner scn = new Scanner(System.in);
		tc = scn.nextInt();
		
		for(int t = 0; t < tc; t++) {
			int N,M;
			N = scn.nextInt();
			M = scn.nextInt();
			Queue<Element> que = new LinkedList<Element>();
			for(int i = 0; i < N; i++) {
				Element e = new Element(i, scn.nextInt());
				que.offer(e);
			}
			
			int num = 1;
			while(que.size() != 0) {
				int max = getMax(que);
				if(que.peek().priority == max) {
					if(que.peek().id == M) {
						System.out.println(num);
						break;
					} else {
						num++;
						que.poll();
					}
				} else {
					Element tmp = que.poll();
					que.offer(tmp);
				}
			}
		}
	}
	public static int getMax(Queue<Element> q) {
		int max = 0;
		for(int i = 0; i < q.size(); i++) {
			if(max < q.peek().priority) {
				max = q.peek().priority;
			}
			Element tmp = q.poll();
			q.offer(tmp);
		}
		return max;
	}
}

class Element {
	public int id;
	public int priority;
	public Element(int id, int priority) {
		this.id = id;
		this.priority = priority;
	}
}
