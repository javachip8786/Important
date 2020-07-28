
public class AddAtAnyIndexOfLL {
	public class Node{
		int data;
		Node next;
	}
	private Node head;
	private Node tail;
	private int size;

	
	public void addLast(int data) {
		if(size==0) {
			handleAddWhenSizeZero(data);
			return;
		}
		//create
		Node n=new Node();
		//set properties
		n.data= data;
		n.next=null;
		//attach
		tail.next= n;
		//summary
		tail=n;
		size++;
	}
	public void handleAddWhenSizeZero(int data) {
		Node n=new Node();
		n.data=data;
		n.next=null;
		head=tail=n;
		size++;
	}
	public void display() {
		Node temp= this.head;
		while(temp!=null) {
			System.out.print(temp.data+"  -->  ");
			temp=temp.next;
			
		}
		System.out.print(".");
	}
	public void AddFirst(int data) {
		Node n=new Node();
		n.data=data;
		n.next=head;
		head=n;
		size++;
	}
	public Node getIndex(int index) {
		
		Node node=head;
		for(int i=0;i<index;i++) {
			node=node.next;
		}
		return node;
		
	}
	
	public void AddAtAny(int data,int index) {
		if(index<0 || index>size) {
			System.out.print("not possible");
		}
		else if(index==size) {
			addLast(data);
		}
		else if(index==0) {
			AddFirst(data);
		}
		else {
			Node indexm1node=getIndex(index-1);
			Node indexnode=indexm1node.next;
			Node n=new Node();
			n.data=data;
			n.next=indexnode;
			indexm1node.next=n;
			size++;
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		AddAtAnyIndexOfLL list=new AddAtAnyIndexOfLL();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.display();
		list.AddAtAny(45,2);
		System.out.println();
		list.display();

	}

}
