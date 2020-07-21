package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_q1991_tree {

	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static class Node {
		public Node l, r;  // l,r은 다른 노드. 즉, l,r 출력하면 l,r Node의 주소값이 나옴. 
		public char c;

		public Node(char c) {
			this.c = c;
		}
	}

	private static Node tree[];

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		tree = new Node[N];
		for (int i = 0; i < N; i++) {
			tree[i] = new Node((char) ('A' + i));
			// ex) tree[0].c = A, tree[0].l = null, tree[0].r = null
			// ex) tree[1].c = B, tree[1].l = null, tree[1].r = null
			// System.out.println("tree["+i+"].c="+tree[i].c);
		}
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 순서대로 root, left, right 니까 이걸 각각 root,l,r 변수에 저장해서 
			char root = st.nextToken().charAt(0);
			char l = st.nextToken().charAt(0);
			char r = st.nextToken().charAt(0);
			// tree에다가 넣는다. 
			if (l != '.')
				tree[root - 'A'].l = tree[l - 'A'];
				// ex) B D . ==> tree[1].c=B니까 tree[1].l에다가 char l값 집어넣는다. 
			if (r != '.')
				tree[root - 'A'].r = tree[r - 'A'];
				// ex) F . G ==> tree[5].c=F니까 tree[5].r에다가 char r값 집어넣는다. 
			// ===> 이렇게 하면 노드에 값 다 집어넣었음!! 노드에 값 집어넣기 완료!! 
			// tree[숫자].l, tree[숫자].r 에 값이 안 들어간건 자동으로 NULL로 들어가있으니까 괜춘 
		}
		preorder(0);
		bw.write("\n");
		inorder(0);
		bw.write("\n");
		postorder(0);
		bw.write("\n");
		bw.flush();
	}

	// preorder: Node --> left --> right 
	private static void preorder(int idx) throws IOException {
		bw.write(tree[idx].c);
		if (tree[idx].l != null) {
			// 왼쪽 노드를 preorder 한다. 
			preorder(tree[idx].l.c - 'A');
			// System.out.println("tree["+idx+"].l = "+tree[idx].l);  // tree[idx]의 left Node의 주소를 찾고 
			// System.out.println("tree["+idx+"].l.c = "+tree[idx].l.c); // left Node의 글자 c를 찾고 
			// System.out.println("tree["+idx+"].l.c - 'A' = "+(tree[idx].l.c-'A')); // 이 노드가 몇 번째 노드인지 확인 후 
			// System.out.println("preorder("+(tree[idx].l.c - 'A')+")"); // 이 노드에 대한 preorder를 실행시킨다. 
		}
			
		if (tree[idx].r != null) {
			// 오른쪽 노드를 preorder 한다. 
			preorder(tree[idx].r.c - 'A');
		}
			
	}

	// inorder: left --> Node --> right 
	private static void inorder(int idx) throws IOException {
		if (tree[idx].l != null)
			inorder(tree[idx].l.c - 'A');
		bw.write(tree[idx].c);
		if (tree[idx].r != null)
			inorder(tree[idx].r.c - 'A');
	}

	// postorder: left --> right --> Node 
	private static void postorder(int idx) throws IOException {
		if (tree[idx].l != null)
			postorder(tree[idx].l.c - 'A');
		if (tree[idx].r != null)
			postorder(tree[idx].r.c - 'A');
		bw.write(tree[idx].c);
	}
	
}
