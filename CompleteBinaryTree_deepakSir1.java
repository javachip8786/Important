import java.util.*;
public class CompleteBinaryTree_deepakSir1 {
	public static class Node{
		int data;
		Node left;
		Node right;
	}
	public static Node root;
	public static int size;
	
	
	public static Node cons(int[] arr,int left,int right) {
		if(left>right) {
			return null;
		}
		if(left==right) {
			Node s=new Node();
			s.data=arr[left];
			return s;
		}
		int mid=(left+right)/2;
		Node root=new Node();
		root.data=arr[mid];
		size++;
		root.left=cons(arr,left,mid-1);
		root.right=cons(arr,mid+1,right);
		return root;
	}
	
	//min
	public static int min(Node root) {
		if(root==null) {
			return -1;
		}
		while(root.left!=null) {
			root=root.left;
		}
		return root.data;
	}
	
	//max
		public static int max(Node root) {
			if(root==null) {
				return -1;
			}
			while(root.right!=null) {
				root=root.right;
			}
			return root.data;
		}
	
	//find
	public static boolean find(Node root,int target) {
		if(root==null) {
			return false;
		}
		if(root.data==target) {
			return true;
		}
		if(target<root.data) {
			return find(root.left,target);
		}
		if(target>root.data) {
			return find(root.right,target);
		}
		return false;
	}
	
	//replace with sum of larger
	public static int maxsum=0;
	
	public static void re(Node root) {
		if(root==null) {
			return;
		}
		re(root.right);
		int val=root.data;
		root.data=maxsum;
		maxsum+=val;
		System.out.print(root.data+" ");
		re(root.left);
	}
	
	//printing in zig zag order
//	public static void dis(Node root,boolean f) {
//		if(root==null) {
//			return;
//		}
//		LinkedList<Integer> queue=new LinkedList<>();
//		if(f==false) {
//			
//		}
//	}

	public static void main(String[] args) {
		//CompleteBinaryTree_deepakSir1 s=new CompleteBinaryTree_deepakSir1();
		int[] arr= {10,20,30,40,50,60,70,80,90};
		Node root=cons(arr,0,arr.length-1);
		boolean n=find(root,200 );
		System.out.println(n);
		System.out.println(min(root));
		System.out.println(max(root));
		re(root);
	}

}
