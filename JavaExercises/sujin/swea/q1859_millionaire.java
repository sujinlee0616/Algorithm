package swea;

import java.util.Scanner;

// 1. 원재는 연속된 N일 동안의 물건의 매매가를 예측하여 알고 있다.
// 2. 당국의 감시망에 걸리지 않기 위해 하루에 최대 1만큼 구입할 수 있다.
// 3. 판매는 얼마든지 할 수 있다.
public class q1859_millionaire {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int i=0;i<TC;i++) {
			// 1. 입력값 저장 
			int day=sc.nextInt();
			int[] price=new int[day];
			for(int j=0;j<day;j++)
				price[j]=sc.nextInt();
			// 2. 판별 결과 출력
			System.out.println("#"+(i+1)+" "+maxMargin(day,price));
		}
	}
	
	
	// ArrayIndexOutOfBoudsException ==> 수정해야 
	public static long maxMargin(int day, int[] price) {
		
		long margin = 0;
		int max=price[0]; // 최고값 
		int sellday=0; // 팔아야 하는 날 (값이 최고일때) 
		int start=0;
		
		// 1. 최고값이 있는 날짜와 최고값을 구한다. 
		for(int i=0;i<day;i++) {
			if(price[i]>max) {
				max=price[i];
				sellday=i;
			}
		}
		
		while(start <= (day-1)) {
			// 1. 가격을 구한다 
			for(int i=start;i<sellday;i++) {
				margin += price[sellday] - price[i];
			}
			// 2. sellday를 업데이트 
			if(sellday<=day-1)
				start=sellday+1;
			max=price[start];
			for(int i=start;i<day;i++) {
				if(price[i]>max) {
					max=price[i];
					sellday=i;
				}
			}
		}
		
		return margin;
	}
	
	// 에고;;; 잘못 생각했음;; 
	/* 
	public static long maxMargin(int day, int[] price) {
		long margin = 0;
		int sellday = day-1;
		
		for(int i=day-1;i>=1;i--) {
			if(price[i-1]>price[i]) {
				// 1. 판다 
				for(int j=i;j<=sellday;j++) {
					margin += (price[sellday] - price[j]);
				}
				// 2. sellday 업데이트
				sellday = i-1;
			}
			if(i==1 && sellday!=1) {
				for(int j=0;j<=sellday;j++) {
					margin += (price[sellday] - price[j]);
				}
			}
		}
		return margin;
	}
	*/ 
	
}





