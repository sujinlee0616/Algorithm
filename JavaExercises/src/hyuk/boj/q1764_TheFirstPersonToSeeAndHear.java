package hyuk.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class q1764_TheFirstPersonToSeeAndHear {
	
	private static int N,M;
	private static Set<String> set;
	private static List<String> ans;
	
	public static void main(String[] args) throws Exception{
		new q1764_TheFirstPersonToSeeAndHear().service();
	}
	private void service() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		set = new HashSet<String>();
		ans = new ArrayList<String>();
		
		for(int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		for(int i = 0; i < M; i++) {
			String personName = br.readLine();
			if(set.contains(personName)) {
				ans.add(personName);
			}
		}
		Collections.sort(ans, new ComparatorAns());
		StringBuilder sb = new StringBuilder();
		for(String name : ans) {
			sb.append(name + "\n");
		}
		System.out.println(ans.size());
		System.out.println(sb.toString());
		br.close();
	}
}
class ComparatorAns implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}
}