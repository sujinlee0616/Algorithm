package hyuk.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HCI02 {
	public static void main(String[] args) {
		try {
			new HCI02().service();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void service() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		int count = 0;
		for(int i = 0; i < N; i++) {
			if(isFormat(arr[i])) {
				count++;
			}
		}
		System.out.println(count);
		br.close();
	}
	private boolean isFormat(String str) {
		int gCount = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '@') {
				gCount++;
			}
		}
		if(gCount > 1) return false;
		String[] splitedName = str.split("@");// @hello@hello
		if(splitedName.length != 2) return false; // 골뱅이가 1개 들어간게 아니면 false
		if(splitedName[0].length() < 1) return false; // 이름파트의 길이가 1보다 작으면 false
		for(int i = 0; i < splitedName[0].length(); i++) { //이름에 소문자 또는 .외의 글자가 들어갔을 때
			if(!(splitedName[0].charAt(i) >= 'a' && splitedName[0].charAt(i) <= 'z' || splitedName[0].charAt(i) == '.')) return false;
		}
		String[] splitedDomain = (splitedName[1]).split("\\."); // 도메인과 탑레벨 도메인 분리
		int dCount = 0;
		for(int i = 0; i < splitedName[1].length(); i++) {
			if(splitedName[1].charAt(i) == '.') {
				dCount++;
			}
		}
		if(dCount > 1) return false;
		if(splitedDomain.length != 2) return false; // 만약, .이 1개가 아니라면 false
		if(splitedDomain[0].length() < 1) return false; //도메인의 길이가 1보다 작으면 false
		for(int i = 0; i < splitedDomain[0].length(); i++) { //도메인에 소문자가 아닌 것이 들어가면 false
			if(!(splitedDomain[0].charAt(i) >= 'a' && splitedDomain[0].charAt(i) <= 'z')) return false;
		}
		String[] topDomain = {"com","org","net"}; // 같으면 정답이 될 탑도메인네임
		boolean isTopDomain = false; 
		for(int i = 0; i < topDomain.length; i++) {
			if(topDomain[i].equals(splitedDomain[1])) isTopDomain = true; // 하나라도 같으면 오케이!
		}
		if(isTopDomain == false) return false;
		System.out.println(str + " = true");
		return true;
	}
}
