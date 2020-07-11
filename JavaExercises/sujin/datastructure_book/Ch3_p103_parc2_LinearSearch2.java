package datastructure_book;

// [선형검색2] - for문 이용 ==> 더 짧고 간결. 
public class Ch3_p103_parc2_LinearSearch2 {
	
	// 크기가 n인 배열a에서 key와 값이 같은 요소를 선형검색 
	static int linSearch(int[] a, int n, int key) {
		for(int i=0;i<n;i++)
			if(a[i]==key)
				return i; // 검색 성공 (인덱스를 반환) 
		return -1; // 검색 실패 (-1을 반환)
	}
		
	public static void main(String[] args) {
		int n=10;
		int[] a= {0,1,2,3,4,5,6,7,8,9};
		int key=7;
		System.out.println(linSearch(a,n,key));
	}

}
