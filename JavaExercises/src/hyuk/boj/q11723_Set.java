package hyuk.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q11723_Set {
	public static List<Integer> arr = new ArrayList<Integer>();
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static String[] operator = {"add","remove","check","toggle","all","empty"};
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String[] a = (br.readLine()).split(" ");
			int op = 0;
			for(int j = 0; j < operator.length; j++) {
				if(a[0].equals(operator[j])) {
					op = j; break;
				}
			}
			switch(op) {
			case 0: add(Integer.parseInt(a[1])); break;
			case 1: remove(Integer.parseInt(a[1])); break;
			case 2: check(Integer.parseInt(a[1])); break;
			case 3: toggle(Integer.parseInt(a[1])); break;
			case 4: all(); break;
			case 5: empty(); break;
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static boolean find(int a) {
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i) == a) {
				return true;
			}
		}
		return false;
	}
	public static void add(int a) {
		if(find(a)) {
			return;
		}
		arr.add(a);
	}
	public static void remove(int a) {
		if(find(a)) {
			arr.remove(arr.indexOf(a));
		}
	}
	public static void check(int a) throws IOException{
		if(find(a)) {
			//System.out.println(1);
			bw.write("1");
		} else {
			//System.out.println(0);
			bw.write("0");
		}
		bw.newLine();
	}
	
	public static void toggle(int a) {
		if(find(a)) {
			remove(a);
		} else {
			add(a);
		}
	}
	
	public static void all() {
		empty();
		for(int i = 1; i <= 20; i++) {
			arr.add(i);
		}
	}
	public static void empty() {
		arr.clear();
	}
}
