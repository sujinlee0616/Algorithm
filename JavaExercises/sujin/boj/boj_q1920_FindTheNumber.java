package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

// List로 푼 것 - 시간초과남...
public class boj_q1920_FindTheNumber {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String s1 = br.readLine();
		StringTokenizer st1 = new StringTokenizer(s1);
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		while(st1.hasMoreTokens()) 
			list1.add(Integer.parseInt(st1.nextToken()));
		
		int m = Integer.parseInt(br.readLine());
		String s2 = br.readLine();
		
		br.close();
		
		StringTokenizer st2 = new StringTokenizer(s2);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(st2.hasMoreTokens()) {
			int a = Integer.parseInt(st2.nextToken());
			list2.add(a);
			if(list1.contains(a))
				bw.write("1\n");
			else
				bw.write("0\n");
		}
		bw.flush();
		bw.close();
		
	}
	
}





