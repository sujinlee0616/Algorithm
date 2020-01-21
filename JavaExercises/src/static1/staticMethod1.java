package static1;
class Print{
	public static void a(String delimiter) { // 2. 메소드가 클래스의 소속일 때는 static을 붙여줘야 
		System.out.println(delimiter);
		System.out.println("a");
		System.out.println("a");
	}
	public static void b(String delimiter) {
		System.out.println(delimiter);
		System.out.println("b"); 
		System.out.println("b");
	}
}
public class staticMethod1 {
	public static void main(String[] args) {
		Print.a("-"); // 1. 메소드 a는 클래스인 Print의 소속으로 실행되고 있음 
		Print.b("*");
	}

}

