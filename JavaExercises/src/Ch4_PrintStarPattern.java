import java.util.Scanner;
public class Ch4_PrintStarPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the number of rows.");
		int rows=scan.nextInt();
		System.out.println("Enter the number of colums.\n(¡Ø Some of the patterns may not apply the number of column to exactly obey the pattern rule.)");
		int columns=scan.nextInt();
		
		
		// Pattern #1 - Rectangle
		
		// #1-1. Solid Rectangle	
		for(int i=1;i<=rows;i++) {
			for(int j=1;j<=columns;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		// #1-2. Hollow Rectangle
		for(int i=1;i<=rows;i++) {
			if(i==1||i==rows) { //First & last row : ****..** (Full of *s)
				for(int j=1;j<=columns;j++) {
					System.out.print("*");
				}
			}
			else { // Other rows : *  ..  *  
				System.out.print("*");
				for(int j=2;j<columns;j++) {
					System.out.print(" ");
				}
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
				
		
		// Pattern #2 - Pyramid
		
		// #2-1. Half Pyramid
		for(int i=1;i<=rows;i++) {
			for(int j=1;j<=i;j++) {
				System.out.printf("%c",'*');
			}
			System.out.println();
		}
		System.out.println();
		
		// #2-2. Inverted Half Pyramid
		for(int i=1;i<=rows;i++) {
			for(int j=rows;j>=i;j--) {
				System.out.printf("%c",'*');
			}
			System.out.println();
		}
		System.out.println();
		
		
		// 12345
		//  678
		//   9
		//  101112
		// 1314151617
		
		
		
		
	}

}
