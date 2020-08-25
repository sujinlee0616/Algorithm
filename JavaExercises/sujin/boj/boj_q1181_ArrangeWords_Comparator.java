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
// - http://tcpschool.com/java/java_collectionFramework_comparable
// - https://gmlwjd9405.github.io/2018/09/06/java-comparable-and-comparator.html
// - https://www.daleseo.com/java-comparable-comparator/

public class boj_q1181_ArrangeWords_Comparator {
	
	public static void main(String[] args) throws NumberFormatException,IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// 1. 중복제거 - 중복 제거 귀찮으니까 Set사용했음 
		HashSet<String> set = new HashSet<String>();
		for(int i=0; i<n; i++)
			set.add(br.readLine());
		
		br.close();
		
		ArrayList<String> list = new ArrayList<String>();
		for(String element : set) {
			list.add(element);
		}
		
		// 2. 정렬 - 1) 글자수에 따라 2) 글자수가 같다면 사전순으로  ==> Comparator 이용 
		Comparator<String> MyComparator = new Comparator<String>() {
			public int compare(String x, String y) {
				if (x.length() > y.length()) { // 길이에 따라 정렬 - x의 길이가 y보다 크다면 
					return 1; 
					// 첫 번째 파라미터로 넘어온 객체 > 두 번째 파라미터로 넘어온 객체: 양수 리턴
					// 음수 또는 0이면 객체의 자리가 그대로 유지되며, 양수인 경우에는 두 객체의 자리가 변경된다.
				} else if (x.length() == y.length()) { // 길이가 같다면 
					return x.compareTo(y); 
					// x.compareTo(y) ==> x<y인 경우에는 (y가 사전순으로 더 뒤) 음수를 리턴 ==> x,y 자리 변경X 
					// x.compareTo(y) ==> x>y인 경우에는 (x가 사전순으로 더 뒤) 양수를 리턴 ==> x,y 자리 변경O
				}
				return -1;
			}
		};
		
		Collections.sort(list, MyComparator);

		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
		
	}

}
