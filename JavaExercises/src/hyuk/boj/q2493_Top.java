package hyuk.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class q2493_Top {
	public static void main(String[] args) {
		new q2493_Top().service();
	}
	private void service() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuffer sb = new StringBuffer();
			
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer t = new StringTokenizer(br.readLine(), " ");
			int i = 0;
			while(t.hasMoreTokens()) {
				arr[i] = Integer.parseInt(t.nextToken());
				i++;
			}
			
			getTop(arr, sb);
			System.out.println(sb);
			br.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void getTop(int[] arr, StringBuffer sb) {
		Stack<int[]> stack = new Stack<int[]>();
		int len = arr.length;
		for(int i = 0; i < len; i++) {
			while(true) {
				if(stack.size() == 0) {
					stack.push(new int[] {arr[i],i+1});
					sb.append(0 + " ");
					break;
				}else if(stack.peek()[0] <= arr[i]) {
					stack.pop();
				} else {
					sb.append(stack.peek()[1] + " ");
					stack.push(new int[] {arr[i],i+1});
					break;
				}
			}
		}
	}
	
}

