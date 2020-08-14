package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj_q2776_MemoryKing {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int j=0; j<TC; j++) {
			
			int N = Integer.parseInt(br.readLine()); // 100만 이하 
			String s1 = br.readLine();
			StringTokenizer st1 = new StringTokenizer(s1);
			HashSet<Integer> set = new HashSet<Integer>();
			
			while(st1.hasMoreTokens()) 
				set.add(Integer.parseInt(st1.nextToken()));
			
			int M = Integer.parseInt(br.readLine());
			String s2 = br.readLine();
			StringTokenizer st2 = new StringTokenizer(s2);
			while(st2.hasMoreTokens()) {
				if(set.contains(Integer.parseInt(st2.nextToken())))
					bw.write("1\n");
				else
					bw.write("0\n");
			}
			
		}
		
		br.close();
		bw.flush();
		bw.close();
			
	}

}
