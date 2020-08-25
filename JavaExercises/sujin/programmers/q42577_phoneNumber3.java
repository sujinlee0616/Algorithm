package programmers;

public class q42577_phoneNumber3 {
	
	public static void main(String[] args) {
		// String[] phone_book = {"119", "97674223", "1195524421"};
		// String[] phone_book = {"123", "456", "789"};
		String[] phone_book = {"12", "123", "1235", "567", "88"};
		System.out.println(solution(phone_book));
	}
	
	public static boolean solution(String[] phoneBook) {
		for (int i = 0; i < phoneBook.length - 1; i++) {
			for (int j = i + 1; j < phoneBook.length; j++) {
				if (phoneBook[i].startsWith(phoneBook[j])) 	return false;
				if (phoneBook[j].startsWith(phoneBook[i]))	return false;
			}
		}
		return true;
	}

}
