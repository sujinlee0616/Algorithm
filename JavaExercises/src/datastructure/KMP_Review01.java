package datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class KMP_Review01 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String H = scn.next();
		String N = scn.next();
		MyKmp_Review01 kmp = MyKmp_Review01.getInstance();
		List<Integer> res = kmp.KMP(H, N);
		System.out.println("res : ");
		for(int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i)+ " ");
		}
		System.out.println();
	}
}

class MyKmp_Review01 {
	private static MyKmp_Review01 instance;
	private MyKmp_Review01() {}
	public static MyKmp_Review01 getInstance() {
		if(instance == null) {
			instance = new MyKmp_Review01();
		}
		return instance;
	}
	// Haystack, Needle
	public List<Integer> KMP(String H, String N) {
		int hLen = H.length();
		int nLen = N.length();
		
		int[] table = getPartialTable(N);
		int begin = 0;
		List<Integer> res = new ArrayList<Integer>();
		int matched = 0;
		while(begin <= hLen - nLen) {
			if(matched != nLen && H.charAt(begin+matched) == N.charAt(matched)) {
				matched++;
				if(matched == nLen) {
					res.add(begin);
				}
			}else {
				if(matched == 0) begin++;
				else {
					begin += matched - table[matched-1];
					matched = table[matched-1];
				}
			}
		}
		return res;
	}
	
	private int[] getPartialTable(String N) {
		int len = N.length();
		int begin = 1;
		int matched = 0;
		int[] table = new int[len];
		
		while(begin + matched < len) {
			if(N.charAt(begin+matched) == N.charAt(matched)) {
				matched++;
				table[begin+matched-1] = matched;
			}else {
				if(matched == 0) begin++;
				else {
					begin += matched - table[matched-1];
					matched = table[matched-1];
				}
			}
		}
		return table;
	}
}