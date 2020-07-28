import java.util.*;
public class AVL_LU {
	
	public static class Node{
		int data=0;
		Node left=null;
		Node right=null;
		int height=0;
		int bal=0;
		Node(int data){
			this.data=data;
			
		}
	}
	
	public static void updateHeightBAl(Node node) {
		int lh=-1;
		int rh=-1;
		if(node.left!=null) {
			lh=node.left.height;
		}
		if(node.right!=null) {
			rh=node.right.height;
		}
		node.height=Math.max(lh, rh)+1;
		node.bal = lh-rh;
	}
	
	//left
	public static Node ll(Node A) {
		Node B=A.left;
		Node BkR=B.right;
		B.right=A;
		A.left=BkR;
		updateHeightBAl(A);
		updateHeightBAl(B);
		return B;
	}
	//right
	public static Node rr(Node A) {
		Node B=A.right;
		Node BkL=B.left;
		B.left=A;
		A.right=BkL;
		updateHeightBAl(A);
		updateHeightBAl(B);
		return B;
	}
	//this function takes care of Rotation
	public static Node RotateSubTree(Node node) {
		updateHeightBAl(node);
		if(node.bal == 2) {
			if(node.left.bal == 1) {
				return ll(node);
			}
			else {
				node.left=rr(node.left);
				return ll(node);
			}
		}
		else if(node.bal == -2) {
			if(node.right.bal == -1) {
				return rr(node);
			}
			else {
				node.right = ll(node.right);
				return rr(node);
			}
		}
		return node;
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
		return RotateSubTree(root);	
	}
	
	//max element
	public static int max(Node root) {
		Node curr=root;
		while(curr.right!=null) {
			curr=curr.right;
		}
		return curr.data;
	}
	//remove
		public static Node remove(Node root,int data) {
			if(root==null) {
				return null;
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
			return RotateSubTree(root);
		}
	//print
		// left current right print
		public static void printLCR(Node node) {
			if(node==null) {
				return;
			}
			String str="";
			str+=node.left!=null ? node.left.data : ".";
			str+=" <- "+node.data + " -> ";
			str+=node.right!=null?node.right.data:".";
			System.out.println(str);
			printLCR(node.left);
			printLCR(node.right);
		}
		
		
		//leetcode 173
		public static Stack<Node> st=new Stack<>();
	    public static void BSTIterator(Node root) {
	        insertLeftMost(root);
	    }
	    
	    public static void insertLeftMost(Node root){
	        Node curr=root;
	        while(curr!=null){
	            st.push(curr);
	            curr=curr.left;
	        }
	    }
	    
	    /** @return the next smallest number */
	    public int next() {
	        Node rnode=st.peek();
	        st.pop();
	        insertLeftMost(rnode.right);
	        return rnode.data;
	    }
	    
	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return st.size()!=0;
	    }
	    
	    
	    //morris traversal- just like inorder
	    public static Node curr=new Node(-1);
	    public static Node prev=null;
	    public static Node n=null;
	    public static Node Morris(Node root) {
	    	if(root==null) {
	    		return null;
	    	}
	    	prev.left=Morris(root.left);
	    	if(root!=null) {
	    		System.out.println(root.data);
	    	}
	    	prev.right=Morris(root.right);
	    	return curr;
	    }
	    
	    
	    //construct a tree from pre-order and in-order 
	    public static Node cons(int[] pre,int[] in,int psi,int pli,int isi,int ili) {
	    	if(psi>pli || isi>ili) {
	    		return null;
	    	}
	    	Node node=new Node(pre[psi]);
//	    	int idx=ins;
//	    	while(in[idx]!=pre[pres]) {
//	    		idx++;
//	    	}
	    	int idx=-1;
	    	for(idx=isi ; idx<=ili ;idx++) {
	    		if(pre[psi] == in[idx]) {
	    			break;
	    		}
	    	}
	    	int tel = idx - isi;
	    	node.left = cons(pre,in,psi+1,psi+tel,isi,idx-1);
	    	node.right= cons(pre,in,psi+tel+1,pli,idx+1,ili);
	    	return node;
	    }
	    
	    
	    public static Node consPI(int[] pre,int psi,int pli,int[] in,int isi,int ili) {
	    	if(psi>pli || isi>ili) {
	    		return null;
	    	}
	    	Node root=new Node(pre[psi]);
	    	int idx=-1;
	    	for(idx=isi;idx<=ili;idx++) {
	    		if(pre[psi]==in[idx]) {
	    			break;
	    		}
	    	}
	    	int nle=idx-isi;
	    	root.left=consPI(pre,psi+1,psi+nle,in,isi,idx-1);
	    	root.right=consPI(pre,psi+nle+1,pli,in,idx+1,ili);
	    	return root;
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	  //construct a tree from post-order and in-order 
	    public static Node cons2(int[] post,int[] in,int psi,int pli,int isi,int ili) {
	    	if(psi>pli || isi>ili) {
	    		return null;
	    	}
	    	Node node=new Node(post[pli]);
//	    	int idx=ins;
//	    	while(in[idx]!=pre[pres]) {
//	    		idx++;
//	    	}
	    	int idx=-1;
	    	for(idx=isi ; idx<=ili ;idx++) {
	    		if(post[pli] == in[idx]) {
	    			break;
	    		}
	    	}
	    	int tel = ili - idx;
	    	node.left = cons2(post,in,psi,pli-tel-1,isi,idx-1);
	    	node.right= cons2(post,in,pli-tel,pli-1,idx+1,ili);
	    	return node;
	    }
	    
	    //construct tree from pre-order and post-order
	    public static Node cons3(int pre[],int[] post,int psi,int pli,int posi,int poli) {
	    	if(psi>pli){
	    		return null;
	    	}
	    	if(psi==pli) {
	    		return new Node(pre[psi]);
	    	}
	    	Node node=new Node(pre[psi]);
	    	int idx=posi;
	    	for(idx=posi ; idx<=poli ;idx++) {
	    		if(post[idx]==pre[psi+1]) {
	    			break;
	    		}
	    	}
	    	int tel=idx-posi+1;
	    	node.left = cons3(pre,post,psi+1,psi+tel,posi,idx);
	    	node.right= cons3(pre,post,psi+tel+1,pli,idx+1,poli-1);
	    	return node;
	    }
	    
	    //leetcode 968 --each camera can monitor each of the adjacent node, how many cameras required
	    // -1 : need a camera
	    //  0 : is a camera
	    //	1 : doesn't need a camera
	    public static int camera=0;
	    public static int minCameraCover(Node root) {
	        
	        if(cam(root)==-1){
	            camera++;
	        }
	        return camera;
	    }
		    public static int cam(Node root) {
		    	if(root==null) {
		    		return 1;
		    	}
		    	
		    	int lans=cam(root.left);
		    	int rans=cam(root.right);
		    	if(lans == -1 || rans==-1) {
		    		camera++;
		    		return 0;
		    	}
		    	else if(lans==0 || rans==0) {
		    		return 1;
		    	}
		    	return -1;
		    }
	   //leetcode 662
	   public static int leftMost(Node root) {
		   int l=0;
		   while(root.left!=null) {
			   l++;
		   }
		   int r=0;
		   while(root.right!=null) {
			   r++;
		   }
		   return l+r;
	   }
	   
	   
	   public static void leftMost(Node node, Stack<Node> st) {
		   while(node!=null) {
			   st.push(node);
			   node=node.left;
		   }
	   }
	   public static int KthSmallest(Node root,int k) {
		   Stack<Node> st=new Stack<>();
		   leftMost(root,st);
		   int ans=-1;
		   while(k>0) {
			   Node rnode=st.peek();
			   st.pop();
			   leftMost(rnode.right,st);
			   ans=rnode.data;
		   }
		   return ans;
	   }
	   
	   //Leetcode 230--------Kth smallest elements in a BST
	   public static int kthSmallest(Node root, int k) {
	        Kth(root,k);
	        return co;
	    }
	    public static int co=-1; 
	    public static int count=0;
	    public static void Kth(Node root,int k){
	        if(root==null){
	            return;
	        }
	        Kth(root.left,k);
	        count++;
	        if(count==k && co==-1){
	            co=root.data;
	        }
	        System.out.println(root.data+"  count is "+count);
	        Kth(root.right,k);
	    }
	    
	    

	public static void main(String[] args) {
//		Node root= new Node(25);
//		AddNode(root,20);
//		AddNode(root,75);
//		AddNode(root,65);
//		AddNode(root,10);
//		AddNode(root,15);
//		AddNode(root,85);
//		printLCR(root);
//		Morris(root);
//		printLCR(curr);
		int[] pre= {5,3,2,1,4,6};
		int[] in= {1,2,3,4,5,6};
		Node root=cons(pre,in,0,pre.length-1,0,in.length-1);
		System.out.print(kthSmallest(root,3));
		
//		int[] in= {12,20,25,30,37,50,62,75,87};
//		int[] pre= {50,25,12,20,37,30,75,62,87};
//		Node root=cons(pre,in,0,pre.length-1,0,in.length-1);
//		printLCR(root);
//		System.out.println("--------------");
//		int[] post= {20,12,30,37,25,62,87,75,50};
//		Node root=cons2(post,in,0,post.length-1,0,in.length-1);
//		printLCR(root);
		
//		Node root=cons3(pre,post,0,pre.length-1,0,post.length-1);
		
//		printLCR(root);
//		cam(root);
//		System.out.println(camera);
	}

}
