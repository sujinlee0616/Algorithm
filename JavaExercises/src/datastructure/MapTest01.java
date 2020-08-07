package datastructure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest01 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 123);
		map.put("b", 323);
		map.put("c", 123);
		map.put("e", 153);
		map.put("d", 1263);
		map.put("hello", 72);
		map.put("a", 124);
		map.remove("e");
		System.out.println(map.get("c"));
		System.out.println(map.get("notUsed"));
		System.out.println("--------------------");
		print(map);
		System.out.println("====================");
		printByIterator(map);
	}
	private static void print(Map<String, Integer> map) {
		Set<Map.Entry<String, Integer>> entries = map.entrySet();
		for(Map.Entry<String, Integer> entry : entries) {
			System.out.println("{" + entry.getKey() + " : " + entry.getValue() + "}");
		}
	}
	private static void printByIterator(Map<String, Integer> map) {
		Set<Map.Entry<String, Integer>> entries = map.entrySet();
		Iterator<Map.Entry<String, Integer>> iter = entries.iterator();
		while(iter.hasNext()) {
			Map.Entry<String, Integer> entry = iter.next();
			System.out.println("{" + entry.getKey() + " : " + entry.getValue() + "}");
		}
	}
}
