package presentation;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Map;
import java.util.Iterator;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
public class Collection {

	/*
	 Collection 
	 = Container , 여러 원소를 하나의 그룹으로 묶어 관리 
	 
	 JCF 
	 - 컬렉션 표현하고 다루기 위한 프레임워크
	 - 다양한 방식으로 저장,검색,수정,관리하는 도구 제공
	 - 일관된 방법으로 컬렉션을 다룸 
	  	= Interface : 컬렉션 기능표현
	  	= Class : 인터페이스를 구현한클래스 제공 
	  	
	  - Set : 순서는 의미 X, 중복을 허용하지 않는 자료구조
	  - List/Queue : 중복 허용, 순서가 있음 ( 단, Queue 는 FIFO)
	  - Map : 원소가<key,value>의 형태이고 키는 유일함
	  
	   
	  *Iterator<E>인터페이스
	  + 컬렉션에 저장된 원소를 차례대로 다룸
	  + hasNext(), E next(), void remove()  등의 메소드 제공
	  + HashSet, ArrayList,LinkedList등에서 Iterator 객체를 리턴 
	
	 예) 
	 List<String> list=new ArrayList<String>();
	 
	 Iterator<String> it= list.iterator();
	 while(it.hasNext())
	 	System.out.println(it.next());
	 	
	 */
	
	public static void main(String[] args) {
		//LinkedList (Queue)
		LinkedList<String> queue=new LinkedList<>();
		queue.add("ONE");queue.add("TWO");queue.add("THREE");
		String s=queue.poll();  //꺼냄 
		while(s!=null) {
			System.out.println(s);
			s=queue.poll();
		}
		
		//Set
		//- List와 가장 큰 차이는 순서가 없다는 것 .
		Set<String>set=new HashSet<>();
		
		set.add("ONE");set.add("TWO");set.add("THREE");
		System.out.println(set.add(new String("ONE")));
		
		
		System.out.println(set.size()); //3
		System.out.println(set.contains("THREE"));
		System.out.println(set.contains(new String("ONE")));

		set.remove("THREE");
		set.remove(new String("ONE"));
		System.out.println(set.size()); //1 
		
		set.clear();
		System.out.println(set.size()); //0
		
		
		//Map<K,V>
		/*
		 - 하나의 key에 하나의 value만 대응되는 원소를 가지는 컬렉션을 일컬음
		 - V put(K key, V value),V get(Object key),remove ,containsKey, values, keyset ...  
		 - 아래 코드의 경우, 
		 1) List 에 이름 KIM /LEE를 저장 
		 2) Map에 점수를 저장해서 
		 3) 나중에 Value값을 가져올 때 Key값으로 호출하는 것을 알 수 있음 
		 */
		List<String> names=new ArrayList<>();
		Map<String,Integer> lectures;
		Map<String,Map> scores=new HashMap();
		
		names.add("KIM");names.add("LEE");
		
		Iterator<String> it=names.iterator();
		while(it.hasNext()) {
			String name=it.next();
			if(name.equals("KIM")) {
				lectures=new HashMap<String,Integer>();
				lectures.put("KOR", 100);
				lectures.put("ENG",99);
				lectures.put("MATH", 68);
				scores.put(name, lectures);
			}else if(name.equals("LEE")) {
				lectures=new HashMap<String,Integer>();
				lectures.put("KOR", 90);
				lectures.put("ENG",87);
				lectures.put("MATH", 100);
				scores.put(name, lectures);
			}
		}
		
		Iterator<String> it2=names.iterator();
		while(it2.hasNext()) {
			String name=it2.next();
			System.out.println(name);
			
			System.out.print("Korean : ");
			System.out.println(scores.get(name).get("KOR"));
			System.out.print("English : ");
			System.out.println(scores.get(name).get("ENG"));
			System.out.print("Math : ");
			System.out.println(scores.get(name).get("MATH"));
			System.out.println();
			
		}
		
	}
	
	
}
