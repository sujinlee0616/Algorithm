package datastructure_book;

// 연습문제 Q2.임의의 객체형 데이터를 쌓을 수 있는 제네릭 스택 클래스 Gstack<E>를 작성하세요.

public class Ch4_p144_q2_Gstack<E> {
	private int max; // 스택 용량 
	private int ptr; // 스택 포인터 
	private E[] stk; // 스택 본체 
	
	// 실행 시 예외: 스택이 비어 있음
	public static class EmptyGstackException extends RuntimeException{
		public EmptyGstackException() {
		}
	}
	
	// 실행 시 예외: 스택이 가득 참
	public static class OverflowGstackException extends RuntimeException{
		public OverflowGstackException() {
		}
	}

	// 생성자 
	public Ch4_p144_q2_Gstack(int capacity) {
		ptr=0;
		max=capacity;
		try {
			stk=(E[]) new Object[max]; // 스택 본체용 배열을 생성 
		} catch (OutOfMemoryError e) { // 생성 불가 
			max=0;
		}
	}
	
	// 1.push: 스택에 x를 푸시 
	public E push(E x) throws OverflowGstackException{
		if(ptr>=max) // 스택이 가득 차면
			throw new OverflowGstackException();
		return stk[ptr++]=x;
	}
	
	// 2.pop: 스택에서 데이터를 팝 (꼭대기의 데이터를 꺼냄)
	public E pop() throws EmptyGstackException{
		if(ptr<=0) // 스택이 비어 있음 
			throw new EmptyGstackException();
		return stk[--ptr];
	}
	
	// 3.peek: 스택에서 데이터를 피크 (꼭대기의 데이터를 살펴 봄)
	public E peek() throws EmptyGstackException{
		if(ptr<=0) // 스택이 비어 있음
			throw new EmptyGstackException();
		return stk[ptr-1];
	}
	
	// 4.indexOf: 스택에서 x의 값을 검색하여 index를 반환. 못 찾으면 -1 반환.
	public int indexOf(E x) {
		for(int i=ptr-1; i>=0; i--) // 꼭대기쪽부터 선형 검색
			if(stk[i].equals(x))
				return i; // 검색 성공 시 
		return -1; // 검색 실패 시 
	}
	
	// 5.clear: 스택을 비움
	public void clear() {
		ptr=0;
	}
	
	// 6.capacity: 스택의 용량을 반환
	public int capacity() {
		return max;
	}
	
	// 7.size: 스택에 쌓여있는 데이터 수를 반환
	public int size() {
		return ptr;
	}
	
	// 8.isEmpty: 스택이 비어있는지 확인 
	public boolean isEmpty() {
		return ptr<=0;
	}
	
	// 9.isFull: 스택이 가득찼는지 확인
	public boolean isFull() {
		return ptr>=max;
	}
	
	// 10.dump: 스택 안의 데이터를 바닥에서 꼭대기의 차례로 출력
	public void dump() {
		if(ptr<=0)
			System.out.println("스택이 비었습니다. ");
		else {
			for(int i=0;i<ptr;i++)
				System.out.println(stk[i]+" ");
			System.out.println();
		}
	}
	

}













