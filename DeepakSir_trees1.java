
public class DeepakSir_trees1 {
	public static class Node{
		int data;
		Node next;
	}
	public static Node head;
	public static Node tail;
	public static int size;
	
	public static void AddAtLast(int data) {
		if(size==0) {
			Node nn=new Node();
			nn.data=data;
			nn.next=null;
			head=tail=nn;
			size++;
		}
		else {
			Node nn=new Node();
			nn.data=data;
			nn.next=null;
			tail.next=nn;
			tail=nn;
			size++;
		}
		
	}
	
	public static void popout() {
		Node temp=head;
		while(temp.next!=tail) {
			temp=temp.next;
		}
//		System.out.println(temp.data);
		temp.next=null;
		size--;
	}
	
	public static void display() {
		Node first=head;
		while(first!=null) {
			System.out.print(first.data+"  ");
			first=first.next;
		}
		System.out.println();
		
	}

	public static void main(String[] args) {
		AddAtLast(20);
		AddAtLast(30);
		AddAtLast(40);
		AddAtLast(50);
		display();
		popout();
		display();

	}

}
