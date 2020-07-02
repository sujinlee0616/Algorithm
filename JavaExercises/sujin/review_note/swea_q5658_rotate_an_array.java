package review_note;

public class swea_q5658_rotate_an_array {
	
	// [배열 회전시키기]
	
	// Q1. 길이가 12인 배열이 주어지고, 3개씩 끊어서 인덱스를 출력한다. 배열을 회전시켜서 총 3번 출력
	// ex) 0,1,2,3,4,5,6,7,8,9,10,11 배열이 있을 때,
	// 출력 : (0,1,2),(3,4,5),(6,7,8),(9,10,11),
	// (1,2,3),(4,5,6),(7,8,9),(10,11,0),
	// (2,3,4),(5,6,7),(8,9,10),(11,0,1)
	
	// <더 나은 방법> 
	/* public static void main(String[] args) {
		for(int i=0; i<3; i++) {
			for(int j=0; j<4; j++) {
				System.out.print("(");
				for(int k=0; k<3; k++) {
					int pos=(i+j*3+k)%12;
					System.out.print(pos+",");
				}
				System.out.print(") ");
			}
		}
	}
	*/
	
	// <내가 푼 방법> 
	/* public static void main(String[] args) {
		
		int[] arr= {0,1,2,3,4,5,6,7,8,9,10,11};
		String[] ans= new String[12];
		
		for(int i=0;i<arr.length;i++) {
			if(i+2<=11) // i=0~9
				ans[i]= arr[i]+","+arr[i+1]+","+arr[i+2];
			if(i+2>11 && i+1<=11) // i=10
				ans[i]= arr[i]+","+arr[i+1]+","+arr[(i+2)-12];
			if(i+1>11) // i=11
				ans[i]= arr[i]+","+arr[(i+1)-12]+","+arr[(i+2)-12];
			
			System.out.println("ans["+i+"]="+ans[i]);
		}
	}
	*/
	
	// 크기가 N인 배열을 M개씩 끊어서?
	public static void main(String[] args) {
		int N=35;
		int M=7;
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<(N/M); j++) {
				// ==================== 한 묶음 (괄호 한 개) ====================
				System.out.print("(");
				for(int k=0; k<M; k++) {
					int pos=(i+j*M+k)%N;
					System.out.print(pos+",");
				}
				System.out.print(")");
				System.out.println();
			}
		}
	}
	
	
}
