package datastructure_book;

// 버블정렬 - 버전3(개선)
// : 어떤 시점 이후에 교환이 수행되지 않는다면 그보다 앞쪽의 요소는 이미 정렬을 마친 상태임 
public class Ch6_p207_BubbleSort3 {
	
	// 버블정렬 - 버전3(개선) 
	static void bubleSort(int[] a, int n) {
		int k=0;
		while(k<n-1) {
			int last=n-1;
			for(int j=n-1;j>k;j--)
				if(a[j-1]>a[j]) {
					swap(a,j-1,j);
					last=j;
				}
			k=last;
		}
	}

	static void swap(int[] a, int idx1, int idx2) {
		int t=a[idx1];
		a[idx1]=a[idx2];
		a[idx2]=t;
	}
	
	public static void main(String[] args) {
		int[] a= {3,23,53,22,1,436,32,2,37,6};
		int n=a.length;
		
		System.out.println("========== 정렬 전 ==========");
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
		System.out.println();
		
		bubleSort(a,n);
		System.out.println("========== 정렬 후 ==========");
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
	}
}
