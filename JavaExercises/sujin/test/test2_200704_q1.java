package test;

public class test2_200704_q1 {
	
	// 이름이 포함되어 있는지 아닌지 
	public static boolean solution(String[] name_list) {
		boolean answer=false;
		int leng=name_list.length;
		
		// 앞의 원소가 뒤에 포함되어 있는지 확인 
		for(int i=0;i<leng;i++) {
			for(int j=1;j<leng-i;j++) {
				if(name_list[i+j].contains(name_list[i]))
					answer=true;
			}
		}
		
		// 뒤의 원소가 앞에 포함되어 있는지 확인
		for(int i=leng-1;i>0;i--) {
			for(int j=1;j<=i;j++) {
				if(name_list[i-j].contains(name_list[i]))
					answer=true;
			}
		}
		
		return answer;
	}
	
	
	public static void main(String[] args) {
		
		//String[] name_list= {"봄","여울","봄봄"};
		String[] name_list= {"봄봄","여울","봄"};
		//String[] name_list= {"가을", "우주", "너굴"};
		solution(name_list);
		System.out.println(solution(name_list));
	}

}
