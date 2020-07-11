package boj;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
//import java.util.Collections;
import java.util.Scanner;

public class boj_q11650 {
//좌표정렬 30' Array(2차원)  > List ,인터페이스 사용법 
	public static void main(String[] args) {
			Scanner scn= new Scanner(System.in);
			int N=scn.nextInt();
			//ArrayList x=new ArrayList();
			//ArrayList y=new ArrayList();
			
			//int x[]=new int [N];
			//int y[]=new int [N];
			
			int arr[][]=new int [N][2];
			for(int i=0;i<N;i++) {				// x length 
				for(int j=0;j<2;j++) { //y length
					arr[i][j]=scn.nextInt();
				}
			}
			
			Arrays.sort(arr, new Comparator<int[]>() {
				//새로 정의된규칙에 의해 
				@Override
				public int compare(int[]x, int[] y) {
					if(x[0]== y[0])		// x0=y0값이 같다면 
						return Integer.compare(x[1],  y[1]); //x1과  y1을 비교
						return Integer.compare(x[0],  y[0]);
				}
				
				
			});
			
			
			for(int i=0; i<N; i++) {
				System.out.println(arr[i][0]+"\t"+arr[i][1]);
			}
		}
			
			
	}

