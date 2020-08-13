package programmers;

import java.util.Arrays;

public class q42577_phoneNumber2 {
	
	public static void main(String[] args) {
		// String[] phone_book = {"119", "97674223", "1195524421"};
		// String[] phone_book = {"123", "456", "789"};
		String[] phone_book = {"12", "123", "1235", "567", "88"};
		System.out.println(solution(phone_book));
	}
	
	public static boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);
        boolean result = true;
        for (int i=0; i<phoneBook.length-1; i++) {
            if (phoneBook[i+1].contains(phoneBook[i])) {
                result = false;
                break;
            }
        }
        return result;
    }
}
