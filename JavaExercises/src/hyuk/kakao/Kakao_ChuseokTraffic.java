package hyuk.kakao;

public class Kakao_ChuseokTraffic {
	public static void main(String[] args) {
		String[] lines = {"2016-09-15 01:00:04.001 2.0s", 
				"2016-09-15 01:00:07.000 2s"};
		int ans = new Kakao_ChuseokTraffic().solution(lines);
		System.out.println(ans);
	}

	public int solution(String[] lines) {
		int answer = 0;

		int len = lines.length;
		int[][] arr = new int[len][2];
		for (int i = 0; i < len; i++) {
			int time = getTime(lines[i]);
			int pTime = getPTime(lines[i]);
			arr[i][0] = time - pTime + 1;
			arr[i][1] = time;
		}

		for (int i = 0; i < len; i++) {
			int count = 0;
			int a = arr[i][1];
			int b = arr[i][1] + 1000 -1;
			
			for (int j = 0; j < len; j++) {
				if (arr[j][1] < a || arr[j][0] > b)
					continue;
				count++;
			}
			answer = max(answer, count);
		}

		return answer;
	}

	private int getTime(String line) {
		int ans = 0;
		String[] times = line.split(" ");
		String[] end = times[1].split(":");
		ans += Integer.parseInt(end[0]) * 3600 * 1000;
		ans += Integer.parseInt(end[1]) * 60 * 1000;
		String[] endSecond = end[2].split("\\.");
		ans += Integer.parseInt(endSecond[0]) * 1000;
		ans += Integer.parseInt(endSecond[1]);
		return ans;
	}

	private int getPTime(String line) {
		int ans = 0;
		String[] times = line.split(" ");
		times[2] = times[2].substring(0,times[2].length()-1);
		String[] seconds = times[2].split("\\.");
		int len = seconds.length;
		for (int i = 0; i < len; i++) {
			if (i == 0) {
				ans += Integer.parseInt(seconds[i]) * 1000;
			} else if (i == 1) {
				ans += Integer.parseInt(seconds[i]);
			}
		}
		return ans;
	}

	private int max(int a, int b) {
		if (a > b)
			return a;
		return b;
	}
}
