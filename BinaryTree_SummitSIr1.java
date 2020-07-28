import java.util.*;
public class BinaryTree_SummitSIr1 {
	
	public class Node{
		int data;
		Node left;
		Node right;
	}
	public int size;
	public Node root;
	
	public void BinaryTree_SummitSIr1() {
		this.root=this.binary(new Scanner(System.in),null,false);
	}
	
	public Node binary(Scanner scn,Node parent,boolean ilc) {
		if(parent==null) {
			System.out.println("enter the data of root");
		}
		else {
			if(ilc) {
				System.out.println("enter the left child of "+parent.data);
			}
			else {
				System.out.println("enter the right child of "+parent.data);
			}
		}
		Node child=new Node();
		int n=scn.nextInt();
		child.data=n;
		size++;
		
		System.out.println("do you have a left child");
		boolean hlc=scn.nextBoolean();
		if(hlc) {
			child.left=binary(scn,child,true);
		}
		
		System.out.println("do you have right child");
		boolean hrc=scn.nextBoolean();
		if(hrc) {
			child.right=binary(scn,child,false);
		}
		return child;
		
	}
	
	//display
	public void dis() {
		display(root);
	}
	public void display(Node node){
		if(node==null) {
			return;
		}
		String str="";
		if(node.left!=null) {
			str+=node.left.data;
		}
		else {
			str+=".";
		}
		str+="-->"+node.data+"<--";
		if(node.right!=null) {
			str+=node.right.data;
		}
		else {
			str+=".";
		}
		System.out.println(str);
		display(node.left);
		display(node.right);
	}
	
	//size
	public void size() {
		int n=size(root);
		System.out.println(n);
	}
	public int size(Node node) {
		if(node==null) {
			return 0;
		}
		int countl=size(node.left);
		int countr=size(node.right);
		return countl+countr+1;
	}
	
	//max node
	public void max() {
		int m=max(root);
		System.out.print(m);
	}
	public int max(Node node) {
		if(node==null) {
			return Integer.MIN_VALUE;
		}
		
		int lmax=max(node.left);
		int rmax=max(node.right);
		return Math.max(node.data,(Math.max(lmax, rmax)));
	}
	
	//height
	public void height() {
		int h=height(root);
		System.out.println(h);
	}
	public int height(Node node) {
		if(node==null) {
			return -1;
		}
		int Cmax=-1;
		int left=height(node.left);
		int right=height(node.right);
		Cmax=Math.max(left, right);
		return Cmax+1;
	}
	
	//find
	public void find(int data) {
		boolean d=find(root,data);
		System.out.println(d);
	}
	
	public boolean find(Node node,int data) {
		if(node==null) {
			return false;
		}
		if(node.data==data) {
			return true;
		}
		boolean lfind=find(node.left,data);
		if(lfind==true) {
			return true;
		}
		boolean rfind=find(node.right,data);
		if(rfind==true) {
			return true;
		}
		return false;
	}
	
	//traversal
	public void dis2() {
		display2(root);
	}
	public void display2(Node node) {
		if(node==null) {
			return;
		}
		System.out.println(node.data);
		display2(node.left);
		display2(node.right);
	}
	
	//level order
	public void levelo() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);
		while(queue.size()!=0) {
			Node rem=queue.removeFirst();
			System.out.print(rem.data+" ");
			if(rem.left!=null) {
				queue.addLast(rem.left);
			}
			if(rem.right!=null) {
				queue.addLast(rem.right);
			}
		}
	}
	
	//binary numbers upto
	public static class pairs
	{
		int n;
		String bin="";
	
		pairs(int n,String bin){
			this.n=n;
			this.bin=bin;
		}
		}
	public static void printB(int n) {
		LinkedList<pairs> s=new LinkedList<>();
		s.addLast(new pairs(1,"1"));
		
		while(s.size()>0) {
			pairs rem=s.removeFirst();
			System.out.println(rem.n+" "+rem.bin);
			if(rem.n*2 <=n) {
				s.addLast(new pairs(rem.n*2,rem.bin+"0"));
			}
			if(rem.n*2+1<=n) {
				s.addLast(new pairs(rem.n*2+1,rem.bin+"1"));
			}
		}
	}
		
	//print only child node
	public void onlyc() {
		onlyc(root,root.left);
		onlyc(root,root.right);
	}
	public void onlyc(Node parent,Node child) {
		if(child==null) {
			return;
		}
		if((parent.left==child && parent.right==null) || (parent.left==null && parent.right==child)){
			System.out.print(child.data+" ");
		}
		onlyc(child,child.left);
		onlyc(child,child.right);
	}
	
	//remove leave
	public void remove() {
		remove(root,root.left);
		remove(root,root.right);
	}
	public void remove(Node parent,Node child) {
		if(child==null) {
			return;
		}
		if(child.left==null && child.right==null) {
			if(parent.left==child) {
					parent.left=null;
			}
				else {
					parent.right=null;
					
				}
			
			return;
		}
		remove(child,child.left);
		remove(child,child.right);
	}
	
	//print path, similar to find
	public void path(int data) {
		path(root,data,"");
	}
	public boolean path(Node node,int data,String path) {
		if(node==null) {
			return false ;
		}
		if(node.data==data) {
			System.out.print(path+node.data);
		}
		boolean l=path(node.left,data,path+node.data+" ");
		if(l) {
			System.out.println(path);
		}
		boolean r=path(node.right,data,path+node.data+" ");
		if(r) {
			System.out.println(path);
		}
		return false;
		
	}
	
	//sum less than target
	public void sumless(int target) {
		sumless(root,0,"",target);
	}
	public void sumless(Node node,int sum,String path,int target) {
		
		if(node==null) {
			return;
		}
		if(node.left==null && node.right==null) {
			System.out.println(path+node.data);
		}
		if(sum>target) {
			return;
		}
		if(sum<target) {
			sumless(node.left,sum+node.data,path+node.data+" ",target);
			sumless(node.right,sum+node.data,path+node.data+" ",target);
		}
		
	}
	
	//does any path available from root to leaf having sum equal to target
	public void ispath(int target) {
		boolean f=ispath(root,target);
		System.out.println(f);
	}
	public boolean ispath(Node node,int target) {
		if(node==null && target==0) {
			return true;
		}
		if(node==null) {
			return false;
		}
		boolean n=ispath(node.left,target-node.data);
		boolean m=ispath(node.right,target-node.data);
		if(n==true || m==true) {
			return true;
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		BinaryTree_SummitSIr1 s=new BinaryTree_SummitSIr1 ();
		s.BinaryTree_SummitSIr1();
//		s.dis();
//		s.size();
//		s.max();
	//	s.height();
//		s.find(210);
	//	s.dis2();
//		s.levelo();
//		System.out.println("this is now");
//		printB(15);
//		s.onlyc();
//		s.remove();
//		s.dis();
//		s.path(30);
//		s.sumless(200);
		s.ispath(125);
	}
// 50 true 25 true 12 false true 20 false false true 37 true 30 false false false true 75 true 62 false false true 87 false false
}
