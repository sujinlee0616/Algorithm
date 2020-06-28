package yeseo_incorrect_note;

import java.util.Scanner;

public class boj_q1978 {
	 /*
	  *  소수찾기 
	  *  1회 - 30' 2회 - 20' 
	  *  count++ 과정의 런타임 오류 
	  *  경계값 분석을 늘 유의 
	  */

	 public static boolean isPrime(int num) {
		 	boolean result = true;
		 	if(num<2) { 
		 		result = false; 
		 	}
	        for(int i = 2; i < num; i++) {
	            if( num%i == 0) {
	                result = false;
	                break; 
	            } else {
	                result = true;
	          
	            }
	        }        
	        return result;        
	    }
	    

	    public static boolean isPrime2(int num) {
	        boolean result = true;
	        int end = num/2;
	        for(int i = 2; i <= end; i++) {
	            if( num%i == 0) {
	                result = false;
	                break;
	            } else {
	                result = true;
	            }
	        }        
	        return result;        
	    }

	    

	    public static boolean isPrime3(int num) {
	        boolean result = true;
	        int end = (int)Math.sqrt(num);
	        for(int i = 2; i <= end; i++) {
	            if( num%i == 0) {
	                result = false;
	                break; 
	            } else {
	                result = true;
	            }
	        }        
	        return result;        
	    }



	public static void main(String[] args) {
		
		int N;
		Scanner scn=new Scanner(System.in);	
		N=scn.nextInt();	
		int count=0;
		int num[]=new int [N];
		boolean check=false;
		for (int i=0;i<num.length;i++)
		{		
			num[i]=scn.nextInt();
		}
		
		for (int i=0;i<num.length;i++)
		{
			boolean result=isPrime(num[i]); //t/f
			if(result==true)count++;
		}
		System.out.println(count);
		
	}
}
