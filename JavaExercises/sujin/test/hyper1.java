package test;

public class hyper1 {
	
	public static void main(String[] args) {
		String phone_number = "+82-010-3434-2323";
		System.out.println(solution(phone_number));
	}
	
	static int solution(String phone_number) {
		int ans = -1; 
		
		// 유형1 : 13글자  ex) 010-XXXX-XXXX // -의 위치: 3,8
		// 유형2 : 11글자  ex) 01012345678
		// 유형3 : 16글자  ex) +82-10-1234-5678  // 3+3+1+4+1+4=8+8=16 // -의 위치: 3,6,11
		
		int leng = phone_number.length();
		
		// 유형1
		if(leng==13) {
			boolean type1 = true;
			// 1) 010-으로 시작하고 8번째에 -인지 검사 
			if(! ( phone_number.startsWith("010-") && phone_number.charAt(8)=='-' ) )
				type1 = false;
			// 2) - 뺀 문자들이 다 숫자인지 검사 
			else {
				phone_number = phone_number.replaceAll("-", "");
				for(int i=0; i<10; i++) {
					if(phone_number.charAt(i)<'0' || phone_number.charAt(i)>'9')
						type1 = false;
				}
			}
			if(type1==true)
				ans=1;
		}
				
		// 유형2
		else if(leng==11) {
			boolean type2 = true;
			// 1) 010으로 시작하는지 검사 
			if(!phone_number.startsWith("010"))
				type2 = false;
			// 2) 전부 다 숫자인지 검사  
			else {
				for(int i=0; i<leng; i++) {
					if(phone_number.charAt(i)<'0' || phone_number.charAt(i)>'9')
						type2 = false;
				}
			}
			if(type2==true)
				ans=2;
		}
		
		
		// 유형3
		else if(leng==16) {
			boolean type3 = true;
			// 1) +82-10-으로 시작하고, 11번째가 -인지 검사 검사 
			if( ! ( phone_number.startsWith("+82-10-") && phone_number.charAt(11)=='-' ) )
				type3 = false;
			// 2) +82-10- 이하 XXXX-XXXX 부분에서 - 제외한 놈이 다 숫자인지 검사 
			else {
				String s = phone_number.substring(7,leng);
				s = s.replaceAll("-","");
				int sLeng = s.length();
				for(int i=0; i<sLeng; i++)
					if(s.charAt(i)<'0' || s.charAt(i)>'9')
						type3 = false;
			}
			if(type3==true)
				ans=3;
		}
		
		return ans;
	}

}




