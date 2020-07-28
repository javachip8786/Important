
//to add sum numbers and display them
public class Linked_List {
	public class Node{
		int data;
		Node next;
	}
	private Node mid;
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
		if(size%2==0) {
			mid=mid.next;
		}
	}
	public void handleAddWhenSizeZero(int data) {
		Node n=new Node();
		n.data=data;
		n.next=null;
		head=tail=n;
		size++;
		mid=n;
	}
	public void display() {
		Node temp= this.head;
		while(temp!=null) {
			System.out.print(temp.data+"  -->  ");
			temp=temp.next;
			
		}
		System.out.print(".");
	}
	
	public int removeFirst() {
		if(size==0) {
			return -1;
		}
		if(size==1) {
			int val=head.data;
			head=tail=null;
			size--;
			return val;
		}
		else {
			int val=head.data;
			head=head.next;
			size--;
			return val;
		}
	}
	
	 public void bubble(){
	       
	        for(int i=0;i<size;i++){
	             Node temp=head;
	        Node temp2=head.next;
	            while(temp!=tail){
	                if(temp.data>temp2.data){
	                    int t=temp.data;
	                    temp.data=temp2.data;
	                    temp2.data=t;
	                }
	                temp=temp2;
	                if(temp2.next!=null){
	                    temp2=temp2.next;
	            }
	             }
	        }
	    }
	 
	 public void selection() {
		 Node temp=head;
		 while(temp!=tail) {
			 Node temp2=temp;
			 while(temp2!=null) {
				 if(temp2.data<temp.data) {
					 int t=temp2.data;
					 temp2.data=temp.data;
					 temp.data=t;
				 }
				 temp2=temp2.next;
			 }
			 temp=temp.next;
		 }
	 }
	 //remove duplicate
	 public void removeD() {
		 Node temp=head;
		 while(temp!=null) {
			 Node temp2=temp.next;
			 while(temp2!=null) {
				 if(temp.data==temp2.data) {
						 temp.next=temp2.next;
				 }
				 temp2=temp2.next;
			 }
			 temp=temp.next;
			
		 }
	 }
	 public void RD() {
		 Node temp1=null; Node temp2=null; Node temp=null;
		 temp1=head;
		 while(temp1!=null && temp1.next!=null) {
			 temp2=temp1;
			 while(temp2.next!=null) {
				 if(temp1.data==temp2.next.data){
					 temp=temp2.next;
					 temp2.next=temp2.next.next;
				 }
				 else {
					 temp2=temp2.next;
				 }
			 }
			 temp1=temp1.next;
		 }
	 }
	 
	 //first all odd elements then all even elements
	 public void OE() {
		 Node temp=head;
		 Linked_List odd=new Linked_List();
		 Linked_List even=new Linked_List();
		 while(this.size!=0) {
			 int s=removeFirst();
			 if(s%2==0) {
				 even.addLast(s);
			 }
			 else {
				 odd.addLast(s);
			 }
			 
		 }
		 if(odd.size!=0 && even.size==0) {
			 this.head=odd.head;
			 this.tail=odd.tail;
		 }
		 else if(odd.size==0 && even.size!=0) {
			 this.head=even.head;
			 this.tail=even.tail;
		 }
		 else {
			 this.head=odd.head;
			 odd.tail.next=even.head;
			 this.tail=even.tail;
		 } 
	 }
	 
	 //middle element
	 public void Middle() {
		 System.out.println(mid.data);
	 }
	 
	 //mergesort
	 public void merge() {
		 if(this.size<=1) {
			 return;
		 }
		 
	 }
	
	 
	public static void main(String[] args) {
		Linked_List list=new Linked_List();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		list.addLast(6);
		list.addLast(7);
		list.addLast(8);
		list.addLast(9);
		list.addLast(10);
//		list.bubble();
//		list.selection();
		list.display();
//		list.RD();
		list.OE();
		System.out.println();
		list.display();
		System.out.println();
		list.Middle();

	}

}
