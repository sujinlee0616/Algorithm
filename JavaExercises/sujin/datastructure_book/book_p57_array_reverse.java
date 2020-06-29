package datastructure_book;

import java.util.Scanner;

public class book_p57_array_reverse {


	// 배열을 역순으로 바꾼다. 
	// #1
//	public static int[] reverse(int n, int[] a) {
//		
//		for(int i=0; i<=n/2; i++) {
//			int temp=a[i];
//			a[i]=a[n-1-i];
//			a[n-1-i]=temp;
//		}
//		
//		for(int i=0; i<n; i++) {
//			System.out.println("a["+i+"]="+a[i]);
//		}
//		return a;
//	}
	
	// #2
	public static void reverse(int n, int[] a) {
		
		for(int i=0; i<=n/2; i++) {
			int temp=a[i];
			a[i]=a[n-1-i];
			a[n-1-i]=temp;
		}
		
		for(int i=0; i<n; i++) {
			//System.out.println("a["+i+"]="+a[i]);
			System.out.print("역 배열:"+a[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("배열의 크기를 입력해주세요.");
		int n=sc.nextInt();
		
		System.out.println("배열을 입력해주세요.");
		int[] a=new int[n];		
		for(int i=0; i<n; i++) {
			a[i]=sc.nextInt();
		}
		
		// System.out.println("배열의 역순: "+reverse(n,a)[0] );
		// 이렇게 하려면 리턴된 역순 배열의 요소를 나하나 [0] 이렇게 인덱스 지정해줘야 하는데 for문 돌려야함...
		
		// #1
		//System.out.println(reverse(n,a)); // 이렇게하면 배열 주소값이 리턴됨...리턴형을 배열로 주지 말자. ==> #2
		// #2
		reverse(n,a);

	}

}
