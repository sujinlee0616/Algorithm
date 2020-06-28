package hyuk.presentation;

public class TestCase_PrimeNumber {
	public static void main(String[] args) {
		int size = 100000;
		
		int prime = 997;
		System.out.println("start");
		System.out.println(size);
		for(int i = 0; i < size; i++) {
			System.out.print(prime + " ");
			if(i%100 == 0 && i != 0) {
				System.out.println();
			}
		}
		System.out.println("end");
	}
}
