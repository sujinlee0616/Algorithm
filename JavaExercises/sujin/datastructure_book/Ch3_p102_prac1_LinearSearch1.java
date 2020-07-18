package datastructure_book;

// [선형검색1] - while문 이용 
public class Ch3_p102_prac1_LinearSearch1 {

	// 크기가 n인 배열a에서 key와 값이 같은 요소를 선형검색 
	static int linSearch(int[] a, int n, int key) {
		int i=0;
		while(true) {
			if(i==n)
				return -1; // 검색 실패 (-1을 반환) 
			if(a[i]==key)
				return i; // 검색 성공 (인덱스를 반환) 
			i++;
		}
	}
	
	public static void main(String[] args) {
		
		int n=10;
		int[] a= {0,1,2,3,4,5,6,7,8,9};
		int key=7;
		System.out.println(linSearch(a,n,key));
	}
	
}






