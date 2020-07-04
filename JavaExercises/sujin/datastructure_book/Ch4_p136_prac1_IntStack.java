package datastructure_book;

public class Ch4_p136_prac1_IntStack {
	
	private int max; // 스택 용량 
	private int ptr; // 스택 포인터 
	private int[] stk; // 스택 본체
	
	// 실행 시 예외: 스택이 비어 있음 
	public class EmptyInStackException extends RuntimeException{
		public void EmptyInstackException() {}
	}
	// 실행 시 예외: 스택이 가득 참 
	public class OverflowInstackException extends RuntimeException{
		public void OverflowInStackException() {}
	}
	// 생성자 
	public Ch4_p136_prac1_IntStack(int capacity) {
		ptr=0;
		max=capacity;
		try {
			stk=new int[max]; // 스택 본체용 배열을 생성 
		} catch (OutOfMemoryError e) { // 생성할 수 없음 
			max=0;
		}
	}
	
	// 1.push: 스택에 x를 푸시 
	public int push(int x) throws OverflowInstackException{
		if(ptr>=max) // 스택이 가득 차있다면 
			throw new OverflowInstackException();
		return stk[ptr++]=x;
	}
	// 2.pop: 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄)  
	public int pop() throws EmptyInStackException{
		if(ptr<=0) // 스택이 비어 있다면 
			throw new EmptyInStackException();
		return stk[--ptr];
	}
	// 3.peak: 스택의 꼭대기에 있는 데이터를 몰래 엿본다.
	public int peek() throws EmptyInStackException{
		if(ptr<=0) // 스택이 비어 있다면 
			throw new EmptyInStackException();
		return stk[ptr -1];
	}
	// 4.index of: 검색에 성공하면 찾아낸 요소의 인덱스를 반환하고, 실패하면 -1을 반환. 
	public int indexOf(int x) {
		for(int i=ptr-1; i>=0; i--) {
			if(stk[i]==x)
				return i; // 검색 성공 시 
		}
		return -1; // 검색 실패 시 
	}
	// 5. clear: 스택을 비움 
	public void clear() {
		ptr=0;
	}
	// 6. capacity: 스택의 용량을 반환
	public int capacity() {
		return max;
	}
	// 7. size: 스택에 쌓여 있는 데이터 수를 반환
	public int size() {
		return ptr;
	}
	// 8. isEmpty: 스택이 비어 있는지 확인  
	public boolean isEmpty() {
		return ptr<=0;
	}
	// 9. isFull: 스택이 가득 차있는지 확인 
	public boolean isFull() {
		return ptr>=max;
	}
	// 10. dump: 스택 안의 모든 데이터를 출력. (바닥에서 꼭대기 순) 
	public void dump() {
		if(ptr<=0) // 스택이 비어 있음
			System.out.println("스택이 비어있습니다.");
		else {
			for(int i=0; i<ptr; i++) 
				System.out.println(stk[i]+" ");
			System.out.println();
		}
	}
	
}





