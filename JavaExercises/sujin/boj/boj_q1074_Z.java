package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

// [배경지식]
// - 지수승 : Math.pow(a, b)
// [idea] 
// - 딱 봐도 재귀함수... 

public class boj_q1074_Z {
	
	static int n;
	static int r;
	static int c;
	static int m;
	static int cnt = 0;
	 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		m = (int) Math.pow(2, n); // m = 2^n 
		
		search(0,0,m);
	}
	
	static void search(int x, int y, int size) {
		
		if(size==1) {
            if(x==r && y==c)
                System.out.println(cnt);
            cnt++;
            return;
        }
 
        int s = size/2;
 
        // 현재의 사이즈를 4사분면으로 나눠서 재귀함수로 처리 ★★★
        search(x, y, s); // 좌측상단 (2사분면)
        search(x, y+s, s); // 우측상단 (1사분면)
        search(x+s, y, s); // 좌측하단  (3사분면)
        search(x+s, y+s, s); // 우측하단 (4사분면)
	}

}
