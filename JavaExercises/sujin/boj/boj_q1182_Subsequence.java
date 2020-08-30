package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj_q1182_Subsequence {
	
	static int N,S;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
 
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
 
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
 
        powerSet(arr, N, 0, 0);        
        // s가 0 일때는 부분집합 중에 공집합인 경우도 카운트 될 수 있음
        
        if(S == 0)
            count--;
        
        System.out.println(count);
		
	}
	
	
	static void powerSet(int[] arr, int n, int idx, int sum) {
        if(idx == n) {
            if(sum == S)
                count++;
            return;
        }
 
        powerSet(arr, n, idx + 1, sum);
        powerSet(arr, n, idx + 1, sum + arr[idx]);
    }

}
