package boj;

import java.util.Arrays;
import java.util.Scanner;
//오름차순 문제   

public class boj_q2750_ascending_compare {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
			//System.out.println(arr[i]);
		}
		
		for(int i=0;i<n-1;i++) {
			for(int j=1; j<n-i; j++) {
				if(arr[i]>arr[i+j]) {
					int temp=arr[i];
					arr[i]=arr[i+j];
					arr[i+j]=temp;
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			System.out.println(arr[i]);
		}
		
	}
}
