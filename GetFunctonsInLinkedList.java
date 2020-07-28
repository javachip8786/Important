
public class GetFunctonsInLinkedList {
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
		//getFuntion
		public int getFunction() {
			if(size==0) {
				return -1;
			}
			return head.data;
		}
		//getFunctionwithexception
		//getLAst
		public int getLast() {
			if(size==0) {
				return -1;
			}
			//Node temp=head;
			//while(temp.next!=null) {
			//	temp=temp.next;
			//}
			//return temp.data;
			return tail.data;
		}
		public static void main(String[] args) {
			GetFunctonsInLinkedList list=new GetFunctonsInLinkedList();
			list.addLast(10);
			list.addLast(20);
			list.addLast(30);
			list.addLast(40);
			list.display();
			System.out.println("");
			System.out.println(list.getFunction());
			System.out.print(list.getLast());

		}

	
}
