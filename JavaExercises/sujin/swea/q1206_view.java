package swea;

import java.util.Scanner;

// idea) 
// 아파트의 높이를 배열로 받음
// 아파트 높이: 0 0 3 5 7 4 0 3 0 5 2  0  0  0 
// index:   0 1 2 3 4 5 6 7 8 9 10 11 12 13
// ==> arr[8]이 조망권이 있는지 살펴보자.
// ==> 좌우 2개씩 각 4개의 아파트의 높이의 영향을 받음
// ==> arr[7]=3   ==> arr[9]-arr[7]=2
//     arr[8]=0   ==> arr[9]-arr[8]=5
//     arr[9]=5 ★★★★ 
//     arr[10]=2  ==> arr[9]-arr[10]=3
//     arr[11]=0  ==> arr[9]-arr[11]=5
//                    ===============> 위의 4개 중 min값이 arr[9]에서 조망권 있는 층의 수임. 
public class q1206_view {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<10;i++) {
			// 1. 갯수 받고 
			int n=sc.nextInt();
			// 2. 배열 만들고 배열에 값 넣고 
			int[] arr=new int[n];
			for(int j=0;j<n;j++) {
				arr[j]=sc.nextInt();
			}
			// 3. 판정결과 출력 
			System.out.println("#"+(i+1)+" "+solution(n,arr));
		}
	}
	
	public static int solution(int n,int[] arr) {
		int res=0;
		
		// i번째 건물에서 조망권 있는 층의 수 
		for(int i=2; i<=n-3; i++) {
			//System.out.println("========== i="+i+"==========");
			int l2=arr[i]-arr[i-2]; 
			//System.out.println("l2="+l2);
			int l1=arr[i]-arr[i-1];
			//System.out.println("l1="+l1);
			int r1=arr[i]-arr[i+1];
			//System.out.println("r1="+r1);
			int r2=arr[i]-arr[i+2];
			//System.out.println("r2="+r2);
			
			if(! (l2<=0 || l1<=0 || r1<=0 || r2<=0) ) { // i가 좌우2개 건물들보다 높이가 낮거나 같으면 조망권 있는 층이 없음  
				// l2,l1,r1,r2 중에 min값 찾기 
				int[] compare= {l2,l1,r1,r2};
				int min=compare[0];
				for(int j=0;j<4;j++)
					if(min>compare[j])
						min=compare[j];
				res+=min;
			} 
		}
		
		return res;
	}
	
	
}
