package swea;

import java.util.Scanner;

// - 소요시간: 10분 
public class q1284_water_bill {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		for(int i=1;i<=TC;i++) {
			 int P=sc.nextInt();
			 int Q=sc.nextInt();
			 int R=sc.nextInt(); 
			 int S=sc.nextInt();
			 int W=sc.nextInt();
			 System.out.println("#"+i+" "+waterBill(P,Q,R,S,W));
		}
	}
	
	static int waterBill(int P, int Q, int R, int S, int W) {
		int tax=0;
		
		// A사: P원/L
		// B사: 기본요금 Q원(사용량: 0~R리터일 때) + S원/L (R리터 초과 사용 시 )
		// W리터: 한달간 수도 사용량 
		// 더 저렴한 요금을 골라 출력 
		
		int A=P*W;
		int B=0;
		
		if(W>R) {
			B = Q + (W-R)*S;
		}
		else
			B=Q;
		
		if(A>B)
			tax=B;
		else
			tax=A;
		
		
		return tax;
	}

}
