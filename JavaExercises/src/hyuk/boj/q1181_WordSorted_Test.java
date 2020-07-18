package hyuk.boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q1181_WordSorted_Test {
	
	private static String[] tmp;
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		String[] arr = new String[N];
		tmp = new String[N];
		for(int i = 0; i < N; i++) {
			arr[i] = scn.next();
		}
		
		mergeSort(arr, 0, arr.length-1);
		List<String> ans = deduplicate(arr);
		printArr(ans);
	}
	
	//1. 합병정렬하는 메서드
	private static void mergeSort(String[] arr, int start, int end) {
		if(start >= end) {
			return;
		}
		
		int mid = (start + end ) / 2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid+1, end);
		
		int ps = start, pe = mid+1, ts = start;
		while(ps <= mid && pe <= end) {
			//arr[ps]의 우선순위가 더 클 때
			if(compare(arr[ps],arr[pe]) >= 0) {
				tmp[ts++] = arr[ps++];
			} else {
				tmp[ts++] = arr[pe++];
			}
		}
		while(ps <= mid) {
			tmp[ts++] = arr[ps++];
		}
		while(pe <= end) {
			tmp[ts++] = arr[pe++];
		}
		for(int i = start; i <= end; i++) {
			arr[i] = tmp[i];
		}
	}
	
	//2. 비교 기준을 정하는 메서드
	private static int compare(String a, String b) {
		// 길이로 먼저 정한다
		if(a.length() < b.length()) {
			return 1;
		} else if(a.length() > b.length()){
			return -1;
		}
		
		//길이가 같을 때, 각 원소를 사전순으로 비교한다
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(i) < b.charAt(i)) {
				return 1;
			} else if(a.charAt(i) > b.charAt(i)) {
				return -1;
			}
		}
		//완전히 같을 때
		return 0;
	}
	
	//3. 중복을 제거하는 메서드
	private static List<String> deduplicate(String[] arr) {
		List<String> list = new ArrayList<String>();
		int point = 0;
		String value = arr[0];
		list.add(value);
		for(int i = 1; i < arr.length; i++) {
			if(value.equals(arr[i])) continue;
			list.add(arr[i]);
			value = arr[i];
		}
		return list;
	}
	
	//4. 배열을 출력하는 메서드
	private static void printArr(List<String> arr) {
		for(int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}
}
