package presentation;

import java.util.Comparator;

public class Tree<K,V> {
	
	static class Node<K,V>{
		private K key;
		private V data;
		private Node<K,V> left;
		private Node<K,V> right;
	//생성자 
		Node(K key,V data,Node<K,V> left,Node<K,V> right){
			this.key=key;
			this.data=data;
			this.left=left;
			this.right=right;
		}
		
		K getKey() {
			return key;
		}
		
		V getValue() {
			return data;
		}
		void print() {
			System.out.println(data);
		}		
	}
	
	//루트 
	private Node<K,V> root;
	//비교자 
	private Comparator<? super K> comparator=null;
	
	//생성자  
	public Tree() {
		root=null;  // node가 비어있는 이진검색트리를 생성 
	}	
	public Tree(Comparator<? super K> c) {
		this();		// node가 비어있는 이진검색트리를 생성 
		comparator=c; // 비교인자  c를 전달받아서 설정 
	}
	
	//비교 메서드 
	private int comp(K key1, K key2) {   
		return (comparator==null)? ((Comparable<K>)key1).compareTo(key2):comparator.compare(key1,key2);
		//key1 > key2 : +  key<key2 : -  
	}
	
	//Key 검색
	public V search(K key) {
		Node<K,V> p=root;
		
		while(true) {
			if(p==null)	
				return null;      			//검색실패 
			int cond=comp(key,p.getKey());	// Key = node(같으면 0 return)
			if(cond==0)
				return p.getValue();		//검색 성공 
			else if(cond<0)					//작으면 왼쪽 
				p=p.left;
			else 							//크면 오른쪽 
				p=p.right;
		}
	}
	
	//Add  subtree node  - subtree의 루트값을 알아놔야 함 
	private void addNode(Node<K, V>node, K key, V data) {
		int cond=comp(key,node.getKey());
		if(cond==0)
			return;						//이미 트리에 node.getKey가 존재 한다 
		else if(cond<0) {				//왼쪽 	
			if(node.left==null)					//left ,right 
				node.left=new Node<K,V>(key, data,null,null);
			else
				addNode(node.left,key,data);
		}else {							//오른쪽 
			if(node.right==null)
				node.right=new Node<K,V>(key,data,null,null);
			else addNode(node.right,key,data);
		}
	}
	
	//Add Node 
	public void add(K key,V data) {
		if(root==null)
			root=new Node<K,V>(key,data,null,null); //루트만으로 구성된 트리를 생성 
		else 
			addNode(root,key,data); //삽입 성공 
	}
	
	// Key 노드 삭제 
	public boolean remove(K key) {
		Node<K, V>p=root;
		Node<K, V>parent=null;
		boolean isLeftChild=true;  //p 는 parent 의 왼쪽자식인가 
		
		while(true) {
			if(p==null)
				 return false;
			int cond=comp(key,p.getKey());
			if(cond==0)
				break;				//검색성공 , 종료 
			else {
				parent=p;
				if(cond<0){
					isLeftChild=true;
					p=p.left;
				}else {
					isLeftChild=false;
					p=p.right;
				}
			}
		}
		
		/*
		 * 삭제할 키를 검색
		 * 검색 성공 , p는 찾은 노드를 참조 & parent는 찾은 노드의 부모 참조 
		 */
		
		
		
		//그런데 , 
		if(p.left==null) {  // 왼쪽 자식이 없음 
			if(p==root)
				root=p.right;	//오른쪽 자식을 가리킴 
			else if(isLeftChild)  //true
				parent.left=p.right; //왼쪽 부모가 오른쪽 자식을 가리킴
			else					//false
				parent.right=p.right;//오른쪽 부모가 오른쪽 자식을 가리킴
			
	    //혹은 
		}else if(p.right==null) { //오른쪽 자식이 없음 
			if(p==root)
				root=p.left;
			else if(isLeftChild)
				parent.left=p.left;
			else
				parent.right=p.left; //오른쪽에 자식이 없으면 왼쪽 자식을 가리킴 
		/*
		 * 1) 자식 노드가 없는 경우 삭제  - 지우고 p 대입 
		 * 2) 자식 노드가 1인 경우 삭제  -  자식 노드를 대입 
		 *  삭제노드에 왼쪽 자식이 없으면 왼쪽 p ==null
		 *  오른쪽 자식이 없으면 오른쪽 p ==null 
		 */
			
			
			
		//서브트리 	
		}else {
			parent=p;
			Node<K, V>left=p.left; //서브트리에서  가장 큰 노드 
			isLeftChild=true;
			while(left.right !=null) { //가장 큰 left노드를 검색 
				parent=left;
				left=left.right;
				isLeftChild=false;
			}
			p.key=left.key;			// p로 키와 값을 옮김 
			p.data=left.data;
			if(isLeftChild)
				parent.left=left.left; //left 삭
			else 
				parent.right=left.left;
		}
		return true;
	}
	/*
	 * 3)자식 노드가 2개인 노드 삭제 
	 */
	
	//Print 
	private void printSubTree(Node node) {
		if(node!=null) {
			printSubTree(node.left);
			System.out.println(node.key+" "+node.data);
			printSubTree(node.right);
		}
	}
	// 키의 오름차순으로 출력
	public void print() {
		printSubTree(root);
	}
}
