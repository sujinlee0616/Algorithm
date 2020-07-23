package presentation;

import presentation.ChainHash.Node;
/*

배열 : 내부 인덱스 이용해 빠른 검색 속도를 가짐  / 삽입, 삭제시 데이터 이동이 불가피  
리스트 : LinkedList데이터 삽입, 삭제 인근 노드의 참조값을 수정하면 됨 (빠른 처리 가능!) / 처음,마지막 노드를 제외하고 검색,삭제,추가시에 데이터 순회가 불가피 (효율성 떨어짐)

=> 해시  : 내부 배열을 이용해 빠른 검색 속도 가짐 
- 저장되는 데이터가 가진 인덱스는 고유하기 때문에 데이터 이동할 필요가 없음 



*/
public class OpenHash<K,V> {
	//오픈 주소법 , rehashing 재해시라고 하기도 함 
	enum Status {OCCUPIED,EMPTY,DELETED};
	
	static class Bucket<K,V> {
		private K key;
		private V data;
		private Status stat;
	
		Bucket(){
			stat=Status.EMPTY;
		}
		
		void set(K key,V data,Status stat) {
			this.key=key;
			this.data=data;
			this.stat=stat;
		}
		
		void setStat(Status stat) {
			this.stat=stat;
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
	private Bucket<K,V> [] table;  //버킷용 클래스 
	
	public  OpenHash(int size) {
		try {
			table=new Bucket[size];
			for(int i=0;i<size;i++)
				table[i]=new Bucket<>();
			this.size=size;
		} catch (OutOfMemoryError e) {
			this.size=0; //메모리 초과시 size 0으로 만듦 
		}
	}
	
	public int hashValue(Object Key) {
		return Key.hashCode() %size;
	}
	
	//rehash 재해시 값 구하기 
	public int rehashValue(int hash) {
		return (hash+1) %size;
	}
	
	//key값을 갖는 버킷 탐
	public Bucket<K,V> searchNode(K key) {
		int hash=hashValue(key);
		Bucket<K, V>p=table[hash];
	
		for(int i=0;p.stat!=Status.EMPTY&& i<size;i++) {
			if(p.stat==Status.OCCUPIED && p.getKey().equals(key))
				return p;
			hash=rehashValue(hash);
			p=table[hash];
		}
		return null;
	}
	
	public V search(K key) {
		Bucket<K, V> p=searchNode(key);
		if(p!=null)
			return p.getValue();
		else 
			return null;
	}
	
	public int add(K key,V data) {
		if(search(key)!=null)
			return 1;
		
		int hash=hashValue(key);
		Bucket<K, V>p=table[hash];
		for(int i=0;i<size;i++) {
			if(p.stat==Status.EMPTY || p.stat==Status.DELETED) {
				p.set(key, data, Status.OCCUPIED);
				return 0;
			}
			hash=rehashValue(hash);
			p=table[hash];
		}
		return 2; // 해시 테이블 가득 참 
	}
	
	public int remove(K key) {
		Bucket<K, V>p=searchNode(key);
		if(p==null)
			return 1;
		
		p.setStat(Status.DELETED);
		return 0;
	}
	
	public void dump() {
		for(int i=0;i<size;i++)
		{
			System.out.printf("%02d",i);
			switch(table[i].stat) {
			case OCCUPIED:
				System.out.printf("%s(%s)\n", table[i].getKey(),table[i].getValue());
				break;
			case EMPTY:
				System.out.println("++++NONE++++");
				break;
			case DELETED:
				System.out.println("---DELETE COMPLETE--");
				break;
			}
		}
	}
}


