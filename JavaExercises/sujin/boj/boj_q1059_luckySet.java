package boj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// - 구간 [A,B] : A~B 모든 정수가 있는 구간. (단, A,B는 양수. B>A) 
// - 구간 [A,B]가 unlucky가 되기 위해선 구간에 속한 모든 정수가 lucky set에 없어야함 

public class boj_q1059_luckySet {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int Lsize = sc.nextInt();

		Set<Integer> luckySet = new HashSet<Integer>();
		for (int i = 0; i < Lsize; i++)
			luckySet.add(sc.nextInt()); // luckySet를 입력받는다.
		int n = sc.nextInt(); // n을 입력받는다. ==> n을 포함하는 luckySet 개수를 출력해야함.

		// n과 lukcySet에 속한 수들을.. 구간을 정해서...
		int min = n;
		int max = n;
		for (int a : luckySet)
			if (a < min)
				min = a;
		for (int b : luckySet)
			if (b > max)
				max = b;

		luckySet.add(min);
		luckySet.add(max);

		// n보다 작으면서 n에 가장 가까운 luckySet 원소 구하기 (없을 수도 있음)
		for (int c : luckySet) {

		}
		// n보다 크면서 n에 가장 가까운 luckySet 원소 구하기 (없을 수도 있음)
		for (int d : luckySet) {

		}
	}
		

}
