
public class LectureSlidesDSA {
	public class Node{
		int data;
		Node next;
	}
	private Node head;
	private Node tail;
	int size;
	
	public void ADD(int data) {
		Node n=new Node();
		if(head==null) {
			n.data=data;
			head=tail=n;
			size++;
		}
		else {
			n.data=data;
			n.next=head;
			head=n;
			size++;
		}
	}
	
	public void disp() {
		Node temp=head;
		int count=0;
		while(temp!=null) {
			System.out.print(temp.data+"  ");
			temp=temp.next;
			count+=1;
		}
		System.out.print(count);
	}

	public static void main(String[] args) {
		LectureSlidesDSA list=new LectureSlidesDSA();
		list.ADD(5);
		list.ADD(15);
		list.ADD(25);
		list.ADD(35);
		list.disp();

	}

}
