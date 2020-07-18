package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_q1181_Sort_String {
	
	// 아직 다 못풀었음. 
	// 1. 길이가 짧은 것부터
	// 2. 길이가 같으면 사전 순으로 
	// 3. 같은 단어가 여러번 입력된 경우에는 한 번만 출력 
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String[] arr=new String[n];
		int[] leng=new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.next();
			leng[i]=arr[i].length();
		}
		
		// 1. 길이에 따라 정렬했음 
		bubbleSort(leng, arr, n);
		
		
		// 2. 알파벳 순으로 정렬해야함 
		//bubbleSort2(arr,n);
		
		// 결과 확인 
		for(int i=0;i<n;i++) {
			System.out.println("arr["+i+"]="+arr[i]);
			//System.out.println("leng["+i+"]="+leng[i]);
		}
		
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0;i<n;i++)
			list.add(arr[i]);
		
		removeDuplicatedNumber(list, n);
		
		// 확인
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i));
	}
	
	
	public static void removeDuplicatedNumber(ArrayList<String> a, int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-1-i;j++) {
				if(a.get(i).equals(a.get(i+j)))
					a.remove(a.get(i));
			}
		}
	}
	
	public static void bubbleSort2(String[] a, int n) {
		for(int i=0;i<n-1;i++) {
			for(int j=n-1;j>i;j--) {
				
				int leng1=a[j].length();
				int leng2=a[j].length();
				
				if(leng1==leng2) {
					for(int k=0;k<leng1;k++) {
						if(a[j-1].charAt(k)>a[j].charAt(k)) {
							swap(a, j-1, j);
						}
					}
				}
				
			}
		}
	}

	public static void bubbleSort(int[] leng, String[] arr, int n) {
		for(int i=0;i<n-1;i++)
			for(int j=n-1;j>i;j--)
				if(leng[j-1]>leng[j]) {
					swap(leng, j-1, j); 
					swap(arr, j-1, j);
				}
					
	}
	
	// 값을 바꾼다 
	public static void swap(int[] a, int idx1, int idx2) {
		int t=a[idx1];
		a[idx1]=a[idx2];
		a[idx2]=t;
	}
	
	public static void swap(String[] a, int idx1, int idx2) {
		String s=a[idx1];
		a[idx1]=a[idx2];
		a[idx2]=s;
	}
	
}
