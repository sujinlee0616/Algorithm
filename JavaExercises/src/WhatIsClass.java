

public class WhatIsClass {
	static final int VMAX = 21; // 0.0���� �����ؼ� 0.1�� ������ư ������, �� 21����� ��

	/*
	 * Ŭ������ Ư¡. 1. static�� �ٿ��� (1) static Ű���带 ����ؼ� ������ �ڿ����� JVM �޸� �ȿ� ���� �ϳ��� �����ȴ�.
	 * (2) �޸� �ε� �������� static���� ����� �ڿ����� �ν��Ͻ�ȭ ���� ���� ���� ������ ���·� �޸𸮿� �ٷ� �����ȴ�. 2. �پ���
	 * ������Ÿ���� �� Ŭ������ ������ �� �ִ�. 3. Ŭ���� �ȿ� Ŭ������ ������ �� �ִ�(nested class)
	 */
	static class PhyscData {
		String name;
		int height;
		double vision;

		/*
		 * ������ : Ŭ������ ó�� �ν��Ͻ��� ���� ��, �Ǵ� �޸𸮿� �ø� �� �ѹ��� ����Ǵ� �޼ҵ�
		 */
		PhyscData(String name, int height, double vision) {
			this.name = name;
			this.height = height;
			this.vision = vision;
		}
	}
	
	/*
	 * ����� ���ϴ� �޼���
	 * ���� : dat�迭�� �� ������ height�� ��� sum�̶�� ������ ���ؼ� ����
	 *      dat ���̷� ���� sum�� ����
	 */
	static double aveHeight(PhyscData[] dat) {
		double sum = 0;
		
		for(int i = 0; i < dat.length; i++) {
			sum += dat[i].height;
		}
		
		return sum / dat.length;
	}
	
	/*
	 * �÷� ���� ���ϱ�
	 * ���� : 1. ����, �����Ͱ� 0.0~ VMAX/10.0���� ��ȿ�� �˻縦 �ϰ�,
	 *      2. dist��� �迭�� �ػ� �÷��� ����Ű�� �ε���(0.1�̶�� 0.1*10 = 1)�� ���ؼ�, �ش� ������ ������� �����Ѵ�.
	 */
	static void disVision(PhyscData[] dat, int[] dist) {
		int i = 0;
		
		dist[i] = 0; // ��? 
		for(i = 0; i < dat.length; i++) {
			if(dat[i].vision >= 0.0 && dat[i].vision <= VMAX / 10.0) {
				dist[(int)(dat[i].vision*10)]++;
			}
		}
	}
}
