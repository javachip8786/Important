// THIS IS FOR BINARY TREE
import java.util.*;
public class ConstructTreeByPreOrder {
	public static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data=data;
		}
	}
	public static Node root;
	public static int idx=0;
	public static Node cons(int[] arr) {
		if(idx==arr.length|| arr[idx]==-1) {
			idx++;
			return null;
		}
		Node n=new Node(arr[idx]);
		idx++;
		n.left = cons(arr);
		n.right = cons(arr);
		return n;
	}
	
	//print
	public static void print(Node root) {
		if(root==null) {
			return;
		}
		System.out.println(root.data);
		print(root.left);
		print(root.right);
	}
	
	//max
	public static int maximum(Node root) {
		if(root==null) {
			return (int)-1e9;
		}
		int maxL=maximum(root.left);
		int maxR=maximum(root.right);
		return Math.max(root.data, Math.max(maxL, maxR));
	}
	
	//min
		public static int minimum(Node root) {
			if(root==null) {
				return (int)1e9;
			}
			int maxL=minimum(root.left);
			int maxR=minimum(root.right);
			return Math.min(root.data, Math.min(maxL, maxR));
		}
		
	//height
	public static int height(Node root) {
		if(root==null) {
			return -1;
		}
		int h=Math.max(height(root.left), height(root.right)+1);
		return h;
	}
	
	//remove leaves
	public static Node RL(Node root) {
		if(root.left==null && root.right==null) {
			return null;
		}
		root.left=RL(root.left);
		root.right=RL(root.right);
		return root;
	}
	
	//clear the tree
	public static Node clear(Node root) {
		if(root==null) {
			return null;
		}
		root.left=clear(root.left);
		root.right=clear(root.right);
		if(root.left == null && root.right == null) {
			return null;
		}
		return root;
	}
	

	public static void main(String[] args) {
		int[] arr= {10,20,40,-1,-1,70,-1,-1,30,50,-1,-1,60,-1,-1};
		Node root=cons(arr);
		print(root);
//		int max=maximum(root);
//		System.out.println(max);
		
//		int min=minimum(root);
//		System.out.println(min);
		
//		int h=height(root);
//		System.out.println(h);
		System.out.println("-----------------------------");
//		RL(root);
		System.out.println("----------------------------- ");
		//this deletes all the nodes from the tree
		root=clear(root);
		print(root);
	}

}
