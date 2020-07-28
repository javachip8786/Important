
public class HAcker1_LL {
	public static class LL{
	public class Node{
		int data;
		Node next;
	}
	public static Node head;
	public static Node tail;
	public static int size;
	
	//AddLast
	public void AddLast(int data) {
		if(size==0) {
			Node nn=new Node();
			nn.data=data;
			nn.next=tail;
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
	
	public static void print() {
		if(size!=0) {
			Node temp=head;
			while(temp!=null) {
				System.out.print(temp.data+" ");
				temp=temp.next;
			}
		}
		System.out.println();
	}
	
	
	public static int[] merge() {
		if(size<=1) {
			return;
		}
		int mid=size/2;
		LL left=new LL();
		LL right=new LL();
		
		Node temp=head;
		int lp=0;
		while(lp<mid) {
			left.AddLast(temp.data);
			temp=temp.next;
		}
		Node temp2=temp;
		int rp=0;
		while(rp<mid) {
			right.AddLast(temp2.data);
			temp2=temp2.next;
		}
		left=merge(left);
		right=merge(right);
		int[] result=new int[left.length+right.length];
		result=mergeS(left,right);
		return result;
	}
	
	public static int[] mergeS(int[] left,int[] right) {
		int[] result=new int[left.length+right.length];
		int lp,rp,resp;
		lp=rp=resp=0;
		while(lp<left.length || rp<right.length) {
			if(lp<left.length && rp<right.length) {
				if(left[lp]<right[rp]) {
					result[resp++]=left[lp++];
//					resp++;lp++;
				}
				else {
					result[resp++]=right[rp++];
//					resp++;
//					rp++;
				}
			}
			else if(lp<left.length) {
				result[resp++]=left[lp++];
//				resp++;
//				lp++;
			}
			else if(rp<right.length) {
				result[resp++]=right[rp++];
//				resp++;
//				rp++;
			}
		}
		return result;
	}
	}
	
	
	
	

	public static void main(String[] args) {
		LL s=new LL();
		s.AddLast(3);
		s.AddLast(2);
		s.AddLast(9);
		s.AddLast(13);
		s.AddLast(4);
		s.AddLast(5);
		s.print();
		
		
	}

}
