package datastructure_book;

public class Ch4_p148_prac3_IntQueue {
	
	private int max; // 큐의 용량 
	private int front; // 첫번째 요소 커서 
	private int rear; // 마지막 요소 커서 
	private int num; // 현재 데이터 수 
	private int[] que; // 큐 본체 
	
	// 실행 시 예외: 큐가 비어 있음 
	public class EmptyIntQueueException extends RuntimeException{
		public EmptyIntQueueException() {}
	}
	
	// 실행 시 예외: 큐가 가득 참 
	public class OverflowIntQueueException extends RuntimeException{
		public OverflowIntQueueException() {}
	}
	
	// 생성자 
	public Ch4_p148_prac3_IntQueue(int capacity) {
		num=front=rear=0;
		max=capacity;
		try {
			que=new int[max]; // 큐 본체용 배열을 생
		} catch (OutOfMemoryError e) {
			max=0;
		}
	}
	
	// 1. 인큐 
	public int enque(int x) throws OverflowIntQueueException{
		if(num>=max)
			throw new OverflowIntQueueException(); // 큐가 가득 참 
		que[rear++]=x;
		num++;
		if(rear==max)
			rear=0;
		return x;
	}
	
	// 2. 디큐
	public int deque() throws EmptyIntQueueException{
		if(num<=0)
			throw new EmptyIntQueueException(); // 큐가 비어있음
		int x=que[front++];
		num--;
		if(front==max)
			front=0;
		return x;
	}
	
	// 3. peek: 맨 앞의 데이터(디큐에서 꺼낼 데이터)를 몰래 엿봄. 
	public int peek() throws EmptyIntQueueException{
		if(num<=0)
			throw new EmptyIntQueueException();
		return que[front];
	}
	
	// 4. indexOf: 값이 있으면 그 값의 인덱스를 반환, 없으면 -1 반환 
	public int indexOf(int x) {
		for(int i=0;i<num;i++) {
			int idx=(i+front)%max;
			if(que[idx]==x) // 검색 성공 
				return idx;
		}
		return -1; // 검색 실패 
	}
	
	// 5. clear: 큐를 비움 
	public void claer() {
		num=front=rear=0;
	}
	
	// 6. capacity: 큐의 용량을 반환 
	public int capacity() {
		return max;
	}
	
	// 7. size: 큐에 쌓여있는 데이터의 수를 반환
	public int size() {
		return num;
	}
	
	// 8. isEmpty: 큐가 비어있는지 체크
	public boolean isEmpty() {
		return num<=0;
	}
	
	// 9. isFull: 큐가 가득 찼는지 체크 
	public boolean isFull() {
		return num>=max;
	}
	
	// 10. dump: 큐 안의 모든 데이터를 프론트에서 리어 순으로 출력
	public void dump() {
		if(num<=0)
			System.out.println("큐가 비어 있습니다.");
		else {
			for(int i=0;i<num;i++)
				System.out.println(que[(i+front)%max]+" ");
			System.out.println();
		}
	}
	

}








