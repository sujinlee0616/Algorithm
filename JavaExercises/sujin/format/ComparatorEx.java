package format;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorEx {

	public static void main(String[] args) {
		ArrayList<Book2> list = new ArrayList<Book2>();

		list.add(new Book2("다다다", "나씨", "D출판사", 2015));
		list.add(new Book2("파타고니아 파도가 칠 때는 서핑을", "이본 쉬나드", "라이팅하우스", 2020));
		list.add(new Book2("파타고니아 파도가 칠 때는 서핑을", "이본 쉬나드", "라이팅하우스", 2010));
		list.add(new Book2("코스모스", "칼 세이건", "사이언스북스", 2010));
		list.add(new Book2("코스모스", "칼 세이건", "사이언스북스", 2001));
		list.add(new Book2("가가가", "이작가", "C출판사", 2001));
		list.add(new Book2("가가가가가가", "이작가", "C출판사", 2001));
		list.add(new Book2("파파파파파파", "이작가", "C출판사", 2001));
		list.add(new Book2("니니니니니", "이작가", "C출판사", 2001));
		list.add(new Book2("리리리리리", "이작가", "C출판사", 2001));
		list.add(new Book2("마마마", "이작가", "C출판사", 2001));
		list.add(new Book2("하하하", "이작가", "C출판사", 2001));
		list.add(new Book2("나나나", "김씨", "B출판사", 1923));
		list.add(new Book2("죽은 자의 집 청소", "김완", "김영사", 2020));
		list.add(new Book2("2050 거주불능 지구", "데이비드 월러스 웰즈", "추수밭", 2020));
		list.add(new Book2("1984", "조지 오웰", "민음사", 2007));
		list.add(new Book2("침묵의 봄", "레이첼 카슨", "에코리브르", 2011));
		list.add(new Book2("라라라", "제레미 다이아몬드", "문학사상", 2005));
		list.add(new Book2("마마마", "제레미 다이아몬드", "문학사상", 2000));
		list.add(new Book2("불안", "알랭 드 보통", "은행나무", 2012));
		list.add(new Book2("싯다르타", "헤르만 헤세", "민음사", 2002));
		list.add(new Book2("호모데우스", "유발 하라리", "김영사", 2017));
		
		// ex1) 제목 사전 역순 
		Collections.sort(list, new DescTitle());
		for(int i=0; i<list.size(); i++)
			System.out.printf(list.get(i).getYear()+", "+list.get(i).getTitle()+", "+list.get(i).getAuthor()+", "+list.get(i).getCompany()+"\n");
		System.out.println("=====================================");
		
		// ex2) 출간년도 내림차순
		Collections.sort(list, new DescYear());
		for(int i=0; i<list.size(); i++)
			System.out.printf(list.get(i).getYear()+", "+list.get(i).getTitle()+", "+list.get(i).getAuthor()+", "+list.get(i).getCompany()+"\n");
		
		// ex3) 저자 사전역순 
		Collections.sort(list, new DescAuthor());
		for(int i=0; i<list.size(); i++)
			System.out.printf(list.get(i).getYear()+", "+list.get(i).getTitle()+", "+list.get(i).getAuthor()+", "+list.get(i).getCompany()+"\n");
		System.out.println("=====================================");
		
		// ex4) 출간년도 사전역순
		Comparator<Book2> MyComparator = new Comparator<Book2>() {
		    @Override
		    public int compare(Book2 o1, Book2 o2) {
		        return (o1.getYear() - o2.getYear()) * (-1);
		    }
		};
		Collections.sort(list, MyComparator);
		for(int i=0; i<list.size(); i++)
			System.out.printf(list.get(i).getYear()+", "+list.get(i).getTitle()+", "+list.get(i).getAuthor()+", "+list.get(i).getCompany()+"\n");
		System.out.println("=====================================");
		
		// ex5) 출판사 사전역순
		Collections.sort(list, new Comparator<Book2>() {
			@Override
		    public int compare(Book2 o1, Book2 o2) {
		        return (o1.getCompany().compareTo(o2.getCompany())) * (-1);
		    }
		});
		for(int i=0; i<list.size(); i++)
			System.out.printf(list.get(i).getYear()+", "+list.get(i).getTitle()+", "+list.get(i).getAuthor()+", "+list.get(i).getCompany()+"\n");
		System.out.println("=====================================");

		
		// ex6) 기준1: 출간년도 최신순. 기준2: 출간년도가 같다면, 제목 글자수 내림차순. 기준3: 출간년도, 제목 글자수 같다면, 제목 사전역순
		Collections.sort(list, new Comparator<Book2>() {
			@Override
			public int compare(Book2 o1, Book2 o2) {
				int res = (o1.getYear() - o2.getYear()) * (-1);
				if(res == 0) 
					res = (o1.getTitle().length() - o2.getTitle().length()) * (-1);
				if(res == 0)
					res = (o1.getTitle().compareTo(o2.getTitle())) * (-1);
				return res;
			}
		});
		for(int i=0; i<list.size(); i++)
			System.out.printf(list.get(i).getYear()+", "+list.get(i).getTitle()+", "+list.get(i).getAuthor()+", "+list.get(i).getCompany()+"\n");
		System.out.println("=====================================");
	}
	
}

// [Comparator]
// - 기본 정렬기준 외에 다른 기준(ex. 내림차순, 사전역순 등)으로 정렬하고자 할 때 사용 
//   ex) JAVA에서 기본제공하는 Reference Type을 내가 원하는대로 정렬하고 싶을때 (예시 : 내림차순, 사전역순, 특정 조건 추가하여 정렬)
//   ex) 기존에 구현된 Comparable의 정렬과는 다른 결과를 얻고 싶을 때
// - Arrays.sort() 혹은 Collections.sort()에 두번째 인자로 Comparator 구현체를 전달해주면 된다.
//   ex) Collections.sort(list, MyComparator);
//   ex) Arrays.sort(arr, new Comparator<Student>() {
//			  @Override
//			  public int compare(Student o1, Student o2) {
//    		  		return o1.getAge() - o2.getAge();
//			  }
//		 });
// - 이렇게 별도 Comparator를 구현하는 경우 Comparator의 compare메소드의 처리 결과를 기준으로 정렬하게 된다.

// [Comparator 인터페이스가 사용하는 메소드]
// - int compare(T o1, T o2) : 전달된 두 객체의 순서를 비교함.
// - boolean equals(Object obj) : 해당 comparator와 전달된 객체가 같은지를 확인함.
// - default Comparator<T> reversed() : 해당 comparator의 역순인 comparator를 반환함.

class Book2 {
    private String title;
    private String author;
    private String company;
    private int year;

    public Book2(String a, String b, String c, int d) {
		this.title = a;
		this.author = b;
		this.company = c;
		this.year = d;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getCompany() {
		return company;
	}

	public int getYear() {
		return year;
	}
}


// ex1) 제목 사전 역순 
class DescTitle implements Comparator<Book2>{	
	public int compare(Book2 o1, Book2 o2) {
		int res = (o1.getTitle().compareTo(o2.getTitle())) * (-1);
		return res;
	}
}

// ex2) 출간년도 내림차순
class DescYear implements Comparator<Book2>{	
	public int compare(Book2 o1, Book2 o2) {
		return (o1.getYear() - o2.getYear()) * (-1);
	}
}

// ex3) 저자 사전 역순 
class DescAuthor implements Comparator<Book2>{	
	public int compare(Book2 o1, Book2 o2) {
		return (o1.getAuthor().compareTo(o2.getAuthor())) * (-1);
	}
}


