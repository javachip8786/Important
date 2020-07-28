import java.util.*;
public class LinkedList_LU {
	public static class LL{
		public class Node{
			int data;
			Node next;
			Node(int n){
				data=n;
			}
		}
		private Node head;
		private Node tail;
		private int size;
		
		public void AddLast(int data) {
			if(size==0) {
				Node nn=new Node(data);
				nn.next=null;
				head=tail=nn;
				size++;
			}
			else {
				Node nn=new Node(data);
				nn.next=null;
				tail.next=nn;
				tail=nn;
				size++;
			}
		}
		public void removeLast() {
			if(size==0) {
				return;
			}
			else if(size==1) {
				head=tail=null;
				size--;
			}
			else {
				Node temp=head;
				while(temp.next!=tail) {
					temp=temp.next;
				}
				temp.next=null;
				size--;
			}
		}
		
		public void AddFirst(int data) {
			if(size==0) {
				Node nn=new Node(data);
				nn.next=null;
				head=tail=nn;
				size++;
			}
			else {
				Node nn=new Node(data);
				nn.next=head;
				head=nn;
				size++;
			}
		}
		
		public void removeFirst() {
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
		
		public void print(Node head) {
			if(size==0) {
				return;
			}
			else {
				Node temp=head;
				while(temp!=null) {
					System.out.print(temp.data+" --> ");
					temp=temp.next;
				}
			}
			System.out.println();
		}
		
		public int getAt(int idx) {
			if(idx==0) {
				return head.data;
			}
			if(idx>size) {
				System.out.println(" index out of bound ");
				return -1;
			}
			if(idx==size) {
				return tail.data;
			}
			else {
				Node temp=head;
				int i=0;
				while(i<idx) {
					temp=temp.next;
					i++;
				}
				return temp.data;
			}
		}
		
		public void AddAt(int idx,int data) {
			if(idx==0) {
				AddFirst(data);
			}
			else if(idx==size) {
				AddLast(data);
			}
			else {
				Node temp=head;
				int i=0;
				while(i<idx-1) {
					i++;
					temp=temp.next;
				}
				Node second =temp.next;
				Node nn=new Node(data);
				temp.next=nn;
				nn.next=second;
				size++;
			}
		}
		//leetcode 876
		public Node mid() {
			if(size==0) {
				return null;
			}
			else if(size==1) {
				return head;
			}
			else {
				Node t1=head;
				Node t2=head.next;
				while(t2!=null && t2.next!=null) {
					t1=t1.next;
					t2=t2.next.next;
				}
				return t1;
			}
		}
		
		public Node midNode() {
			if(size==0) {
				return null;
			}
			else if(size==1) {
				return head;
			}
			else {
				Node t1=head;
				Node t2=head;
				while(t2.next!=null && t2.next.next!=null) {
					t1=t1.next;
					t2=t2.next.next;
				}
				return t1;
			}
		}
		
		//206
		public Node Rev(Node head) {
			if(size==0) {
				return null;
			}
			else if(size==1) {
				return head;
			}
			else {
				Node temp=head;
				Node temp2=tail;
				Node prev=null;
				Node curr=head;
//				Node forw=head.next;
				while(curr!=null) {
					Node forw=curr.next;
					curr.next=prev;
					prev=curr;
					curr=forw;
				}
				tail=temp;
				head=temp2;
				return prev;
			}
		}
		
		//234
		public boolean isPlain() {
			if(size==0 || size==1) {
				return true;
			}
			Node mid=midNode();
			
			Node secondHalf=mid.next;
			mid.next=null;
			Node revSecond=Rev(secondHalf);
//			print(revSecond);
			
			Node t1=head;
			Node t2=revSecond;
			while(t1!=null && t2!=null) {
				if(t1.data!=t2.data) {
					return false;
				}
				t1=t1.next;
				t2=t2.next;
			}
			return true;
		}
		
		//Leetcode 143
		public void recorderList(Node head) {
			if(head==null && head.next==null) {
				return;
			}
			else {
				Node mid=midNode();
				Node secondHalf=mid.next;
				Node rev=Rev(secondHalf);
				mid.next=null;
				Node l1=head;
				Node l2=rev;
				while(l1!=null && l2!=null) {
					Node f1=l1.next;
					Node f2=l2.next;
					
					l1.next=l2;
					l2.next=f1;
					
					l1=f1;
					l2=f2;
				}
			}
		}
		
		//leetcode 19
		public Node RemoveNthNode(Node head,int idx) {
			if(head==null || head.next==null) {
				return null;
			}
			else {
				Node t1 = head;
				Node t2=head;
				int i=0;
				while(i<idx) {
					i++;
					t1=t1.next;
				}
				
				if(t2==null) {
					return head.next;
				}
				
				while(t1.next!=null) {
					t1=t1.next;
					t2=t2.next;
				}
				Node f2=t2.next.next;
				t2.next=f2;
				return head;
			}
		}
		
		//Merge two sorted list
		//leet 21
		public Node mergeTo(Node n1,Node n2) {
			Node s=new Node(-1);
			Node prev=s;
			Node c1=n1;
			Node c2=n2;
			while(c1!=null && c2!=null) {
				if(c1.data>c2.data) {
					s.next=c2;
					s=c2;
					c2=c2.next;
				}
				else {
					s.next=c1;
					s=c1;
					c1=c1.next;
				}
			}
			if(c1!=null) {
				s.next=c1;
			}
			if(c2!=null) {
				s.next=c2;
			}
			return prev.next;
		}
		
		//leetcode 23 Merge K Lists
		public Node MergeKLists(Node[] lists) {
			if(lists.length==0) {
				return null;
			}
			ArrayList<Node> list=new ArrayList<>();
			for(int i=0;i<lists.length;i++) {
				list.add(lists[i]);
			}
			while(list.size()!=1) {
				Node l1=list.remove(list.size()-1);
				Node l2=list.remove(list.size()-1);
				Node l3=mergeTo(l1,l2);
				list.add(l3);
			}
			return list.get(0);
		}
		
		
		//merge in lesser time
		//this is just like merge sort. divide them until its size is 1. then apply mergesort
		public Node mergeKLists02(Node[] lists, int li, int ri) { // O(Nlogk)
	        if (li == ri)
	            return lists[li];

	        int mid = (li + ri) / 2;

	        Node l1 = mergeKLists02(lists, li, mid);
	        Node l2 = mergeKLists02(lists, mid + 1, ri);
	        Node finalList = mergeTo(l1, l2);

	        return finalList;
	    }

	    public Node mergeKLists02(Node[] lists) {
	        if (lists.length == 0)
	            return null;

	        return mergeKLists02(lists, 0, lists.length - 1);
	    }
	    
	    
	    //leetcode 141 Cycle in LL
	    public boolean cycle(Node head) {
	    	if(head==null || head.next==null) {
	    		return false;   		//travelled the whole linked list and it breaks at a point, its not continuous
	    	}
//	    	else {
	    		Node slow=head;
	    		Node fast=head;
	    		while(fast!=null && fast.next!=null) {
	    			slow=slow.next;
	    			fast=fast.next.next;
	    			if(slow==fast) {
//	    				System.out.println(slow.data+" "+fast.data);
	    				return true;
	    			}
	    		}
//	    	}
	    	return false;
	    }
	    
	    //leetcode 142 meeting point in cycle
	    public Node cycle2(Node head) {
	    	if(head==null || head.next==null) {
	    		return null;
	    	}
//	    	else {
	    		Node slow=head;
	    		Node fast=head;
	    		while(fast!=null && fast.next!=null) {
	    			slow=slow.next;
	    			fast=fast.next.next;
	    			if(slow==fast) {
//	    				System.out.println(slow.data+" "+fast.data);
	    				return Mpoint(head,slow);
	    			}
	    		}
//	    	}
	    	return null;
	    }
	    
	    public Node Mpoint(Node head,Node temp) {
	    	while(head!=temp) {
	    		head=head.next;
	    		temp=temp.next;
	    	}
	    	return temp;
	    }
	    
	    //leetcode 160
	    public Node getInterS(Node headA,Node headB) {
	    	if(headA==null || headB==null) {
	    		return null;
	    	}
	    	Node curr=headA;
	    	while(curr.next!=null) {
	    		curr=curr.next;
	    	}
	    	curr.next=headB;
	    	Node s=cycle2(headA);
	    	curr.next=null;
	    	return s;
	    }
	    
	    //leetcode 25
	    Node oh=null, ot=null, th=null, tt=null;
	    public void AddFirst(Node n) {
	    	if(tt==null) {
	    		th=n;
	    		tt=n;
	    	}
	    	else {
	    		n.next=th;
	    		th=n;
	    	}
	    }
	    public int length(Node n) {
	    	int len=0;
	    	while(n!=null) {
	    		n=n.next;
	    		len++;
	    	}
	    	return len;
	    }
	    public Node Krev(Node head,int k) {
	    	if(head==null || head.next==null || k==0 || k==1) {
	    		return head;
	    	}
	    	int len=length(head);
	    	if(len < k) {
	    		return head;
	    	}
	    	Node curr=head;
	    	while(curr!=null && len>=k) {
	    		for(int temp=k;temp>0;temp--) {
	    			Node rnode=curr;
	    			curr=curr.next;
	    			rnode.next=null;
	    			AddFirst(rnode);
	    		}
	    		
	    		if(oh==null) {
	    			oh=th;
	    			ot=tt;
	    		}
	    		else {
	    			ot.next=th;
	    			ot=tt;
	    		}
	    		
	    		th=null;
	    		tt=null;
	    		len-=k;
	    	}
	    	ot.next=curr;
	    	return oh;
	    }
	    
	    //leetcode 92
	    public Node revNodes(Node head,int m,int n) {
	    	if(head==null || head.next==null || n==m) {
	    		return head;
	    	}
	    	int i=1;
	    	Node curr=head;
	    	Node prev=null;
	    	while(curr!=null) {
	    		while( i>= m && i<=n) {
	    			Node rnode = curr;
	    			curr = curr.next;
	    			rnode.next = null;
	    			AddFirst(rnode);
	    			i++;
	    		}
	    		if(i>n) {
	    			if(prev!=null) {
	    				prev.next=th;
	    			}
	    			else {
	    				head=th;
	    			}
	    			tt.next=curr;
	    			break;
	    		}
	    		
	    		prev=curr;
	    		curr=curr.next;
	    		i++;
	    	}
	    	return head;
	    }
	    
	
		public Node mid(Node node) {
			if(size==0 || size==1) {
				return node;
			}
			else {
				Node fast=head;
				Node slow=head;
				while(fast!=null) {
					fast=fast.next.next;
					slow=slow.next;
				}
				return slow;
			}
		}
	    
	   
	}
	
	
	

	public static void main(String[] args) {
		LL s=new LL();
		s.AddLast(12);
		s.AddLast(24);
		s.AddLast(36);
		s.AddLast(2);
//		s.AddLast(2);
		s.AddLast(6);
		s.AddLast(4);
		s.AddLast(1);
//		s.AddLast(25);
//		s.AddLast(6);
//		s.removeFirst();
		s.print(s.head);
//		s.head=s.Rev(s.head);
//		s.AddAt(2,16);
//		s.print();
//		int j=s.mid();
//		System.out.println(j);
//		boolean f=s.isPlain();
//		System.out.println(f);
//		s.recorderList(s.head);
//		s.print(s.head);
//		s.RemoveNthNode(s.head,2);
//		s.print(s.head);
		boolean f=s.cycle(s.head);
		System.out.println(f);
	}

}
