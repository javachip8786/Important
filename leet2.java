import java.util.*;
public class leet2 {
	public static class Node{
		char data;
		Node next;
	}
	public static int size;
	public static Node head;
	public static Node tail;
	
	//addlast
	public static void AddFirst(char data) {
		if(size==0) {
			Node s=new Node();
			s.data=data;
			s.next=null;
			head=tail=s;
			size++;
		}
		else {
			Node s=new Node();
			s.data=data;
			s.next=head;
			head=s;
			size++;
		}
		//dis();
	}
	
	//remove last
	public static void remove() {
		if(size==0) {
			return;
		}
		else if(size==1) {
			head=tail=null;
			size--;
		}
		else {
			head=head.next;
			size--;
		}
	}
	
	//peek
	public static char peek() {
		if(size<=0) {
			return 'a';
		}
		else {
			return head.data;
		}
	}
	
	public static boolean isValid(String str) {
		for(int i=0;i<str.length();i++) {
			//System.out.println(peek()+" ");
			
			if(str.charAt(i)==')') {
				if(peek()=='(') {
					remove();
				}
			}
			else if(str.charAt(i)=='}') {
				if(peek()=='{') {
					remove();
				}
			}
			else if(str.charAt(i)==']') {
				if(peek()=='[') {
					remove();
				}
			}
			else if(str.charAt(i)=='"') {
				if(peek()=='"') {
					remove();
				}
			}
			else {
				if(str.charAt(i)!=' ') {
					AddFirst(str.charAt(i));
				}
			}
//			System.out.print("size is "+size+"  ");
//			dis();
//			System.out.println();
		}
		if(size==0) {
			return true;
		}
		
		return false;
    }
	
	//display
	public static void dis() {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		String str=scn.nextLine();
		System.out.print(isValid(str));
//		for(int i=0;i<str.length();i++) {
//			AddLast(str.charAt(i));
//			//System.out.print(str.charAt(i)+" ");
//		}
//		dis();
	}

}
