package CodeTest;

import java.util.Scanner;

public class Q1 {
/*
전화번호 유효값  
 */

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);

		String phone_number=scn.next();
			if(solution1(phone_number)) {
				System.out.println(1);
			}else if(solution2(phone_number)) {
				System.out.println(2);
			}else if(solution3(phone_number)) {
				System.out.println(3);
			}else {
				System.out.println(-1);
			}
		
		
	}
	private static boolean solution1(String phone_number) {
		
		String front="010-";
		if(phone_number.length()!=13) {
			return false;
		}
		if(phone_number.indexOf(front)!=0) { // 0번째부터 010- 시작되지 않는다면  
			return false;
		}
		for(int i=4;i<8;i++) {
			if(phone_number.charAt(i)<'0'||phone_number.charAt(i)>'9') { //숫자가 아니라
				return false;
			}
		}
		if(phone_number.charAt(8)!='-') {
			return  false;
		}
		//숫자가 안들어 올 경우 
		for(int i=9;i<13;i++) {
			if(phone_number.charAt(i)<'0'||phone_number.charAt(i)>'9') { 
				return false;
			}
		}
		return true;
		
	}
	
	private static boolean solution2(String phone_number) {
		String front="010";
		if(phone_number.length()!=11) {
			return false;
		}
		if(phone_number.indexOf(front)!=0) {
			return false;
		}
		for(int i=3;i<11;i++) {
			if(phone_number.charAt(i)<'0'||phone_number.charAt(i)>'9') { 
				return false;
			}
		}
		return true;
	}
	
	private static boolean solution3(String phone_number) {
		String front="+82-10-";
		if(phone_number.length()!=16) {
			return false;
		}
		if(phone_number.indexOf(front)!=0) {
			return false;
		}
		for(int i=7;i<11;i++) {
			if(phone_number.charAt(i)<'0'||phone_number.charAt(i)>'9') {
				return false;
			}
		}
		return true;
	}
	
	
	
}
