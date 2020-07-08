package hyuk.boj;

import java.util.Scanner;

public class q11650_SortCoordinate {
	private static Coordinate[] tmp;
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		tmp = new Coordinate[N];
		Coordinate[] arr = new Coordinate[N];
		for(int i = 0; i < N; i++) {
			Coordinate data = new Coordinate();
			arr[i] = data;
			arr[i].x = scn.nextInt();
			arr[i].y = scn.nextInt();
		}
		sort(arr, 0, arr.length-1);
		printArr(arr);
	}
	
	public static void sort(Coordinate[] arr, int start, int end) {
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
			int check = compare(arr[ps],arr[pe]);
			if(check >= 1) {
				tmp[ts++] = arr[pe++];
			} else if(check == -1) {
				tmp[ts++] = arr[ps++];
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
	private static int compare(Coordinate A, Coordinate B) {
		if(A.x > B.x) {
			return 1;
		} else if( A.x < B.x) {
			return -1;
		} else {
			if(A.y > B.y) {
				return 1;
			} else if(A.y < B.y) {
				return -1;
			}
		}
		return 0;
	}
	
	private static void printArr(Coordinate[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].x + " " + arr[i].y);
		}
	}
}

class Coordinate{
	public int x;
	public int y;
	
	public Coordinate() {
		x = 0; y = 0;
	}
}