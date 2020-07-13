package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class boj_q10820 {
/*
 문자열 분석
 50' 
 nextLine (X) / BufferedReader 사용해야 되는 이유 이해 
 코테 2 참고 
 */
	public static void main(String[] args)throws IOException {
		//Scanner scan=new Scanner(System.in);
		//int N=scan.nextInt(); + nextLine()
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str=""; //선언 EOF 헤맴. 
		while((str=br.readLine())!=null) {
			
			int count[]=new int[4]; //소/대/숫/공 
			
			for(int i=0;i<str.length();i++) {
				//small letter
				if(str.charAt(i)>='a'&&str.charAt(i)<='z') 
					count[0]+=1; //1씩 더해 
				
				//capital
				if(str.charAt(i)>='A'&&str.charAt(i)<='Z') 
					count[1]+=1; 
				
				//number
				if(str.charAt(i)>='0'&&str.charAt(i)<='9') 
					count[2]+=1; //1씩 더해 
				
				//blank 
				if(str.charAt(i)==' ')  //contains(" ")는 틀림 -true로 무한 찍음 !
					count[3]+=1; //1씩 더해 
				
			}
			
			for(int i:count)
			{
				bw.write(i);
			}
			bw.write('\n');
				
			bw.flush(); //다음으로 넘어갈 때 비워줘야 함. (재사용) 
			
		} //while종료   닫으면 안되는 이유 , = 다음 라인 읽어야 함 
		//br.close();
		//bw.close();
		
	}
}
