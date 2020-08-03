package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

// 다른 방법으로 탑 풀어보기 
// - test case는 맞지만 시간초과남. 

public class boj_q2493_tower4 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
		// 1. 탑의 수 
		int n = Integer.parseInt(bf.readLine());
		// 2. 탑들의 높이값을 저장 
		int[] arr=new int[n+1]; // 
		String s=bf.readLine();
		String[] s2=s.split(" ");
		
		for (int i=1; i<=n; i++) { // 1부터 n까지 
			arr[i]=Integer.parseInt(s2[i-1]);
			//System.out.println("arr["+i+"]="+arr[i]);
		}
		
		ArrayList<String> reversed_res=new ArrayList<String>();
		
		for(int i=n;i>=1;i--) {
			//System.out.println("=======i="+i+"=======");
			if(i==1) {
				reversed_res.add("0");
				break;
			}
			for(int j=i-1;j>=1;j--) {
				//System.out.println("j="+j);
				if(arr[i] < arr[j]) {
					//System.out.println("arr["+i+"] < arr["+j+"]");
					reversed_res.add(Integer.toString(j));
					break;
				}
				if(j==1) {
					reversed_res.add("0");
				}
			}
		}
		
		
		// reversed_res(뒤집힌 결과)를 뒤집어서 똑바른 결과를 출력하게 만들자. 
		for(int i=reversed_res.size()-1;i>=0;i--) {
			System.out.print(reversed_res.get(i)+" ");
		}
		
	}
	
}
