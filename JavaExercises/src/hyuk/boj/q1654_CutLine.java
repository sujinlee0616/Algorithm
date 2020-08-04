package hyuk.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class q1654_CutLine {
	public static void main(String[] args) throws Exception{
		new q1654_CutLine().service();
	}
	private void service() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		long[] arr = new long[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		long res = binarySearch(N,M,arr,0L, 0,3000000000L);
		System.out.println(res);
		br.close();
	}
	private long binarySearch(int N, int M, long[] arr, long res, long start, long end) {
		long mid = (start + end) / 2;
		long value = getLineNumber(N, arr, mid);
		if(value >= M) {
			res = max(res, (long)mid);
		}
		if(start+1 >= end) {
			return res;
		}
		if(value >= M) {
			return binarySearch(N, M, arr, res, mid, end);
		}else {
			return binarySearch(N, M, arr, res, start, mid);
		}
	}
	private long getLineNumber(int N, long[] arr, long mid) {
		long res = 0;
		for(int i = 0; i < N; i++) {
			res += (long)arr[i] / mid;
		}
		return res;
	}
	private long max(long a, long b) {
		if(a > b)	return a;
		return b;
	}
}
