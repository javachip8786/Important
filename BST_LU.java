import java.util.*;
public class BST_LU {
	
	public static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data=data;
		}
	}
	
	public static Node cons(int[] arr,int l,int r) {
		if(l>r) {
			return null;
		}
		
		int mid=(l+r)/2;
		Node root=new Node(arr[mid]);
		root.left=cons(arr,l,mid-1);
		root.right=cons(arr,mid+1,r);
		return root;
		
	}
	
	public static void print(Node root) {
		if(root==null) {
			System.out.print(-1+" ");
			return;
		}
		System.out.print(root.data+" ");
		print(root.left);
		print(root.right);
	}
	
	public static boolean find(Node root,int data) {
		Node curr=root;
		while(curr!=null) {
			if(curr.data==data) {
				return true;
			}
			else if(curr.data>data) {
				curr=curr.left;
			}
			else {
				curr=curr.right;
			}
		}
		return false;
	}
	
	public static boolean find_recur(Node root,int data) {
		if(root==null) {
			return false;
		}
		if(root.data==data) {
			return true;
		}
		else if(root.data>data) {
			return find(root.left,data);
		}
		else {
			return find(root.right,data);
		}
	}
	
	public static int max(Node root) {
		Node curr=root;
		while(curr.right!=null) {
			curr=curr.right;
		}
		return curr.data;
	}
	
	public static int min(Node root) {
		Node curr=root;
		while(curr.left!=null) {
			curr=curr.left;
		}
		return curr.data;
	}
	
	//leetcode 235
	public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root==null){
            return null;
        }
        if(p.data<root.data && q.data<root.data){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(p.data>root.data && q.data>root.data){
            return lowestCommonAncestor(root.right,p,q);
        }
        else{
            return root;
        }
    }
	
	public static Node lowestCommonAncestor_itr(Node root, Node p, Node q) {
        while(root!=null){
            if(root.data<p.data && root.data<q.data){
                root=root.right;
            }
            else if(root.data>p.data && root.data>q.data){
                root=root.left;
            }
            else{
                return root;
            }
        }
         return null;
    }
	//If Node p and q doesn't exist
	public static Node lowestCommonAncestor_itr2(Node root, Node p, Node q) {
		Node curr=root;
        while(curr!=null){
            if(curr.data<p.data && curr.data<q.data){
                curr=curr.right;
            }
            else if(curr.data>p.data && curr.data>q.data){
                curr=curr.left;
            }
            else{
                if(find(curr,p.data) && find(curr,q.data)) { ;
                	return curr;
                }
            }
        }
         return null;
    }
	
	// all nodes in sorted order between (a,b) range
	public static ArrayList<Integer> NodesInRange(Node root,int a,int b,ArrayList<Integer> n){
		if(root==null) {
			return n;
		}
		NodesInRange(root.left,a,b,n);
		if(root.data>a && root.data<b) {
			n.add(root.data);
		}
		NodesInRange(root.right,a,b,n);
		return n;
	}
	
	public static ArrayList<Integer> findpath(Node root,int data){
		ArrayList<Integer> path=new ArrayList<>();
		while(root!=null) {
			if(root.data==data) {
				path.add(root.data);
				
			}
			if(root.data>data) {
				root=root.left;
			}
			else {
				root=root.right;
			}
		}
		return path;
	}
	
	public static int height(Node root) {
		if(root==null) {
			return 0;
		}
		int lh=height(root.left);
		int rh=height(root.right);
		return Math.max(lh, rh)+1;
	}
	
	//construct tree from pre-order
	public static int idx=0;
	public static Node cons_pre(int[] arr,int left,int right) {
		if(idx == arr.length || arr[idx]<left || arr[idx]> right) {
			return null;
		}
		Node root=new Node(arr[idx++]);
		root.left=cons_pre(arr,left,root.data);
		root.right=cons_pre(arr,root.data,right);
		return root;
	}
	
	//height by pre-order
	public static int heightPre(int[] arr,int left,int right) {
		if(idx == arr.length || arr[idx]<left || arr[idx]> right) {
			return -1;
		}
		int data = arr[idx];
		idx++;
		int lh=heightPre(arr,left,data);
		int rh=heightPre(arr,data,right);
		return Math.max(lh, rh)+1;
	}
	
	//construct tree from post-order
	public static int idx2;
	public static Node cons_post(int[] arr,int left,int right) {
		if(idx2 == -1 || arr[idx2]<left || arr[idx2]> right) {
			return null;
		}
		Node root=new Node(arr[idx2--]);
		root.right=cons_post(arr,root.data,right);
		root.left=cons_post(arr,left,root.data);
		return root;
	}
	
	public static int height(int[] arr) {
		int i=1;
		int curr=arr[0];
		while(curr>arr[i]) {
			System.out.println(curr +"  "+arr[i]);
			i++;
			curr=arr[i];
		}
		return i;
	}
	
	//predecssor and succssor of data. ceil and floor of data
	public static class PSCF{
		int size=0;
		int height=0;
		boolean find=false;
		Node pre;
		Node post;
		int ceil;
		int floor;
	}
	
	public static void PSCF2(Node root,int data,int level,PSCF p) {
		if(root==null) {
			return;
		}
		p.height = Math.max(p.height,level);
		p.size++;
		p.find = p.find || root.data ==data;
		if(root.data > data) {
			p.ceil = Math.min(p.ceil, root.data);
		}
		if(root.data < data) {
			p.floor = Math.max(p.floor, root.data);
		}
		
		if(root.data == data) {
			p.pre = p.pre;
		}
		if(p.pre != null && p.pre.data==data) {
			p.post=root;
		}
		p.pre=root;
		PSCF2(root.left,data,level+1,p);
		PSCF2(root.right,data,level+1,p);
	}
	
	//predessor and successor in less time
	public static void preSuccInBST(Node node,int data) {
		Node curr=node;
		Node preD=null;
		Node succR=null;
		while(curr!=null) {
			if(data<curr.data) {
				succR=curr;
				curr=curr.left;
			}
			else if(curr.data<data) {
				preD=curr;   // when there is no left child of node then its parent is its predessor
				curr=curr.right;
			}
			else {
				Node tPred=curr.left;
				if(preD==null) {  	// if left child of node is available, predessor will be here
					while(tPred!=null) {
						tPred=tPred.right;
					}
					preD=tPred;
				}
				Node rSucc=curr.right;
				if(succR==null) {
					while(rSucc.left!=null) {
						rSucc=rSucc.left;
					}
					succR=rSucc;
				}
			}
	}
	}
	
	//Adding a new Node
	public static Node AddNode(Node root,int data) {
		if(root==null) {
			return new Node(data);
		}
		if(root.data>data) {
			root.left=AddNode(root.left,data);
		}
		else {
			root.right=AddNode(root.right,data);
		}
		return root;
	}
	
	
	
	//remove
	public static Node remove(Node root,int data) {
		if(root==null) {
			return new Node(data);
		}
		if(root.data>data) {
			root.left=remove(root.left,data);
		}
		else if (root.data<data) {
			root.right=remove(root.right,data);
		}
		else if (root.data==data) {
			if(root.left==null || root.right==null) {
				if(root.left!=null) {
					return root.left;
				}
				else {
					return root.right;
				}
			}
			int maxEle = max(root.left);
			root.data=maxEle;
			root.left = remove(root.left,maxEle);
		}
		return root;
	}
	
	// https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1
	// converts a binary tree into a sorted doubly linkedlist 
	public static Node prevDLL = null;
	public static Node head = null;
	public static void DLL(Node node)
	{
	    if (node == null)
	        return;

	    DLL(node.left);
	    if (head == null)
	        head = node;
	    else
	    {
	        prevDLL.right = node;
	        node.left = prevDLL;
	    }

	    prevDLL = node;
	    DLL(node.right);
	}

	public static Node bToDLL(Node root)
	{
	    prevDLL = null;
	    head = null;
	    DLL(root);
	    return head;
	}
	
	//Leetcode : 426

	public static Node treeToDoublyList(Node root)
	{
	    if (root == null)
	        return root;

	    prevDLL = null;
	    head = null;
	    DLL(root);

	    prevDLL.right = head;
	    head.left = prevDLL;

	    return head;
	}
	
	public static void pri(Node root) {
		if(root==null) {
			return;
		}
		System.out.println(root.data);
		pri(root.right);
	}
	
	//Morris Practice
	public static Node RightMost(Node next,Node curr) {
		while(next.right!=null && next.right!=curr) {
			next=next.right;
		}
		return next;
	}
	
	
	public static void Morris(Node root) {
		Node curr=root;
		while(curr!=null) {
			Node next=curr.left;
			if(next==null) {
				System.out.println(curr.data);
				curr=curr.right;
			}
			else {
				Node rightmost=RightMost(next,curr);
				if(rightmost.right==null) {   //creating thread
					rightmost.right=curr;
					curr=curr.left;
				}
				else {           				//breaking the thread
					System.out.println(curr.data);
					rightmost.right=null;
					curr=curr.right;
				}
			}
		}
	}
	
	public static void MorrisPreOrder(Node root) {
		Node curr=root;
		while(curr!=null) {
			Node next=curr.left;
			if(next==null) {
				System.out.println(curr.data);
				curr=curr.right;
			}
			else {
				Node rightmost=RightMost(next,curr);
				if(rightmost.right==null) {   //creating thread
					System.out.println(curr.data);
					rightmost.right=curr;
					curr=curr.left;
				}
				else {           				//breaking the thread
					rightmost.right=null;
					curr=curr.right;
				}
			}
		}
	}
	
	
	

	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6,7,8,9};
		Node root=cons(arr,0,arr.length-1);
		MorrisPreOrder(root);
//		AddNode(root,11);
//		ArrayList s=NodesInRange(root,2 ,8,new ArrayList<Integer>());
//		System.out.println(s);
//		remove(root,9);
//		print(root);
//		int h=height(root);
//		System.out.println(h);
		
//		int[] pre= {25,15,10,4,12,22,18,24,50,35,31,44,70,66,90};
//		Node root=cons_pre(pre,-10000000,10000000);
//		print(root);
//		System.out.println();
		
//		int[] post= {4,12,10,18,24,22,15,31,44,35,66,90,70,50,25};
//		idx2=post.length-1;
//		Node k=cons_post(post,-1000000,1000000);
//		print(k);
//		
//		PSCF f=new PSCF();
//		PSCF2(root, 12, 0 ,f);
//		System.out.println(f.pre.data +" "+f.post.data+" "+f.ceil+" "+f.floor);
		
//		root=treeToDoublyList(root);
//		pri(root);
		
//		Node doot=bToDLL(root);
//		pri(doot);
	}

}
