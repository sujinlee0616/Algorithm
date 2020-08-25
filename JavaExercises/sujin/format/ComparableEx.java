package format;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableEx {
	public static void main(String[] args) {
		ArrayList<Book> list = new ArrayList<Book>();
		list.add(new Book("총균쇄", "제레미 다이아몬드", "문학사상", 2005));
		list.add(new Book("총균쇄", "제레미 다이아몬드", "문학사상", 2000));
		list.add(new Book("파타고니아, 파도가 칠 때는 서핑을", "이본 쉬나드", "라이팅하우스", 2020));
		list.add(new Book("파타고니아, 파도가 칠 때는 서핑을", "이본 쉬나드", "라이팅하우스", 2010));
		list.add(new Book("코스모스", "칼 세이건", "사이언스북스", 2010));
		list.add(new Book("코스모스", "칼 세이건", "사이언스북스", 2001));
		list.add(new Book("죽은 자의 집 청소", "김완", "김영사", 2020));
		list.add(new Book("동물농장", "조지 오웰", "민음사", 2007));
		list.add(new Book("동물농장", "조지 오웰", "민음사", 1988));
		list.add(new Book("침묵의 봄", "레이첼 카슨", "에코리브르", 2011));
		list.add(new Book("불안", "알랭 드 보통", "은행나무", 2012));
		list.add(new Book("불안", "알랭 드 보통", "은행나무", 2018));
		list.add(new Book("싯다르타", "헤르만 헤세", "민음사", 2002));
		list.add(new Book("싯다르타", "헤르만 헤세", "민음사", 2005));
		list.add(new Book("호모데우스", "유발 하라리", "김영사", 2017));
		Collections.sort(list);
		
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i).getYear()+", "+list.get(i).getTitle());
		
		Book book01 = new Book("가가가", "이씨", "C출판사", 2001);
		Book book02 = new Book("나나나", "김씨", "B출판사", 1923);
		Book book03 = new Book("다다다", "나씨", "D출판사", 2015);
		Book book04 = new Book("라라라", "최씨", "Z출판사", 2015);
		// int compareTo(T o) : 해당 객체와 전달된 객체의 순서를 비교함.
		
		// ex1) 출간년도 오름차순  
		//System.out.println(book01.compareTo(book02)); // ex1) 2001 > 1923 ==> return 1  
		//System.out.println(book02.compareTo(book03)); // ex1) 1923 < 2015 ==> return -1  
		//System.out.println(book03.compareTo(book04)); // ex1) 1923 == 2015 ==> return 0  
		
		// ex2) 책 제목 사전 순 
		//System.out.println(book01.getTitle().compareTo(book02.getTitle())); // ex3) 가가가 < 나나나 ==> return -1176  ==> 자리 바꾸지X
		//System.out.println(book03.getTitle().compareTo(book02.getTitle())); // ex3) 다다다 > 나나나 ==> return 588 ==> 자리 바꾸지O
		//System.out.println(book04.getTitle().compareTo(book04.getTitle())); // ex3) 라라라 == 라라라 ==> return 0 ==> 자리 바꾸지X
	}
}


// [Comparable]
// - 정렬 수행 시 "기본적으로 적용되는 정렬(오름차순, 사전순)"의 기준이 되는 메서드를 정의하는 인터페이스
//   ==> 기본 정렬(오름차순, 사전순)이 아닌 정렬(내림차순, 사전역순)은 Comparable이 아니라 Comparator를 이용하여 구현한다. 
// - 정렬할 객체에 Comparable interface를 implements 후, compareTo() 메서드를 오버라이드하여 구현한다. 
// - Java에서 제공되는 정렬이 가능한 클래스들은 모두 Comparable 인터페이스를 구현하고 있으며, 정렬 시에 이에 맞게 정렬이 수행된다.
//   ex) Integer, Double 클래스: 오름차순 정렬.  String 클래스: 사전순 정렬. 

// [Comparable 인터페이스가 사용하는 메소드]
// - int compareTo(T o)
//   ==> public int compareTo(T) 메소드를 구현하고 내부에서 비교처리 후 int형 리턴으로 비교 결과를 리턴한다.

// [compareTo() 메서드 작성법]
// - 현재 객체 < 파라미터로 넘어온 객체: 음수 리턴 ==> 자리 바뀌지X
//   현재 객체 == 파라미터로 넘어온 객체: 0 리턴 ==> 자리 바뀌지X
//   현재 객체 > 파라미터로 넘어온 객체: 양수 리턴 ==> 자리 바뀌지O
// - 음수 또는 0이면 객체의 자리가 그대로 유지됨. 양수일 경우 두 객체의 자리가 바뀐다. 

class Book implements Comparable<Book> {
    private String title;
    private String author;
    private String company;
    private int year;

    public Book(String a, String b, String c, int d) {
		this.title = a;
		this.author = b;
		this.company = c;
		this.year = d;
	}
    
    public String getTitle() {
		return title;
	}
    
    public int getYear() {
		return year;
	}

    // ex1) 출판년도(year) 오름차순 
    /* 
    public int compareTo(Book obj) {
        if (this.year == obj.year) { // 현재 객체 == 파라미터로 넘어온 객체 ==> 0 리턴 
            return 0; 
        } else if(this.year < obj.year) { // 현재 객체 < 파라미터로 넘어온 객체 ==> 음수 리턴  ==> 자리 바뀌지 X ==> 오름차순 
            return -1; 
        } else { // 현재 객체 > 파라미터로 넘어온 객체 ==> 양수 리턴 ==> 자리 바뀌지 O ==> 오름차순  
            return 1;
        }
    }
    */
    
    // ex2) 책 제목 사전 순 
    /*
	public int compareTo(Book o) {
        int res = this.getTitle().compareTo(o.getTitle());
        return res;
    }
    */

	// ex3) 책 제목 사전순으로. 책 제목이 같을 경우, 출간년도 오름차순으로. <== 보통 이렇게 정렬 조건 추가하는 경우에는 Comparator 더 많이 쓰는듯...
	public int compareTo(Book o) {
        int res = this.getTitle().compareTo(o.getTitle());
        if(res==0) 
        	res = this.getYear() - o.getYear();
        	// 현재 객체 출판년도 > 파라미터로 넘어온 객체 출판년도 ==> 양수 리턴 ==> 자리 바뀌지 O ==> 오름차순 
        return res;
    }
    
}
