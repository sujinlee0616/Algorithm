package datastructure_book;

// [선형검색3] - 보초법 
// 보초(sentinel)법으로 종료조건 검사 비용을 절반으로 줄이기 
// 보초법: 검색 전, 검색하고자 하는 키값을 맨 끝에 저장 (원래 데이터 다음에 보초 추가) 
// - 보초법 사용 전: 종료조건1(키값 발견 못하고 배열의 끝을 지나감), 종료조건2(검색할 값과 같은 요소 발견) 두 개를 검사해야 
// - 보초법 사용 후: 종료조건1은 검삭할 필요 없음. 종료조건 2만 검사하면 됨. 
//   ==> 반복문에서 종료 판단 횟수를 2회에서 1회로 줄임. 

public class Ch3_p105_prac3_LinearSearch3_Sentinel {
	static int linSearch(int[] a, int n, int key) {
		int i=0;
		a[n]=key; // 보초를 추가 
		
		while(true) {
			if(a[i]==key) // 검색 성공
				break;
			i++;
		}
		return i==n? -1 : i; // 인덱스값이 n(보초)이면 -1(없다)를 반환, 아니면(검색 성공) 인덱스번호를 반환 
	}
	
	public static void main(String[] args) {
		int n=10;
		int[] a=new int[n+1]; // 주의! 크기가 n+1인 배열 생성해야!
		int key=7;
		System.out.println(linSearch(a,n,key));
	}
}
