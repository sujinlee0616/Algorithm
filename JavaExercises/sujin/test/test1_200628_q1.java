package test;

import java.util.Scanner;
import java.util.StringTokenizer;

public class test1_200628_q1 {
    //유형 1 : 010-XXXX-XXXX
    //유형 2 : 010XXXXXXXX
    //유형 3 : +82-10-XXXX-XXXX
	
	 public static int solution(String phone_number) {
		 int answer = -1;
		 int length=phone_number.length();
		
		// 유형1 - 13글자. 앞에가 '010-'으로 시작.
		 if(length==13) {
			 String ch1=phone_number.substring(0,4);
			 String ch2=phone_number.substring(8,9);
			 if(ch1.equals("010-") && ch2.equals("-")) {
				 answer=1;
			 }
		 }
		 
		// 유형2 - 11글자. -랑 + 없음. 
		 if(length==11) {
			 int loc1=phone_number.indexOf("-");
			 int loc2=phone_number.indexOf("+");
			 if(loc1==-1 && loc2==-1) {
				 answer=2;
			 }
		 }
		 
		// 유형3 - 16글자. +있음.
		 if(length==16) {
			 String ch3=phone_number.substring(0,7);
			 String ch4=phone_number.substring(11,12);
			 if(ch3.equals("+82-10-") && ch4.equals("-")) {
				 answer=3;
			 }
		 }
		 
		 System.out.println(answer);
	     return answer;
	}
	 
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
	    String phone_number=sc.next();
	    solution(phone_number);
		 
	}

}
