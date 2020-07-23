package presentation;

import com.sun.javafx.css.StyleCacheEntry.Key;

public class ChainHash<K,V> {
/*
 * 해시법 ; 데이터 위치를 연산으로 구하는 것 ( 추가 삭제에 이용 ) 
 * 
 * =Collision
 * Key 값 Hash 값이 1:1로 대응되라는 법은 없음 (충돌 발생)
 * 
 *해결 )
 *
 *1) 체인법
 *	같은 해시값을 갖는 데이터를 쇠사슬 모양으로 연결 ( LinkedList ) 
 *
 *2) 오픈 주소법 
 *	빈 버킷을 찾을 때 까지 해시를 반복 ( index 빈 공간을 탐색)
 *
 */
	
		class Node<K,V>{
			private K key;
			private V data;
			private Node<K, V> next;
			
			Node(K key, V data,Node<K,V>next){
				this.key=key;
				this.data=data;
				this.next=next;
			}
			
			K getKey() {
				return key;
			}
			
			V getValue() {
				return data;
			}
			
			public int hashCode() {
				return key.hashCode();
			}
		}
	
	
	private int size;
	private Node<K,V> [] table;  //버킷용 클래스 
	
	public  ChainHash(int capacity) {
		try {
			table=new Node[capacity];
			this.size=capacity;
		} catch (OutOfMemoryError e) {
			this.size=0; //메모리 초과시 size 0으로 만듦 
		}
	}
	
	//key 별 hash값을 size(capacity)로 나눈 나머지를 반환 
	public int hashValue(Object Key) {
		return Key.hashCode() %size;
	}
	
	public V search(K key) {
		int hash=hashValue(key);
		Node<K, V> p=table[hash];
		
		while(p!=null) {
			if(p.getKey().equals(key))
				return p.getValue();
			p=p.next;  // 다음 노드 
		}
		return null;
	}
	
	public int add(K key, V data) {
		int hash=hashValue(key);
		Node<K,V> p=table[hash];
	
		while(p!=null) {
			if(p.getKey().equals(key))
				return 1;
			p=p.next;
		}
		Node<K, V> temp=new Node<K,V>(key,data,table[hash]);
		table[hash] =temp;
		return 0;
	}
	
	public int remove(K key) {
		int hash=hashValue(key);
		Node< K, V> p=table[hash]; //current node
		Node<K,V> pp=null; // previous node
		
		while(p!=null)
		{
			if(p.getKey().equals(key))
			{
				if(pp==null)			//바로 앞 선택 노드가 비어있다면 값을 넣어 
					table[hash]=p.next;
				else 
					pp.next=p.next;
			}
			pp=p;
			p=p.next; //다음 노드 
		}
		return 1;								// Key 값을 없앰  (remove)
	}
	
	public void dump() {
		for(int i=0;i<size;i++) {
			Node<K, V> p=table[i];
			System.out.printf("%02d",i);
			while(p!=null) {
				System.out.printf("-> %s (%s)",p.getKey(),p.getValue());
				p=p.next;
			}
			System.out.println();
		}
	}
}
