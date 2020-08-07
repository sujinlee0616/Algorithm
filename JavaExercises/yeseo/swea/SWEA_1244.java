package swea;

import java.util.*;
public class SWEA_1244 {
/*
 최대상금 
 
 
 자리수 = 상금
 횟수만큼 교환 했을 때 최대 상금을 출력하라
 최대 6자리
 최대 10번 교환 
 
  
 입력)
 케이스 번호
 문자열 | 교환 횟수 
 
 
 */
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int T=scan.nextInt();
		//이슈1)어디에 담아야 호출이 편할까
		for(int i=1;i<=T;i++) {
			int input=scan.nextInt(); //321
			int N=scan.nextInt(); //교환 
			ArrayList<Integer>[] check = new ArrayList[10]; 
			
			// ***** 자리수로 자르는 메소드 **********
			String str=Integer.toString(input);
			int arr[]=new int [str.length()];
			for(int j=0;j<str.length();j++)
				//100의자리 = [0] 
				arr[j]=str.charAt(j); //굳이 -0 ? 
			//**********************************
			
			
			//이슈2)가장 앞자리수가 커야 됨 
			//int max=0;
			for(int k=0;k<arr.length;k++) {
				
				int index=i; // MAX의 인덱스 
				for(int j=k;j<arr.length;j++) {
					if(arr[index]<=arr[k]) {
						index=k;
					}
				}
				
				if(arr[index]!=arr[k]) //312 1=>321 
				{
					int temp=arr[index];//위치교환 
					arr[index]=arr[k];
					arr[k]=temp;
					N--; //교환횟수 감소 
					
					ArrayList<Integer> alNum=check[temp];
					alNum.add(index);
					if(alNum.size()>1) {
						Collections.sort(alNum);
						for(int m=0;m<alNum.size();m++) {
							int max=alNum.get(k);
							for(int t=k;t<alNum.size();t++) {
								if(arr[max]<arr[alNum.get(t)]) {
									max=alNum.get(t);
								}
							}
							int tempN=arr[alNum.get(k)];
							arr[alNum.get(k)]=arr[max];
							arr[max]=tempN;
						}
					}
				}
			}
			HashSet<Integer> set=new HashSet(Arrays.asList(arr));
			if(N%2==1 && set.size() ==arr.length) {
				int O=arr[arr.length-1];
				arr[arr.length-1]=arr[arr.length-2];
				arr[arr.length-2]=O;
			}

			System.out.print("#" + T + " ");
			for (int G = 0; G < arr.length; G++) {
				System.out.print(arr[i]);
			}
			System.out.println();
		}

	}
}
