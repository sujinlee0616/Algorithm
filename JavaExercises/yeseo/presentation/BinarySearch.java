package presentation;

/*
이진 탐색
= 정렬된 데이터를 반씩 나누어 중간값과 찾으려는 대상값의 비교 작업을 반복하는 것 
= 반으로 나누어 찾는다는 의미 
0 [1] 23 [4] 5678
 s		  b	
 
특징)
-아주 빠르다
원소의 특징) 
-검색하려고 하는 데이터가 정렬되어 있어야 한다 ASC DESC
-고유한 값들을 가져야 한다 (배열로 예시들면 중복되지 않는 값) 

{이를테면, LinkedList에서는 사용이 곤란 <= 순서가 있기 때문에 탐색 지점을 마음대로 건너 뛰지 못함}

시간복잡도)
순차검색 = O(N)
이진탐색 = O(logN) 
; 한번 검색 할 때 마다 탐색 양이 반으로 줄기 때문에 노드개수 N : O(logN)이 걸린다 

코드 구현)
재귀 함수

- array
- start
- end 
 */
	

	//이진 검색 트리를 만드는 법 
	class Tree2{
		class Node{
			int data;
			Node left;
			Node right;
			Node(int data){
				this.data=data;	
			}
		}
		Node root;
		public void makeTree(int []a) {
			root=makeTreeR(a,0,a.length-1);
		}
		public Node makeTreeR(int []a, int start,int end) {
			if(start>end) return null; //재귀 함수를 멈춰라 =종료조건 
			int mid=(start+end)/2;
			Node node=new Node(a[mid]);
			node.left=makeTreeR(a,start,mid-1);
			node.right=makeTreeR(a,mid+1,end);
			return node;
		}

		public void searchBTree(Node n,int find) {
			if(find<n.data) {
				System.out.println("Smaller than"+n.data);
				searchBTree(n.left, find);
			}else if(find>n.data) {
				System.out.println("Bigger than"+n.data);
				searchBTree(n.right, find);
			}else {
				System.out.println("FOUND");
			}
		}
	}
	public class BinarySearch{
		public static void main(String[] args) {
			int []a =new int[10];
			for(int i=0;i<a.length;i++) 
				a[i]=i;
			Tree2 t=new Tree2();
			t.makeTree(a);//트리만들고 
			t.searchBTree(t.root,2);//2찾기 확인 
		}
	}
