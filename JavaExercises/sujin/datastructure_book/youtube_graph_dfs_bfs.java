package datastructure_book;


// [자료구조 알고리즘] Graph 검색 DFS, BFS 구현 in Java
//https://youtu.be/_hxFgg7TLZQ

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// 이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 
// 결과를 출력하는 프로그램을 작성하시오

class Graph{
	
	class Node{
		int data;
		LinkedList<Node> adjacent; // 인접한 노드 
		boolean marked; // 방문했는지 체크 
		Node (int data){
			this.data = data;
			this.marked = false; 
			adjacent = new LinkedList<Node>();
		}
	}
	
	// 그래프 만들자 
	Node[] nodes; 
	Graph(int size){
		nodes = new Node[size];
		for(int i=0;i<size;i++) {
			nodes[i] = new Node(i);
		}
	}
	
	void addEdge(int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		if(!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}
		if(!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
	}
	
	void dfs() {
		dfs(0);
	}
	
	void dfs(int index) {
		Node root = nodes[index];
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		root.marked = true;
		
		while(!stack.isEmpty()) {
			Node r = stack.pop();
			for(Node n : r.adjacent) {
				if(n.marked == false) {
					n.marked = true;
					stack.push(n);
				}
			}
			visit(r);
		}
	}
	
	void bfs() {
		bfs(0);
	}
	
	void bfs(int index) {
		Node root = nodes[index];
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);
		root.marked = true;
		while(!queue.isEmpty()) {
			Node r = queue.remove();
			for(Node n : r.adjacent) {
				if(n.marked == false) {
					n.marked = true;
					queue.remove(n);
				}
			}
			visit(r);
		}
		
	}
	
	void dfsR(Node r) {
		if(r == null) return;
		r.marked = true;
		visit(r);
		for(Node n : r.adjacent) {
			if(n.marked == false) {
				dfsR(n);
			}
		}
	}
	
	void dfsR(int index) {
		Node r = nodes[index];
		dfsR(r);
	}
	
	void visit(Node n) {
		System.out.print(n.data+" ");
	}
	
}


public class youtube_graph_dfs_bfs {

	public static void main(String[] args) {
		
		Graph g = new Graph(9);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(6, 7);
		g.addEdge(6, 8);
		//g.dfs();
		g.bfs(); // <== 다시 확인 
	}
}
