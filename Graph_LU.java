import java.util.*;
public class Graph_LU {
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
	
	public static void AddEdge(ArrayList<ArrayList<edge>> graph,int src,int nbr,int wt) {
		graph.get(src).add(new edge(src,nbr,wt));
//		graph.get(nbr).add(new edge(nbr,src,wt));
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
		
	//does that vertex connects another vertix
	public static boolean find(ArrayList<ArrayList<edge>> graph,int src,int nbr) {
		for(int i=0;i<graph.get(src).size();i++) {
			edge ce=graph.get(src).get(i);
			if(ce.nbr==nbr) {
				return true;
			}
		}
		return false;
	}
		
	public static int HamiltonionPath(ArrayList<ArrayList<edge>> graph,int src,int des,int count,boolean[] v,String path,int osrc) {
		if(src==des && count==graph.size()-1) {
//			System.out.println(count);
			path+=des;
			boolean f=find(graph,src,osrc);
			if(f==true) {
				System.out.println("cycle : "+path+osrc);
			}
			System.out.println("path : "+path);
			return 1;
		}
		v[src]=true;
		int co=0;   //count;
		for(int i=0;i<graph.get(src).size();i++) {
			edge ce=graph.get(src).get(i);
			if(v[ce.nbr]==false) {
				co+=HamiltonionPath(graph,ce.nbr,des,count+1,v,path+src,osrc);
			}
		}
		
		v[src]=false;
		return co;
	}
	
	
	//Hamiltonion Path Done in Class
	public static int searchVrtx(ArrayList<ArrayList<edge>> graph,int u, int v)
	{
	    int idx = -1;
	    for (int i = 0; i < graph.get(u).size(); i++)
	    {
	       edge e = graph.get(u).get(i);
	        if (e.nbr == v)
	        {
	            idx = i;
	            break;
	        }
	    }

	    return idx;
	}
	
	public static int N=0;
	public static int hamintoninPath(ArrayList<ArrayList<edge>> graph,int src, int osrc, int noEdge, boolean[] vis, String path)
	{
	    if (noEdge == N - 1)
	    {
	        int idx = searchVrtx(graph,src, osrc);
	        path += src;
	        if (idx != -1)
	        	System.out.println("Cycle : "+path);
//	            cout << "Cycle : " << path << endl;
	        else
	        	System.out.println("Non Cycle : "+path);
//	            cout << "Non Cycle : " << path << endl;
	        return 1;
	    }

	    vis[src] = true;
	    int count = 0;
	    for (edge e : graph.get(src))
	    {
	        if (!vis[e.nbr])
	            count += hamintoninPath(graph,e.nbr, osrc, noEdge + 1, vis, path +(src) + " ");
	    }
	    vis[src] = false;

	    return count;
	}
	
	//components of graph
	//GCC
	public static void components(ArrayList<ArrayList<edge>> graph,int src,boolean[] v) {
		v[src]=true;
		for(int i=0;i<graph.get(src).size();i++) {
			edge ce=graph.get(src).get(i);
			if(v[ce.nbr]==false) {
				components(graph,ce.nbr,v);
			}
		}
//		v[src]=false;
	}
	
	public static int compo(ArrayList<ArrayList<edge>> graph) {
		boolean[] v=new boolean[graph.size()];
		int count=0;
		for(int i=0;i<graph.size();i++) {
			if(v[i]==false) {
				components(graph,i,v);
				count++;
			}
		}
		return count;
	}
	
	//Leetcode 200=== based on GCC
	public static int[][] dir={{0,-1},{0,1},{1,0},{-1,0}};
    
    public static void compos(char[][] grid,int sr,int sc){
        grid[sr][sc]=0;
        for(int d=0;d<4;d++){
            int r=sr+dir[d][0];
            int c=sc+dir[d][1];
            if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]=='1'){
                compos(grid,r,c);
            }
        }
    }
    
    public static int numIslands(char[][] grid) {
        if(grid.length==0 || grid[0].length==0){
            return 0;
        }
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    compos(grid,i,j);
                }
            }
        }
        return count;
    }
	
    //Leetcode 463====================================================
//public int islandPerimeter(int[][] grid) {
//        
//        int count=numIsland(grid);
//        int c=numIslands(grid);
//        // System.out.println(count+"   "+c);
//        return ((4*(c)) - (2*(count)));
//    }
//    
//    
//    
////    public int[][] dir={{0,-1},{0,1},{1,0},{-1,0}};
//    
//    public void compos(int[][] grid,int sr,int sc){
//        grid[sr][sc]=0;
//        for(int d=0;d<4;d++){
//            int r=sr+dir[d][0];
//            int c=sc+dir[d][1];
//            if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]=='1'){
//                compos(grid,r,c);
//            }
//        }
//    }
//    
//    public int numIslands(int[][] grid) {
//        if(grid.length==0 || grid[0].length==0){
//            return 0;
//        }
//        int count=0;
//        for(int i=0;i<grid.length;i++){
//            for(int j=0;j<grid[0].length;j++){
//                if(grid[i][j]==1){
//                    count++;
//                    compos(grid,i,j);
//                }
//            }
//        }
//        return count;
//    }
//    
//    public int numIsland(int[][] grid) {
//        if(grid.length==0 || grid[0].length==0){
//            return 0;
//        }
//        int count=0;
//        for(int i=0;i<grid.length;i++){
//            for(int j=0;j<grid[0].length;j++){
//                if(grid[i][j]==1){
//                        if(i+1<grid.length && grid[i+1][j]==1){
//                            count++;
//                        }
//                        if(j+1<grid[0].length && grid[i][j+1]==1){
//                            count++;
//                    }
//                }
//            }
//        }
//        return count;
//    }
    
    //Leetcode 130==========Water flows out
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
        return;
    int n = board.length;
    int m = board[0].length;

    for (int i = 0; i < board.length; i++)
    {
        if (board[i][0] == 'O')
            solve_(board, i, 0);
        if (board[i][m - 1] == 'O')
            solve_(board, i, m - 1);
    }

    for (int i = 0; i < board[0].length; i++)
    {
        if (board[0][i] == 'O')
            solve_(board, 0, i);
        if (board[n - 1][i] == 'O')
            solve_(board, n - 1, i);
    }

    for (int i = 0; i < board.length; i++)
    {
        for (int j = 0; j < board[0].length; j++)
        {
            if (board[i][j] == 'O')
                board[i][j] = 'X';
            else if (board[i][j] == '#')
                board[i][j] = 'O';
        }
    }
    }
//    public static int[][] dir={{0,-1},{0,1},{1,0},{-1,0}};
    
    
    
    public void solve_(char[][] board, int sr, int sc)
{

    board[sr][sc] = '#';
    for (int d = 0; d < 4; d++)
    {
        int r = sr + dir[d][0];
        int c = sc + dir[d][1];

        if (r >= 0 && c >= 0 && r < board.length && c < board[0].length && board[r][c] == 'O')
            solve_(board, r, c);
    }
}
	
	//BSF ====== this can also be used to count the number of cycles in a graph
	public static void BSF(ArrayList<ArrayList<edge>> graph,int src,boolean[] v) {
		Queue<Integer> q=new LinkedList<>();
		q.add(src);
		while(q.size()!=0) {
			int ce=q.peek();
			q.remove();
			if(v[ce]==true) {
				System.out.println(" Cycle ");
				continue;
			}
			if(ce==6) {
				System.out.println("Destination ");
//				break;
			}
			v[ce]=true;
			for(int i=0;i<graph.get(ce).size();i++) {
				edge c=graph.get(ce).get(i);
				if(v[c.nbr]==false) {
					q.add(c.nbr);
				}
			}
		}
		
	}
	//BFS.==============================BFS gives shortest Path from source to destination

	public static void BFS_01(ArrayList<ArrayList<edge>> graph,int src, boolean[] v)
	{
	    Queue<Integer> que=new LinkedList<>();
	    que.add(src);
	    int desti = 6;

	    while (que.size() != 0)
	    {
	        int rvtx = que.peek();
	        que.remove();

	        v[rvtx] = true;    // Mark here to find cycle
	        for(int i=0;i<graph.get(src).size();i++) {
				edge c=graph.get(src).get(i);
				if(v[c.nbr]==false) {
					que.add(c.nbr);
				}
	    }
	}
	}
	
	public static void BFS_02(ArrayList<ArrayList<edge>> graph,int src, boolean[] v)
	{
		Queue<Integer> que=new LinkedList<>();
	    que.add(src);
//	    v[src] = true;			//This is for Non-cyclic
	    int level = 0;
	    while (que.size() != 0)
	    {
//	    	System.out.print("Level : "+level+" -> ");
	        int size = que.size();
	        while (size-- > 0)
	        {
	            int rvtx = que.peek();
//	            System.out.print(rvtx+" ");
	            que.remove();

	            v[rvtx] = true;   		//This is for Cyclic- To detect a cycle
	            for(int i=0;i<graph.get(rvtx).size();i++) {
					edge c=graph.get(rvtx).get(i);
					if(v[c.nbr]==false) {
//						v[c.nbr]=true;     //This is for Non-cyclic
						que.add(c.nbr);
					}
	            }
	        }
//	        System.out.println();
	        level++;
	    }
	}
	
	//Level Order BSF
	public static void BFS_03(ArrayList<ArrayList<edge>> graph,int src, boolean[] v)
	{
		Queue<Integer> que=new LinkedList<>();
	    que.add(src);
	    v[src] = true;			//This is for Non-cyclic
	    int level = 0;
	    while (que.size() != 0)
	    {
	    	System.out.print("Level : "+level+" -> ");
	        int size = que.size();
	        while (size-- > 0)
	        {
	            int rvtx = que.peek();
	            System.out.print(rvtx+" ");
	            que.remove();

//	            v[rvtx] = true;   		//This is for Cyclic- To detect a cycle
	            for(int i=0;i<graph.get(rvtx).size();i++) {
					edge c=graph.get(rvtx).get(i);
					if(v[c.nbr]==false) {
						v[c.nbr]=true;     //This is for Non-cyclic
						que.add(c.nbr);
					}
	            }
	        }
	        System.out.println();
	        level++;
	    }
	}
	//GCC- Get connected conponents- used to get number of components in graph
	public static void GCC_UsingBFS(ArrayList<ArrayList<edge>> graph)
	{
	    boolean[] v=new boolean[graph.size()];
	    int count = 0;
	    for (int i = 0; i < graph.size(); i++)
	    {
	        if (v[i]==false)
	        {
	            BFS_03(graph,i, v);
	            count++;
	        }
	    }
	    System.out.println(count);
	}
	
	//Leetcode 994
	//Leetcode 785
	//Leetcode 1091
	
	//Topological sort
	public static void topoDFS(ArrayList<ArrayList<edge>> graph,int src,boolean[] v,Stack st) {
		v[src]=true;
		for(int i=0;i<graph.get(src).size();i++) {
			edge ce=graph.get(src).get(i);
			if(v[ce.nbr]==false) {
				topoDFS(graph,ce.nbr,v,st);
			}
		}
		st.add(src);
	}
	
	public static void topologicalSort(ArrayList<ArrayList<edge>> graph) {
		boolean[] v=new boolean[graph.size()];
		Stack<Integer> st=new Stack<>();
		for(int i=0;i<graph.size();i++) {
			if(v[i]==false) {
				topoDFS(graph,i,v,st);
			}
		}
		for(int i=0;i<st.size();i++) {
			System.out.println(st.get(i));
		}
		
	}
	
	//Kahns Algo
	public static void kahnsAlgo(ArrayList<ArrayList<edge>> graph)
	{

//	    vector<int> indegre(N, 0);
	    int[] indegre=new int[graph.size()];   //Put indegree of each node in this array
	    for (int i = 0; i < graph.size(); i++)
	    {
	    	for(int j=0;j<graph.get(i).size();j++) {
	    		edge ce=graph.get(i).get(j);
	    		indegre[ce.nbr]++;
	    	}
	    }

	    Queue<Integer> que=new LinkedList<>();       //this queue will contain nodes with indegree 0
	    ArrayList<Integer> ans=new ArrayList<>();

	    for (int i = 0; i < graph.size(); i++)
	    {
	        if (indegre[i] == 0)
	            que.add(i);                   //Add all nodes of indegree 0 to queue
	    }

	    while (que.size() != 0)
	    {								//BFS- remove node and add its neighbors if their indree becomes 0
	        int rvtx = que.peek();
	        que.remove();

	        ans.add(rvtx);				//Add nodes to ans ArrayList
	        for(int j=0;j<graph.get(rvtx).size();j++) {
	        	edge ce=graph.get(rvtx).get(j);
	        	if (--indegre[ce.nbr] == 0)
	                que.add(ce.nbr);
	        }
	    }

	    if (ans.size() != graph.size())   				//ans size!= graph size, there must be a cycle
	        System.out.println(" there is a cycle ");
	    else
	    {
	        for (int ele : ans)
	        	System.out.println(ele+" ");
	    }
	}
	
	//Leetcode 207
	//Leetcode 210
	
	public static boolean topoCycle(ArrayList<ArrayList<edge>> graph,int src,boolean[] vis,boolean[] myPath,boolean[] ans) {
		vis[src]=myPath[src]=true;
		boolean isCycle=false;
		for(int e : graph.get(src)) {
			
		}
	}
	
	
	
	public static void main(String[] args) {
		ArrayList<ArrayList<edge>> graph=new ArrayList<>();
		for(int i=0;i<7;i++) {
			graph.add(new ArrayList<edge>());
		}
		AddEdge(graph,0,1,2);
		AddEdge(graph,1,2,4);
		AddEdge(graph,0,3,9);
		AddEdge(graph,2,3,6);
		AddEdge(graph,3,4,2);
		AddEdge(graph,4,5,10);
		AddEdge(graph,5,6,2);
		AddEdge(graph,4,6,2);
		topologicalSort(graph);
//		int h=hamintoninPath(graph,0,0,0,new boolean[graph.size()],"");
//		BFS_03(graph,0,new boolean[graph.size()]);
//		AddEdge(graph,6,0,11);
//		kahnsAlgo(graph);
//		print(graph);
//		HamiltonionPath(graph,0,6,0,new boolean[graph.size()],"",0);
//		int c=compo(graph);
//		System.out.println(h);
//		GCC_UsingBFS(graph);
//		System.out.println(j);	
	}

}
