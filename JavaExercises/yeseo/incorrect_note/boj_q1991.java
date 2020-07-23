package incorrect_note;

import java.util.Scanner;

public class boj_q1991 {	

	/*
	 트리순회  
	 1) data, left , right 값 받기
	 2) 중위순회 : left, data, right
	 3) 전위순회 : data,left,right
	 4) 후위순회 : left, right ,data 

	 Node에 입력값있는게 어려웠음 ..
	 + 탐색 구현 못함. else if 표현 
	 & Map으로 훨씬 간결하게 구현하는 방법 익히기 
	 
	 + 호출 순서 public  / class ..
	 
	 
	 *오류를 못잡겠다 ...
	 */
	
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int N=scn.nextInt(); // Node 개
		//항상 A가 Root가 됨.
		String curr[]=new String [N];
		String left[]=new String [N];
		String right[]=new String [N];
		
		//Tree만들기 
		Tree t=new Tree();
		Node node[]=new Node[N];
		for(int i=0;i<N;i++) {
			curr[i]=scn.next();
			left[i]=scn.next();
			right[i]=scn.next();
			t.add(curr[i], left[i], right[i]);
		}
		//A부터차례대로 매겨짐 ..

		t.preOrder(t.root);
		System.out.println();
		t.inOrder(t.root);
		System.out.println();
		t.postOrder(t.root);
		
	}
}
	
	//Node 생성자 = 노드 하나에 담길 데이터들은 총3개
		class Node{
			String data;
			Node left;
			Node right;
			//노드 자체 생성 
			public Node(String data){
				this.data=data;
			}
		 }
		
		
		//Tree생성자 
		 class Tree{

			 Node root; // 여기선 항상 A 
		
			//1) 루트가비어있는 경우 _ 비어있지 않으면 어디에 넣어야 하는지 알아야 하니까 .
			//2) 루트가 있는경우 search 메소드 다시 써야 함 
			public void add(String data, String left, String right) {
				if(root==null) { //루트가 비어있다면 
					if(data!=".") root= new Node(data); 
					if(left!=".") root.left=new Node(left);
					if(right!=".") root.right=new Node(right);
				}else 
					search(root,data,left,right);// 탐색 호출 
			
			}
			
			
			//탐색 *********************
			private void search(Node root, String data, String left,String right) {
				if(root==null)return;		//root비어있다면 
				else if(root.data==data) {  //위에노드가 존재한다면 
					if(left!=".") root.left=new Node(left); //왼쪽 자식이 있으면 추가 
					if(right!=".") root.right=new Node(right);
				}else {
					//*****************재귀 탐색 
					search(root.left,data,left,right);//왼쪽 호출 
					search(root.right,data,left,right);//오른쪽  호출 
				}
			}
			
			//전위 
			public void preOrder(Node root) {
				if(root!=null) {
					System.out.print(root.data);	//Node생성자를 위에서 정의했으니까 Syso필요 X 
					if(root.left!=null)preOrder(root.left);
					if(root.right!=null)preOrder(root.right);
				}
			}
			
			//중위 
			public void inOrder(Node root) {
					if(root.left!=null)inOrder(root.left);
					System.out.print(root.data);
					if(root.right!=null)inOrder(root.right);

			}
			
			//후위 
			public void postOrder(Node node) {
				
					if(node.left!=null)postOrder(node.left);
					if(node.right!=null)postOrder(node.right);
					System.out.print(node.data);
				
			}
		}


