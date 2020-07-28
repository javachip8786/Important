import java.util.*;
public class Graph_Carry_LevelUp {
	
	public static class edge{
		int src;
		int nbr;
		edge(int s,int n){
			src=s;
			nbr=n;
		}
	}
	
	public static void AddEdge(ArrayList<ArrayList<edge>> graph,int src,int nbr) {
		graph.get(src).add(new edge(src,nbr));
		graph.get(nbr).add(new edge(nbr,src));
	}
	
	
	//finding Mansion
	public static int findM(ArrayList<ArrayList<edge>> graph,boolean[] v,int src,int M) {
		if(src==M) {
			return -1;
		}
		v[src]=true;
		for(int i=0;i<graph.get(src).size();i++) {
			edge ce=graph.get(src).get(i);
			if(v[ce.nbr]==false) {
				return findM(graph,v,ce.nbr,M);
			}
		}
		v[src]=false;
		return 1;
	}
	
	
	
	//finding  des
	public static int find(ArrayList<ArrayList<edge>> graph,boolean[] v,int src,int des,int M,int ans) {
		if(src==des) {
//			System.out.println("yes mother fucker");
			int f=findM(graph,v,src,1);
			if(M==0 && f==1) {
//				System.out.println("first");
				return 1;
			}
			if(M==1 && f==-1) {
//				System.out.println("second");
				return 1;
			}
		}
		v[src]=true;
		
		for(int i=0;i<graph.get(src).size();i++) {
			edge ce=graph.get(src).get(i);
			if(v[ce.nbr]==false) {
				int h=find(graph,v,ce.nbr,des,M,ans);
				if(h==1) {
					ans=1;
				}
			}
		}
		v[src]=false;
		return ans;
	}
	
	
	//print
	public static void print(ArrayList<ArrayList<edge>> graph) {
		for(int i=0;i<graph.size();i++) {
			for(int j=0;j<graph.get(i).size();j++) {
				edge ce=graph.get(i).get(j);
				System.out.println("("+ce.src+" , "+ce.nbr+")");
			}
		}
	}
	
	

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		ArrayList<ArrayList<edge>> graph=new ArrayList<>();
		int n=scn.nextInt();
		
		for(int i=0;i<2*n;i++) {
			graph.add(new ArrayList<edge>());
		}
		
		for(int i=0;i<n-1;i++) {
			int s=scn.nextInt();
			int d=scn.nextInt();
			AddEdge(graph,s,d);
		}
		int test=scn.nextInt();
		for(int i=0;i<test;i++) {
			int M=scn.nextInt();
			int x=scn.nextInt();
			int y=scn.nextInt();
			int fin=find(graph,new boolean[graph.size()],y,x,M,-1);
//			int fin=findM(graph,new boolean[graph.size()],10,1);
			if(fin==1) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
//		print(graph);
	}

}
