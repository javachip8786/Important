
public class BinaryTree_summitSir2 {
	public class Node{
		int data;
		Node left;
		Node right;
	}
	public int size;
	public Node root;
	
	
	//generate a tree from pre-order and in-order
	public void gen(int[] pre,int[] in) {
		root=gen(pre,0,pre.length-1,in,0,in.length-1);
		size=pre.length;
	}
	//psi= start of pre(array) and pli= end of pre(array)
	//isi= start of in(array) and ili=end of in(array)
	public Node gen(int[] pre,int psi,int pli,int[] in,int isi,int ili) {
		if(psi>pli || isi>ili) {
			return null;
		}
		Node n=new Node();
		n.data=pre[psi];
		int idx=-1;
		for(idx=isi;idx<=ili;idx++) {
			if(pre[psi]==in[idx]) {
				break;
			}
		}
		int nle=idx-isi;
		n.left=gen(pre,psi+1,psi+nle,in,isi,idx-1);
		n.right=gen(pre,psi+nle+1,pli,in,idx+1,ili);
		return n;
	}
	
	//construct tree from post-order and in-order
	public void cons(int[] post,int[] in) {
		root=cons(post,0,post.length-1,in,0,in.length-1);
		size=post.length;
	}
	public Node cons(int[] post,int psi,int pli,int[] in,int isi,int ili) {
		if(psi>pli || isi>ili) {
			return null;
		}
		Node s=new Node();
		s.data=post[pli];
		int idx=-1;
		for(idx=isi;idx<=ili;idx++) {
			if(post[pli]==in[idx]) {
				break;
			}
		}
		int nre=ili-idx;
		s.left=cons(post,psi,pli-nre-1,in,isi,idx-1);
		s.right=cons(post,pli-nre,pli-1,in,idx+1,ili);
		return s;
	}
	
	//deepest node (diameter)
	public void deep() {
		int h=deep(root);
		System.out.println(h);
	}
	public int deep(Node node) {
		if(node==null) {
			return 0;
		}
		int ld=deep(node.left);
		int rd=deep(node.right);
		int rh=height(node.right);
		int lh=height(node.left);
//		int max= Math.max(2*dl,2*dr);
		int factor=(lh+rh+2);
		return Math.max(Math.max(ld,rd), factor);
	}
	
	public void height() {
		System.out.println(height(root));
	}
	public int height(Node node) {
		if(node==null) {
			return -1;
		}
		int cmax=-1;
		int l=height(node.left);
		int r=height(node.right);
		cmax=Math.max(l, r);
		return cmax+1;
	}
	
	//display
	public void dis() {
		dis(root);
	}
	public void dis(Node node) {
		if(node==null) {
			return;
		}
		System.out.print(node.data+" ");
		dis(node.left);
		dis(node.right);
	}
	
	//if a tree is balance or not
	public void BST() {
		boolean t=BST(root);
		System.out.println(t);
	}
	public boolean BST(Node node) {
		if(node==null) {
			return true;
		}
		boolean ilb=BST(node.left);
		boolean irb=BST(node.right);
		int lh=height(node.left);
		int rh=height(node.right);
		return (ilb && irb) && Math.abs(lh-rh)<=1;
	}
	
	//isBST
	public class BSTPair
	{
		boolean isBST;
		int  min;
		int max;
	}
	public void isBST() {
		BSTPair s=isBST(root);
		System.out.println(s.isBST);
		 
	}
	public BSTPair isBST(Node node) {
		if(node==null) {
			BSTPair bp=new BSTPair();
			bp.min=Integer.MAX_VALUE;
			bp.max=Integer.MIN_VALUE;
			bp.isBST=true;
			return bp;
		}
		BSTPair lp=isBST(node.left);
		BSTPair rp=isBST(node.right);
		BSTPair mp=new BSTPair();
		mp.isBST=lp.isBST && rp.isBST && node.data>=lp.max && node.data<=rp.min;
		mp.max=Math.max(node.data, Math.max(lp.max, rp.max));
		mp.min=Math.min(node.data, Math.min(lp.min, rp.min));
		return mp;
	}
	
	
	//isBST with largest BST in a tree
		public class BSTPair2
		{
			boolean isBST2;
			int  min;
			int max;
			Node lbstroot;
			int lbstsize;
		}
		public void isBST2() {
			BSTPair2 s=isBST2(root);
			System.out.println(s.isBST2);
			System.out.println(s.lbstroot.data+" --> "+s.lbstsize);
			
			 
		}
		public BSTPair2 isBST2(Node node) {
			if(node==null) {
				BSTPair2 bp=new BSTPair2();
				bp.min=Integer.MAX_VALUE;
				bp.max=Integer.MIN_VALUE;
				bp.isBST2=true;
				return bp;
			}
			BSTPair2 lp=isBST2(node.left);
			BSTPair2 rp=isBST2(node.right);
			BSTPair2 mp=new BSTPair2();
			mp.isBST2=lp.isBST2 && rp.isBST2 && node.data>=lp.max && node.data<=rp.min;
			mp.max=Math.max(node.data, Math.max(lp.max, rp.max));
			mp.min=Math.min(node.data, Math.min(lp.min, rp.min));
			if(mp.isBST2) {
				mp.lbstroot=node;
				mp.lbstsize=lp.lbstsize+rp.lbstsize+1;
			}
			else {
				if(lp.lbstsize>rp.lbstsize) {
					mp.lbstroot=lp.lbstroot;
					mp.lbstsize=lp.lbstsize;
				}
				else {
					mp.lbstroot=rp.lbstroot;
					mp.lbstsize=rp.lbstsize;
				}
			}
			return mp;
		}
		
	//mirror
		  
		    public void mirror() 
		    { 
		        root = mirror(root); 
		    } 
		  
		    public Node mirror(Node node) 
		    { 
		        if (node == null) 
		            return node; 
		  
		        /* do the subtrees */
		        Node left = mirror(node.left); 
		        Node right = mirror(node.right); 
		  
		        /* swap the left and right pointers */
		        node.left = right; 
		        node.right = left; 
		  
		        return node; 
		    } 

	public static void main(String[] args) {
		BinaryTree_summitSir2 s=new BinaryTree_summitSir2();
		//pre + in to construct tree
//		int[] pre= {50,25,12,20,37,30,75,62,87}; 
//		int[] in= {12,20,25,30,37,50,62,75,87};
//		s.gen(pre,in);
		s.dis(); //this displays preorder
		//post + in to construct tree
		int[] post= {22,21,20,12,30,31,37,25,62,87,75,50};
		int[] in= {12,20,21,22,25,31,30,37,50,62,75,87};
		
//		int[] post= {12,51,37,25,62,87,75,50};
//		int[] in= {12,25,37,51,50,62,75,87};
		s.cons(post, in);
		s.dis(); 
//		s.deep();
//		s.BST();
//		s.isBST2(); //same as BST but it also gives largest bst and its height
		s.mirror();
		System.out.println("mirror is ");
		s.dis(); 
	}

}
