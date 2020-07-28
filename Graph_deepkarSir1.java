import java.util.*;
public class Graph_deepkarSir1 {
	//class
	public static class edge{
		int source;  //source
		int neighbor; //neighbor
		int weight; //weight
		edge(int src,int nbr,int wt){
			this.source=src;
			this.neighbor=nbr;
			this.weight=wt;
		}
	}	
	public static void addEdge(ArrayList<ArrayList<edge>> graph,int src,int nbr,int wt) {
		graph.get(src).add(new edge(src,nbr,wt));
		graph.get(nbr).add(new edge(nbr,src,wt));		
	}
	public static void display(ArrayList<ArrayList<edge>> graph) {
		for(int i=0;i<graph.size();i++) {
			for(int j=0;j<graph.get(i).size();j++) {
				edge ce=graph.get(i).get(j);
				System.out.print(ce.source+"-->"+"["+ce.neighbor+"@"+ce.weight+']'+"  ");
			}
			System.out.println();
		}
	}
	
	//is path available
	public static boolean istrue(ArrayList<ArrayList<edge>> graph,int src,int nbr,boolean[] visited) {
		if(src==nbr) {
			return true;
		}
		visited[src]=true;
		for(int e=0;e<graph.get(src).size();e++) {
			edge ce=graph.get(src).get(e);
			if(visited[ce.neighbor]==false) {
				boolean recAns=istrue(graph,ce.neighbor,nbr,visited);
				if(recAns==true) return true;
			}
		}
		visited[src]=false;
		return false;
	}
	
	//print path available
		public static void istrue(ArrayList<ArrayList<edge>> graph,int src,int nbr,boolean[] visited,String path) {
			if(src==nbr) {
				System.out.println(path+nbr);
				System.out.println();
				//visited[src]=false;
				return;
			}
			visited[src]=true;
			for(int e=0;e<graph.get(src).size();e++) {
				edge ce=graph.get(src).get(e);
				if(visited[ce.neighbor]==false) {
					//visited[src]=true;
					istrue(graph,ce.neighbor,nbr,visited,path+ce.source+" ");
					//visited[src]=false;
				}
			}
			visited[src]=false;
		}
	
	//longest path wrong
	public static int longest(ArrayList<ArrayList<edge>> graph) {
		int csum=graph.get(0).get(0).weight;
		int fsum=graph.get(0).get(0).weight;
		for(int i=0;i<graph.size();i++) {
			for(int j=1;j<graph.get(i).size();j++) {
				edge ce=graph.get(i).get(j);
				if(csum<0) {
					csum=ce.weight;
				}
				else {
					csum+=ce.weight;
				}
				if(fsum<csum) {
					fsum=csum;
				}
			}
		}
		return fsum;
	}
	
	//highest cost and lowest min
	public static int mincost=Integer.MAX_VALUE;
	public static int maxcost=Integer.MIN_VALUE;
	public static String minpath="";
	public static String maxpath="";
	public static void cost(ArrayList<ArrayList<edge>> graph,int src,int nbr,boolean[] visited,String path,int csum) {
		if(src==nbr) {
			path+=nbr;
			if(csum < mincost && csum>39) {
				mincost=csum;
				minpath=path;
			}
			if(csum > maxcost && csum<39) {
				maxpath=path;
				maxcost=csum;
			}
			return;
		}
		visited[src]=true;
		for(int e=0;e<graph.get(src).size();e++) {
			edge ce=graph.get(src).get(e);
			if(visited[ce.neighbor]==false) {
				//visited[src]=true;
				cost(graph,ce.neighbor,nbr,visited,path+ce.source+" ",csum+ce.weight);
				//visited[src]=false;
			}
		}
		visited[src]=false;
	}
	
	//ceil and floor cost and their path
	public static int floorcost=Integer.MAX_VALUE;
	public static int ceilcost=Integer.MIN_VALUE;
	public static String floorpath="";
	public static String ceilpath="";
	public static void ceilandfloor(ArrayList<ArrayList<edge>> graph,int src,int nbr,boolean[] visited,String path,int csum,int target) {
		if(src==nbr) {
			path+=nbr;
			if(csum < floorcost && csum>target) {
				floorcost=csum;
				floorpath=path;
			}
			if(csum > ceilcost && csum<target) {
				ceilpath=path;
				ceilcost=csum;
			}
			return;
		}
		visited[src]=true;
		for(int e=0;e<graph.get(src).size();e++) {
			edge ce=graph.get(src).get(e);
			if(visited[ce.neighbor]==false) {
				//visited[src]=true;
				ceilandfloor(graph,ce.neighbor,nbr,visited,path+ce.source+" ",csum+ce.weight,target);
				//visited[src]=false;
			}
		}
		visited[src]=false;
	}
	
	public static void Kthpath(ArrayList<ArrayList<edge>> graph,int src,int nbr,int k) {
		int factor=Integer.MIN_VALUE;
		boolean[] visited=new boolean[graph.size()];
		for(int i=0;i<k;i++) {
			floorcost=Integer.MAX_VALUE;
			ceilandfloor(graph,src,nbr,visited,"",0,factor);
			factor=floorcost;
		}
		System.out.print(floorcost+" --> "+floorpath);
	}
	
	
	//Hamiltonian path and cycle
	public static void Hpath(ArrayList<ArrayList<edge>> graph,int s,ArrayList<Integer> arr,boolean[] visited,int fin) {
		if(arr.size()==graph.size()-1) {
			arr.add(s);
			for(int i=0;i<arr.size();i++) {
				System.out.print(arr.get(i)+" ");
			}
			boolean isCycle=false;
			for(int e=0;e<graph.get(s).size();e++) {
				edge ce=graph.get(s).get(e);
				if(ce.neighbor==fin) {
					isCycle=true;
					break;
				}
			}
			if(isCycle) {
				System.out.println(".");
			}
			arr.remove(arr.size()-1);
			System.out.println();
			return;
		}
		
		
		visited[s]=true;
		arr.add(s);
		for(int e=0;e<graph.get(s).size();e++) {
			edge ce=graph.get(s).get(e);
			if(visited[ce.neighbor]==false) {
				Hpath(graph,ce.neighbor,arr,visited,fin);
			}
		}
		
		arr.remove(arr.size()-1);
		visited[s]=false;
	}
	
	
	//components in a graph getcomp function
	public static void getcomp(ArrayList<ArrayList<edge>> graph,ArrayList<Integer> comp,boolean[] visited,int fin) {
		visited[fin]=true;
		comp.add(fin);
		for(int e=0;e<graph.get(fin).size();e++) {
			edge ce=graph.get(fin).get(e);
			if(visited[ce.neighbor]==false) {
				getcomp(graph,comp,visited,ce.neighbor);
			}
		}
	}
	
	//components in a graph 
	public static int compo(ArrayList<ArrayList<edge>> graph) {
		int count=0;
		boolean[] visited=new boolean[graph.size()];
		for(int e=0;e<graph.size();e++) {
			if(visited[e]==false) {
				count++;
				ArrayList<Integer> singlecomp=new ArrayList<>();
				getcomp(graph,singlecomp,visited,e);
				System.out.println(singlecomp);
			}
		}
		return count;
	}
	
	//level order of graph  BSF- breadth first search
	public static class bfsHelper
	{
		int vtx;
		String path;
		int cost;
		bfsHelper(int v,String p,int c){
			vtx=v;path=p;cost=c;
		}
	
	
	}	
		public static void bfs(ArrayList<ArrayList<edge>> graph,int s) {
	
		Queue<bfsHelper> qu=new LinkedList<>();
		boolean[] visited=new boolean[graph.size()];
		qu.add(new bfsHelper(s," "+s+"-->",0));
		visited[0]=true;
		while(qu.size()>0) {
			bfsHelper cv=qu.remove();
			System.out.println(cv.path+" @ "+cv.cost);
			for(int e=0;e<graph.get(cv.vtx).size();e++) {
				edge ce=graph.get(cv.vtx).get(e);
				if(visited[ce.neighbor]==false) {
					visited[ce.neighbor]=true;
					qu.add(new bfsHelper(ce.neighbor,cv.path+ce.neighbor+"-->",cv.cost+ce.weight));
				}
			}
		}
	}
		
	//using priority to print min path
		public static class Helper implements Comparable<Helper>{
			int vtx;
			String path;
			int cost;
			Helper(int v,String p,int c){
				this.vtx=v;this.path=p;this.cost=c;
			}
			public int compareTo(Helper other) {
				if(this.cost==other.cost) {
					return this.vtx-other.vtx;
				}
				else {
					return this.cost- other.cost;
				}
//				return this.cost- other.cost;
			}
		}
		
		
		public static void dijkstra(ArrayList<ArrayList<edge>> graph,int s) {
			PriorityQueue<Helper> pq=new PriorityQueue<>();
			boolean[] visited=new boolean[graph.size()];
			Helper root=new Helper(s,""+s,0);
			pq.add(root);
			while(pq.size()>0) {
				//remove
				Helper cv=pq.remove();
				//mark
				if(visited[cv.vtx]==true) {
					continue;
				}
				else {
					visited[cv.vtx]=true;
				}
				//work
				System.out.println(cv.path+" @ "+cv.cost);
				for(int i=0;i<graph.get(cv.vtx).size();i++) {
					edge ce=graph.get(cv.vtx).get(i);
					if(visited[ce.neighbor]==false) {
						Helper newvtx=new Helper(ce.neighbor,cv.path+" --> "+ce.neighbor,cv.cost+ce.weight);
						pq.add(newvtx);
					}
				}
			}
		}
		
		//spanning Graph- contains all vertices but remove cycle edge.
		//using priority to print min path
		public static class primsHelper implements Comparable<primsHelper>{
			int vtx;
			int par;
			int cost;
			primsHelper(int v,int p,int c){
				this.vtx=v;this.par=p;this.cost=c;
			}
			public int compareTo(primsHelper other) {
				return this.cost - other.cost;
			}
		}
		public static void Maxdijkstra(ArrayList<ArrayList<edge>> graph,int s) {
			ArrayList<ArrayList<edge>> mst=new ArrayList<>();
			for(int i=0;i<graph.size();i++) {
				mst.add(new ArrayList<edge>());
			}
			
			PriorityQueue<primsHelper> pq=new PriorityQueue<>();
			primsHelper rootNode = new primsHelper(2,-1,0);
			boolean[] visited=new boolean[graph.size()];
			
			pq.add(rootNode);
			while(pq.size()>0) {
				//remove
				primsHelper cv=pq.remove();
				//mark
				if(visited[cv.vtx]==true) {
					continue;
				}
				else {
					visited[cv.vtx]=true;
				}
				//work
				if(cv.par!=-1) {
					addEdge(mst,cv.vtx,cv.par,cv.cost);
				}
				//add nbrs
				for(int i=0;i<graph.get(cv.vtx).size();i++) {
					edge ce=graph.get(cv.vtx).get(i);
					if(visited[ce.neighbor]==false) {
						primsHelper newvtx=new primsHelper(ce.neighbor,cv.vtx,ce.weight);
						pq.add(newvtx);
					}
				}
			}
			display(mst);
		}
	
	
	public static void main(String[] args) {
		ArrayList<ArrayList<edge>> graph=new ArrayList<>();
		for(int i=0;i<=6;i++) {
			graph.add(new ArrayList<edge>());
		}
		addEdge(graph,0,1,10);
		addEdge(graph,0,3,40);
		addEdge(graph,1,2,10);
		addEdge(graph,2,3,10);
		addEdge(graph,3,4,2);
		addEdge(graph,2,5,20);
		addEdge(graph,4,5,3);
		addEdge(graph,5,6,3);
		addEdge(graph,4,6,8);
//		display(graph);
		boolean[] visited=new boolean[graph.size()];
	//	System.out.print(istrue(graph,1,6,visited));
		//istrue(graph,0,6,visited,"");
		//System.out.println(longest(graph));
//		cost(graph,0,6,visited,"",0);
//		System.out.println(maxpath+" is maxpath and cost is "+maxcost);
//		System.out.print(minpath+" is minpath cost is "+mincost);
		
//		ceilandfloor(graph,0,6,visited,"",0,49);
//		System.out.println(ceilpath+" is ceilpath and cost is "+ceilcost);
//		System.out.print(floorpath+" is floorpath cost is "+floorcost);
		
//		Kthpath(graph,0,6,2);
//		Hpath(graph,0,new ArrayList<Integer>(),visited,0);
	//	System.out.println(compo(graph));
//		bfs(graph,0);
//		dijkstra(graph,0);
//		Maxdijkstra(graph,0);
		Maxdijkstra(graph,0);
	}
}