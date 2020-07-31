package hyuk.kakao;

import java.util.LinkedList;
import java.util.Queue;

class Kakao_ConstructRoadOfRace {

	public static void main(String[] args) {
		Kakao_ConstructRoadOfRace k = new Kakao_ConstructRoadOfRace();
		int[][] arr = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
		k.solution(arr);
	}

	private static int res = 100000;

	public int solution(int[][] board) {
		int answer = 0;
		int len = board.length;

		Queue<HaveNode> que = new LinkedList<HaveNode>();
		for (int ii = 0; ii < 4; ii++) {
			Node[][] arr = new Node[len][len];
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					arr[i][j] = new Node(i, j);
					for (int k = 0; k < 4; k++) {
						arr[i][j].v[k] = -1 * board[i][j];
					}
				}
			}
			arr[0][0].v[ii] = 0;
			que.offer(new HaveNode(arr[0][0], ii));
			bfs(arr, que);
		}

		return answer;
	}

	private void bfs(Node[][] board, Queue<HaveNode> que) {
		int len = board.length;
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };

		while (que.size() != 0) {
			HaveNode haveNode = que.poll();
			int rot = haveNode.rot;
			Node node = haveNode.node;
			//System.out.println("node : (" + node.x + "," + node.y + ") : " + node.v[rot]+ ", rot : " + rot);
			for (int i = 0; i < 4; i++) {
				//System.out.println("next rot : " + i);
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if (nx < 0 || nx >= len || ny < 0 || ny >= len)
					continue;
				if (board[nx][ny].v[i] == -1)
					continue;
				int score = board[node.x][node.y].v[rot];
				if (i == rot) {
					score += 100;
				} else {
					score += 600;
				}
				if (board[nx][ny].v[i] != 0) {
					if (board[nx][ny].v[i] <= score) {
						continue;
					}
				}
				board[nx][ny].v[i] = score;
				int nextRot = i;
				que.offer(new HaveNode(board[nx][ny], nextRot));
				//print(board);
			}
		}
		for (int i = 0; i < 4; i++) {
			if (board[len - 1][len - 1].v[i] != 0) {
				res = min(res, board[len - 1][len - 1].v[i]);
			}
		}
		System.out.println("res : " + res);
	}

	private int min(int a, int b) {
		if (a > b)
			return b;
		return a;
	}
}

class HaveNode {
	public Node node;
	public int rot;
	public HaveNode(Node node, int rot) {
		this.node = node;
		this.rot = rot;
	}
}
class Node {
	public int x, y;
	public int[] v;

	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.v = new int[4];
	}

}
