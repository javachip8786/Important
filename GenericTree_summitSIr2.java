import java.util.*;
public class GenericTree_summitSIr2 {
	
	public class Node{
		int data;
		ArrayList<Node> children=new ArrayList<>();
	}
	public int size;
	public Node root;
	
	public GenericTree_summitSIr2() {
		this.root=cons(new Scanner(System.in),null,0);
	}
	
	public Node cons(Scanner scn,Node parent,int i) {
		if(parent ==null) {
			System.out.println("enter the root");
		}
		else {
			System.out.println("enter the "+i+"th child of parent "+parent.data);
		}
		int cdata=scn.nextInt();
		Node s=new Node();
		size++;
		s.data=cdata;
		System.out.println("enter the number of children of "+cdata);
		
		int gnchild=scn.nextInt();
		
		for(int j=0;j<gnchild;j++) {
			Node gc=cons(scn,s,j);
			s.children.add(gc);
		}
		return s;
	}
	
	
	//printing level order by approach 2
	public void level() {
		LinkedList<Node> queue=new LinkedList();
		queue.addLast(root);
		queue.addLast(null);
		
		while(queue.size()>0) {
			Node rem=queue.removeFirst();
			if(rem!=null) {
				System.out.print(rem.data+" ");
				for(Node child: rem.children) {
					queue.addLast(child);
				}
			}
			else {
				System.out.println();
				if(queue.size()>0) {
					queue.addLast(null);
				}
			}
		}
	}
	
	//mirror
	public void mirror() {
		mirror(root);
	}
	public void mirror(Node node) {
		for(Node child: node.children) {
			mirror(child);
		}
		Collections.reverse(node.children);
	}

	//remove leaves
	public void removeleaves() {
		remove(root);
	}
	public void remove(Node node) {
		for(int i=node.children.size()-1;i>=0;i--) {
			Node child=node.children.get(i);
			if(child.children.size()==0) {
				node.children.remove(child);
			}
			else {
				remove(child);
			}
		}
	}
	
	//display
	public void dis() {
		display(root);
	}
	public void display(Node node) {
		System.out.print(node.data+" ");
		for(Node child:node.children) {
			display(child);
		}
	}
	
	public ArrayList<Integer> s=new ArrayList<>();
	
	//linearize_Mine
	public void lin() {
		lin(root);
	}
	public void lin(Node node) {
		
		s.add(node.data);
		for(Node child : node.children) {
			lin(child);
		}
	}
	
	//IsIsomorphic
	public boolean IsIsomorphic(GenericTree_summitSIr2 other) {
		return this.IsIsomorphic(this.root, other.root);
	}
	public boolean IsIsomorphic(Node tnode,Node onode) {
		if(tnode.children.size()==onode.children.size()) {
			for(int i=0;i<tnode.children.size();i++) {
				Node tchild=tnode.children.get(i);
				Node ochild=onode.children.get(i);
				boolean s=IsIsomorphic(tchild,ochild);
				if(s==false) {
					return false;
				}
			}
			return true;
		}
		else {
			return false;
		}
		
	}
	
	//isMirror
	public boolean ismirror(GenericTree_summitSIr2 other) {
		return this.ismirror(this.root,other.root);
	}
	public boolean ismirror(Node tnode,Node onode) {
		if(tnode.children.size()!=onode.children.size()) {
			return false;
		}
		int left=0;
		int right=tnode.children.size()-1;
		while(left<tnode.children.size()) {
			Node tchild=tnode.children.get(left);
			Node ochild=onode.children.get(right);
			boolean s=ismirror(tchild,ochild);
			if(s==false) {
				
				return false;
				
			}
			left++;
			right--;
		}
		return true;
	}
	
	//IsSemetric
	public boolean sem() {
		return ismirror(this.root,this.root);
	}
	
	//multi solver
	public class heapmover{
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		int height=0;
		int size=0;
		boolean find=false;
	}
	public void multisolver(int data) {
		heapmover s=new heapmover();
		multi(root,s,data,0);
		System.out.println("max is "+s.max);
		System.out.println("min is "+s.min);
		System.out.println("size is "+s.size);
		System.out.println("height is "+s.height);
		System.out.println("find is "+s.find);
	}
	public void multi(Node node,heapmover s,int data,int depth) {
		s.size++;
		s.min=Math.min(node.data, s.min);
		s.max=Math.max(node.data, s.max);
		s.height=Math.max(depth, s.height);
		s.find= s.find || node.data==data;
		
		for(Node child : node.children) {
			multi(child,s,data,depth+1);
		}
	}
	
	
	//predessor and successor
	public void succ(int data) {
		succ(root,data,0,root.data);
	}
	public void succ(Node node,int data,int prev,int curr) {
//		if(data==root.data) {
//			System.out.println("pre is null");
//			
//		}
		if(data==node.data) {
			System.out.println("prev is "+prev);
			System.out.println("curr is "+curr);
		}
		for(Node child : node.children) {
			succ(child,data,curr,child.data);
		}
	}
	
	public int z;
	
	//just larger node
	public void larger(int data) {
		larger(root,data,0);
//		System.out.println(h);
	}
	public void larger(Node node,int data,int a) {
		//
		if(node.data>data) {
			
			if(a==0 || node.data<a) {
				System.out.println(node.data+" < "+a);
				a=node.data;
				z=a;
			}
		}
//		System.out.println(a);
		//
		for(Node child: node.children) {
			larger(child,data,a);
			
		}
		
	}
	
	public static void main(String[] args) {
		GenericTree_summitSIr2 d=new GenericTree_summitSIr2();
//		GenericTree_summitSIr2 other=new GenericTree_summitSIr2();
//		d.level();
//		d.mirror();
//		d.level();
//		d.dis();
//		System.out.println();
//		d.removeleaves();
//		d.dis();
//		System.out.println();
//		d.lin();
//		for(int i: d.s) {
//			System.out.println(i);
//		}
//		System.out.println(d.IsIsomorphic(other));
//		System.out.println(d.ismirror(other));
//		System.out.println(d.sem());
//		d.multisolver(120);
//		d.succ(110);
		d.larger(82);
		System.out.println(d.z);
	}

}
//10 3 20 2 50 0 60 0 30 3 70 0 80 2 110 0 120 0 90 0 40 1 100 0
