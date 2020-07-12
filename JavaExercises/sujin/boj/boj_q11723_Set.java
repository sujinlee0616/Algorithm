package boj;

import java.util.ArrayList;
import java.util.Scanner;

// 푸는데 걸린시간: 50분 
// 이클립스에선 수행되는데 백준에선 시간초과남 ==> BufferedReader로 바꿔보자 
// 아래의 연산을 수행하는 프로그램을 작성하시오. 
// add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
// remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
// check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
// toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
// all: S를 {1, 2, ..., 20} 으로 바꾼다.
// empty: S를 공집합으로 바꾼다. 

public class boj_q11723_Set {

	public static void main(String[] args) {
		ArrayList<Integer> list=new ArrayList<Integer>();
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String[] arr=new String[n];
		
		for(int i=0;i<n;i++) {
			String command=sc.next();
			
			if(command.equals("add")) {
				int num=sc.nextInt();
				add(list,num);
			}
			else if(command.equals("remove")) {
				int num=sc.nextInt();
				remove(list,num);
			}
			else if(command.equals("check")) {
				int num=sc.nextInt();
				check(list,num);
				System.out.println(check(list,num));
			}
			else if(command.equals("toggle")) {
				int num=sc.nextInt();
				toggle(list,num);
			}
			else if(command.equals("all")) {
				all(list);
			}
			else if(command.equals("empty")) {
				empty(list);
			}
				
		}
	}
	
	
	public static void all(ArrayList<Integer> list) {
		//list.clear(); // 모두 제거 
		list.removeAll(list);
		
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i));
		
		for(int i=1;i<=20;i++) // 1~20 원소 추가 
			list.add(i);
	}
	
	public static void empty(ArrayList<Integer> list) {
		//list.clear(); // 모두 제거 
		list.removeAll(list);
	}
	
	public static void add(ArrayList<Integer> list, int num) {
		if(!list.contains(num))
			list.add(num);
	}
	
	public static void remove(ArrayList<Integer> list, int num) {
		/*
		 * if(list.contains(num)) for(int i=0;i<list.size();i++)
		 * if(list.get(i).equals(num)) list.remove(i);
		 */
		
		// num이라는 값을 list에서 제거하라 - 이러면 for문을 안 쓸 수 있음!!! 
		// list.indexOf(num)값을 변수에 저장하고 쓰는게 더 효율적 <== 두 번 검색하지 않도록 
		// list에 num이 없으면 list.indexOf(num) 값은 -1을 리턴함 
		int index=list.indexOf(num);
		if(index!=-1) // list에 num이 있으면 
			list.remove(index); // 제거 
		
		// remove 주의! remove(num)은 list에서 num을 제거하는 게 아니라, 
		// list에서 인덱스가 num인 애를 제거하는 것임. 
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
