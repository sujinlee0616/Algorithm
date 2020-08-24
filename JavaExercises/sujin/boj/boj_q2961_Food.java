package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 신맛 = 사용한 재료의 신맛의 곱
// 쓴맛 = 사용한 재료의 쓴맛의 합 
// 요리의 신맛과 쓴맛의 차이를 가장 작게. 재료는 적어도 하나 이상 사용해야함. 
public class boj_q2961_Food {
	
	static ArrayList<Integer> SList, BList;
	static boolean[] visited;
	static int N, min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		SList = new ArrayList<Integer>();
		BList = new ArrayList<Integer>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			SList.add(S);
			int B = Integer.parseInt(st.nextToken());
			BList.add(B);
		}
		br.close();
		min = Integer.MAX_VALUE;
		solution(1, 0, 0); // S가 곱하기라서 초기값을 0 주면 안 됨. 1 줘야함. 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(min+"\n");
		// [주의] 그냥 bw.write(min); 하면 아스키코드값이 출력됨!!! ==>   ★★★
		// - writer에 int를 넣으면 아스키 코드에 따른 char형 값이 출력된다.
		// - 그러나 i와 개행 처리 문자열 "\n" 을 더하면 String 으로 자동 형변환 되기 때문에 저장되어 있는 int 값 그대로 출력이 가능하다.
		bw.flush();
		bw.close();
	}
	
	static void solution(int SSum, int BSum, int index) {

		if(index == N) { // 다 돌았으면...
			if(min > Math.abs(SSum - BSum) && BSum!=0) {
				min = Math.abs(SSum - BSum);
			}
			return;
		} 
		
		// 다 돈 게 아니면...
		visited[index] = true;
		solution(SSum * SList.get(index), BSum + BList.get(index), index+1);
		visited[index] = false;
		solution(SSum, BSum, index+1);
	
	}

}

