package swea;

import java.util.Scanner;

// 소요시간: 30분 

public class q1209_sum {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(int TC=1;TC<=10;TC++) {
			int t=sc.nextInt();
			int[][] arr=new int[100][100];
			
			for(int i=0;i<100;i++)   
				for(int j=0;j<100;j++)
					arr[j][i]=sc.nextInt();   // <== 2차원 배열 입력 받을 때 [i][j] 아니라 [j][i]임에 유의!
			System.out.println("#"+TC+" "+findMaxSum(arr));
		}
	}
	
	static int findMaxSum(int[][] arr) {
		int maxSum=0;
		
		// 행의 합 최대값 구하기 
		for(int i=0;i<100;i++) {
			// i행의 합 구하기 
			int sum=0;
			for(int j=0;j<100;j++) 
				sum+=arr[j][i]; // y좌표는 고정, x값만 변함 ==> 행의 합. 
			if(sum > maxSum)
				maxSum=sum;
		}
		
		// 열의 합 최대값 구하기 
		for(int i=0;i<100;i++) {
			// i행의 합 구하기 
			int sum=0;
			for(int j=0;j<100;j++) 
				sum+=arr[i][j]; // x좌표는 고정, y값만 변함 ==> 열의 합. 
			if(sum > maxSum)
				maxSum=sum;
		}
		
		// 대각선의 합 최대값 구하기 - (0,0)에서 우하향 대각선의 합 
		int sumCross1=0;
		for(int i=0;i<100;i++) {
			sumCross1+=arr[i][i];
		}
		if(sumCross1 > maxSum)
			maxSum=sumCross1;
		
		// 대각선의 합 최대값 구하기 - (99,99)에서 좌하향 대각선의 합 
		int sumCross2=0;
		for(int i=0;i<100;i++) {
			sumCross2+=arr[99-i][i];
		}
		if(sumCross2 > maxSum)
			maxSum=sumCross2;
		
		return maxSum;
	}
	
}
