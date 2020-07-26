package swea;

import java.util.Scanner;

// [문제]
// - 걸린 시간: 약 1시간 
// - 가로길이: 항상 100 
// - 높이: 1~100 
// - 덤프횟수: 1~1000 
// - 주어진 덤프 횟수 이내에 평탄화가 완료되면 더 이상 덤프 수행 불가 ==> 그 때의 최고점/최저점 높이 차를 반환 (0 or 1) 
public class q1208_flattening {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(int i=1;i<=10;i++) {
			int dump=sc.nextInt();
			int[] arr=new int[100];
			for(int j=0;j<100;j++)
				arr[j]=sc.nextInt();
			System.out.println("#"+i+" "+flatten(arr,dump));
		}
	}
	
	static int flatten(int[] arr,int dump) {
		int gap=0; // 최고점-최저점 높이 차이 
		int cnt=0;
		
		int maxIndex=0;
		int minIndex=0;
		int maxV=arr[maxIndex];
		int minV=arr[minIndex];
		
		
		// 1. 최고점, 최저점을 찾는다. 
		// 2. 최고점-1, 최저점+1을 한다. cnt++ 한다.
		while(cnt<dump) {
			//System.out.println("=============== cnt="+cnt);
			
			// while문 새로 돌 때 초기화  ★★★
			maxIndex=0;
			minIndex=0;
			maxV=arr[0];
			minV=arr[0];
			
			// 1-1) 최고점 찾기 
			for(int i=0;i<100;i++) {
				if(arr[i] > maxV) {
					maxIndex=i;
					maxV=arr[i];
				}
			}
			//System.out.println("maxIndex="+maxIndex);
			//System.out.println("maxV="+maxV+" = arr[maxIndex]="+arr[maxIndex]);
			
			arr[maxIndex]--;
			//System.out.println("arr[maxIndex]--; 결과==> arr["+maxIndex+"]="+arr[maxIndex]);
			
			// 1-2) 최저점 찾기 
			for(int i=0;i<100;i++) {
				if(arr[i] < minV) {
					minIndex=i;
					minV=arr[i];
				}
			}
			//System.out.println("minIndex="+minIndex);
			//System.out.println("minV="+minV+" = arr[minIndex]="+arr[minIndex]);
			
			arr[minIndex]++;
			//System.out.println("arr[minIndex]++; 결과==> arr["+minIndex+"]="+arr[minIndex]);
			
			// 3. cnt++;
			cnt++;

		}
		
		
		int maxVal=arr[0];
		int minVal=arr[0];
		for(int i=0;i<100;i++) {
			if(arr[i] > maxVal) {
				maxVal=arr[i];
			}
		}
		//System.out.println("maxVal="+maxVal);
		for(int i=0;i<100;i++) {
			if(arr[i] < minVal) {
				minIndex=i;
				minVal=arr[i];
			}
		}
		//System.out.println("minVal="+minVal);
		gap=maxVal - minVal;
		
		return gap;
	}

}





