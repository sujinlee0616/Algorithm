package programmers;

public class kakao_3 {
/*
 * 경주로 설치
 직선 =100
 코너 =500
 
 경주로 건설의 최소 비용을 계산
 0 = 가능
 1 = 벽 (꺾어야 함) 
 
 죠르디는 꿀귀...
 
 
 */
	public static void main(String[] args) {
		
		int board[][]= {
				{0,0,0},{0,0,0},{0,0,0}
				//{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}
				//{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}
				//{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}
		};
		
		solution(board);
	}
	
	public static int solution(int board[][]) {
		int result=0;
		//최단경로를 구한다  , bfs  (tipp)
		//1) 무조건 직진 x++ ; = 100 (두번째 예시)
		//2) 벽을 만난다 (자연적인 벽이거나board.length; | ==1 ) 
		//3) y--;로 turn ++ =>  500
		//4) x--; turn = 500
		//5) y--; turn = 500 
		//6) x++; turn = 500
		//7) turn을 카운팅 * 500 
		//8) cnt로 얼마나 움직였나 카운팅 * 100 
		//9) 7 + 8 = result
		// 예시 3에서 문제가 발생 .. 
		
		int corner=1;
		int cnt=0;
		int x=0;
		int y=-1;
		//bfs N*M; //y깊이 
	
		while(true) { //N차 행렬 
			//x++ 
				for(x=0;x<board.length;x++) {
					y=y+corner;
					//1이랑 같으면 corner 추가 
					if(board[x][y]==1) 
						corner++;	// +500 
						cnt=x;  // +100 
				} 
				System.out.println(cnt); //3 
				System.out.println(corner);  
			//y-- 
			
			// 종료조건?? 
				result=cnt*100+corner*500;
				System.out.println(result);
				return result;
				
			}
		
			
		}
		
	}
	

/*
 import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConstructRoadOfRace {
	public static void main(String[] args) {
		ConstructRoadOfRace c = new ConstructRoadOfRace();
		Scanner scn = new Scanner(System.in);

		int[][] arr = { { 0, 0, 1 }, { 0, 0, 0 }, { 1, 0, 0 } };
		c.solution(arr);
	}

	public int solution(int[][] board) {
		int answer = 0;

		// 1. 벽을 -1로 치환하기
		int len = board.length;
		int[][] isSelected = new int[len][len];

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (board[i][j] == 1) {
					board[i][j] = -1;
				}
			}
		}
		Queue<Node> que = new LinkedList<Node>();
		que.offer(new Node(0, 0, 1));
		board[0][0] = 1;
		isSelected[0][0] = 1;
		bfs(board, isSelected, que);
		int[] res = new int[3]; // 0 = res, 1 = ans 2 = tmpRes
		res[0] = 1000;
		res[1] = 1000;
		res[2] = 0;
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		for (int i = 0; i < 4; i++) {
			dfs(board, res, 0, 0, i);
			res[2] = 0;
			//System.out.println("res : " + res[0]);
			res[1] = min(res[1], res[0]);
		}
		answer = res[1] * 500 + (board[len - 1][len - 1]-1)*100;
		return answer;
	}

	private void dfs(int[][] board, int[] res, int x, int y, int rot) {
		int len = board.length;
		if (x == len - 1 && y == len - 1) {
			 System.out.println("res2 : " + res[2]);
			res[0] = min(res[0], res[2]);
			 System.out.println("res : " + res[0]);
			return;
		}
아하!! 
ㅋㅋㅋㅋㅋㅋㅋㅋㅋ
이거 개꿀팁임!!! ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ 알고싶나!? 네!!!!!!!!
5ㅋㅋㅋㅋㅋㅋㅋ 그 4방향 탐색할때 
가장 직관적이고 빠른 방법입니다!         현재 위치를 x,y라고 했을때, 상 하 좌 우를 표현하려면 
							Dx, dy 를 이용해서 +-1 or 0을 해줘서 네방향을 다 표현하는거죠 
				이렇게 표현하면 for문 하나로 4방향을 전부 검사할 수 있어요!
이해했어용 		   우, 하, 좌, 상       
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };		for (int i = 0; i < 4; i++) {
			
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= len || ny < 0 || ny >= len)
				continue;
			if (board[nx][ny] <= board[x][y])
				continue;
			if (rot != i) {
				res[2] += 1;
				dfs(board, res, nx, ny, i);
				res[2] -= 1;
			} else {
				dfs(board, res, nx, ny, i);
			}
		}
	}

	private void bfs(int[][] board, int[][] isSelected, Queue<Node> que) {
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		int len = board.length;

		while (que.size() != 0) {
			Node node = que.poll();
			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if (nx < 0 || nx >= len || ny < 0 || ny >= len)
					continue;
				if (board[nx][ny] > node.v + 1) 
					continue;
				if (board[nx][ny] == -1)
					continue;
				isSelected[nx][ny] = 1;
				board[nx][ny] = node.v + 1;
				que.offer(new Node(nx, ny, node.v + 1));
			}
		}
	}

	private void print(int[][] board) {
		int len = board.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private int max(int a, int b) {
		if (a > b)
			return a;
		return b;
	}

	private int min(int a, int b) {
		if (a < b)
			return a;
		return b;
	}
}

class Node {
	public int x, y, v;

	public Node(int x, int y, int v) {
		super();
		this.x = x;
		this.y = y;
		this.v = v;
	}

}

 */

