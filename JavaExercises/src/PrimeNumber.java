//정수 n을 입력받아 n까지 모든 소수 구하기 
//Hint : 자기 자신보다 작은 수들을 나누어봐서, 하나라도 나누어지면 소수가 아님. 
//소수 : 약수가 1과 자기자신뿐. 
import java.util.Scanner;
public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//정수 입력받음 
		Scanner scan=new Scanner(System.in);
		System.out.println("정수 입력:");
		int number=scan.nextInt();
		
		//소수 여부 판단
		/*
		 * boolean bCheck=true; int i=2; while(true) { bCheck=false; if(number%i==0 &&
		 * i!=number) { System.out.println("소수가 아닙니다."); break; } else bCheck=true;
		 * if(i==number) { System.out.println("소수입니다."); break; } i++; }
		 */

		//입력받은 수까지의 모든 소수를 출력하라 
		//1~100까지의 소수 출력 
		//1은 약수가 있는가? 2는 약수가 있는가? 
		//10(i)은 약수가 있는가? (j로 나눠보자) 
		//입력받은 수 이하의 수를 2부터 살펴보자...

		for(int i=2;i<=number;i++) {	
			boolean bCheck=true; 
			int j=2; 
			int factor=0;
			while(j<i) { 
				//소수가 아님 (나눠 떨어지는 수가 있음) ==> 약수 개수 +1
				if(i%j==0) 
					factor+=1;
				j++; 
			}
			//소수이려면.... 약수가 한 번도 없어야... 약수가 0개면... 소수...
			if(factor==0) {
				System.out.printf("%d\t",i);	
			}	
		}	
		
		
	}

}
