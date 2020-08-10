package hyuk.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class q7785_WhoRemainsInTheCompany {
	private static int N;
	private static Set<String> set;
	public static void main(String[] args) throws Exception{
		new q7785_WhoRemainsInTheCompany().service();
	}
	private void service() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		set = new HashSet<String>();
		String[] input;
		for(int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			switch(input[1]) {
			case "enter" :
				set.add(input[0]);
				break;
			case "leave" :
				set.remove(input[0]);
				break;
			}
		}
		List<String> list = new ArrayList<String>(set);
		Collections.sort(list, new ComparatorList());
		StringBuilder sb = new StringBuilder();
		for(String name : list) {
			sb.append(name + "\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
class ComparatorList implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2) * -1;
	}
}
