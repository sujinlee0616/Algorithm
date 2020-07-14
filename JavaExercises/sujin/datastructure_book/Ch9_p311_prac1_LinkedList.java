package datastructure_book;

import java.util.Comparator;

// [포인터로 연결 리스트 만들기]
// - 노드 형이 클래스 Node<E>형인 연결 리스트를 클래스 LinkedList<E>로 구현해보자. 
public class Ch9_p311_prac1_LinkedList<E> {
	
	// 노드 
	class Node<E>{
		private E data;
		private Node<E> next;
		// 생성자 
		Node(E data, Node<E> next){
			this.data=data;
			this.next=next;
		}
	}
	
	private Node<E> head; // 머리 노드
	private Node<E> crnt; // 선택 노드 

	// 생성자 
	public Ch9_p311_prac1_LinkedList(){
		head=crnt=null;
	}
	
	// 노드 검색 
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head;
		
		while(ptr != null) {
			if(c.compare(obj, ptr.data) == 0) { // 검색 성공 
				crnt = ptr; 
				return ptr.data;
			}
			ptr = ptr.next; // 다음 노드를 선택 
		}
		return null; // 검색 실패 
	}
	
	// 머리에 노드 삽입 
	public void addFirst(E obj) {
		Node<E> ptr=head; // 삽입 전의 머리 노드 
		head = crnt = new Node<E>(obj, ptr);
	}
	
	// 꼬리에 노드 삽입
	public void addLast(E obj) {
		if(head == null) // 리스트가 비어 있으면 
			addFirst(obj); // 머리에 삽입 
		else {
			Node<E> ptr = head;
			while(ptr.next != null)  // while문 종료 시, ptr은 꼬리 노드를 가리킨다. 
				ptr = ptr.next;
			ptr.next = crnt = new Node<E>(obj, null);
		}
	}
	
	// 머리 노드를 삭제 
	public void removeFirst() {
		if(head != null)
			head = crnt = head.next; 
	}
	
	// 꼬리노드를 삭제
	public void removeLast() {
		if(head != null) {
			if(head.next == null)
				removeFirst();
			else {
				Node<E> ptr = head; // 스캔 중인 노드 
				Node<E> pre = head; // 스캔 중인 노드의 앞쪽 노드 
				
				while(ptr.next != null) {
					pre = ptr;
					ptr = ptr.next;
				}
				pre.next = null; // pre는 삭제 후의 꼬리 노드 
				crnt = pre;
			}
		}
	}
	
	// 노드 p를 삭제 
	public void remove(Node p) {
		if(head != null) {
			if(p == head)
				removeFirst();
			else {
				Node<E> ptr = head;
				while(ptr.next != p) {
					ptr = ptr.next;
					if(ptr == null) return; // p가 리스트에 없다 
				}
				ptr.next = p.next; 
				crnt = ptr;
			}
		}
	}
	
	// 선택 노드를 삭제 
	public void removeCurrentNode() {
		remove(crnt);
	}
	
	// 모든 노드를 삭제 
	public void clear() {
		while(head != null) // 노드에 아무것도 없을 때까지 
			removeFirst(); // 머리노드를 삭제 
		crnt = null;
	}
	
	// 선택 노드를 하나 뒤쪽으로 이동
	public boolean next() {
		if(crnt == null || crnt.next == null)
			return false; // 이동할 수 없음 
		crnt = crnt.next;
		return true;
	}
	
	// 선택 노드를 출력
	public void printCurrentNode() {
		if(crnt == null)
			System.out.println("선택한 노드가 없습니다.");
		else
			System.out.println(crnt.data);
	}
	
	// 모든 노드를 출력
	public void dump() {
		Node<E> ptr = head;
		
		while(ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
	
}







