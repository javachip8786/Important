import java.util.*;
public class BinaryTree_DeepakSir1 {
	public class Node{
		int data;
		Node left;
		Node right;
	}
	public int size;
	public Node root;
	
	//for input of data
	public BinaryTree_DeepakSir1() {
		root=cons(new Scanner(System.in),null,0);
	}
	
	public void cons(Scanner scn,Node parent,int i) {
		if(parent==null) {
			System.out.print("enter the parent");
		}
		else {
			System.out.print("enter the left child of "+parent);
		
		int ldata=scn.nextInt();
		Node left=new Node();
		left.data=ldata;
		System.out.println("enter the right child of "+parent);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
