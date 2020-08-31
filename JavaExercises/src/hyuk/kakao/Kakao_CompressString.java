package hyuk.kakao;

public class Kakao_CompressString {
	public static void main(String[] args) {
		String s = "a";
		int ans = new Kakao_CompressString().solution(s);
		System.out.println(ans);
	}
	public int solution(String s) {
        int answer = 987654321;
        
        int count = 0;
        
        int N = s.length();
        String cur= ""; 
        String next = "";
        for(int i = 1; i <= N/2; i++) {
        	StringBuilder sbAns = new StringBuilder();
        	cur = getCur(i,0,s);
        	int j = 0;
        	count = 0;
        	for(j = 0; j+i <= N; j+= i ) {
        		next = getCur(i,j,s);
        		if(cur.equals(next)) {
        			count++;
        		} else {
        			if(count > 1) {
        				sbAns.append(count);
        			}
        			sbAns.append(cur);
        			cur = next;
        			count = 1;
        		}
        	}
        	if(count > 1) {
        		sbAns.append(count);
        	}
        	sbAns.append(cur);
        	for(int k = j; k < N; k++) {
        		sbAns.append(s.charAt(k));
        	}
        	answer = min(answer,sbAns.length());
        }
        if(answer == 987654321) return 1;
        return answer;
    }
	private int min(int a, int b) {
		if(a > b)	return b;
		return a;
	}
	private String getCur(int len, int start, String s) {
		StringBuilder sb = new StringBuilder();
		for(int i = start; i < start + len; i++) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
}
