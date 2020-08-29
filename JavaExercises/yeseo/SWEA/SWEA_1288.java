package SWEA;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
 
public class SWEA_1288 {
//새로운 불면증 치료법 

	// xN  최소 몇번 에서 0 ~ 9를 다 보게 되는지 찾는 문제
	// tip) (2)의 경우 set사용으로 중복 제거 이미 봤다면 따로 체크 후 리턴 
	// 자리수 숫자 체크가 헷갈림 , 세다가 잠 다 깨겠음
	
	 public static void main(String[] args) {
	        Scanner scan=new Scanner(System.in);
	        int T=scan.nextInt();
	        
	        // (1) Set없이 풀이 (0~9에서 이미 봤는지만 체크) 
	        for(int tc=1;tc<=T;tc++) {

	        	int N=scan.nextInt();

	        	System.out.print("#"+tc+" ");
	        	
	        	
	        	int count=1;
	        	int []num=new int [10];
	        	while(true) {
	        		boolean check=false;
	        		for(int j=0;j<10;j++) {
	        			if(num[j]==0) {
	        				check=true;
	        				break;
	        			}
	        		}
	        		
	        		if(check==false) {
	        			System.out.println((count-1)*N); //xN을 출력함 주의 
	        			break;
	        		}
	        		
	        		String str=String.valueOf(N*count);
	        		for(int j=0;j<str.length();j++) {
	        			int temp=str.charAt(j)-'0';
	        			num[temp]=1;
	        		}
	        		count++;

	        	}
        		
	 
	        }
	        
	        //2) character Set (코드가 짧아질 수 있음) 
	        
	        for (int tc = 1; tc <= T; tc++) {
	            System.out.print("#" + tc + " ");
	            int n = scan.nextInt();
	            int cnt = n;
	            Set<Character> set2 = new HashSet<>();
	            while (true) {
	                char[] arr = String.valueOf(cnt).toCharArray();
	                for (char c : arr) {
	                    set2.add(c);
	                }
	                if (set2.size() == 10) break; 
	                cnt += n;
	            }
	            System.out.println(cnt);
	        }
	        
	       // scan.close();
	        
	    }
	
}
