package pa5;



public class BinaryTree {



	protected Node root;

	public BinaryTree() {

		root=null;
	}
	protected BinaryTree(Node root) {
		this.root=root;
	}




	public BinaryTree getLeftsubTree(){
		if(root!=null&& root.left!=null)
			return new BinaryTree (root.left);
		else 
			return null;
	}

	public BinaryTree getrighttsubTree(){

		if(root!=null&& root.right!=null)
			return new BinaryTree (root.right);
		else 
			return null;

	}
	public Node  TreeSearch(Node x,String k) { //x는 루트노트 k는 찾는 데이터
		if(x==null || k.equals(x.word)) { //노드가 널이거나 값을 찾게된다면
			return x; //찾은 노드 x를 리턴


		}
		if (k.compareToIgnoreCase(x.word)<0  )
		{

			return TreeSearch(x.left,k); //찾는 값이 더작다면 왼쪽으로

		}
		else return TreeSearch(x.right,k);//찾는 값이 더 크다면 오른쪽으로


	}

	public Node  TreeSearch_Iterative(Node x,String k){
		while(x!=null && k.compareToIgnoreCase(x.word)!=0 ) { // 노드 x 가 널이고 데이터가 다를 동안
			if(k.compareToIgnoreCase(x.word)<0) {//찾는 데이터값이 노드 x보다 작다면  더 왼쪽으로

				x=x.left;

			}
			else x=x.right; //아니면 오른쪽으로

		}

		return x;


	} 

	public Node TreeMin(Node x){
		while(x.left!=null)
		{
			x=x.left;

		}
		return x;

	}

	public Node TreeMax(Node x){
		while(x.right!=null)
		{
			x=x.right;

		}
		return x;

	}

	public Node Successor(Node x){
		if(x.right!=null)
			return TreeMin(x.right);
		Node y=x.parent;
		while(y!=null &&x==y.right ) {

			x=y;
			y=y.parent;
		}

		return y;
	}

	public void TreeInsert(BinaryTree T,Node z) {


		Node y=null;
		Node x=T.root;
		while(x!=null) {
			y=x;
			if(z.word.compareToIgnoreCase(x.word)<0)

				x=x.left;
			else
				x=x.right;


		}
		z.parent=y;

		if(y==null)
			T.root=z;
		else if(z.word.compareToIgnoreCase(y.word)<0) {

			y.left=z;	

		}
		else
			y.right=z;


	}

	public Node TreeDelete(BinaryTree T,Node z) {
		Node x=null,y=null;
		if(z.left==null||z.right==null) //z가 자식이 없거나 하나만 있을 경우
			y=z; 
		else y=Successor(z); //자식이 둘다 있다면 z의 대체자인 successor를 찾아준다

		if(y.left!=null) //y의 왼쪽자식이 없다면
			x=y.left;  //x가 y의 왼쪽 자식
		else  //있다면
			x=y.right; //x가 y의 오른쪽 자식

		if(x!=null) //x가 널이 아니라면
			x.parent=y.parent; //y의 부모가 x의 부모가 된다

		if(y.parent==null) //y의 부모노드가 있다면? x가 루트노드
			T.root=x;
		else if(y==y.parent.left)
			y.parent.left=x;
		else y.parent.right=x;

		if(y!=z) {
			z.word=y.word;
			z.meaning=y.meaning;
			z.Class=y.Class;

		}
		return y;




	}
	public void inorder_tree(Node x) {
		
		if(x!=null) {
			inorder_tree(x.left);
			System.out.println(x.word+" ");
			
			inorder_tree(x.right);
		}
	}


	public int size(Node x) {
		
		if(x==null)
			return 0;
		
		return ( 1+size(x.left)+size(x.right) ) ;
		
	}



}
