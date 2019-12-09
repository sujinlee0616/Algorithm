
public class PrintStarPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Pyramid 
		
		// Increase Star Number from 1 to 5 
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.printf("%c",'¡Ú');
			}
			System.out.println();
		}
		
		// Decrease Star Number from 5 to 1
		for(int i=1;i<=5;i++) {
			for(int j=5;j>=i;j--) {
				System.out.printf("%c",'¡Ú');
			}
			System.out.println();
		}
		
	}

}
