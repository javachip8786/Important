//
//public class Kreverse {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}


import java.io.*;
import java.util.*;

public class Kreverse {
    public static class Node{
        int data;
        Node next;
    }
    
    public static class LinkedList{
    public Node head;
    public Node tail;
    public int size;
    
    
    public void addLast(int data){
        if(size==0){
            Node s=new Node();
            s.data=data;
            s.next=null;
            head=tail=s;
            this.size++;
        }
        else{
            Node s=new Node();
            s.data=data;
            s.next=null;
            tail.next=s;
            tail=s;
            this.size++;
        }
    }
        
        
      public void display() {  
    	  Node temp=head;
    	  while(temp!=null) {
    		  System.out.print(temp.data+" ");
    		  temp=temp.next;
    	  }
    	  System.out.println();
      }
        
        
    public int removeFirst(){
        if(this.size==0){
            return -1;
        }
        if(this.size==1) {
        	int temp=head.data;
        	head=tail=null;
        	this.size=0;
        	return temp;
        }
        else{
            int temp1=head.data;
            Node temp=head;
            head=head.next;
            temp.next=null;
            this.size--;
            return temp1;
        }
    }
    
    public void addFirst(int data) {
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
    }
    
        
        public void Krev(int k){
        	LinkedList prev = null;

            while (this.size > 0) {
              LinkedList curr = new LinkedList();

              if (this.size >= k) {
                for (int i = 0; i < k; i++) {
                  int val = this.removeFirst();
//                  this.removeFirst();
                  curr.addFirst(val);
                }
              } else {
                int sz = this.size;
                for (int i = 0; i < sz; i++) {
                  int val = this.removeFirst();
//                  this.removeFirst();
                  curr.addLast(val);
                }
              }

              if (prev == null) {
                prev = curr;
              } else {
                prev.tail.next = curr.head;
                prev.tail = curr.tail;
                prev.size += curr.size;
              }
            }

            this.head = prev.head;
            this.tail = prev.tail;
            this.size = prev.size;
          }

    private int size() {
			return this.size;
		}
    
    
    
    private void displayReverseHelper(Node node){
        // write your code here
        if(node==null){
            return;
        }
        Node temp=node.next;
        displayReverseHelper(temp);
        System.out.println(temp.data);
      }

      public void displayReverse(){
        displayReverseHelper(this.head);
        System.out.println();
      }
      
      public void NR(int k) {
    	  int n=size-k;
    	  Node temp=head;
    	  for(int i=0;i<n;i++) {
    		  temp=temp.next;
    	  }
    	  tail.next=head;
    	  head=temp.next;
    	  temp.next=null;
      }
    }


	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn=new Scanner(System.in);
        LinkedList t=new LinkedList();
        int n=scn.nextInt();
        int k=scn.nextInt();
        for(int i=0;i<n;i++){
            int l=scn.nextInt();
            t.addLast(l);
        }
        t.display();
//        t.Krev(k);
       t.NR(k+1);
        t.display();
//        t.displayReverse();
    }
}