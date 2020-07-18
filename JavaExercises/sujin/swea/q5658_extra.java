package swea;

public class q5658_extra {

	// 길이가 12인 배열이 주어지고, 3개씩 끊어서 인덱스를 출력한다
	// 배열을 회전시켜서 총 3번 출력
	// ex) 0,1,2,3,4,5,6,7,8,9,10,11 배열이 있을 때,
	// 출력 : (0,1,2),(3,4,5),(6,7,8),(9,10,11),
    // (1,2,3),(4,5,6),(7,8,9),(10,11,0),
    // (2,3,4),(5,6,7),(8,9,10),(11,0,1)
	
	
	
	public static void main(String[] args) {
		String[] arr= {"0","1","2","3","4","5","6","7","8","9","10","11"};
		String[] arr2= new String[12];

		for(int i=0;i<12;i++) {
			arr2[i]="";
		}
		
		for(int i=0;i<12;i++) {
			// 3개 출력 
			for(int j=i;j<i+3 && j<10;j++) {
				arr2[i]+=arr[j];
			}
			System.out.println("arr2["+i+"]="+arr2[i]);
		}
		
		// 여기가 문제  
		for(int i=8;i<12;i++) {
			for(int j=12-i;j>0;j--) {
				arr2[i]+=arr[j];
			}
			System.out.println("arr2["+i+"]="+arr2[i]);
		}
		
		
		
	}
	
}

