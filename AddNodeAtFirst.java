

public class AddNodeAtFirst {
	public class Node{
		int data;
		Node next;
	}
	private Node head;
	private Node tail;
	private int size;

	//addAtLast{
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
	//}
	public void display() {
		Node temp= this.head;
		while(temp!=null) {
			System.out.print(temp.data+"  -->  ");
			temp=temp.next;
			
		}
		System.out.print(".");
	}
	public void addAtLast(int data) {
		if(size==0) {
			handleAddWhenSizeZero(data);
			return;
		}
		//create
		Node n=new Node();
		//set properties
		n.data=data;
		n.next=head;
		//attach
		head=n;
		size++;
	}
	public static void main(String[] args) {
		AddNodeAtFirst list=new AddNodeAtFirst();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.display();
		list.addAtLast(50);
		System.out.println("");
		list.display();

	}

}
