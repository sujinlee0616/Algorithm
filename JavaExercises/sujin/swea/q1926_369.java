package swea;

import java.util.Scanner;

// [Java 함수] ★★★ Re!!
// - int형 숫자의 자리수 구하기 : (int)(Math.log10(num)+1)
// - 지수승 : Math.pow(밑, 지수)
// - 정규표현식: String에서 숫자 제외하고 문자만 출력: String a="36-"; a=a.replaceAll("[0-9]", "");

// 56 ==>  5- 이 아니라 - 출력해야함. 

public class q1926_369 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		solution(num);
		//System.out.println(calculateEach(123));
	}
	
	public static void solution(int num) {
		for(int i=1;i<=num;i++)
			System.out.print(calculateEach(i)+" ");
	}
	
	public static String calculateEach(int n) {
		
		String result="";
		
		// 1. n의 자리수를 구한다 
		int length=(int)(Math.log10(n)+1);  // ex) 369 ==> 3자리수 
		//System.out.println("length="+length); 
		
		// 2. 자리수별로 검사 
		for(int i=length;i>0;i--) {
			//System.out.println("i="+i);
			int divide=(int) Math.pow(10,i-1);  // ex) 369 ==> divide=10^2 
			int ith=n/divide;  // ex) 369 / 100 = 3 ==> - 
			//System.out.println("ith="+ith);
			if(ith==3 || ith==6 || ith==9) {
				result+="-";
			}
				
			else
				result+=ith;
			n = n - ith*divide;
			//System.out.println("n="+n);
		}
		
		if(result.contains("-"))
			result = result.replaceAll("[0-9]", "");
		
		return result;
		
	}

}
