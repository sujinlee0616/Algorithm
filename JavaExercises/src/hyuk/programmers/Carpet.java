package hyuk.programmers;

public class Carpet {
	public static void main(String[] args) {
		
		int brown = 28;
		int yellow = 36;
		int[] answer = new Carpet().solution(brown,yellow);
		System.out.println(answer[0] + "," + answer[1]);
	}
	private int[] solution(int brown, int yellow) {
		int[] answer = {0,0};
		
		if(yellow == 1) {
			answer[0] = 3;
			answer[1] = 3;
			return answer;
		}
		for(int i = 1; i <= yellow/2; i++) {
			if(yellow % i != 0) continue;
			int a = yellow / i;
			int b = yellow / a;
			if(brown == (2*a + 2*b + 4)) {
				answer[0] = a+2;
				answer[1] = b+2;
				return answer;
			}
		}
		return answer;
	}
}
