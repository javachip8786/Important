public class GetIndexOfAnyNode {

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
	//data at any index
	public int DataAtIndex(int indx) {
		if(indx<0 || indx>=size || size==0) {
			return -1;
		}
		Node temp=head;
		for(int i=0;i<indx;i++) {
			temp=temp.next;
		}
		return temp.data;
		
	}
	public static void main(String[] args) {
		GetIndexOfAnyNode list=new GetIndexOfAnyNode();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.display();
		System.out.println("");
		System.out.println(list.DataAtIndex(3));

	}

}
