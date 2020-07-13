package hyuk.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class q5397_KeyLocker {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			KeyLocker kl = new KeyLocker();
			StringBuffer input = new StringBuffer(br.readLine()); 
			for(int j = 0; j < input.length(); j++) {
				if(input.charAt(j) == '<') {
					kl.left();
				}else if(input.charAt(j) == '>') {
					kl.right();
				}else if(input.charAt(j) == '-') {
					kl.backSpace();
				}else {
					kl.inputString(input.charAt(j));
				}
				//System.out.print("^^;; : ");
				//kl.dl.print();
			}
			Node a = kl.dl.head;
			while(a != null) {
				bw.write(a.data);
				a = a.after;
			}
			bw.newLine();
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}


class KeyLocker {
	public DoublyLinkedList dl = new DoublyLinkedList();
	
	
	public void left() {
		if(dl.tail != null) {
			if(dl.target == null) {
				dl.target = dl.tail;
			} else {
				if(dl.target.before != null) {
					dl.target = dl.target.before;
				}
			}
		}
	}
	
	public void right() {
		if(dl.tail == null) {
			return;
		}
		if(dl.target == null) {
			return;
		}
		dl.target = dl.target.after;
	}
	
	public void backSpace() {
		dl.remove();
	}
	
	public void inputString(Character a) {
		dl.add(new Node(a));
	}
}

class Node {
	public Node before, after;
	public char data;
	public Node(char data) {
		before = null; after = null;
		this.data = data;
	}
}
class DoublyLinkedList {
	public Node head, target, tail;
	
	public DoublyLinkedList() {
		head = null; target = null; tail = null;
	}
	
	public void print(){
		Node a = head;
		while(a != null) {
			System.out.print(a.data + " ");
			a = a.after;
		}
		char aa = '!';
		if(tail != null) {
			aa = tail.data;
		}
		System.out.print(", tail : " + aa);
		aa = '!';
		if(head != null) {
			aa = head.data;
		}
		System.out.println(", head : " + aa);
	}
	
	//targer에 추가
	public void add(Node a) {
		if(head == null && tail == null) {
			head = a; tail = a;
		} else if(target == null){
			//끝에 넣겠다
			a.before = tail; tail.after = a;
			tail = a;
		} else {
			a.after = target;
			a.before = target.before;
			if(target.before != null) {
				target.before.after = a;
			} else {
				head = a;
			}
			target.before = a;
		}
	}
	//target 삭제
	public void remove() {
		if(head == null && tail == null) {
			return;
		} else if(target == null) {
			if(tail == head) {
				head = null;
				tail = null;
			} else {
				Node tmp = tail;
				tail.before.after = null;
				tail = tail.before;
				tmp.after = null; tmp.before = null;
			}
		} else {
			if(target.before != null) {
				if(target.before.before != null) {
					target.before.before.after = target;
				} else {
					head = target;
				}
				Node tmp = target.before;
				target.before = target.before.before;
				tmp.before = null; tmp.after = null;
			}
		}
	}
}