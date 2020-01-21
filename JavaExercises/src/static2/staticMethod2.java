package static2;
class Print{
	public String delimeter;
	public void a() { // 2. 메소드가 인스턴스의 소속일 때는 static을 빼줘야 
		System.out.println(this.delimeter);
		System.out.println("a");
		System.out.println("a");
	}
	public void b() {
		System.out.println(this.delimeter);
		System.out.println("b");
		System.out.println("b");
	}
}

public class staticMethod2 {
	public static void main(String[] args) {
		Print t1 = new Print();
//			 ===   ============
//			 인스턴스		Print 클래스를 복제 
		t1.delimeter="-";   
		t1.a(); // 1. 메소드 a는 t1이라는 인스턴스의 소속으로써 실행되고 있음 
		t1.b();
		
		Print t2 = new Print();
		t2.delimeter="*";
		t2.a();
		t2.b();
	}
}

