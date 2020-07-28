
public class DeepakSir_BST17APRIL {
	
	public class Node{
		int data;
		Node left;
		Node right;
	}
	public int size;
	public Node root;
	
	public class bsthelper{
		boolean isbst;
		int min;
		int max;
	}
	
	public static bsthelper isbst(Node node) {
		if(root==null) {
			bsthelper baseans= new bsthelper();
			return baseans;
		}
		else if(root.left ==null && root.right==null) {
			bsthelper baseans= new bsthelper();
			baseans.min=root.data;
			baseans.max=root.data;
		}
		bsthelper left=isbst(root.left);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
