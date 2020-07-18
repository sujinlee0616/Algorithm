package datastructure_book;

public class Ch5_p196_q8_FourQueen {
	static boolean[] flag_a=new boolean[4]; // 각 행에 퀸을 배치했는지 체크
	static boolean[] flag_b=new boolean[7]; // '/' 대각선 방향으로 퀸을 배치했는지 체크
	static boolean[] flag_c=new boolean[7]; // '\' 대각선 방향으로 퀸을 배치했는지 체크
	static int[] pos=new int[4];
	
	// 각 열의 퀸의 위치를 출력
	static void print() {
		for(int i=0;i<4;i++) {
			for(int j=0;j<pos[i];j++)
				System.out.print("◻︎︎");
			System.out.print("◼︎");
			for(int j=0;j<(3-pos[i]);j++)
				System.out.print("◻︎︎");
			System.out.println();
		}
		System.out.println();
	}
	
	// i열의 알맞은 위치에 퀸을 배치
	static void set(int i) {
		for(int j=0;j<4;j++) {
			if(flag_a[j]==false && // 가로(j행)에 아직 배치 X
					flag_b[i+j]==false &&  // 대각선 '/'에 아직 배치 X
					flag_c[i-j+3]==false) { // 대각선 '\'에 아직 배치 X
				pos[i]=j;
				if(i==3)
					print();
				else {
					flag_a[j]=flag_b[i+j]=flag_c[i-j+3]=true;
					set(i+1);
					flag_a[j]=flag_b[i+j]=flag_c[i-j+3]=false;
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		set(0);
	}
}
