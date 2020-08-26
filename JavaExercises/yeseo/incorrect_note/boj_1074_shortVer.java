package incorrect_note;
import java.util.*;
public class boj_1074_shortVer {
//Z 
	// N^2 keep N^4 pass 
	//Divide And Conquer
	public static void main(String[]v){
		
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int r=scan.nextInt();
		int c=scan.nextInt();
		
		int y,k;
		int a=0;
		
		int[][]count={{0,1},{2,3}};
		int[][]skip={{0,0},{0,1},{1,0},{1,1}};
		
		
		while(N-->0){
			
			y=(int)Math.pow(2,N);
			a+=y*y*(k=count[y>r?0:1][y>c?0:1]);
			r-=y*skip[k][0];
			c-=y*skip[k][1];
		}
		System.out.print(a);
	}
	
}
