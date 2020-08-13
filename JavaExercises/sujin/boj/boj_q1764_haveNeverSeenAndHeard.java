package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class boj_q1764_haveNeverSeenAndHeard {

		public static void main(String[] args) throws IOException {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			TreeMap<String, Integer> map = new TreeMap<String, Integer>();
			
			for(int i=0; i<n; i++)
				map.put(br.readLine(), 1); // 1: NotHeard
			
			for(int i=0; i<m; i++) {
				String name=br.readLine();
				map.put(name, map.getOrDefault(name, 0)+1); 
				// 디폴트값: 0 ==> 보이지만 않은 애들은 1, 듣지도 못하고 보지도 못한 애들은 1+1=2
				//System.out.print(name+"="+map.get(name));
				//System.out.println();
			}
			br.close();
			
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			// 사전순으로 정렬 
			Iterator<String> keyiterator = map.keySet().iterator();
			
			// 출력 
			int num=0;
			for(String key : map.keySet())
	        	if(map.get(key)==2)
	        		num++;
			System.out.println(num);
			
			while(keyiterator.hasNext()) { 
				String key = keyiterator.next(); 
				int value = map.get(key);
				if(value==2) {
					bw.write(key); 
					bw.newLine();
				}
			}

			bw.flush();
			bw.close();
			
		}
		
		
}


