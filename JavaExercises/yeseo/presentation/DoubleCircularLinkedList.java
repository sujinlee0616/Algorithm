package presentation;

import java.util.Comparator;
import java.util.Scanner;

public class DoubleCircularLinkedList<E>{
	class Node<E>{
		private E data;
		private Node<E> prev;
		private Node<E> next;
		
		Node(){
			data=null;
			prev=next=this;
		}
		
		Node(E obj, Node<E> prev, Node<E> next){
			data=obj;
			this.prev=prev;
			this.next=next;
		}
	}
	private Node<E> head;
	private Node<E> crnt;
	
	public DoubleCircularLinkedList() {
		head=crnt=new Node<E>();
	}
	
	public boolean isEmpty() {
		return head.next==head;
	}
	
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr=head.next;
		
		while(ptr!=head) {
			if(c.compare(obj,ptr.data)==0) {
				crnt=ptr;
				return ptr.data;
			}
			ptr= ptr.next;
		}
		return null;
	}
	
	public void printCurrentNode() {
		if(isEmpty())
			System.out.println("노드 없음 ");
		else 
			System.out.println(crnt.data);
	}
	
	
	public void dump() {
		Node<E> ptr=head.next;
		
		while(ptr!=head) {
			System.out.println(ptr.data);
			ptr=ptr.next;
		}
	}
	
	public boolean next() {
		if(isEmpty() ||crnt.next==head)
			return false;
		crnt=crnt.next;
		return true;
	}
	
	public boolean prev() {
		if(isEmpty() || crnt.prev==head)
			return false;
		crnt=crnt.prev;
		return true;
	}
	
	public void add(E obj) {
		Node<E> node=new Node<E>(obj,crnt,crnt.next);
		crnt.next=crnt.next.prev=node;
		crnt=node;
	}
	
	public void addFirst(E obj) {
		crnt=head;
		add(obj);
	}
	
	public void addLast(E obj) {
		crnt=head.prev;
		add(obj);
	}
	
	public void removeFirst() {
		crnt=head.next;
		if(!isEmpty()) {
			crnt.prev.next=crnt.next;
			crnt.next.prev=crnt.prev;
			crnt=crnt.prev;
			if(crnt==head) crnt=head.next;
		}
	}
	
	public void removeLast() {
		crnt=head.prev;
		if(!isEmpty()) {
			crnt.prev.next=crnt.next;
			crnt.next.prev=crnt.prev;
			crnt=crnt.prev;
			if(crnt==head) crnt=head.next;
		}
	}
	
	public void clear() {
		while(!isEmpty())
			removeFirst();
	}
}
class Tester {

//Double Circular Linkedlist

	static Scanner scn=new Scanner(System.in);
	
	//Data
	 static class Data {
		 static final int NO =1;
		 static final int NAME=2;
		 //instance
		 private Integer no;
		 private String name;	
	 
	 
	 //return String
	 public String toString() {
		 return "("+no+")"+name;
	 }
	 
	 //input data
	 void scanData(String guide, int sw) {
		 System.out.println("PLEASE INSERT DATA");
		 //1
		 if((sw & NO) == NO) {
			 System.out.println("번호=");
			 no=scn.nextInt();
		 }
		 //2
		 if ((sw&NAME) == NAME) {
			 System.out.println("이름=");
			 name=scn.next();
		 }
	 }
	 
	 //Comparator _ NO
	 public static final Comparator<Data> INORDER1= new NoOrderComparator();
	 
	 private static class NoOrderComparator implements Comparator<Data>{
		@Override
		public int compare(Data o1, Data o2) {
			return (o1.no >o2.no)?1:(o1.no<o2.no)?-1:0;
		} 
	 }
	 
	 //Comparator _ NAME 
	 public static final Comparator<Data> INORDER2= new NameOrderComparator();
	 
	 private static class NameOrderComparator implements Comparator<Data>{
		@Override
		public int compare(Data o1, Data o2) {
			return o1.name.compareTo(o2.name); //Comparable 
		} 
	 }
  }
	 
	//Menu  열거 타입 ENUM 
	enum Menu{
		 ADD_FIRST("INSERT DATA INTO HEAD"),
		 ADD_LAST("INSERT DATA INTO TAIL"),
		 ADD(	  "INSERT DATA INTO NEXT POINTER"),
		 RMV_FIRST("REMOVE THE HEAD NODE"),
		 RMV_LAST("REMOVE THE LAST NODE"),
		 RMV_CRNT("REMOVE THE CURRENT NODE"),
		 CLEAR(	  "REMOVE ALL NODES"),
		 SEARCH_NO("SEARCH DATA AS NUMBER"),
		 SEARCH_NAME("SEARCH DATA AS NAME"),
		 NEXT(	  "MOVE CURRENT NODE BEHIND"),
		 PREV(	  "MOVE CURRENT NODE FRONT"),
		 PRINT_CRNT("PRINT CURRENT NODE"),
		 DUMP(	  "PRINT ALL NODES"),
		 TERMINATE("END");
		 
		 private final String msg;//MESSAGE
		 
		 static Menu MenuAt(int index) { // return index
			 for(Menu m:Menu.values())
				 if(m.ordinal()==index)
					 return m;
			 return null;
		 }
		 
		 Menu(String string) //Constructor
		 {
			 msg=string;
		 }
		 
		 String getMessage() {
			 return msg;
		 }
	 }
	
	//Selection --> ordinal ENUM에 열거된 순서대로 출력 
	static Menu Select() {
		int key;
		do {
			for(Menu m:Menu.values()) {
				System.out.printf("(%d) %s", m.ordinal(),m.getMessage());
				if((m.ordinal()%3) == 2 &&	m.ordinal() !=Menu.TERMINATE.ordinal())
				System.out.println();
			}
			System.out.println(":");
			key=scn.nextInt();
		}while(key<Menu.ADD_FIRST.ordinal() || key>Menu.TERMINATE.ordinal());
		//이 사이에 없으면 다시 KEY 호출 
		return Menu.MenuAt(key);
	}
	
	public static void main(String[] args) {
		Menu menu;
		Data data; //ADD
		Data ptr;  //SEARCH
		Data temp=new Data(); //INSERT
		
		DoubleCircularLinkedList<Data> list=new DoubleCircularLinkedList<Data>();
		
		do {
			switch(menu=Select()){
				case ADD_FIRST :
					data=new Data();
					data.scanData("머리 삽입", Data.NO | Data.NAME);
					list.addFirst(data);
					break;
				case ADD_LAST :
					data=new Data();
					data.scanData("꼬리에 삽입",Data.NO | Data.NAME);
					list.addLast(data);
					break;
				case ADD:
					data=new Data();
					data.scanData("선택 노드의 뒤에 삽입",  Data.NO | Data.NAME);
					list.add(data);
					break;
				case RMV_FIRST:
					list.removeFirst();
					break;
				case RMV_LAST:
					list.removeLast();
					break;
				case SEARCH_NO:
					temp.scanData("검색", Data.NO);
					ptr=list.search(temp, Data.INORDER1);
					if(ptr==null)
						System.out.println("그 번호의 데이터가 없습니다");
					else 
						System.out.println("검색 성공 "+ptr);
					break;
				case SEARCH_NAME:
					temp.scanData("검", Data.NAME);
					ptr=list.search(temp,Data.INORDER2);
					if(ptr==null)
						System.out.println("그이름의 데이터가 없습니다");
					else
						System.out.println("검색 성공 "+ptr);
					break;
				case NEXT: 
					list.next();
					break;
				case PREV:
					list.prev();
					break;
				case PRINT_CRNT:
					list.printCurrentNode();
					break;
				case DUMP:
					list.dump();
					break;
				case CLEAR:
					list.clear();
					break;
			}		
		} while (menu!=Menu.TERMINATE);
	}
	
}