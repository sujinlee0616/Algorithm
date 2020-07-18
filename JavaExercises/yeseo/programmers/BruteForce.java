package programmers;

public class BruteForce {
 
		/* [프로그래머스]
		 모의고사
		 1회: 1h
		 어려운 점:
		 수정할 점:가독성있는 코딩 
		 */
	
	
		public static int  check(int[] answers, int arr1[], int arr2[], int arr3[]) {
			//비교할 유저1의 배열 생성
			 int usr1[]=new int[answers.length];
			 int usr2[]=new int[answers.length];
			 int usr3[]=new int[answers.length];
			 
			 int cnt1=0;
			 int cnt2=0;
			 int cnt3=0;
			 
			 
			 int j=0;
			 for(int i=0;i<answers.length;i++)
			 { 
					 j=i%5;
					 usr1[i]=arr1[j];
					 j++;	 
				
			 }

			 int k=0;
			 for(int i=0;i<answers.length;i++) {
				 k=i%7;
				 usr2[i]=arr2[k];
				 usr3[i]=arr3[k];
				 k++;

			 }

			 for(int i=0;i<answers.length;i++) //Q는 최대 10000개 
			 {
				if(answers[i]==usr1[i]) cnt1++;
				else if(answers[i]==usr2[i]) cnt2++;
				else if(answers[i]==usr3[i]) cnt3++;		
			 }
			 int max=0;
			 
			 if(cnt1>=cnt2 && cnt1>=cnt3) max=1;
			 else if(cnt2>=cnt1 && cnt2>=cnt3) max=2;
			 else if(cnt3>=cnt1 && cnt3>=cnt2) max=3;
			 
			 //동률일 경우???
			 
			 return max;
		}
		public static void main(String[] args) {
		 //1: 12345        
		 //2: 21232425  
		 //3: 33114455  
		 int arr1[]= {1,2,3,4,5};
		 int arr2[]= {2,1,2,3,2,4,2,5};
		 int arr3[]= {3,3,1,1,4,4,5,5};
		 
		 int answers[]= {2,1,2,3,2,4,2,5};
		 
		 System.out.println(check(answers,arr1,arr2,arr3));
		 
		}

}
