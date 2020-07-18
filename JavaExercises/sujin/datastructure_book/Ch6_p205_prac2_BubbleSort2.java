package datastructure_book;

// 버블정렬 - 버전2(개선)
// : 어떤 패스에서 요소의 교환 횟수가 0이면 더 이상 정렬할 요소가 없다는 뜻이므로 멈추면 됨 
public class Ch6_p205_prac2_BubbleSort2 {

	// 버블정렬 - 버전2(개선) 
	static void bubleSort(int[] a, int n) {
		for(int i=0;i<n-1;i++) {
			int exchg=0;
			for(int j=n-1;j>i;j--)
				if(a[j-1]>a[j]) {
					swap(a,j-1,j);
					exchg++;
				}
			if(exchg==0) break;
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
