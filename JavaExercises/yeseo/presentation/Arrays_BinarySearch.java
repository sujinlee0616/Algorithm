package presentation;

import java.util.Arrays;
import java.util.Comparator;

public class Arrays_BinarySearch {

	public static void main(String[] args) {
		int arr[]= {4,5,6,8,10,39,50};
		int target=10;
		
		//당연히 target을 String으로 잡아도 찾아준다 
		int idx=Arrays.binarySearch(arr, target);
		
		/*
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

		 */
	
		
		

		if(idx==-1)
			System.out.println("구현한 메소드 결과값이 없습니다 ");
		else
			System.out.println(target+"은 " +idx+"에 있습니다 ");
		
		
		//응용) 
		Data[]arrays= {
				new Data("John",170,1.5),
				new Data("Susan",160,0.9),
	            new Data("Jack", 161, 1.4),
	            new Data("Lee", 162, 1.3),
	            new Data("Kim", 163, 1.2),
	            new Data("Ryan", 164, 1.1),
	            new Data("Phillip", 165, 1.0),
	            new Data("Bo", 166, 0.9)
		};
		
		int height=160;
		int idx2=Arrays.binarySearch(arrays, new Data("",height,0.0), Data.HEIGHT_INORDER);
		if(idx2<0) 
			System.out.println("요소가 없다");
		else
			System.out.println(height+"인 사람은 arrays["+idx2+"]에 있습니다 ");
	}
	

	//응용) Comparator사용 
	static class Data{
		private String name;
		private int height;
		private double vision;
		
		public Data(String name,int height,double vision) {
			this.name=name;
			this.height=height;
			this.vision=vision;
		}
		
		public static final Comparator<Data> HEIGHT_INORDER=new HeightOrderComparator();
		public static final Comparator<Data> VISION_INORDER=new VisionOrderComparator();
		

		private static class HeightOrderComparator implements Comparator<Data>{
			public int compare(Data d1, Data d2) {
				return (d1.height>d2.height)? 1:(d1.height<d2.height)?-1:0;
			}
		}
		
		private static class VisionOrderComparator implements Comparator<Data>{
			public int compare(Data d1, Data d2) {
				return (d1.vision>d2.vision)? 1:(d1.vision<d2.vision)?-1:0;
			}
		}
	}
}
