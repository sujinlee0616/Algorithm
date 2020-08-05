package datastructure_book;

import java.util.Scanner;

//import javafx.scene.transform.Scale;

public class Ch2_p91_practice14 {
	
	static final int VMAX=21;
	
	static class PhyscData{
		String name; // 이름 
		int height; // 키 
		double vision; // 시력 
		
		// 생성자
		PhyscData(String name, int height, double vision){
			this.name=name;
			this.height=height;
			this.vision=vision;
		}
	}
	
	// 키의 평균값을 구함 
	static double avgHeight(PhyscData[] dat) {
		double sum=0;
		for(int i=0;i<dat.length;i++)
			sum+=dat[i].height;
		return sum/dat.length;
	}
	
	// 시력 분포를 구함
	static void distVision(PhyscData[] dat, int[] dist) {
		int i=0;
		dist[i]=0;
		for(i=0;i<dat.length;i++)
			if(dat[i].vision>=0.0 && dat[i].vision<=VMAX/10.0)
				dist[(int)(dat[i].vision*10)]++;
		// dist[3]: 시력이 0.3인 사람의 수를 말함 
		
		/* for(int j=0;j<dist.length;j++)
			System.out.println("dist["+j+"]="+dist[j]);
		*/ 
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		PhyscData[] x= {
				new PhyscData("박현규", 162, 0.3),
				new PhyscData("함진아", 173, 0.7),
				new PhyscData("최윤미", 175, 2.0),
				new PhyscData("홍연의", 171, 1.5),
				new PhyscData("이수진", 168, 0.4),
				new PhyscData("김영준", 174, 1.2),
				new PhyscData("박용규", 169, 0.8),
		};
		int[] vdist=new int[VMAX]; 
		
		// 사람들 신체정보 데이터 출력 
		System.out.println("<신체검사 리스트>");
		System.out.println("이름    키    시력 ");
		for(int i=0;i<x.length;i++)
			System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
		System.out.printf("\n평균키: %5.1fcm\n", avgHeight(x));
		
		// 시력분포 출력 
		distVision(x, vdist);
		System.out.println("\n시력분포 ");
		for(int i=0;i<VMAX;i++)
			System.out.printf("%3.1f~:%2d명\n", i/10.0, vdist[i]);
		
	}
}







