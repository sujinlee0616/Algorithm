package presentation;

public class Recursive_BinarySearch {

	
	//0123[4]5678
	 // s       e 
	public static int binarySearch(int []arr,int start, int end, int value) {
		if(start>end)
			return -1; 
		else if(start==end) {
			if(arr[start]==value)
				return start;
			else 
				return -1; //종료 
			
		}else {
			int mid=(start+end)/2;  
			if(arr[mid]==value)
				return mid; //한번에 맞았다 
			else if(arr[mid]>value) //left = >  0 3 
				return binarySearch(arr, start, mid-1, value);
			else 
				return binarySearch(arr, mid+1, end, value);
		}
	}
	
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5,6,7,8,9};
		System.out.println(binarySearch(arr, 0, arr.length-1, 3));
	}
}
