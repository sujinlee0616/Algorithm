package boj;

import java.util.Scanner;

public class q11650_3 {

	// 완료. 약 2시간 걸린 듯. 
	// 병합정렬로 y좌표 먼저 정렬한 후 x좌표 정렬하는 방식으로 풀어보겠음.
	// 더 깔끔하게 푸는 방법이 있을 것 같은데..... -_-
	// 기존의 병합정렬을 응용해서 풀었는데... 깔끔하지 않다...
	
	static int[] buff1; // 작업용 배열
	static int[] buff2;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] x=new int[n];
		int[] y=new int[n];
		
		for(int i=0;i<n;i++) {
			x[i]=sc.nextInt();
			y[i]=sc.nextInt();
		}
		
		mergeSort(y,x,n); // y좌표 정렬하고 x좌표는 정렬X.  x좌표는 그냥 셋트인 y좌표가 행 바뀌면 같이 따라가기만 함. 
		mergeSort(x,y,n); // x좌표 정렬하고 y좌표는 정렬X.  y좌표는 그냥 셋트인 x좌표가 행 바뀌면 같이 따라가기만 함. 
		
		for(int i=0;i<n;i++) {
			System.out.print(x[i]+" ");
			System.out.print(y[i]);
			System.out.println();
		}
		
	}
	
	// a[left]~a[right]를 재귀적으로 병합 정렬
	// a를 정렬함. b는 걍 따라가는 애.
	static void __mergeSort(int[] a, int[] b, int left, int right) {
		if(left<right) {
			int i1;
			int i2;
			int center=(left+right)/2;
			
			int p1=0;
			int j1=0;
			int k1=left;
			
			int p2=0;
			int j2=0;
			int k2=left;
			
			__mergeSort(a, b, left, center); // 배열의 앞부분을 병합정렬 
			__mergeSort(a, b, center+1, right); // 배열의 뒷부분을 병합정렬 
			
			for(i1=left;i1<=center;i1++) {
				buff1[p1]=a[i1];
				p1++;
			}
			for(i2=left;i2<=center;i2++) {
				buff2[p2]=b[i2];
				p2++;
			}
				
			while(i1<=right && j1<p1) {
				if(buff1[j1]<=a[i1]) {
					a[k1++]=buff1[j1++];
					b[k2++]=buff2[j2++];
				}
				else {
					a[k1++]=a[i1++];
					b[k2++]=b[i2++];
				}
			}
				
			while(j1<p1) {
				a[k1++]=buff1[j1++];
				b[k2++]=buff2[j2++];
			}
				
		}
	}
	
	// 병합정렬 
	static void mergeSort(int[] a, int[] b, int n) {
		buff1=new int[n]; // 작업용 배열 생성 
		buff2=new int[n]; 
		
		__mergeSort(a,b,0,n-1); 
		
		buff1=null; // 작업용 배열 해제 
		buff2=null; 
	}
	

	
}
