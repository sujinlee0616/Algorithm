package etc;

import java.util.HashSet;
import java.util.Iterator;

public class etc_200806_HashSet {

	public static void main(String[] args) {
		HashSet<String> ss = new HashSet<String>();
		
		ss.add("가");
		ss.add("나");
		ss.add("다");
		ss.add("라");
		ss.add("가");
		
		for(String s : ss) {
			System.out.print(s + " ");
			if(s.equals("라")) ss.remove(s);
		}
		
		System.out.println();
		Iterator<String> it = ss.iterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.print(s + " ");
			if(s.equals("다")) it.remove();
		}
		
		System.out.println();
		for(String s : ss) {
			System.out.print(s + " ");
		}
		System.out.println();
		System.out.println("길이 : " + ss.size());
		System.out.println("'가' 포함 여부 : " + ss.contains("가"));
		
	}

}
