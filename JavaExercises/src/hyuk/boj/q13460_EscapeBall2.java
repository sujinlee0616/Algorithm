package hyuk.boj;

import java.util.Scanner;

public class q13460_EscapeBall2 {
	
	private static int[] red,blue;
	private static char[][] arr;
	private static int N,M;
	private static int ans;
	private static int[] dx = {0,1,0,-1};
	private static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) {
		new q13460_EscapeBall2().service();
	}
	
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		N = scn.nextInt();
		M = scn.nextInt();
		String input = "";
		arr = new char[N][M];
		red = new int[2];
		blue = new int[2];
		
		for(int i = 0; i < N; i++) {
			input = scn.next();
			for(int j = 0; j < M; j++) {
				arr[i][j] = input.charAt(j);
				if(arr[i][j] == 'R') {
					red[0] = i; red[1] = j;
				}else if(arr[i][j] == 'B') {
					blue[0] = i; blue[1] = j;
				}
			}
		}
		ans = 100;
		dfs(0);
		if(ans == 100) {
			ans = -1;
		}
		System.out.println(ans);
		scn.close();
	}
	private void dfs(int cnt) {
		if(cnt >= 10) return;
		boolean suc = false;
		int brx, bry, bbx, bby;
		brx = red[0]; bry = red[1];
		bbx = blue[0]; bby = blue[1];
		for(int i = 0; i < 4; i++) {
			suc = moveToEnd(i, cnt+1);
			if(suc != true) {
				dfs(cnt+1);
			}
			red[0] = brx; red[1] = bry;
			blue[0] = bbx; blue[1] = bby;
		}
	}
	private int min(int a, int b) {
		if(a > b)	return b;
		return a;
	}
	private boolean moveToEnd(int rot, int cnt) {
		boolean redMoving = true; 
		boolean blueMoving = true;
		boolean redEnd = false;
		boolean blueEnd = false;
		int nrx,nry,nbx,nby;
		while(true) {
			
			nrx = red[0] + dx[rot]; nry = red[1] + dy[rot];
			nbx = blue[0] + dx[rot]; nby = blue[1] + dy[rot];
			if(arr[nrx][nry] == 'O') {
				redEnd = true;
				redMoving = false;
			}
			if(arr[nbx][nby] == 'O') {
				blueEnd = true;
				blueMoving = false;
			}
			if(arr[nrx][nry] == '#') {
				nrx = red[0]; nry = red[1];
				redMoving = false;
			}
			if(arr[nbx][nby] == '#' || (nbx == nrx && nby == nry)) {
				if(arr[nbx][nby] != '#' && redEnd == true) {
				}else {
					nbx = blue[0]; nby = blue[1];
					if(nbx == nrx && nby == nry) {
						redMoving = false;
					}
					blueMoving = false;
				}
			}
			if(redMoving == false && blueMoving == false) {
				break;
			}
			if(redMoving == true) {
				red[0] = nrx; red[1] = nry;
			}
			if(blueMoving == true) {
				blue[0] = nbx; blue[1] = nby;
			}
			
		}
		if(redEnd == true && blueEnd == false) {
			ans = min(ans, cnt);
		}
		if(redEnd == true || blueEnd == true) {
			return true;
		}
		return false;
	}
}
