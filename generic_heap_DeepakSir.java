import java.util.ArrayList;

public class generic_heap_DeepakSir {
	
	//Priority Queue Class
	public static class PQ<T extends Comparable<T>>{
		
		ArrayList<T> list=new ArrayList<T>();
		
		public void upheapify(int idx) {
			if(idx==0) {
				return;
			}
			int pi=(idx-1)/2;
			if(idx!=0 && isSwap(pi,idx)) {
				swap(idx,pi);
				upheapify(pi);
			}
			
		}
		
		public void downheapify(int pi) {
			int lc=(pi*2)+1;
			int rc=(pi*2)+2;
			int si=pi;
			if(lc<list.size() && isSwap(pi,lc)) {
				si=lc;
			}
			if(rc<list.size() && isSwap(pi,rc)) {
				if(isSwap(lc,rc)) {
					si=rc;
				}
			}
			if(si!=pi) {
				swap(pi,si);
				downheapify(si);
			}
		}
		
		public boolean isSwap(int i,int j) {
			T ith=list.get(i);
			T jth=list.get(j);
			if(ith.compareTo(jth)>0) {
				return true;
			}
			return false;
		}
		
		public void add(T data) {
			list.add(data);
			upheapify(list.size()-1);
		}
		
		public void swap(int i,int j) {
			T temp = list.get(i);
			list.set(i, list.get(j));
			list.set(j, temp);
		}
		
		public T remove() {
			swap(0,list.size()-1);
			T n=list.get(list.size()-1);
			list.remove(list.size()-1);
			downheapify(0);
			return n;
		}
		
		public T peek() {
			return list.get(0);
			
		}
		
		public int size() {
			return list.size();
		}
		
		public void print() {
			for(int i=0;i<list.size();i++) {
				System.out.println(list.get(i));
			}
		}

		
	}
	

	//Node Class
	public static class student implements Comparable<student> {
		int rollNo;
		String name;
		int marks;
		student(int r,String n,int m){
			this.rollNo=r;
			this.name=n;
			this.marks=m;
		}
		public int compareTo(student other) {
			return this.marks - other.marks;		//this is for min heap
//			return other.marks - this.marks;       // this is for max heap
		}
	}
	

	
	public static void main(String[] args) {
		//this is min type. we give our own data type here
		
		PQ<student> pq=new PQ<>();
		pq.add(new student(4,"abc",75));
		pq.add(new student(5,"abc",80));
		pq.add(new student(6,"abc",120));
		pq.add(new student(1,"abc",60));
		pq.add(new student(2,"abc",65));
		pq.add(new student(3,"abc",70));
		
		
		while(pq.size()>0) {
			student st=pq.remove();
			System.out.println(st.rollNo+" -> "+st.name+" "+st.marks);
		}
	}

}
