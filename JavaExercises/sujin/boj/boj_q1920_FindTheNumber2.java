package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

// Set로 푼 것 - 통과함
// - List보다 Set가 시간 훨씬 짧음!!
// - list는 순서도 저장하지만 set는 순서 저장하지 않기 떄문에 검색하는데 있어서 훨씬 빠름. 
public class boj_q1920_FindTheNumber2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String s1 = br.readLine();
		StringTokenizer st1 = new StringTokenizer(s1);
		HashSet<Integer> set = new HashSet<Integer>();
		while(st1.hasMoreTokens()) 
			set.add(Integer.parseInt(st1.nextToken()));
		
		int m = Integer.parseInt(br.readLine());
		String s2 = br.readLine();
		br.close();
		StringTokenizer st2 = new StringTokenizer(s2);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(st2.hasMoreTokens()) {
			int a = Integer.parseInt(st2.nextToken());
			if(set.contains(a)) 
				bw.write("1\n");
			else
				bw.write("0\n");
		}
		bw.flush();
		bw.close();
		
	}
}
