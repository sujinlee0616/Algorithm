package hyuk.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q11723_Set_Test {
	
	private static List<Integer> list;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		//int M = scn.nextInt();
		int M = Integer.parseInt(br.readLine());
		list = new ArrayList<Integer>();
		for(int i = 0; i < M; i++) {
			String[] op = (br.readLine()).split(" ");
			int x = 0;
			switch(op[0]) {
			case "add" : x = Integer.parseInt(op[1]); add(x); break;
			case "check" : x = Integer.parseInt(op[1]); check(x); break;
			case "remove" : x = Integer.parseInt(op[1]); remove(x); break;
			case "toggle" : x = Integer.parseInt(op[1]); toggle(x); break;
			case "all" : all(); break;
			case "empty" : empty(); break;
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static void add(int a) {
		if(search(a) != -1) return;
		list.add(a);
	}
	private static void remove(int a) {
		if(list.size() == 0) return;
		int index = 0;
		if((index = search(a)) != -1) {
			list.remove(list.get(index));
		}
	}
	private static void check(int a) throws IOException{
		int index = search(a);
		if(index == -1) bw.write("0");
		else bw.write("1");
		bw.newLine();
		
	}
	private static void toggle(int a) {
		int index = search(a);
		if(index == -1) {
			list.add(a);
		} else {
			list.remove(list.get(index));
		}
	}
	private static void all() {
		list.clear();
		for(int i = 1; i <= 20; i++) {
			list.add(i);
		}
	}
	private static void empty() {
		list.clear();
	}
	private static int search(int a) {
		for(int i = 0; i < list.size(); i++) {
			if(a == list.get(i)) return i;
		}
		return -1;
	}
}
