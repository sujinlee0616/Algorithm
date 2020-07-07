package hyuk.boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q1181_sortWord {
	
	public static String[] tmp;
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		tmp = new String[N];
		String[] arr = new String[N];
		for(int i = 0; i < N; i++) {
			arr[i] = scn.next();
		}
		sort(arr,0,arr.length-1);
		
		List<String> list = deduplicate(arr);
		print(list);
	}
	
	public static void sort(String[] arr, int start, int end) {
		if(start >= end) {
			return;
		}
		
		int mid = (start + end) / 2;
		sort(arr, start, mid);
		sort(arr, mid+1, end);
		
		int ps = start;
		int pe = mid+1;
		int ts = start;
		
		while(ps <= mid && pe <= end) {
			//arr[ps], arr[pe] 
			if(compare(arr[ps],arr[pe]) == -1) {
				tmp[ts++] = arr[ps++];
			}else {
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
	private static int compare(String A, String B) {
		if(A.length() > B.length()) {
			return 1;
		}else if(A.length() < B.length()) {
			return -1;
		}
		
		for(int i = 0; i < A.length(); i++) {
			if(A.charAt(i) > B.charAt(i)) {
				return 1;
			}else if(A.charAt(i) < B.charAt(i)) {
				return -1;
			}
		}
		
		return 0;
	}
	private static void print(List<String> arr) {
		for(int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}
	
	private static List<String> deduplicate(String[] arr) {
		List<String> list = new ArrayList<String>();
		if(arr.length == 0) {
			return list;
		}
		String value = arr[0];
		list.add(value);
		for(int i = 1; i < arr.length; i++) {
			if(value.equals(arr[i])) {
				continue;
			}
			value = arr[i];
			list.add(value);
		}
		return list;
	}
}
