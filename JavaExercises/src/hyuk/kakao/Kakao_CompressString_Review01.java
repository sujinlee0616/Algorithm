package hyuk.kakao;

public class Kakao_CompressString_Review01 {
	public static void main(String[] args) {
		String s = "xababcdcdababcdcd";
		int ans = new Kakao_CompressString_Review01().solution(s);
		System.out.println(ans);
	}
	private int solution(String s) {
		int len = s.length();
		int answer = s.length();
		
		
		for(int i = 1; i <= len/2; i++) {
			StringBuilder sb = new StringBuilder();
			int count = 0;
			String cur = getString(s,0,i);
			int j = 0;
			for(j = 0; j +i <= len; j += i) {
				String next = getString(s,j,i);
				if(cur.equals(next)) count++;
				else {
					if(count > 1) sb.append(count);
					sb.append(cur);
					count = 1;
					cur = next;
				}
			}
			if(count > 1) sb.append(count);
			sb.append(cur);
			String rest = getString(s,j,len-j);
			sb.append(rest);
			answer = min(answer, sb.length());
		}
		
		return answer;
	}
	private String getString(String s, int start, int len) {
		StringBuilder res = new StringBuilder();
		for(int i = start; i < start + len; i++) {
			res.append(s.charAt(i));
		}
		return res.toString();
	}
	private int min(int a, int b) {
		if(a > b)	return b;
		return a;
	}
}
