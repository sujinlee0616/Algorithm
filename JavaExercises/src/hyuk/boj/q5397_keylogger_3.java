package hyuk.boj;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

public class q5397_keylogger_3 {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			KeyLocker2 kl = new KeyLocker2();
			StringBuffer input = new StringBuffer(br.readLine()); 
			for(int j = 0; j < input.length(); j++) {
				if(input.charAt(j) == '<') {
					kl.left();
				}else if(input.charAt(j) == '>') {
					kl.right();
				}else if(input.charAt(j) == '-') {
					kl.backSpace();
				}else {
					kl.inputString(input.charAt(j));
				}
			}
			
			StringBuffer sb = new StringBuffer();
			for(int j = 0; j < kl.list.size(); j++) {
				sb.append(kl.list.get(j));
			}
			System.out.println(sb);
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}

class KeyLocker2 {
	public LinkedList<Character> list;
	private int pos;
	
	public KeyLocker2() {
		pos = 0;
		list = new LinkedList<Character>();
	}
	
	public void left() {
		if(pos != 0) {
			pos--;
		}
	}
	
	public void right() {
		if(pos < list.size()) {
			pos++;
		}
	}
	
	public void backSpace() {
		if(pos != 0) {
			list.remove(--pos);
		}
	}
	
	public void inputString(Character a) {
		list.add(pos++, a);
	}
}
