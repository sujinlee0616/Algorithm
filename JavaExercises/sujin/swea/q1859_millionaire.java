package swea;

import java.util.ArrayList;
import java.util.Scanner;

// 푸는데 걸린 시간: 처음 2시간 ==> 실패 / 나중 2시간 ==> 성공 
// [문제] 
// 1. 원재는 연속된 N일 동안의 물건의 매매가를 예측하여 알고 있다.
// 2. 당국의 감시망에 걸리지 않기 위해 하루에 최대 1만큼 구입할 수 있다.
// 3. 판매는 얼마든지 할 수 있다.
// idea) 
// 1 2 3 4 8 9 1 1 1 3 7 5 1 4 2   이런 배열이 있다면
// 1 2 3 4 8 9 | 1 1 1 3 7 | 5 | 1 4 | 2 이런식으로 구부할 수 있다. 
// ===========   =========   =   ===   =
// 위의 5구획은, 맨 오른쪽에 위치한 최대값만큼을 받고 팔 수 있다. 
// 즉, 하나의 구획은 오름차순으로 증가하는 데까지라고 할 수 있다. 
// 왼쪽에 위치한 작은 숫자들은 가장 오르쪽에 위치한 최대값만큼을 받고 팔 수 있다. 
// 즉, 하나의 오름차순 구획 | 하나의 오름차순 구획 (이 구획의 맨 왼쪽 수는 앞쪽 구획의 맨오른쪽에 위치한 최대값보다 작음) 이런식으로 구분됨 
// 이걸 코드로 구현하기 위해서는, 일단 priceList(pList)를 0에서 끝까지 쭉 훑어서 가장 큰 값(max)를 찾고, 그 값의 index(sellday)를 찾는다. 
// 이걸 한 번 수행하면 가장 왼쪽 구간 하나를 얻을 수 있다. 
// 그러면, 그 다음 구간을 알아내기 위해서, start를 sellday+1로 해서 for문으로 int i=start부터 priceList한바퀴 쭉 돌면, 첫번째 구획을 제외한 부분에서 가장 큰 값(max)와 그 값의 index(sellday)를 찾을 수 있다. 
// 이때 주의할 점은, 다시 start부터 for문 돌기 전에 max값을 초기화 해줘야 한다는 것이다. 
// 그 이유는, 위의 priceList에서는 처음 for문 돌았을 떄의 max=9이기 때문에, max를 pList(sellday+1) = pList(6) = 1로 초기화해주지 않으면, 
// 두번째 for문 돌 때 max값을 제대로 찾을 수 없기 때문이다. 
public class q1859_millionaire {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int i=0;i<TC;i++) {
			// 1. 입력값 저장 
			int day=sc.nextInt();
			//int[] price=new int[day];
			ArrayList<Integer> pList = new ArrayList<Integer>();
			for(int j=0;j<day;j++) {
				//price[j]=sc.nextInt();
				pList.add(sc.nextInt());
			}
				
			// 2. 판별 결과 출력
			System.out.println("#"+(i+1)+" "+maxMargin(day,pList));
		}
	}
	
	
	public static long maxMargin(int day, ArrayList<Integer> pList) throws InterruptedException {
		
		long margin = 0;
		int max=pList.get(0); // 최고값 - 초기화 
		int sellday=0; // 팔아야 하는 날 (값이 최고일때) - 초기화 
		int start=0; // 이번 회차 판매 시작일 
		
		
		while(start < day) {
			// 1. 최고값이 있는 날짜와 최고값을 구한다. 
			for(int i=start;i<day;i++) {
				if(pList.get(i)>=max) {
					max=pList.get(i);
					sellday=i;
				} 
			}
			
			
			// 2. start 일 ~ sellday까지 판매 
			for (int i=start; i<=sellday; i++) { // '<=' 이어야함.
				margin += (max - pList.get(i));
			}
			
			// max 초기화 필요 ★★★★★
			if(sellday<day-1)
				max=pList.get(sellday+1);
			
			start=sellday+1; // 3. max, sellday, start 갱신  ==> while문이 수행 
			
			if(start==day-1)
				break;
			
		}
		
		return margin;
	}
	
}





