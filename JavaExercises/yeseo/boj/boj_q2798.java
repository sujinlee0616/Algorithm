package boj;

import java.util.LinkedList;
import java.util.Scanner;

public class boj_q2798 {

	//블랙잭 
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int N=scn.nextInt();
		int M=scn.nextInt();
		
		LinkedList<Integer> num= new LinkedList<>();
		int total=0;
		int max=0;
		for(int i=0;i<N;i++) {
			num.add(scn.nextInt());
		}
		
		
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				for(int k=j+1;k<N;k++) {
					if(num.get(i)+num.get(j)+num.get(k)>=max&&num.get(i)+num.get(j)+num.get(k)<=M) {
					max=num.get(i)+num.get(j)+num.get(k);
					}
				}
			}
		}
	total=max;
	System.out.println(total);
	}
	
	
}
