package boj;
import java.io.*;
import java.util.*;

//단어 정렬 set Version
public class boj_1181_setVer {
	
	    public static void main(String args[]) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int N = Integer.parseInt(br.readLine());
	        
	        //set이용 
	        HashSet<String> set = new HashSet<String>();
	 
	        for(int i=0; i<N; i++) 
	            set.add(br.readLine());
	        
	        // List 변환
	        ArrayList<String> list = new ArrayList<String>(set);
	 
	        // Comparator 클래스를 통하여 custom 정렬
	        // 길이에 따라서 먼저 정렬하고 길이가 같으면 사전순으로 정렬
	        Collections.sort(list, new Comparator<String>() {
	            public int compare(String v1, String v2) {
	                if(v1.length() > v2.length()) 
	                    return 1;
	                else if(v1.length() < v2.length()) 
	                    return -1;
	                else
	                    return v1.compareTo(v2);
	            }
	        });
	 
	        for(String s : list) 
	            System.out.println(s);
	    }
	}

