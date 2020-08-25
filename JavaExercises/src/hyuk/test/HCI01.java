package hyuk.test;

import java.util.Scanner;

public class HCI01 {
	public static void main(String[] args) {
		new HCI01().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		String input = scn.next();
		if(isCase1(input))
			System.out.println(1);
		else if(isCase2(input))
			System.out.println(2);
		else if(isCase3(input))
			System.out.println(3);
		else
			System.out.println(-1);
		
		scn.close();
	}
	private boolean isLength(String arr, int len) {
		if(arr.length() == len) return true;
		return false;
	}
	private boolean isHyphen(String arr, int[] pos) {
		for(int i = 0; i < pos.length; i++) {
			if(arr.charAt(pos[i]) != '-') {
				return false;
			}
		}
		return true;
	}
	private boolean isNumber(String arr, int start, int len) {
		for(int i = start; i < start + len; i++) {
			if(arr.charAt(i) < '0' || arr.charAt(i) > '9') return false;
		}
		return true;
	}
	private boolean isStarter(String arr, String starter) {
		for(int i = 0; i < starter.length(); i++) {
			if(arr.charAt(i) != starter.charAt(i)) return false;
		}
		return true;
	}
	private boolean isCase1(String arr) {
		if(! isLength(arr, 13)) return false;
		if(! isStarter(arr, "010")) return false;
		if(! isHyphen(arr, new int[] {3,8})) return false;
		if(! isNumber(arr, 4, 4)) return false;
		if(! isNumber(arr, 9, 4)) return false;
		return true;
	}
	private boolean isCase2(String arr) {
		if(! isLength(arr, 11)) return false;
		if(! isStarter(arr, "010")) return false;
		if(! isNumber(arr, 3, 4)) return false;
		if(! isNumber(arr, 7, 4)) return false;
		return true;
	}
	private boolean isCase3(String arr) {
		if(! isLength(arr, 16)) return false;
		if(! isStarter(arr, "+82-10-")) return false;
		if(! isHyphen(arr, new int[] {11})) return false;
		if(! isNumber(arr, 7, 4)) return false;
		if(! isNumber(arr, 12, 4)) return false;
		return true;
	}
}
