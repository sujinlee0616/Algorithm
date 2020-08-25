package boj;

import java.util.ArrayList;
import java.util.Scanner;

// 틀렸음! 다시 풀어야함! 
// - 백준 1260이랑 비슷한 느낌...
// - 임의의 두 사람이 최소 몇 단계 만에 이어질 수 있는지
// - BOJ 유저의 수와 친구 관계가 입력으로 주어졌을 때, 케빈 베이컨의 수가 가장 작은 사람
// - 꼭지점/간선으로 치환해서, 가장 간선이 많은 꼭지점이 답이라고 생각했는데 아닌듯... 다시 풀자. 
public class boj_q1389_KevinBaconGame {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt(); // 친구 관계의 수 ==> 간선의 수 
		
		// int[] arr = new int[N+1]; // 5개의 꼭지점 --> arr[1], arr[2],... arr[5]
		// ArrayList<Integer> list = new ArrayList<Integer>(); // list.get(0) = ...   list={0,1,2,...};
		// ArrayList<int[]> list = new ArrayList<int[]>();
		// ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer>[] list = new ArrayList[N+1]; // ★★★
			// list는 ArrayList의 배열 ==> list의 원소는 ArrayList<Integer>로 구성되어 있다. 
		
		for(int i=1; i<=N; i++)
			list[i] = new ArrayList<Integer>(); // list[i] : 꼭지점 i에 연결된 점의 리스트 
		 
		for(int i=1; i<=M; i++) {
			int v = sc.nextInt();
			int u = sc.nextInt();
			list[v].add(u); 
			list[u].add(v);
		}

		// test 
		// for(int i=1; i<=N; i++)
			// System.out.println("list["+i+"]="+list[i]);
		
		int max = N;
		
		for(int i=N; i>=1; i--)
			if( list[i].size() >= list[max].size() )
				max = i;
		
		System.out.println(max);
		
	}


}
