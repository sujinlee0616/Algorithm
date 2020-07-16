package presentation;

import java.util.Scanner;

public class Recursion {

/*
 
 재귀함수 : recursive function
 
  0) 정의 
  다른 함수가  자신을 포함 하여 정의 되는 것 
 
  
  1) 종류 
  - 직접 재귀  : 자신과 같은 메서드를 호출  
  	a(){ a(); } --> a(){ a(); } --> a(){ a(); } ... 
  - 간접 재귀  :	매개 메서드를 호출함으로 자신을 호출 
    a(){ b(); } --> b(){ a(); } --> a(){ b(); } ...
 
  2) 팩토리얼의 재귀적 정의   n!=nxn-1xn-2xn-3x...x1
  10!= 10 X 9! 
  	9!= 9 X 8! 			A! = AXB! - 재귀성을 띔을 확인 할 수 있
  	 8! = 8 X 7! 
  	  ....  n!= nx(n-1)! 
  	
  3) 유클리드 호제법 
  :최대공약수를 재귀적으로 구하는 방식 , 주어진 자연수 M,N을 '직사각형'으로 생각 (M<N인 자연수)
  1> 짧은 변(M)을 하나의 정사각형으로 생각하여 2개를 만듦 
  2> 남은 사각형에 같은 과정을 반복 (N-2M 길이 만큼의 정사각형을 만듦) ... 재귀성을 띈다.
  		
 */
	
	//0)
	public static void hello() {
		System.out.print("Hello Algorithm! :) ");
		hello();
	}
	/*
	 * hello();
	 * 	--> hello();
	 * 		--> hello();
	 * 			--> hello();   hello 메서드를 hello 메서드 안에서 계속 생성 .. 재귀적
	 */
	
	
	
	//1) 자연수의 정의
	/*	
	 1은 자연수다 						f1()=자연수   , f()= 2  
	 1의 다음수 =2 도 자연수다 			  f2(){ f1(); }
	 2의 다음수 =3 도 자연수다 
	 ... n도 자연수다 
	 */
	
	//2) factorial 
	 static int factorial(int num) {		// int num=9;
		if(num>0) 
			return num*factorial(num-1);		// f(9){9Xf(8)}
													// f(8) {8Xf(7);} .. 재귀적! 
		else 
			return 1; // 0!=1;
	}
	
	 
	 
	//3)  Euclid
	 static int euclideanAlgorithm(int x,int y)
	 {
		 if(y==0)
			 return x; //0은 모든 양의 자연수 보다 작다 
		 else 
			 return euclideanAlgorithm(y, x%y);
		 /*
		 최대공약수 구하기 =  서로소가 나올 때 까지 공약수로 나눔 , 그 결과값을 곱함 OR 소인수 분해 
		  */
	 }
	 
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int num=scn.nextInt();
		System.out.println(num+"'s Factorial="+factorial(num));
		
		
		int x=scn.nextInt();
		int y=scn.nextInt();
		System.out.println("x와 y의 GCD = "+euclideanAlgorithm(x, y));
	}
	
	
}
