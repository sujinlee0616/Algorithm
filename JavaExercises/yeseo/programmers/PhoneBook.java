package programmers;

public class PhoneBook {
//전화번호 목록 
	public static void main(String[] args) {
		String [] phone_book= {"119", "97674223", "1195524421"};
		Solution(phone_book);
	}
	
	public static boolean Solution(String[] phone_book) {
		int i,j;
		for(i=0;i<phone_book.length-1;i++) {
			for(j=i+1;j<phone_book.length;j++) {
				if(phone_book[i].startsWith(phone_book[j]))
					return false;
				if(phone_book[j].startsWith(phone_book[i]))
					return false;
			}
		}
		return true;
	}
}
