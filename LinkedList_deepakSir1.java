
public class LinkedList_deepakSir1 {
	
	public static class Node{
		int data;
		Node next;
		Node(int n){
			data=n;
		}
	}
	public static Node head;
	public static Node tail;
	public static int size;
	
	public static void AddLast(int n) {
		if(size==0) {
			Node s=new Node(n);
			s.next=null;
			head=tail=s;
			size++;
		}
		else {
			Node s=new Node(n);
			s.next=null;
			tail.next=s;
			tail=s;
			size++;
		}
	}
	
	public static void remove() {
		Node temp=head;
		if(size==0) {
			return;
		}
		else {
			
			while(temp.next!=tail) {
				if(temp.data==temp.next.data) {
					temp.next=temp.next.next;
					size--;
				}
				else {
					temp=temp.next;
				}
			}
		}
		if(temp.data==tail.data) {
			temp.next=null;
		}
		
	}
	
	
	
	public static void display() {
		if(size==0) {
			return;
		}
		else {
			Node temp=head;
			while(temp!=null) {
				System.out.print(temp.data+" ");
				temp=temp.next;
			}
		}
	}
	
	

	public static void main(String[] args) {
		AddLast(5);
		AddLast(5);
		AddLast(10);
		AddLast(10);
		AddLast(10);
		AddLast(10);
		display();
		remove();
		System.out.println();
		display();
	}

}
