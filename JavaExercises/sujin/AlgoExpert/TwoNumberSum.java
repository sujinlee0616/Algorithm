package AlgoExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 푸는 중 
public class TwoNumberSum {
	
	// local test 
	public static int[] arr = {3,5,-4,8,11,1,-1,6};
	public static int ts = 10;
	public static int[] answer = new int[2];
	
	public static int[] twoNumberSum(int[] array, int targetSum) {
	    // Write your code here.
		int n = array.length;
		
		// 두 수씩 돌아가면서 더해보자 
		for(int i=0; i<n; i++) {
			for(int j=n-1; j>-1; j--) {
				int a = array[i] + array[j];
				if(a==ts) {
					answer[0] = array[i];
					answer[1] = array[j];
				}
			}
		}
		
	    return new int[0];
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// local test
		Scanner sc = new Scanner(System.in);
		System.out.println(twoNumberSum(arr, ts));
		
	}

}


