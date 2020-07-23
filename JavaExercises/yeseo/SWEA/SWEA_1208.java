package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_1208 {
	/*
	 * 평탄화 (2h) - 횟수제한 걸려있음 - 결과, 블록의 높이 차이가 1 이내 (1 | 0) - max와 min을 리턴 - max (-1)
	 * --> min (+1) ( dump ) - 평탄화 이후 최고-최저의 값을 구해라 (어려운점) max 함수가필요 없었다 , index 넘치는
	 * 문제...
*/
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		for (int t = 1; t <=10; t++) {
			int dump = scan.nextInt();
			// String boxes=scan.nextLine();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int box[] = new int[100];// st.countTokens()
			System.out.println();
			int i = 0;
			while (st.hasMoreTokens()) {
				box[i++] = Integer.parseInt(st.nextToken());
			}
			// 길이는 100
			Arrays.sort(box); // 0(min) 99(max)
			for (i = 0; i < dump; i++) {
				box[0]++;
				box[99]--;
				Arrays.sort(box); // min+1 , max-1 한 후 다시 정렬	 
			}
			// max-min 
			System.out.format("#%d %d\n",t,box[99]-box[0]);
			// MaxMin(box);
		}
	}

	/*
	 * public static void MaxMin(int arr[]){
	 * 
	 * int max=arr[0]; int min=arr[0];
	 * 
	 * for(int i=0;i<arr.length;i++) { if(max<arr[i]) { max=arr[i]; } if(min>arr[i])
	 * { min=arr[i]; } } System.out.println("max:"+max);
	 * System.out.println("min:"+min);
	 * 
	 * }
	 */

}
