package format;

import java.util.Scanner;

// - 병합정렬이 어떻게 나뉘고 합쳐지는지 이미지 생각하면서 코드 짜면 쉬움. 
//   (Youtube: https://www.youtube.com/watch?v=QAyl79dCO_k ) 

public class MergeSort {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr = new int[n];

		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		mergeSort(arr,0,n-1);
		
		// test
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
	}
	
	public static void mergeSort(int[] arr, int start, int end) {
		
		int[] tmp=new int[arr.length]; // 작업용 배열 (임시배열)  
				
		if(start >= end) 
			return;
		
		int mid = (start + end ) / 2;
		mergeSort(arr, start, mid); // 배열의 앞의 절반을 mergeSort
		mergeSort(arr, mid+1, end); // 배열의 뒤의 절반을 mergeSort 
		
		int front_index = start; // 원래 배열의 앞부분 - (현재 비교중인) 인덱스 번호. start로 초기화. 
		int back_index = mid+1; // 원래 배열의 뒷부분 - (현재 비교중인) 인덱스 번호. mid+1로 초기화. 
		int tmp_index = start; // 임시배열 - (현재 비교중인) 인덱스 번호. start로 초기화. 
		
		while(front_index <= mid && back_index <= end) { /// 원래 배열의 앞부분/뒷부분 둘 다 아직 원소 남아 있는 경우 
			if(arr[front_index] <= arr[back_index]) // 배열의 앞부분 첫번째 원소가  배열의 뒷부분 첫번째 원소보다 작으면 
				tmp[tmp_index++] = arr[front_index++]; 
					// 1. 임시배열에다가  배열의 앞부분 첫번째 원소 넣고 (내림차순이니까 작은 수를 넣어야 하니까) 
					// 2. 임시배열의 첫번째 원소 index를 증가시키고(ts++) 배열의 앞부분 첫번째 원소가 다음 인덱스가 되게 한다 (ps++) 
			else // 위의 반대로 하면 됨. 
				tmp[tmp_index++] = arr[back_index++];
		}
		
		while(front_index <= mid) // 원래 배열의 뒷부분의 원소를 모두 사용한 경우 - 즉, pe=end. pe가 end에 도달해버린 경우. 
			tmp[tmp_index++] = arr[front_index++];
			
		while(back_index <= end) // 원래 배열의 앞부분의 원소를 모두 사용한 경우 - 즉, ps=mid. ps가 mid에 도달해버린 경우. 
			tmp[tmp_index++] = arr[back_index++];
		
		for(int i = start; i <= end; i++) 
			arr[i] = tmp[i];
	}

}
