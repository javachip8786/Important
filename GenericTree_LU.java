import java.util.*;
public class GenericTree_LU {

	public static class Node{
		int data;
		ArrayList<Node> childs=new ArrayList<>();
		Node(int data){
			this.data=data;
		}
	}
	
	public static Node creatTree(int[] arr) {
		Stack<Node> st=new Stack<>();
		for(int i=0;i<arr.length-1;i++) {
			int ele=arr[i];
			if(ele==-1) {
				Node node=st.peek();
				st.pop();
				st.peek().childs.add(node);
			}
			else {
				st.push(new Node(ele));
			}
		}
		return st.peek();
	}
	
	public static void preOrder(Node node) {
		System.out.println(node.data);
		for(int i=0;i<node.childs.size();i++) {
			Node c=node.childs.get(i);
			preOrder(c);
		}
	}
	
	public static void display(Node node)
	{
	    String str = (node.data) + " -> ";
	    for (Node child : node.childs)
	        str += (child.data) + ", ";
	    System.out.println(str);
//	    cout << str << endl;

	    for (Node child : node.childs)
	        display(child);
	}

	
	public static int height(Node root) {
		int h=-1;
		for(Node child: root.childs) {
			h=Math.max(h, height(child));
		}
		return h+1;
	}
	
	public static int size(Node root) {
		int s=0;
		for(Node child: root.childs) {
			s+=size(child);
		}
		return s+1;
	}
	
	
	public static boolean find(Node root, int data) {
		if(root.data==data) {
			return true;
		}
		for(int i=0;i<root.childs.size();i++) {
			Node c=root.childs.get(i);
			if( find(c,data)==true){
				return true;
			}
		}
		
		return false;
	}
	
	public static void LevelOrder(Node root) {
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		int h=0;
		while(q.size()!=0) {
			System.out.print("level "+h+" : " );
			int s=q.size();
			while(s>0) {
				Node d=q.peek();
				q.remove();
				System.out.print(d.data+" ");
				for(int i=0;i<d.childs.size();i++) {
					Node c=d.childs.get(i);
					q.add(c);
				}
				s--;
			}
			h++;
			System.out.println();
		}
	}
	
	public static Node getTail(Node node) {
		while(node.childs.size()!=0) {
			node=node.childs.get(0);
		}
		return node;
	}
	// Linearizing in O(n^2) using another fucntion getTail
	public static void linearize(Node root) {
		int n=root.childs.size();
		for(int i=n-1;i>=0;i--) {
			Node child = root.childs.get(i);
			linearize(child);
			
			if(i<n-1) {
				Node tail=getTail(child);
				tail.childs.add(root.childs.get(i+1));
				root.childs.remove(root.childs.size()-1);
			}
			
		}
	}
	
	//doing linearization in O(n)
	public static Node linearize2(Node root) {
		if(root.childs.size()==0) {
			return root;
		}
		int n=root.childs.size();
		Node lastTail = linearize2(root.childs.get(n-1));
		for(int i=n-2;i>=0;i--) {
			Node child=root.childs.get(i);
			Node secondLastTail= linearize2(child);
			secondLastTail.childs.add(root.childs.get(i+1));
			root.childs.remove(root.childs.size()-1);
		}
		return lastTail;
	}
	
//	public static void nodeToRootPath(Node node,int data) {
//		String str="";
//		str+=
//		
//	}
//	
//	public static void DistanceBetweenTwoNodes(Node node,int d1,int d2) {
//		
//	}
	
	//print all elements K distance away from root
	
	
	public static void main(String[] args) {
		int[] arr= {10,20,50,-1,60,-1,-1,30,70,-1,80,100,-1,110,-1,-1,90,-1,-1,40,120,140,-1,150,-1,-1,-1,-1};
		Node root=creatTree(arr);
//		preOrder(root);
//		System.out.println(height(root));
//		boolean f=find(root,40);
//		System.out.println(f);
//		LevelOrder(root);
		linearize(root);
//		LevelOrder(root);
//		linearize2(root);
		display(root);
//		LevelOrder(root);
//		PrintK(root,2,0);
//		System.out.println(path);
	}

}
