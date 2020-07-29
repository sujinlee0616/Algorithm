package swea;

import java.util.Scanner;

public class q2007_pattern_length {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		for(int i=1;i<=TC;i++) {
			String s=sc.next();
			System.out.println("#"+i+" "+ptnleng(s));
		}
	}
	
	static int ptnleng(String s){
		int leng=0;
		
		// s는 30글자. 
		// 1. 0번째 글자와 일치하는 n번째 글자를 찾는다. ==> 패턴의 길이 계산 leng=n+1;
		// 2. 1번째 글자와 n+1번째 글자가 일치하는지 체크한다. 
		// 3. ... n번째 글자와 2n+1번째 글자까지 일치하는지 체크한다. 
		
		
		boolean isPtn=true;
		boolean isComplete=false;
		
		for (int i=1; i<30; i++) {
			//System.out.println("========= i="+i+"=========");
			// 0번째 글자와 일치하는 i번째 글자를 찾는다. 
			if (s.charAt(0) == s.charAt(i)) {
				//System.out.println("i="+i);
				isPtn=true;
				for (int j=0; j<=i; j++) {
					// 0-i번째 글자, 1-i+1번째 글자, 2-i+2번째 글자 ... i+1-2i+1번째 글자가 모두 일치하는지 확인한다. 
					if (s.charAt(j) == s.charAt(j+i+1)) {
						isPtn = false;
					}
				}
				// 모두 일치한다면 길이 계산 
				if (isPtn == true) {
					leng = i;
					isComplete=true;
					break;
				}
			}
			if(isComplete==true)
				break;
		}
		
		return leng;
	}

}
