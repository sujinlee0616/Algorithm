package presentation;

public class TreeNode {

	private TreeNode left;
	private TreeNode right;
	private Object data;
	
	public TreeNode(Object item) {
		left=null;
		right=null;
		data=item;
	}
	 //자신과 왼쪽 자식 노드(sub)와 연결해주는 method

		public void makeLeftSubTree(TreeNode sub){

	   if(this.left != null) this.left = null;

			this.left = sub;

		}

		

	 //자신과 오른쪽 자식 노드(sub)와 연결해주는 method

		public void makeRightSubTree(TreeNode sub){

	   if(this.right != null) this.right = null;

			this.right = sub;

		}

		

	 //자신의 data를 반환하는 함수

		public Object getData(){

	  return this.data;

		}

		

	 //자신의 왼쪽 자식노드를 반환하는 함수

		public TreeNode getLeftSubTree(){

	  return this.left;

		}

		

	 //자신의 오른쪽 자식노드를 반환하는 함수

		public TreeNode getRightSubTree(){

			return this.right;
		}

		public static void main(String[] args) {

				TreeNode bt1 = new TreeNode(1);

				TreeNode bt2 = new TreeNode(2);

				TreeNode bt3 = new TreeNode(3);

				TreeNode bt4 = new TreeNode("song");

				

				bt1.makeLeftSubTree(bt2);

				bt1.makeRightSubTree(bt3);

				bt2.makeLeftSubTree(bt4);

				

				//bt1의 왼쪽 자식노드의 데이터 출력

				System.out.println(bt1.getLeftSubTree().getData());

				//bt1의 오른쪽 자식노드의 데이터 출력

				System.out.println(bt1.getRightSubTree().getData());

		}
	  
}
