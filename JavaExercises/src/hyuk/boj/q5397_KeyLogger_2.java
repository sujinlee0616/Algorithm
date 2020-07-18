package hyuk.boj;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class q5397_KeyLogger_2 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			MyDoublyLinkedList kl = new MyDoublyLinkedList();
			StringBuffer input = new StringBuffer(br.readLine());
			for (int j = 0; j < input.length(); j++) {
				if (input.charAt(j) == '<') {
					kl.left();
				} else if (input.charAt(j) == '>') {
					kl.right();
				} else if (input.charAt(j) == '-') {
					kl.backSpace();
				} else {
					kl.input(input.charAt(j));
				}
			}
			/*
			for (int j = 0; j < kl.list.size(); j++) {
				bw.write(kl.list.get(j));
			}
			bw.newLine();
			*/
			StringBuffer output = new StringBuffer();
			for(char ch : kl.list) {
				output.append(ch);
			}
			System.out.println(output);
		}

		br.close();
		bw.flush();
		bw.close();
	}
}

class MyDoublyLinkedList {
	public List<Character> list = new LinkedList<Character>();
	public ListIterator<Character> it = list.listIterator();

	public void left() {
		if (it.hasPrevious()) {
			it.previous();
		}
	}

	public void right() {
		if (it.hasNext()) {
			it.next();
		}
	}

	public void backSpace() {
		if (it.hasPrevious()) {
			it.previous();
			it.remove();
		}
	}

	public void input(char c) {
		it.add(c);
	}
}