import java.util.*;

public class GraphLU2 {
// CLASS 24 
	
	public static class edge{
		int src;
		int nbr;
		int wt;
		edge(int s,int n,int w){
			src=s;
			nbr=n;
			wt=w;
		}
	}
	
	public static int N=14;
	public static ArrayList<edge>[] graph=new ArrayList[N];
	
	public static void addEdge(ArrayList<edge>[] graph,int src,int nbr,int wt) {
		graph[src].add(new edge(src,nbr,wt));
		graph[nbr].add(new edge(nbr,src,wt));
	}
	
	public static void display(ArrayList<edge>[] graph) {
		for(int i=0;i<graph.length;i++) {
			for(int j=0;j<graph[i].size();j++) {
				edge ce=graph[i].get(j);
				System.out.println(ce.src+"-->"+"[ "+ce.nbr+" @ "+ce.wt+" ]"+"  ");
			}
//			System.out.println();
		}
	}
	
	public static void DFS(int src, boolean[] vis,ArrayList<edge>[] graph, ArrayList<Integer> res)
	{
	    vis[src] = true;
	    for (edge e : graph[src])
	    {
	        if (!vis[e.nbr])
	            DFS(e.nbr, vis, graph, res);
	    }

	    res.add(src);
	}
	
	
	public static void KosaRajuAlgoFor_SCC()
	{
//	    vector<bool> vis(N, false);
		boolean[] vis=new boolean[N];
		ArrayList<Integer> res=new ArrayList<>();
//		int[] res=new int[N];
//	    vector<int> res;

	    for (int i = 0; i < N; i++)
	        if (!vis[i])
	            DFS(i, vis, graph, res);

//	    vector<vector<Edge>> gp(N, vector<Edge>());
	    ArrayList<edge>[] gp=new ArrayList[N];
	    for(int i=0;i<N;i++) {
	    	gp[i]=(new ArrayList<>());
	    }
	    
	    for (int i = 0; i < N; i++)
	        for (edge e : graph[i])
	            gp[e.nbr].add(new edge(i,e.nbr, e.wt));

	    for (int i = 0; i < N; i++)
	        vis[i] = false;
	    int count = 1;
//	    vector<int> vtx;
	    ArrayList<Integer> vtx=new ArrayList<>();

	    for (int i = res.size() - 1; i >= 0; i--)
	        if (!vis[res.get(i)])
	        {
	            DFS(res.get(i), vis, gp, vtx);
//	            cout << count++ << " -> ";
	            System.out.print(count+" --> ");
	            count++;
	            while (vtx.size() != 0)
	            {
	            	System.out.print(vtx.get(vtx.size()-1) +" , ");
//	                cout << vtx.back() << ", ";
	                vtx.remove(vtx.size()-1);
	            }
//	            cout << endl;
	            System.out.println();
	        }
	}

	
	
	
	public static int[] par=new int[N];
	public static int[] size=new int[N];
//	public static void UnionFind(int n) {
//		for(int i=0;i<n;i++) {
//			par.add(i);
//			size.add(1);
//		}
//		for(ArrayList<edge> e : graph) {
//			int u=e;
//			int 
//		}
//	}
	public static int findPar(int u) {
		if(par[u]==u) {
			return u;
		}
		return par[u] = findPar(par[u]);
	}
	public static void merge(int p1,int p2) {
		if(size[p1] < size[p2]) {
			par[p1]=p2;
			size[p2] += size[p1];
		}
		else {
			par[p2] = p1;
			size[p1] += size[p2];
		}
	}
	
//	public static void UnionFind(int n, ArrayList<Integer>[] edges)
//	{
////	    graph=new ArrayList<ArrayList<edge>>();
//	    for (int i = 0; i < n; i++)
//	    {
//	        par[i]=i;
//	        size[i]=1;
//	    }
//
//	    for ( ArrayList<Integer> e : edges)
//	    {
//	        int u = e.get(0);
//	        int v = e.get(1);
//	        int w = e.get(2);
//
//	        int p1 = findPar(u);
//	        int p2 = findPar(v);
//
//	        if (p1 != p2)
//	        {
//	            merge(p1, p2);
//	            addEdge(u, v, w);
//	        }
//	    }
//
//	    display(graph);
//	}
	
	//Leetcode 1061
	public static int[] parent=new int[26];
	public static String smallestESS(String A,String B,String C) {
		for(int i=0;i<26;i++) {
			parent[i]=A.charAt(i);
		}
		for(int i=0;i<A.length();i++) {
			char ch1= A.charAt(i);
			char ch2= B.charAt(i);
			int p1 = findPar(ch1 - 'a');
			int p2 = findPar(ch2 - 'a');
			par[p1]=Math.min(p1, p2);
			par[p2] = Math.min(p1, p2);
		}
		String ans="";
		for(int i=0;i<C.length();i++) {
			ans+=(char)(findPar(C.charAt(i)-'a')+'a');
		}
		return ans;
	}
	
	
	public static void AddEdge(ArrayList<ArrayList<edge>> graph,int src,int nbr,int wt) {
		graph.get(src).add(new edge(src,nbr,wt));
//		graph.get(nbr).add(new edge(nbr,src,wt));
	}
	
	//KrusKal==== Making a graph from arrayList of edges, by minimum spanning tree. -> there's no cycle, all edges are minimum weight
	public static void KrusKal(int n,int[][] pages) {
		ArrayList<edge>[] gp=new ArrayList[n];
//		ArrayList<ArrayList<edge>> gp=new ArrayList<>();		//You can do this by ArrayList<ArrayList<edge >> too
//		for(int i=0;i<n;i++) {
//			gp.add(new ArrayList<edge>());
//		}
		for(int i=0;i<n;i++){
            gp[i] = new ArrayList<edge>();
        }
		for (int i = 0; i < n; i++)
		    {
		        par[i]=i;
		        size[i]=1;
		    }
		
	    for(int[] ce: pages){

	    		int u = ce[0];
		        int v = ce[1];
		        int w = ce[2];

		        int p1 = findPar(u);
		        int p2 = findPar(v);
		        
		        if (p1 != p2)
		        {
		            merge(p1, p2);
		            addEdge(gp,u,v,w);
		            		
		        }
//	    	}
	    }
	    display(gp);
//	    return gp;
	}
	
	
	//spanning tree -- Tree with No Cycle, starting from 0 as source
	//Prims Algo is the same, just use priority queue instead of Queue
	public static void BFS(int src, boolean[] vis) {
		Queue<int[]> que=new LinkedList<>();
		que.add(new int[]{src,-1,0});
		ArrayList<edge>[] gp=new ArrayList[N];
		for(int i=0;i<N;i++) {
			gp[i]=(new ArrayList<edge>());
		}
		while(que.size()!=0) {
			int size=que.size();
			while(size-->0) {
				int[] rvtx=que.peek();
				que.remove();
				if(vis[rvtx[0]]==true) {
					continue;
				}
				if(rvtx[1]!=-1) {
					addEdge(gp,rvtx[0],rvtx[1],rvtx[2]);
				}
				vis[rvtx[0]]=true;
				for(edge e: graph[rvtx[0]]) {
					if(vis[e.nbr]==false) {
						que.add(new int[] {e.nbr,rvtx[0],e.wt});
					}
				}
			}
		}
		display(gp);
	}
	
	//Minimum Spanning Tree
	public static void BFS_Prims(int src, boolean[] vis) {
//		Queue<int[]> que=new LinkedList<>();
		
//		PriorityQueue<int[]> que = new PriorityQueue<int[]>();
		PriorityQueue<int[]> que = new PriorityQueue<>((a,b)-> {
			return a[2] - b[2];
		});
//		PriorityQueue<int[]> que=new PriorityQueue<>();
		que.add(new int[]{src,-1,0});
		ArrayList<edge>[] gp=new ArrayList[vis.length];
		for(int i=0;i<vis.length;i++) {
			gp[i]=(new ArrayList<edge>());
		}
//		int noOfEdges=0;
//		int total=N;
		while(que.size()!=0) {
//			int size=que.size();
//			while(size-->0) {
				int[] rvtx=que.peek();
				que.remove();
				if(vis[rvtx[1]]==true) {
					continue;
				}
				if(rvtx[2]!=-1) {
					addEdge(gp,rvtx[1],rvtx[2],rvtx[0]);
//					noOfEdges++;
				}
				vis[rvtx[1]]=true;
				for(edge e: graph[rvtx[1]]) {
					if(vis[e.nbr]==false) {
						que.add(new int[] {e.wt,e.nbr,rvtx[1]});
					}
				}
//			}
		}
		display(gp);
	}
	
	
	public static void primsAlgo(int src, boolean[] vis)
	{
		PriorityQueue<int[]> que = new PriorityQueue<>((a,b)-> {
			return a[2] - b[2];
		});
		que.add(new int[]{0, src, -1});                                                     //{weight, u, v}


	    ArrayList<edge>[] gp=new ArrayList[N];
		for(int i=0;i<N;i++) {
			gp[i]=(new ArrayList<edge>());
		}
	    while (que.size() != 0)
	    {
	        int size = que.size();
	        while (size-- > 0)
	        {
	            int[] rvtx = que.peek();
	            que.remove();

	            if (vis[rvtx[1]])
	                continue;

	            if (rvtx[2] != -1)
	                addEdge(gp, rvtx[1], rvtx[2], rvtx[0]); //{u, v, w}

	            vis[rvtx[1]] = true;
	            for (edge e : graph[rvtx[1]])
	            {
	                if (!vis[e.nbr])
	                    que.add(new int[]{e.wt, e.nbr, rvtx[1]});
	            }
	        }
	    }

	    display(gp);
	}
	
	
	
//	PriorityQueue<int[]> que=new PriorityQueue<>((a,b)-> {
//		return a[2]-b[2];
//	});
	public static class pri{
		int src;
		int nbr;
		int wt;
		pri(int s,int n,int w){
			src=s;
			nbr=n;
			wt=w;
		}
	}
	
	//
	public static void Prims(int src,boolean[] vis) {
		
		ArrayList<edge>[] gp=new ArrayList[N];
		for(int i=0;i<N;i++) {
			gp[i]=(new ArrayList<edge>());
		}
		
		PriorityQueue<pri> que = new PriorityQueue<>((a,b)-> {  //Min Priority Queue on the basis of weight
			return a.wt - b.wt;
		});
		que.add(new pri(src,-1,0));
		
		while(que.size()!=0) {
			pri p=que.peek();
			que.remove();
			if(vis[p.src]==true) {
				continue;
			}
			if(p.nbr!=-1) {
				addEdge(gp,p.src,p.nbr,p.wt);
//				NoOfEdges++;
			}
			vis[p.src]=true;
			for(edge e : graph[p.src]) {
				if(vis[e.nbr]==false) {
					que.add(new pri(e.nbr,p.src,e.wt));
				}
			}
			
		}
		display(gp);
	}
	
	//Leetcode 1168
	
	//Dijkstra
	public static void Dijkstra(int src,int des,boolean[] vis) {
		PriorityQueue<int[]> que = new PriorityQueue<>((a,b)-> {  //Min Priority Queue on the basis of weight
			return a[3] - b[3];
		});
		que.add(new int[] {src,-1,0,0});
		while(que.size()!=0) {
			int[] p=que.peek();
			que.remove();
			if(vis[p[0]]==true) {
				continue;
			}
			if(p[0]==des) {
				System.out.println(p[3]);
				break;
			}
			vis[p[0]]=true;
			for(edge e : graph[p[0]]) {
				if(vis[e.nbr]==false) {
					que.add(new int[] {e.nbr,p[0],e.wt,p[3]+e.wt});
				}
			}
		}
	}
	
	//Dijkstra for All Nodes====
		public static int[] DijkstraForAll(int src,boolean[] vis) {
			int[] dis=new int[vis.length];
			for(int i=1;i<dis.length;i++) {
				dis[i]=(int)1e8;
			}
			PriorityQueue<int[]> que = new PriorityQueue<>((a,b)-> {  //Min Priority Queue on the basis of weight
				return a[3] - b[3];
			});
			que.add(new int[] {src,-1,0,0});
			while(que.size()!=0) {
				int[] p=que.peek();
				que.remove();
				if(vis[p[0]]==true) {
					continue;
				}
				vis[p[0]]=true;
				for(edge e : graph[p[0]]) {
					if(vis[e.nbr]==false && dis[e.nbr]>p[3]+e.wt) {
						dis[e.nbr] = p[3] + e.wt;
						que.add(new int[] {e.nbr,p[0],e.wt,p[3]+e.wt});
					}
				}
			}
			return dis;
		}
	
	
	//Leetcode 839
	//Leetcode 547
	
	public static void dis(ArrayList<ArrayList<edge>> gp) {
		for(int i=0;i<gp.size();i++){
			for(int j=0;j<gp.get(i).size();j++){
				edge ce=gp.get(i).get(j);
				System.out.println(ce.src+ " -> "+ ce.nbr +" @ "+ce.wt);
			}
		}
	}
	
	//Leetcode 787
	//Leetcode 778
	
	
	public static void main(String[] args) {
		for(int i=0;i<N;i++) {
			graph[i]=(new ArrayList<edge>());
		}
		addEdge(graph,7,6,1);
//		addEdge(2,8,2);
		addEdge(graph,2,8,2);
		addEdge(graph,6,5,2);
		addEdge(graph,0,1,4);
		addEdge(graph,2,5,4);
		addEdge(graph,8,6,6);
		addEdge(graph,2,3,7);
		addEdge(graph,7,8,7);
		addEdge(graph,0,7,8);
		addEdge(graph,1,2,8);
		addEdge(graph,3,4,9);
		addEdge(graph,5,4,10);
		addEdge(graph,1,7,11);
		addEdge(graph,3,5,14);
		
//		addEdge(graph,1,2,1);
//		addEdge(graph,2,3,1);
//		addEdge(graph,3,4,1);
//		addEdge(graph,0,1,1);
		
//		ArrayList<ArrayList<Integer>> pages=new ArrayList<ArrayList<Integer>>();
//		for(int i=0;i<14;i++) {
//			pages.add(new ArrayList<Integer>());
//		}
//		pages.get(0).add(new ArrayList[7,6,1]);
//		pages.add(new edge(2,8,2));
//		pages.add(new edge(6,5,2));
//		pages.add(new edge(0,1,4));
//		pages.add(new edge(2,5,4));
//		pages.add(new edge(8,6,6));
//		pages.add(new edge(2,3,7));
//		pages.add(new edge(7,8,7));
//		pages.add(new edge(0,7,8));
//		pages.add(new edge(1,2,8));
//		pages.add(new edge(3,4,9));
//		pages.add(new edge(5,4,10));
//		pages.add(new edge(1,7,11));
//		pages.add(new edge(3,5,14));
		Dijkstra(0,6,new boolean[N]);
		int[][] pages={{7,6,1},{2,8,2},{6,5,2},{0,1,4},{2,5,4},{8,6,6},{2,3,7},{7,8,7},{0,7,8},{1,2,8},{3,4,9},{5,4,10},{1,7,11},{3,5,14}};
		
		int[] arr=DijkstraForAll(2,new boolean[N]);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		
//		DFS(4,new boolean[N]);
//		display(graph);
//		KosaRajuAlgoFor_SCC();
//		KrusKal(9,pages);
//		dis(str);
//		display(str);
//		BFS_Prims(0,new boolean[N]);
//		primsAlgo(0,new boolean[N]);
//		boolean[] vis=new boolean[N];
//		for(int i=0;i<N;i++) {			//this loop takes care of the components too
//			if(vis[i]==false) {
//				Prims(0,vis);
//			}
//		}
		
	}

}
