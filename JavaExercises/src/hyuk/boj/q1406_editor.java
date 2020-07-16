package hyuk.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class q1406_editor {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException{
		String input = br.readLine();
		int M = Integer.parseInt(br.readLine());
		Editor e = new Editor();
		
		for(int i = 0; i < input.length(); i++) {
			e.add(input.charAt(i));
		}
		
		for(int i = 0; i < M; i++) {
			String[] operation = br.readLine().split(" ");
			switch(operation[0]) {
			case "P": e.add(operation[1].charAt(0)); break;
			case "L": e.left(); break;
			case "D": e.right(); break;
			case "B": e.backSpace(); break;
			}
		}
		StringBuffer sb = new StringBuffer();
		/*
		for(int i = 0; i < e.list.size(); i++) {
			sb.append(e.list.get(i));
		}
		*/
		/*
		for(char ch : e.list) {
			sb.append(ch);
		}
		*/
		int len = e.list.size();
		e.it = e.list.listIterator();
		while(e.it.hasNext()) {
			sb.append(e.it.next());
		}
		System.out.println(sb);
	}
}

class Editor {
	public List<Character> list = new LinkedList<Character>();
	public ListIterator<Character> it = list.listIterator();
	
	public void left() {
		if(it.hasPrevious()) {
			it.previous();
		}
	}
	public void right() {
		if(it.hasNext()) {
			it.next();
		}
	}
	public void backSpace() {
		if(it.hasPrevious()) {
			it.previous();
			it.remove();
		}
	}
	public void add(Character c) {
		it.add(c);
	}
}