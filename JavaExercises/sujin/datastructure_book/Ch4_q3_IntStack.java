package datastructure_book;

// 연습문제 Q3. 
// 하나의 배열을 공유하여 2개의 스택을 구현하는 int형 데이터용 스택 클래스를 만드세요. 
// 스택에 저장하는 데이터는 int형 값으로 그림처럼 배열의 처음과 끝을 사용하세요. 

public class Ch4_q3_IntStack {
	private int max; // 스택의 용량 (A-B의 합계)
	private int ptrA; // 스택 포인터 A
	private int ptrB; // 스택 포인터 B
	private int[] stk; // 스택 본체 
	
	public enum AorB{
		StackA, StackB
	};
	
	// 실행할 때 예외：스택이 비어 있음
	public class EmptyIntStackX2Exception extends RuntimeException {
		public EmptyIntStackX2Exception() {
		}
	}

	// 실행할 때 예외：스택이 가득 참
	public class OverflowIntStackX2Exception extends RuntimeException {
		public OverflowIntStackX2Exception() {
		}
	}

	// 생성자
	public Ch4_q3_IntStack(int capacity) {
		ptrA = 0;
		ptrB = capacity - 1;
		max = capacity;
		try {
			stk = new int[max]; // 스택 본체용 배열을 생성
		} catch (OutOfMemoryError e) { // 생성할 수 없습니다.
			max = 0;
		}
	}
	
	// 1.push: 스택에 x를 푸시
	public int push(AorB sw,int x) throws OverflowIntStackX2Exception{
		if(ptrA>=ptrB+1) // 스택이 가득 참
			throw new OverflowIntStackX2Exception();
		switch (sw){
		case StackA:
			stk[ptrA++]=x;
			break;
		case StackB:
			stk[ptrB--]=x;
			break;
		}
		return x;
	}
	
	// 2.pop: 스택에서 데이터를 팝(꼭대기의 데이터를 꺼냄)
	public int pop(AorB sw) throws EmptyIntStackX2Exception{
		int x=0;
		switch (sw) {
		case StackA:
			if(ptrA<=0) // 스택 A가 비어 있음
				throw new EmptyIntStackX2Exception();
			x=stk[--ptrA];
			break;

		case StackB:
			if(ptrB>=max-1) // 스택 B가 비어 있음 
				throw new EmptyIntStackX2Exception();
			x=stk[++ptrB];
			break;
		}
		return x;
	}
	
	// 3.peek: 스택에서 데이터를 피크(꼭대기의 데이터를 살펴봄)
	public int peek(AorB sw) throws EmptyIntStackX2Exception{
		int x=0;
		switch (sw) {
		case StackA:
			if(ptrA<=0) // 스택 A가 비어 있으면
				throw new EmptyIntStackX2Exception();
			x=stk[ptrA-1];
			break;
		case StackB:
			if(ptrB>=max-1) // 스택 B가 비어있으면
				throw new EmptyIntStackX2Exception();
			x=stk[ptrB+1];
			break;
		}
		return x;
	}
	
	
	
}









