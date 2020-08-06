package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1206 {
	/*
	 * VIEW --M++ (2칸씩 띄어져 있다면 조망권 확보) 윗변 = 인덱스 값 빌딩 최대 높이 = 255 가로길이 = 빌딩개수 <=1000
	 * building.length=height 
	 * return 이 view 인개수를 세서 출력
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int T = 1; T <= 10; T++)// 테스트 케이스
		{
			int N = scan.nextInt();// 빌딩개수
			int building[] = new int[N];
			int i = 0;
			for (i = 0; i < N; i++) {
				building[i] = scan.nextInt();// 빌딩높이 0 0 3 ~ n-3 0 0
			}
			System.out.println("#"+T+" "+solution(building));

		}
	}

	public static int solution(int building[]) {
		int view = 0;
		for (int j = 2; j < building.length - 2; j++) // 3~n-3s
		{
			int near[] = new int[4]; // 여기가 핵심 -2 ~ +2 만 검색
			near[0] = building[j] - building[j - 1];
			near[1] = building[j] - building[j - 2];
			near[2] = building[j] - building[j + 1];
			near[3] = building[j] - building[j + 2];

			if (near[0] < 0 || near[1] < 0 || near[2] < 0 || near[3] < 0)
				continue;
			else {
				Arrays.sort(near);
				view += near[0];
			}
		}
		return view;
	}

}
