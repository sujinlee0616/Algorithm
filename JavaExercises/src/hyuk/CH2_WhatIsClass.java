package hyuk;


public class CH2_WhatIsClass {
	static final int VMAX = 21; // 0.0부터 시작해서 0.1씩 증가한튼 분포로, 총 21개라는 뜻

	/* ^^
	 * 클래스의 특징. 1. static을 붙여서 (1) static 키워드를 사용해서 선언한 자원들은 JVM 메모리 안에 오직 하나만 생성된다.
	 * (2) 메모리 로딩 과정에서 static으로 선언된 자원들은 인스턴스화 과정 없이 실행 가능한 형태로 메모리에 바로 생성된다. 2. 다양한
	 * 데이터타입을 한 클래스에 저장할 수 있다. 3. 클래스 안에 클래스를 생성할 수 있다(nested class)
	 */
	static class PhyscData {
		String name;
		int height;
		double vision;

		/*
		 * 생성자 : 클래스를 처음 인스턴스를 만들 때, 또는 메모리에 올릴 때 한번만 수행되는 메소드
		 */
		PhyscData(String name, int height, double vision) {
			this.name = name;
			this.height = height;
			this.vision = vision;
		}
	}
	
	/*
	 * 평균을 구하는 메서드
	 * 로직 : dat배열의 각 원소의 height를 모두 sum이라는 변수에 더해서 저장
	 *      dat 길이로 나눈 sum을 리턴
	 */
	static double aveHeight(PhyscData[] dat) {
		double sum = 0;
		
		for(int i = 0; i < dat.length; i++) {
			sum += dat[i].height;
		}
		
		return sum / dat.length;
	}
	
	/*
	 * 시력 분포 구하기
	 * 로직 : 1. 먼저, 데이터가 0.0~ VMAX/10.0으로 유효성 검사를 하고,
	 *      2. dist라는 배열의 해상 시력을 가리키는 인덱스(0.1이라면 0.1*10 = 1)를 더해서, 해당 분포에 몇명인지 누적한다.
	 */
	static void disVision(PhyscData[] dat, int[] dist) {
		int i = 0;
		
		dist[i] = 0; // 왜? 
		for(i = 0; i < dat.length; i++) {
			if(dat[i].vision >= 0.0 && dat[i].vision <= VMAX / 10.0) {
				dist[(int)(dat[i].vision*10)]++;
			}
		}
	}
}
