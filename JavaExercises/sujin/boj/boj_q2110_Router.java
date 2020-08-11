package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// [이진탐색 문제]
public class boj_q2110_Router {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s1 = br.readLine();
		StringTokenizer st = new StringTokenizer(s1);
		int n = Integer.parseInt(st.nextToken()); 
		int c = Integer.parseInt(st.nextToken());
	
		int[] arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		br.close();
		
		Arrays.sort(arr);
		

		// [이진탐색]
		int left = 1; // 가능한 최소 거리
	    int right = arr[n - 1] - arr[0]; // 가능한 최대 거리
	    int d = 0;
	    int ans = 0;

	    while (left <= right) {
	        int mid = (left + right) / 2; // 기준
	        int start = arr[0];
	        int cnt = 1;
	 
	        // 간격(d) 를 기준으로 공유기 설치
	        for (int i = 1; i < n; i++) {
	            d = arr[i] - start;
	            if (mid <= d) {
	                ++cnt;
	                start = arr[i];
	            }
	        }
	 
	        if (cnt >= c) {
	            ans = mid;
	            left = mid + 1;
	        } else {
	            right = mid - 1;
	        }
	    }
	    System.out.println(ans);

	}
}
