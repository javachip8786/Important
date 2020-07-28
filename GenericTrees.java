import java.util.*;
public class GenericTrees {
	public class Node{
		int data;
		ArrayList<Node> children=new ArrayList<>();
		
	}
	private int size;
	private Node root;
	
	public GenericTrees() {
		root=construct(new Scanner(System.in),null,0); //i has no meaning,root has no parent
		
	}
	//expectation -> to create ith child of parent node
	private Node construct(Scanner scn,Node parent,int i) {
		if(parent==null) {
			System.out.println("enter the data for root");
		}
		else {
		System.out.println("enter the data for "+i+"th child of "+parent.data );
		}
		int cdata=scn.nextInt();
		Node child=new Node();
		size++;
		child.data=cdata;
		System.out.println("enter the number of children for "+child.data);
		int numgc=scn.nextInt();
		for(int j=0;j<numgc;j++) {
			Node gc=construct(scn,child,j);
			child.children.add(gc);
		}
		return child;
	}
	//size
	public int size() {
		return size;
	}
	//return true or false
	public boolean isEmpty() {
		return size==0;
	}
	
	public void display() {
		display(root);
	}
	public void display(Node node) {
		String str=node.data+" -> ";
		for(Node child: node.children) {
			str+=child.data+", ";
		}
		str+=".";
		System.out.println(str);
		for(Node child: node.children) {
			display(child);
		}
	}
	
//	public int size2() {
//		return size2(root);
//	}
	
	public int size2(Node node) {
		int size=0;
		for(Node child: node.children) {
			int csize=size2(child);
			size+=csize;
		}
		size+=1; //for root
		return size;
	}
	//max of tree
//	public int max() {
//		return max(root);
//	}
	public int max(Node node) {
		int rv=node.data;
		for(Node child: node.children) {
			int cmax= max(child);
			if(cmax>rv) {
				rv=cmax;
			}
		}
		return rv;
	}
	
//	public boolean find(int target) {
//		return find(root,target);
//	}
	public boolean find(Node node,int target) {
		if(node.data==target) {
			return true;
		}
		for(Node child: node.children) {
//			if(child.data==target) {
//				return true;
//			}
			boolean fic= find(child,target);
			if(fic) {
				return true;
			}
		}
		return false;
	}
	//height
	private int height() {
		return height(root);
	}
	private int height(Node node) {
		int cmaxhh=-1;
		for(Node child: node.children) {
			int cht=height(child);
			cmaxhh= Math.max(cmaxhh, cht);
		}
		return cmaxhh+1;
	}
	
	//preorder
	public void preo() {
		preo(root);
	}
	//rule-> node>children
	public void preo(Node node) {
		System.out.print(node.data+" ");
		for(Node child: node.children) {
			preo(child); //faith that child and family will get printed honoring the rules
		}
	}
	//posto
	public void posto() {
		posto(root);
	}
	//rule->children>node
	public void posto(Node node) {
		for(Node child: node.children) {
			posto(child); //faith that child and family will get printed honoring the rules
		}
		System.out.print(node.data+" ");	
	}
	
	//level order
	public void levelo() {
		LinkedList<Node> queue=new LinkedList<>();//add last remove first
		queue.addLast(root);
		while(queue.isEmpty()==false) {
			Node rem=queue.removeFirst();
			System.out.print(rem.data+" ");
			for(Node child: rem.children) {
				queue.addLast(child);
			}
		}
		System.out.println(".");
	
	}

	public static void main(String[] args) {

		GenericTrees tree=new GenericTrees();
		tree.display();
		System.out.println(tree.size2(tree.root));
		System.out.println(tree.size);
		System.out.println(tree.max(tree.root));
		System.out.println(tree.find(tree.root,120));
		System.out.println(tree.height());
		tree.preo();
		System.out.println();
		tree.posto();
		System.out.println();
		tree.levelo();
//10 3 20 2 50 0 60 0 30 3 70 0 80 2 110 0 120 0 90 0 40 1 100 0
	}

}
