import java.util.*;
public class GenericTree_summitSir1 {
	public class Node{
		int data;
		ArrayList<Node> children=new ArrayList<>();
	}
	public int size;
	public Node root;
	
	public GenericTree_summitSir1() {
		this.root=construct(new Scanner(System.in),null,0);
			
	}
	public Node construct(Scanner scn,Node parent,int i) {
		if(parent==null) {
			System.out.println("enter the data of root");
		}
		else {
		System.out.println("enter the data for "+i+"th child of "+parent.data);
		}
		int  cdata=scn.nextInt();
		Node child=new Node();
		child.data=cdata;
		System.out.println("enter the number of children for "+child.data);
		int numgn=scn.nextInt();
		for(int j=0;j<numgn;j++) {
			Node gc=construct(scn,child,j);
			child.children.add(gc);
		}
		return child;
		
	}
	public void display() {
		display(root);
	}
	public void display(Node n) {
		String str=n.data+"-->";
		for(Node child : n.children) {
			str+=child.data+",";
		}
		System.out.println(str);
		for(Node child : n.children) {
			display(child);
		}
	}
	
	public int size2(Node root) {  //pass root here
		int size=0;
		for(Node child : root.children) {
			int csize=size2(child);
			size+=csize;
		}
		size+=1;
		return size;
	}
	public int max() {
		return MAX(root);
	}
	public static int MAX(Node root) {
		int rv=root.data;
		for(Node child:root.children) {
			int cmax=MAX(child);
			rv=Math.max(rv, cmax);
		}
		return rv;
	}
	
	public boolean find(int data) {
		return find(root,data);
	}
	
	public boolean find(Node node,int data) {
		if(node.data==data) {
			return true;
		}
		for(Node child:node.children) {
			boolean fic=find(child,data);
			if(fic==true) {
				return true;
			}
		}
		
		return false;
	}
	
	//preoder
	public void pre() {
		pre(root);
	}
	public void pre(Node node) {
		System.out.print(node.data+" ");
		for(Node child: node.children) {
			pre(child);
		}
	}
	
	//postoder
		public void post() {
			post(root);
		}
		public void post(Node node) {
			
			for(Node child: node.children) {
				post(child);
			}
			System.out.print(node.data+" ");
		}
		
	
	
	//level order
		public void levelo() {
			LinkedList<Node> queue=new LinkedList<>();
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
		
		
	//print levelwise
		public class pair{
			Node node;
			int level;
		}
		public void level() {
			LinkedList<pair> queue=new LinkedList<>();
			pair s=new pair();
			s.node=root;
			s.level=0;
			
			queue.addLast(s);
			pair prev=null;
			while(queue.size()>0) {
				pair cur=queue.removeFirst();
				if(prev!=null && prev.level!=cur.level) {
					System.out.println();
				}
				System.out.print(cur.node.data+" ");
				for(Node child:cur.node.children) {
					pair cpair=new pair();
					cpair.node=child;
					cpair.level=cur.level+1;
					queue.addLast(cpair);
				}
				prev=cur;
				}
		}

	public static void main(String[] args) {
		GenericTree_summitSir1 s=new GenericTree_summitSir1();
		s.display();
//		System.out.println(max());
		System.out.println(s.find(190));
		s.pre();
		System.out.println();
		s.post();
		System.out.println();
		s.levelo();
		s.level();
	}

}
// 10 3 20 2 50 0 60 0 30 3 70 0 80 2 110 0 120 0 90 0 40 1 100 0
