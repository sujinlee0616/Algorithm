package yeseo_boj;

import java.util.Scanner;

public class boj_q3052 {

	public static void main(String[] args) {
		

		Scanner scn=new Scanner(System.in);
		// count ++;  	
		
		int a[]=new int[10];
		for(int i=0;i<a.length;i++)
			a[i]=scn.nextInt();
		
		boolean[] arr=new boolean[42];
		
		int rest[]=new int [10];
		for(int i=0;i<a.length;i++)
		{
			rest[i]=a[i]%42;
			System.out.println("The rest="+rest[i]);
			arr[rest[i]]=true;
		}
		
		int cnt=0;
		for(boolean v:arr)
		{
			if(v) {
				cnt++;
			}
		}
		System.out.println(cnt);

		
	}
}
