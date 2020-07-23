package presentation;

public class Hash {
	/**메소드 구현 **
	hashTable 사이즈를 나눈 나머지값으로 고유 번호를 지정 
	hashCode % hashTable.size() = index
	즉 index에 hashCode라는 해시값을 저장하는 것 
	단, 나머지 연산의 결과가 같다면? 충돌 발생
	그래서 되도록 테이블 사이즈를 primeNumber 소수로 만드는 것
	
	hash 
	 */
 

	 private class Entry{
		 private int value;
		 public Entry next;
	 }
	 
	 private int size;
	 private Entry[] hTable;
	 
	 public Hash(int size) {
		 this.size=size;
		 this.hTable=new Entry[size];
	 }
	 //key->index구해주기 
	 public int hashMethod(int key) {
		 return key % size;
	 }
	 
	 public int getKey(int data) {
		 return data;
	 }
	 
	 public int add(int data) {
		 
		 //data의 hashCode를 Key와 저장할 index 얻기 
		 int key=getKey(data);
		 int hashValue=hashMethod(key);
		 //저장할 엔트리 생
		 Entry entry=new Entry();
		 entry.value=data;
		 
		 if(hTable[hashValue]==null) {
			 hTable[hashValue]=entry;
			 return 0;
		 }
		 
		 Entry pre=null;
		 Entry cur=hTable[hashValue];
		 
		 //해당 index연결리스트 값의 크기가 작은 값부터 큰 순서대로 !
		 while(true) {
			 if(cur==null) {
				 hTable[hashValue]=entry;
				 return 0;
			 }else if(cur.value<key) {
				 pre=cur;
				 cur=cur.next;
			 }else {
				 if(cur==hTable[hashValue]) {
					 
					 //삽입노드를 첫째로 노드로삽입, 나음 노드를 cur로 지정 
					 entry.next=cur;
					 hTable[hashValue]=entry;
					 return 0;
					}else {
						
						
						//삽입 노드 다음 노드로 커서를 지정
						//전 노드의 다음 노드를 삽입 노드로 지정 
						entry.next=cur;
						pre.next=entry;
						return 0;
					}
				 
			 }
		 }
	 }
	 
	 
	 //data 위치 얻기
	 public int get(int data) {
		 int key=getKey(data);
		 int hashValue=hashMethod(key);
		 Entry cur = hTable[hashValue];
	        
	        while(true){
	            
	            if(cur == null){    // index 가 비어있다면 -1 반환
	            
	                return -1;
	            
	            }else if(cur.value == key){    // 커서의 값과 키가 같으면 0 반환
	                
	                return hashValue;
	            
	            }else if(cur.value > key){    // 커서의 값이 키보다 크면 -1 반환
	                                                    // 리스트는 작은 값에서 큰 값으로 정렬되어있다.
	                return -1;
	            
	            }else{        // 커서의 값이 키보다 작으면 다음 노드로 커서 이동
	                
	                cur = cur.next;
	            }
	        
	        }
	    }
	    
	    // data가 있는 노드를 반환한다.
	    private Entry getEntry(int data){
	        
	        int key = getKey(data);
	        int hashValue = hashMethod(key);
	        
	        // HashTable의 index의  첫번째 노드와 두번째 노드
	        Entry pre = hTable[hashValue];
	        Entry cur = pre.next;
	        
	        while(true){
	            
	            if(cur == null){    // 커서 노드가 null 이면 null 반환
	                
	                return null;
	            
	            }else if(cur.value == key){    // 커서 노드의 값이 키와 같으면 전 노드를 반환
	                
	                return pre;
	                
	            }else if(cur.value > key){    // 커서의 값이 키보다 크면 null 반환
	                
	                return null;
	            
	            }else{            // 커서의 값이 키보다 작으면 커서를 다음으로 이동
	                
	                pre = cur;
	                cur = cur.next;
	            }
	        }
	    }
	    
	    // data 를 제거
	    public int remove(int data){
	        
	        Entry pre = null;
	        
	        // data가 있는 노드의 전노드를 가져오고 null이면 -1 반환
	        if((pre=getEntry(data))== null){
	            return -1;
	        }
	        
	        // 전 노드가 data의 다음노드를 가리키게 한다.
	        // data 노드를 건너뛰게 연결한다 (제거)
	        Entry cur = pre.next;
	        pre.next = cur.next;
	        return 0;
	    }
	    
	    public String toString(){
	        
	        StringBuffer result = new StringBuffer();
	        Entry cur = null;
	        
	        for(int i=0; i<size; i++){
	            
	            result.append("[" + i + "]\t");
	            cur = hTable[i];
	            
	            if(cur == null){
	                result.append("n ");
	                
	            }else{
	                
	                while(cur!=null){
	                    result.append(cur.value + "");
	                    cur = cur.next;
	                }
	            }
	            result.append("\n");
	        }
	        
	        return result.toString();
	    }
	}


