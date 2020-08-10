package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.stream.Collectors;
// [배경지식]
// - BufferedReader : https://jhnyang.tistory.com/92
// - Map : https://coding-factory.tistory.com/556
// [배경지식] 
// - Map key값 정렬: https://seongsillvanas.tistory.com/7
// - Iterator<string> keyiterator = tm.keySet( ).iterator( ); //키값 오름차순 정렬
// - Iterator<string> keyiterator = tm.descendingKeySet().iterator(); //키값 내림차순 정렬

public class boj_q7785_working_log {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());	
		}
		br.close();
			
		// 데이터 확인 
		// System.out.println(map);
		
		// sort by key ==> TreeMap 이용. ★★★
		TreeMap<String,String> tm = new TreeMap<String,String>(map);
		Iterator<String> keyiterator = tm.descendingKeySet().iterator(); //키값 내림차순 정렬 ★★★
		
		// value가 enter인 사람 다 출력하기 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 이렇게 하면 순서대로 출력 안 됨... 
		/* 
		for(String key : tm.keySet()) {
        	if(tm.get(key).equals("enter")) {
        		bw.write(key);
        		bw.newLine();
        	}
        } */
		// 순서대로 정렬하기 위해서...  ★★★
		while(keyiterator.hasNext()) { 
			String key = keyiterator.next(); 
			String value = tm.get(key);
			if(value.equals("enter")) {
				bw.write(key); 
				bw.newLine();
			}
		}

		bw.flush();
		bw.close();

	}
	
}
