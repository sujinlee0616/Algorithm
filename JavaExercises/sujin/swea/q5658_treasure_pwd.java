package swea;
import java.util.Scanner;
import java.io.FileInputStream;


public class q5658_treasure_pwd {
	
	// 못풀었음 ㅠㅠ ==> 집가서 다시 해보자. 
	// 필요한 자료구조 딱히 없음. 걍 생각 잘 해서 풀면 됨. 
	// N개의 숫자가 입력으로 주어졌을 때, 
	// 비밀번호는 보물 상자에 적힌 숫자로 만들 수 있는 모든 수 중, K번째로 큰 수를 10진 수로 만든 수이다.
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T; // 테스트케이스 수 
		T=sc.nextInt();
		
		int N; // N개의 숫자 입력 
		N=sc.nextInt();
		
		String S; // 입력한 N개의 16진수 
		S=sc.next(); // ex) 1B3B3B81F75E : 12개의 16진수 

		String[] ss=S.split(""); //  S를 한 글자씩 잘라서 만든 배열 
		// ex) ss={1,B,3,B,3,8,8,1,F,7,5,E};
		
		// ex) N=20 ==> 4로 나누면 5 ==> 
		
		// 1. "N/4개"의 숫자 케이스 만들 수 있음 
		// 2. 각 케이스는 항상 "4개"의 숫자를 가짐 
		// 3. 따라서, N개로 만들 수 있는 숫자 N개  
		// 인덱스 번호 기준으로... 
		// 012 345 678 91011 ==> 숫자 4개 
		// 123 456 789 10110 ==> 숫자 4개 
		// 234 567 8910 1101 ==> 숫자 4개  
		
		// 각 변의 16진수를 구하자. 
		String[] numbers=new String[N];
		for(int i=0; i<N; i++) {
			numbers[i]="";
		}
		
		for(int i=0; i<N; i++) {
			
			int j=N/4*i;
			int count=0;
			
			if(j<N) {
				while(count<N/4) {
					numbers[i]+=ss[j];
					count++;
					j++;
				}
			}
			
			System.out.println("numbers["+i+"]="+numbers[i]);
		}
		

		
		
	}

}
