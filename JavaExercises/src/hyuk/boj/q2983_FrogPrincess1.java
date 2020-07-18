package hyuk.boj;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class q2983_FrogPrincess1 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		HashMap<Integer, TreeSet<pair>> mMap = new HashMap<Integer, TreeSet<pair>>();
		HashMap<Integer, TreeSet<pair>> pMap = new HashMap<Integer, TreeSet<pair>>();

		int x, y;
		int N, K;
		N = scn.nextInt();
		K = scn.nextInt();

		String op = scn.next();
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		x = arr[0][0];
		y = arr[0][1]; // 개구리 처음 위치

		// map 제작
		for (int i = 1; i < N; i++) {
			pair p = new pair();
			p.first = arr[i][0];
			p.second = arr[i][1];
			TreeSet<pair> t = mMap.get(p.first - p.second);
			if (t == null) {
				t = new TreeSet<pair>();
			}
			t.add(p);
			mMap.put(p.first - p.second, t);

			TreeSet<pair> t2 = pMap.get(p.first + p.second);
			if (t2 == null) {
				t2 = new TreeSet<pair>();
			}
			t2.add(p);
			pMap.put(p.first + p.second, t2);
		}

		// 명령 시작
		// System.out.println(" k : " + K);
		for (int i = 0; i < K; i++) {
			char c = op.charAt(i);
			// System.out.println("c : " + c);
			switch (c) {
			case 'A': // 오른쪽 위
			case 'D': // 왼쪽 아래
				TreeSet<pair> t = mMap.get(x - y);
				if (t == null) {
					continue;
				}
				pair tp = new pair();
				tp.first = x;
				tp.second = y;
				pair tmp;
				if (c == 'A') {
					tmp = t.higher(tp);
				} else {
					tmp = t.lower(tp);
				}
				if (tmp == null || t.size() == 0) {
					tmp = null;
					continue;
				}
				x = tmp.first;
				y = tmp.second;
				t.remove(tmp);
				mMap.put(x-y, t);
				
				TreeSet<pair> rt = pMap.get(x+y);
		          rt.remove(tmp);
		          if (rt == null || rt.size() == 0) {
		            rt = null;
		          } 
		          pMap.put(x+y, rt);
				break;
			case 'B':
			case 'C':
				TreeSet<pair> tt = pMap.get(x + y);
				if (tt == null) {
					continue;
				}
				pair ttp = new pair();
				ttp.first = x;
				ttp.second = y;
				pair ttmp;
				if (c == 'B') {
					ttmp = tt.higher(ttp);
				} else {
					ttmp = tt.lower(ttp);
				}
				if (ttmp == null || tt.size() == 0) {
					ttmp = null;
					continue;
				}
				x = ttmp.first;
				y = ttmp.second;
				tt.remove(ttmp);
				pMap.put(x+y, tt);
				
				TreeSet<pair> rrt = mMap.get(x-y);
		          rrt.remove(ttmp);
		          if (rrt == null || rrt.size() == 0) {
		            rrt = null;
		          } 
		          mMap.put(x-y, rrt);
				break;
			}
			//System.out.println("x,y : " + x + " " + y);
		}
		System.out.println(x + " " + y);
	}
	
}

class pair implements Comparable<pair> {
	public int first, second;

	@Override
	public int compareTo(pair o) {
		if (this.first > o.first)
			return 1;
		else if (this.first < o.first)
			return -1;
		if (this.second > o.second)
			return 1;
		else if (this.second < o.second)
			return -1;
		return 0;
	}

}