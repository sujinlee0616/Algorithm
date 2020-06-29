package boj;

import java.util.Scanner;
import java.util.StringTokenizer;

// 선택정렬 

// 두번째로 큰 수 출력 
public class boj_q10817_selection_sort {
	
	// [방법2] 
	public static void method2(){
		
		// 1. 입력 
		Scanner sc = new Scanner(System.in);
		int[] numbers = new int[3];
		for(int i=0;i<numbers.length;i++) {
			numbers[i]=sc.nextInt();
		}
		
		// 2. 선택정렬 
		
		
	}
	
	
	// [방법1]
	public static void method1(){
		
		// 1. 입력
		Scanner scan = new Scanner(System.in);
		String numbers = scan.nextLine();
		// System.out.println(numbers);

		StringTokenizer st = new StringTokenizer(numbers, " ");

		int i = 0;
		int[] number = new int[3];

		while (st.hasMoreTokens()) {
			number[i] = Integer.parseInt(st.nextToken());
			// System.out.println(number[i]);
			i++;
		}

		// 2. 수 비교, 두번째로 큰 수 출력 
		if (number[0] > number[1]) {
			int temp = number[0];
			number[0] = number[1];
			number[1] = temp;
			//System.out.print("number[0]="+number[0]);
			//System.out.print("/ number[1]="+number[1]);
			//System.out.print("/ number[2]="+number[2]);
		}

		if (number[0] > number[2]) {
			int temp = number[0];
			number[0] = number[2];
			number[2] = temp;
			//System.out.println("===================");
			//System.out.print("number[0]="+number[0]);
			//System.out.print("/ number[1]="+number[1]);
			//System.out.print("/ number[2]="+number[2]);
		}

		if (number[1] > number[2]) {
			int temp = number[1];
			number[1] = number[2];
			number[2] = temp;
			//System.out.println("===================");
			//System.out.print("number[0]="+number[0]);
			//System.out.print("/ number[1]="+number[1]);
			//System.out.print("/ number[2]="+number[2]);
		}

		System.out.println(number[1]);
	}
	
	public static void main(String[] args) {
		
		
		//method1();
		method2();
		
		
	}

}
