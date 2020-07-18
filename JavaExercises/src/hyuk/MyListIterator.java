package hyuk;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MyListIterator {
	public static void main(String[] args) {
		
		
		List<Integer> list = new LinkedList<Integer>();
		ListIterator<Integer> it = list.listIterator();
		System.out.println(it.hasPrevious());
		it.add(1);
		it.add(2);
		System.out.println(it.hasPrevious());
		it.previous();
		it.previous();
		System.out.println(it.next());
		it.remove();
		System.out.println("ok : " + it.hasNext());
		System.out.println(it.next());
		it.add(2); // 끝에 추가하기
		if(it.hasPrevious()) {
			it.previous();
		}
		it.add(3);
		while(it.hasPrevious()) {
			it.previous();
		}
		while(it.hasNext()) {
			System.out.print(it.next());
		}
		System.out.println();
		
		it.remove();
		
		while(it.hasPrevious()) {
			it.previous();
		}
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		//2까지 입력받고, 추가
		
		
		list.add(3);
		list.add(4);
		list.add(5);
	}
}
