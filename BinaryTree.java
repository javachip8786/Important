import java.util.*;
public class BinaryTree {
	public class Node{
		int data;
		Node left;
		Node right;
	}
	private Node root;
	private int size;
	
	public BinaryTree() {
		root=construct(new Scanner(System.in), null, false);
	}
	
	private Node construct(Scanner scn,Node parent,boolean ilc) {
		int cdata=scn.nextInt();
		Node child=new Node();
		child.data=cdata;
		size++;
		//for left child
		boolean hlc=scn.nextBoolean();
		if(hlc) {
			child.left=construct(scn,child,true);
		}
		//for right child
		boolean hrc=scn.nextBoolean();
		if(hrc) {
			child.right=construct(scn,child,false);
		}
		return child;
	}
	
	public void dis() {
		dis(root);
	}
	private void dis(Node node) {
		if(node==null) {
			return;
		}
		String str="";
		str+=node.left!=null? node.left.data:".";
		str+="->"+node.data +" <-";
		str+=node.right!=null? node.right.data:".";
		System.out.println(str);
		dis(node.left);
		dis(node.right);
		
	}
	
	//size
	public int size() {
		return size;
	}
	//to check if it is empty
	public boolean isEmpty() {
		return size==0;
	}
	//count
	private void count() {
		count(root);
	}

	private int count(Node node) {
		if(node==null) {
			return 0;
		}
		int lsize=count(node.left);
		int rsize=count(node.right);
		return lsize+rsize+1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree list= new BinaryTree();
		System.out.print(list.size);
		System.out.println();
		list.dis();
		System.out.println();
		System.out.println(list.count(list.root));
	}

}
//input
//50
//true
//25
//true
//12
//false
//true
//20
//false
//false
//true
//37
//true
//30
//false
//false
//false
//true
//75
//true
//62
//false
//false
//true
//87
//false
//false