package SWEA;

import java.util.Scanner;

public class SWEA_1204 {
/*
 * 최빈수
 - 가장 여러번 나타나는 값
 - 동률의 경우 높은 값 
 조건)
 테스트 케이스 T
 학생 수 1000
 점수 100이하 
 
 1 점수 배열을 만들어서 동률인 애들만 카운팅 
 2 카운팅 중 최대 값 리턴 
 3 출력 ( 배열의 인덱스에 점수를 넣었음 ) 
 
 어려운점 )
 max가 아닌 index를 반환해야 함 .
 
 실수한 점)
 NUMBER =테스트케이스번호를 호출 안함 .. 
 입력값 오류   
 */
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int T=scan.nextInt();
		//int score[]=new int[1000];
		//다 저장할 필요 없이 count 2++인 애들만 저장하면 됨
		int N=0;
		int score=0;
		//여기서 배열을 만들면 X계속 갱신O 
		
		for(int i=1;i<=T;i++) {
			int count[]=new int[101]; // 1~100 
			N=scan.nextInt();
			System.out.println(N);
			for(int j=0;j<1000;j++) {
				score=scan.nextInt();	
				//System.out.print(score+" ");
				//count[71]=count[71]+1;
				count[score]++;
			}
			
			int max=0;
			int result=0;
			//점수 배열의 수가 높다 = 최빈수 
			for(int j=0;j<100;j++) {
				if(max<=count[j]) { //그 중에서도가장 큰 점수 
					max=count[j];
					result=j; 
				}		
			}
			System.out.println("#"+N+" "+result);
		}
	}
}
