package presentation;

public class NandM0 {
	public static void main(String[] args) {

		int N = 4;
		int M = 4;

		
		/* 1<M<8  이면 8번의 for문이 필요해 
		 * 그러니까, 재귀함수가 필요한 이유는 for문이 몇 개 쓰일지 모르니까? 
		 * M의 값 == for 문 개수 ? 
		 * + 중복 제거 이슈 ...
		 * 이거 메소드로 뺄 수 있을까
		 * 1111 1112 1113 1114 1121 1122 1123 1124
		 */
		boolean visited[]=new boolean [4]; 
		for(int i=0;i<4;i++) {
			visited[i]=false;
		}
		
		//true한번이라도 만들면 
		
		for (int h = 1; h <= N; h++) {

			for (int k = 1; k <= N; k++) {
				// k=1이 4번 i=1 부터 4qjs
				for (int i = 1; i <= N; i++) {
					// i =1 (x) i= k ;
					for (int j = 1; j <= N; j++) {
						//모든 조합에서 중복을 제거 ..
						
					
						if(h==k || h==i || h==j || k==i || k==j ||i==j){continue;}
						
						
						//if(k==i || k==j) {continue;}
						//if(i==j) {continue;}
						//if(h==k && k==i && i==j && j==h) {continue;}
						
						//1)h,k,i,j 가 모두 같으면 안됨
						//2)이웃한 자리 중복 제거 
						
						// 1234 1243 1324 1342 
						
						System.out.print(h+" " +k + " " + i + " " + j);
						System.out.println();


					}
				
			  }
			}
		}
		
		
	}
}
