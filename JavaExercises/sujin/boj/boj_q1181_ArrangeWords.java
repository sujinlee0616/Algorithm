package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

// [배경지식] Comparable, Comparator 
// - https://gmlwjd9405.github.io/2018/09/06/java-comparable-and-comparator.html

public class boj_q1181_ArrangeWords {
	
	public static void main(String[] args) throws NumberFormatException,IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// 1. 중복제거 
		// 중복 제거 귀찮으니까 Set사용할까? 
		HashSet<String> set = new HashSet<String>();
		for(int i=0; i<n; i++)
			set.add(br.readLine());
		
		br.close();
		
		// 2. 글자수에 따라 정렬 
		ArrayList<wordsAndLeng> list = new ArrayList<wordsAndLeng>();
		for(String element : set) {
			list.add(new wordsAndLeng(element, element.length()));
		}
		
		// Collections.sort(list);
		
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i).word);
		
	}
	
	public static class wordsAndLeng {
		String word;
		int leng;
		
		wordsAndLeng(String a, int b){
			this.word = a;
			this.leng = b;
		}
		public String getWord() {
			return word;
		}
		public int getLeng() {
			return leng;
		}
		
		// 이렇게 하면 조건 하나밖에 못 씀.
		/* 
		@Override
		public int compareTo(wordsAndLeng o) {
			return leng-o.leng;
		} */ 
	} 
	
	
		

}
