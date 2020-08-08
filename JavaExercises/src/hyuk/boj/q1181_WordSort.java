package hyuk.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class q1181_WordSort {
	
	private static int N;
	private static Set<String> set;
	
	public static void main(String[] args) throws Exception{
		new q1181_WordSort().service();
	}
	private void service() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		set = new HashSet<String>();
		for(int i = 0; i < N; i++) {
			String value = br.readLine();
			set.add(value);
		}
		List<String> list = new ArrayList<String>(set);
		Collections.sort(list, new ListComparator());
		print(list);
		br.close();
	}
	private void print(List<String> list) {
		for(String value : list) {
			System.out.println(value);
		}
	}
}

class ListComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		if(o1.length() - o2.length() != 0) return o1.length() - o2.length();
		return o1.compareTo(o2);
	}
	
}
