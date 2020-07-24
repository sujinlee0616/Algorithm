package swea;

import java.util.Scanner;

// 다시 풀어야함. 선택정렬로 해결할 수 없음. 
// 완전탐색. DFS. OR 그리디 알고리즘 사용. 

// - 지수승 : Math.pow(밑, 지수)
// - 숫자로 구성된 문자에서 n번째 글자 자르기 ex) String s="12345"; 두번째 글자인 2를 받아오려면? 
//   ==> 첫번째 글자 2 가져오려면 ★★ s.charAt(1)-'0';★★ 해야함.   ★★★즉, 문자 0을 뺴줘야 한다.★★★
public class q1244_max_prize_money {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		for(int i=0;i<TC;i++) {
			String a=sc.next();
			int n=sc.nextInt();
			System.out.println("#"+(i+1)+" "+solution(a,n));
			//solution(a,n);
		}
	}
	
	public static String solution(String a, int n) {
		String result="";
		
		// 1. a의 자리수를 구한다
		int length = a.length(); 
		int[] arr=new int[length];

		// 2. 자리수 각각을 배열로 만든다 
		for(int i=0;i<length;i++) {
			arr[i]=(int)(a.charAt(i)-'0');
			//System.out.println("arr["+i+"]="+arr[i]);
		}	
		
		// 3. n번 교환했을 때의 max 상금을 구한다. ★★★ <==  선택정렬하면 안 됨. 
		// 1) 배열에서 max값과 그 index를 찾고, index!=0 이라면 arr[0]과 바꾼다. 
		// 2) 배열의 0번째자리까지 정렬되었음 ==> 1~length-1 범위에서 max값과 그 index를 찾고, index!=1 이라면 arr[0]과 바꾼다.             
		// ===> 선택정렬을 n회 수행.  
		
		// 선택정렬을 n회... 배열의 길이는 length 임. 
		for(int i=0;i<n;i++) { // 선택정렬을 n회 
			int max=i;   // max: i번째 검사에서 가장 왼쪽에 위치한 수. 가장 큰 값(max)의 인덱스. 우선 처음에는 걍 i로 초기화해줌. 
			for(int j=i+1;j<length;j++) {  // 배열의 길이는 length임. 
				if(arr[j]>arr[max]) // 정렬안 된 범위에서 arr[max]보다 큰 값이 있다면 
					max=j;  // arr 배열에서 가장 큰 값의 인덱스 번호를 제대로 지정.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
				swap(arr,i,max); // index i와 max의 위치를 바꿈. 
			}
		}
		
		for(int i=0;i<length;i++)
			result+=arr[i];
		
		return result;
	}
	
	public static void swap(int[] arr, int idx1, int idx2) {
		int temp=arr[idx1];
		arr[idx1]=arr[idx2];
		arr[idx2]=temp;
	}
	
}






