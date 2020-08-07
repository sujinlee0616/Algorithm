package hyuk.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class q1620_PorketMonster {
	public static void main(String[] args) throws IOException{
		new q1620_PorketMonster().service();
	}
	private void service() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		Map<String, String> map = new HashMap<String, String>();
		for(int i = 0; i < N; i++) {
			String insert = String.valueOf(i+1);
			String name = br.readLine();
			map.put(insert, name);
			map.put(name,insert);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			sb.append(map.get(br.readLine()) + "\n");
		}
		System.out.println(sb.toString());
		
		br.close();
	}
}
