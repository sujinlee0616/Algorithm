package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class boj_q11723_2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Integer> list=new ArrayList<Integer>();
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String[] arr=new String[n];
		
		for(int i=0;i<n;i++) {
			String command=br.readLine();
			System.out.println(command);
			
			if(command.startsWith("add")) {
				//int num=Integer.parseInt(command.substring(4));
				//add(list,num);
				System.out.println("add");
			}
			/*
			 * else if(command.equals("remove")) { int num=sc.nextInt(); remove(list,num); }
			 * else if(command.equals("check")) { int num=sc.nextInt(); check(list,num);
			 * System.out.println(check(list,num)); } else if(command.equals("toggle")) {
			 * int num=sc.nextInt(); toggle(list,num); } else if(command.equals("all")) {
			 * all(list); } else if(command.equals("empty")) { empty(list); }
			 */
				
		}
	}
	
	
	public static void all(ArrayList<Integer> list) {
		list.clear(); // 모두 제거 
		
		for(int i=1;i<=20;i++) // 1~20 원소 추가 
			list.add(i);
	}
	
	public static void empty(ArrayList<Integer> list) {
		list.clear(); // 모두 제거 
	}
	
	public static void add(ArrayList<Integer> list, int num) {
		if(!list.contains(num))
			list.add(num);
	}
	
	public static void remove(ArrayList<Integer> list, int num) {
		if(list.contains(num))
			for(int i=0;i<list.size();i++)
				if(list.get(i).equals(num))
					list.remove(i);
	}
	
	public static int check(ArrayList<Integer> list, int num) {
		if(list.contains(num)) return 1;
		else return 0;
	}
	
	public static void toggle(ArrayList<Integer> list, int num) {
		if(list.contains(num)) {
			for(int i=0;i<list.size();i++)
				if(list.get(i).equals(num))
					list.remove(i);
		}
		else
			list.add(num);
	}
}
