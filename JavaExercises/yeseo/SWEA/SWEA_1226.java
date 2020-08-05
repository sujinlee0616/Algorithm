package SWEA;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1226 {
	/*
	 * 미로1 0,0 최소 1,1 = 출발
	 * [Queue]
	 * 
	 * 0(이동) 1(이동X) 2(s) 3(e)
	 * 
	 * 16,16 최대
	 * 
	 * 배열이 주어지면 [16][16] 2 -> 3 도착할 수 있는지 true =1 false =0
	 */
	static int maze[][];
	static int X, Y;

	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);

		for (int T = 1; T <= 10; T++) {
			int C = scan.nextInt();
			maze= new int[16][16];
			for (int i = 0; i < 16; i++) {
				String str = scan.next();

				for (int j = 0; j < 16; j++) {
					maze[i][j] = str.charAt(j) - '0'; // 0을 왜빼냐 = ASCII -> Integer
					//System.out.print(maze[i][j]);
					if(maze[i][j]==2) {
						//START 
						X=i;
						Y=j;
					}
				}
			}
			System.out.print("#"+T+" ");
			solve();
		}
	}
	
	static int [][]direction= {
			{1,0},{0,1},{-1,0},{0,-1}
			//우 상 좌 하  
		};
	private static void solve() {
		Queue<Integer> q=new LinkedList<>();
		q.add(X);
		q.add(Y);
		while(!q.isEmpty()) {
			//값빼기
			int tempX=q.poll();
			int tempY=q.poll();
			for(int i=0;i<4;i++) {
				int qX=tempX+direction[i][0];//00 10 20 
				int qY=tempY+direction[i][1];//01 11 21 
				if(maze[qX][qY]!=1) {
					if(maze[qX][qY]==3) {
						//END 
						System.out.print("1"); //true 
						return;
					}
					maze[qX][qY]=1; //if possible
					q.add(qX);
					q.add(qY);
				}
			}
		}
		System.out.print("0"); //false
	}
}
