package static3;
class Print{
	public String delimiter;
	public void a() { // 1. 인스턴스 메소드 
		System.out.println(this.delimiter);
		System.out.println("a");
		System.out.println("a");
	}
	public static void c(String delimiter) { // 2. 클래스 메소드(static 메소드)
		System.out.println(delimiter);
		System.out.println("c");
		System.out.println("c");
	}
}

public class staticMethod3 {
	public static void main(String[] args) {
		// 1. 인스턴스 메소드 : 반드시 객체를 생성해야만(new) 호출 가능 
		Print t1 = new Print();
		t1.delimiter="-";   
		t1.a(); 

		// 2. 클래스 메소드 (static 메소드)
		Print.c("*");
		// - 메서드 앞에 static 이 붙어 있으면 클래스 메서드 
		// - 클래스 메서드도 클래스 변수처럼 객체를 생성하지 않고 '클래스 이름.메서드이름(매개변수)'와 같이 호출 가능 
	}
}


