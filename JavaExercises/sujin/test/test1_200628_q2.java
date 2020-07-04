package test;

import java.util.Scanner;
import java.util.StringTokenizer;

public class test1_200628_q2 {
	
	public static void main(String[] args) {
		// 입력 받음  
		Scanner sc=new Scanner(System.in);
		
		// 입력 형태 - ["d@co@m.com", "a@abc.com", "b@def.com", "c@ghi.net"]	
		String emails=sc.nextLine();

		String[] arr=emails.split(",");
		
		// 입력 처리 
		for(int i=0; i<arr.length; i++) {
			arr[i]=arr[i].substring(2,arr[i].length()-1);
			//System.out.println("arr["+i+"]="+arr[i]);
		}
		arr[arr.length-1]=arr[arr.length-1].substring(0,arr[arr.length-1].length()-1);
		//System.out.println("arr["+(arr.length-1)+"]"+arr[arr.length-1]);
		
		// 유효성 검사
		// 1. 끝 세 글자가 com, net, org 중 하나
		// 2. 이름 체크 - 영문 소문자와 .로만 구성되며 길이가 1 이상이어야
		// 3. 도메인 체크 - 영문 소문자로만 구성되며 길이가 1 이상이어야
		String[] check=new String[arr.length];
		String[] name=new String[arr.length];
		String[] domain=new String[arr.length];
		
		for(int i=0; i<arr.length; i++) {
			// 1. 이름 부분과 도메인 부분으로 나눠본다 - @없어서 못 나누면 잘못된 이메일임. 
			if(arr[i].indexOf("@")==-1) {
				check[i]="WRONG";
			}
			
			else {
				name[i]=arr[i].substring(0,arr[i].indexOf("@"));
				//System.out.println("name["+i+"]="+name[i]);
				
				domain[i]=arr[i].substring(arr[i].indexOf("@"),arr[i].length());
				//System.out.println("domain["+i+"]="+domain[i]);
				
				// 2. 이름 부분 유효성 체크 
				if(name[i].length()<1) {
					check[i]="WRONG";
					System.out.println("check["+i+"]=WRONG");
				}
				if(name[i].equalsIgnoreCase(name[i])) {
				}
				else {
					check[i]="WRONG";
				}
				
				// 3. 도메인 부분 유효성 체크 
				int do_leng=domain[i].length();
				String last4letters=domain[i].substring(do_leng-4,do_leng);
				//System.out.println("last4letters="+last4letters);
				if(last4letters.equals(".com") || last4letters.equals(".net") || last4letters.equals(".org")) {
				}
				else {
					check[i]="WRONG";
				}
			}
			
			
		}
		
		// check[i]의 원소 개수 세라 
		int proper_emails=0;
		int wrong_emails=0;
		for(int i=0; i<arr.length; i++) {
			if(check[i]=="WRONG")
				wrong_emails++;
			proper_emails=arr.length-wrong_emails;
		}
		//System.out.println("emails="+arr.length);
		//System.out.println("wrong_emails="+wrong_emails);
		//System.out.println("proper_emails="+proper_emails);
		System.out.println(proper_emails);
		
	}
	
}







