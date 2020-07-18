package hyuk.boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q1967_DiameterOfTree {
	
	private static List<Integer> tree[] = new ArrayList[10010];
	private static List<Integer> line[] = new ArrayList[10010];
	private static int res = 0;
	public static void main(String[] args) {
		// Tree 입력받기 -> 최대 10000개가 있으므로, 트리의 최대 깊이 = 10000
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		for(int i = 0; i < 10005; i++) {
			tree[i] = new ArrayList<Integer>();
			line[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < N-1; i++) {
			int index = scn.nextInt();
			int left = scn.nextInt();
			int right = scn.nextInt();
			/*
			 * if(tree[index] == null) { tree[index] = new ArrayList<Integer>(); }
			 * if(line[index] == null) { line[index] = new ArrayList<Integer>(); }
			 */
			tree[index].add(left);
			line[index].add(right);
		}
		
		//트리를 탐색하며 최대 경로 찾기
		treeDiameter(0, 1);
		System.out.println(res);
	}
	
	public static int max(int a, int b) {
		if(a > b)	return a;
		return b;
	}
	
	public static int treeDiameter(int path, int node) {
		//System.out.println("node : " + node);
		//System.out.println("mid res : " + path);
		if(node == 0) {
			return 0;
		}
		res = max(res,path);
		//왼쪽, 오른쪽 비교해서 최댓값 찾기
		List<Integer> ans = new ArrayList<Integer>();
		for(int i = 0; i < tree[node].size(); i++) {
			if(tree[node].get(i) != null) {
				ans.add(treeDiameter(path+line[node].get(i), tree[node].get(i)) + line[node].get(i));
			}
		}
		
		int[] best = new int[2];
		for(int i = 0; i < 2; i++) {
			if(ans.size() != 0) {
				best[i] = bestValue(ans);
				ans.remove(ans.indexOf(best[i]));
			}
		}
		res = max(res, best[0] + best[1]);
		return best[0];
	}
	public static int bestValue(List<Integer> arr) {
		int best = 0;
		for(int i = 0; i < arr.size(); i++) {
			best = max(best, arr.get(i));
		}
		return best;
	}
}
