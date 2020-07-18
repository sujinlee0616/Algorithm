package presentation;
import java.util.*;
public class HashSet {

	   public static void main(String[] args) {

	//Hash set
	/*
	 *    구현 계획 :
	 *           1. Hash 자료구조를 구현한다(input 데이터 형태는 int로 가정)
	 *             -> Hash Table, Hash Function 구현
	 *           2. Hash 자료구조에서 add 메서드를 만드는데,
	 *             -> 먼저 탐색 메서드를 만들어서 True이면 무시, False이면 add
	 *           3. Hash 자료구조에서 remove 메서드를 만드는데,
	 *             -> 탐색 메서드를 통해 True이면 삭제, False이면 무시
	 *           특징 : Hash Chaining으로 구현하여, remove를 많이 수행해도 
	 *               Table에 찌꺼기가 남지 않게 한다
	 */

	// Node는, 배열로 존재하는데, 각 원소를 list로 하여 chaining을 구현한다
	class Node {
	   private List<Integer> list;
	   
	   public Node() {
	      list = new ArrayList<Integer>();
	   }
	   public List<Integer> getList() {
	      return list;
	   }
	   public void setList(List<Integer> a) {
	      list = a;
	   }
	}

	class MyHashSet {
	   // table과 size
	   private Node[] table;
	   private int size;
	   
	   //생성자 : 넉넉하게 2배 크기로 table을 만든다
	   public MyHashSet(int size) {
	      this.size = size*2;
	      table = new Node[this.size];
	   }
	   
	   // hash function 구현해보기
	   public int hashFunc(int data) {
	      int res = ((data << 5) * (size-1) + 72) % size;
	      return res;
	   }
	   
	   // add 만들어보기
	   public boolean add(int data) {
	      int res = hashFunc(data); // hash 함수로 key를 얻어옴
	      // table에서 해당 위치의 Node를 가져온다
	      Node target = table[res];
	      if(target == null) {
	         target = new Node();
	      }
	      //가져온 Node의 List에서 값이 있나 본다
	      int len = target.getList().size();
	      for(int i = 0; i < len; i++) {
	         if(target.getList().get(i) == data) {
	            return false;
	         }
	      }
	      target.getList().add(data);
	      table[res] = target;
	      return true;
	   }
	   
	   // remove 만들어보기
	   public boolean remove(int data) {
	      int res = hashFunc(data); // hash 함수로 key를 얻어옴
	      Node target = table[res];
	      if(target == null) {
	         return false;
	      }
	      int len = target.getList().size();
	      for(int i = 0; i < len; i++) {
	         if(target.getList().get(i) == data) {
	            target.getList().remove(i);
	            return true;
	         }
	      }
	      return false;
	   }
	   
	   public boolean search(int data) {
	      int res = hashFunc(data); // hash 함수로 key를 얻어옴
	      Node target = table[res];
	      if(target == null) {
	         return false;
	      }
	      int len = target.getList().size();
	      for(int i = 0; i < len; i++) {
	         if(target.getList().get(i) == data) {
	            return true;
	         }
	      }
	      return false;
	   }
	   
	   //모든 것을 출력하는 메서드
	   public void print() {
	      for(int i = 0; i < size; i++) {
	         if(table[i] != null) {
	            System.out.print("[");
	            for(int j = 0; j < table[i].getList().size(); j++) {
	               System.out.print(table[i].getList().get(j) + " ");
	            }
	            System.out.println("]");
	         }
	      }
	   }
	}
 }
}
