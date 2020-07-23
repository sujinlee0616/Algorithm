package incorrect_note;

import java.util.Scanner;


/*
 * 트리
 * 
 * 문제분석 )
 * = 리프(자식이 없는 마지막 노드) 의 개수를 구하라
 * 
 * Node별로 
 * 내가 부모 = 0
 * 부모가 없음 = -1
 * 부모 있음 = 1 
 * 
 * 결과) 남은 리프의 개수를 구해라 
 * 
 *  	 1
 * 	   2   3
 *   4   5  
 * 
 * 
 * In : 4 2 5 1 3
 * Pre : 1 2 4 5 3
 * Post : 4 5 2 3 1 
 * 
*/

 /* class Node {
		int data;
		Node left;
		Node right;
	}

   class Tree{
		public Node root;

		public void setRoot(Node node) {
			this.root=node;
		}
		
		public Node getRoot() {
			return root;
		}
		
		public Node addNode(Node left,int data,Node right) {
			Node node=new Node();
			node.data=data;
			node.left=left;
			node.right=right;
			return node;
		}
		
		public boolean remove(int id) {
			Node parent=root;
			Node current=root;
			boolean isLeftChild=false;
			while(current.data!=id) {
				parent=current;
				if(current.data>id) {
					isLeftChild=true;
					current=current.left;
				}else {
					isLeftChild=false;
					current=current.right;
				}if(current==null) {
					return false;
				}
			}
			//1)No child
			if(current.left==null&&current.right==null) {
				if(current==root) {
					root=null;
				}
				if(isLeftChild==true) {
					parent.left=null;
				}else {
					parent.right=null;
				}
			}
			//2)1 Child
			else if(current.right==null) {
				if(current==root) {
					root=current.left;
				}else if(isLeftChild) {
					parent.left=current.left;
				}else {
					parent.right=current.left;
				}
			}else if(current.left==null) {
				if(current==root) {
					root=current.right;
				}else if(isLeftChild) {
					parent.left=current.right;
				}else {
					parent.right=current.right;
				}
			}
			//3) 2 Children
			else if(current.left!=null && current.right !=null) {
				Node successor=getSuccessor(current);
				if(current==root) {
					root=successor;
				}else if(isLeftChild) {
					parent.left=successor;
				}else {
					parent.right=successor;
				}
				successor.left=current.left;
			}
			return true;
		}
		
		public Node getSuccessor(Node remove) {
			Node successor=null;
			Node successorParent=null;
			Node current=remove.right;
			while(current!=null) {
				successorParent=successor;
				successor=current;
				current=current.left;
			}
			if(successor!=remove.right) {
				successorParent.left=successor.right;
				successor.right=remove.right;
			}
			return successor;
		}
		//Inorder 4 2 5 1 3 
		public void inOrder(Node node) {
			if(node!=null)
			{
				inOrder(node.left);
				System.out.println(node.data);
				inOrder(node.right);
			}
		}
		
		//Preorder 1 2 4 5 3 
		public void preOrder(Node node) {
			if(node!=null) {
				System.out.println(node.data);
				preOrder(node.left);
				preOrder(node.right);
			}
		}
		
		//Postorder 4 5 2 3 1 
		public void postOrder(Node node) {
			if(node!=null) {
				postOrder(node.left);
				postOrder(node.right);
				System.out.println(node.data);
			}
		}
	}
	
	
	
public class boj_q1068 {
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt(); // 전체 index개수 = node개수
		int parent[]=new int[N];// 0~ N-1 <=50 
		for(int i: parent)
		{
			parent[i]=scan.nextInt(); 
		}
		int remove=scan.nextInt();//제거하고 싶은 노드 

	
		Tree t=new Tree();
		*/

		/*
		 *  	 1           0
		 * 	   2   3       1   2   
		 *   4   5       3   4  
		Node n4=t.addNode(null, 4, null);
		Node n5=t.addNode(null, 5, null);
		Node n2=t.addNode(n4, 2, n5);
		Node n3=t.addNode(null, 3, null);
		Node n1=t.addNode(n2, 1, n3);
		
		t.inOrder(t.getRoot()); //그 Root를 호출한 중위순회 
		System.out.println("===========");
		t.postOrder(t.getRoot()); //후위순회
		System.out.println("===========");
		t.preOrder(t.getRoot()); //전위순회 
		
		*/
		
/*
		Node n3=t.addNode(null, 3, null);
		Node n4=t.addNode(null, 4, null);
		Node n2=t.addNode(null,2,null);
		Node n1=t.addNode(n3, 1, n4);
		Node n0=t.addNode(n1, 0, n2);
		
		t.setRoot(n0);//Root설정 
		t.remove(remove);//2삭제 
		//t.inOrder(t.getRoot()); //잘 삭제 되었나 확인 
		
		int count=0;
		if(n1.left==null&& n1.right==null)
			count++;
		if(n3.left==null&& n3.right==null)
			count++;
		if(n4.left==null&& n4.right==null)
			count++;
		
		System.out.println(count);

		
	
	}
	
}
*/