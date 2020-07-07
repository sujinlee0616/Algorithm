package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class boj_2503 {
 /*
  숫자야구
  스트라이크 개수/볼의 개수 
  */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		List<Type> list=new ArrayList<>();
		for(int i=0;i<N;i++) {
			list.add(new Type(sc.nextInt(),sc.nextInt(),sc.nextInt()));
		}
		
		int count=0;
		for(int i=100;i<987;i++) {
			if(i/100==0 || (i%100)/10==0 || (i%100)%10==0)
				continue;
			if(i/100==(i%100)/10 ||(i%100)%10==i/100 ||(i%100)/10==(i%100)%10)
				continue;
			
			boolean check=false;
			for(int j=0;j<N;j++) {
				int s=0;
				int b=0;
				int temp=list.get(j).yagu;
				int A=temp/100;
				int B=(temp%100)/10;
				int C=(temp%100)%10; 
				if(i/100==A) {
					s++;
				}else if(i/100==C || i/100==B) {
					b++;
				}
				if((i%100)/10 ==B) {
					s++;
				}else if((i%100)/10==A || (i%100)/10==C) {
					b++;
				}
				
				if(list.get(j).s==s && list.get(j).b==b) {
					continue;
				}else {
					check=true;
					break;
				}
			}
			if(!check) {
				count++;
			}
			
		}
		System.out.println(count);
	}
	
	static class Type{
		int yagu,s,b;
		
		public Type(int yagu,int s,int b) {
			this.yagu=yagu;
			this.s=s;
			this.b=b;
		}
		
		@Override
		public String toString() {
			return yagu+",s"+s+",b"+b;
		}
	}
	
	
	
}
