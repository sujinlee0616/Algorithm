package boj;


import java.util.Arrays;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



public class boj_5052 {
/*
전화번호목록 



1. 숫자들을 입력받는다. O 
2. 숫자들을 길이 기준으로 정렬한다 (걍 오름차순으로 정렬하면 됨) O 
3. 중복되는게 없을 때 set에 접두어 넣음  => set.contains(prefix) => NO 
list / array에 넣기 

*charAt + set 
*substring  + 삼항연산



 */
	
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int T=scan.nextInt();
		
		
		for(int i=1;i<=T;i++) {
			int N=scan.nextInt();
			String [] arr=new String[N];
			for(int j=0;j<N;j++) {
				arr[i]=scan.next();
			}
			Arrays.sort(arr);
			Set<String> set=new HashSet<>();
		
			
			int flag=0; 
			for(int a=0;a<N-1;a++) { // -1 까지니까 OverFlow 해결 
				int current=arr[i].length();
				int next=arr[i+1].length();
				if(current<next) {
					if(arr[i].equals(arr[i+1].substring(0,current))) {
						flag=1;
						break;
					}
				}
			}
			System.out.println(flag==1?"NO":"YES");
			
			
			String res="";
			outer: 
				for(i=0;i<N;i++) {
				String prefix="";
				
				for(int j=0;j<arr[i].length();j++) {
					prefix+=arr[i].charAt(j)+" ";
					if(set.contains(prefix)) {
						res="NO";
						break outer;
					}
				
					}
				set.add(arr[i]);
				
				}
			if(!res.equals("NO")) {
				res="YES";
			}
				//System.out.println(res);
			}
		
		}
		
	}


