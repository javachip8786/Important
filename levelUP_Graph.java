import java.util.*;
public class levelUP_Graph {
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
	
	//AddEdge
	public static void AddEdge(ArrayList<ArrayList<edge>> graph,int src,int nbr,int wt) {
		graph.get(src).add(new edge(src,nbr,wt));
		graph.get(nbr).add(new edge(nbr,src,wt));
	}
	//Prints the graph
	public static void print(ArrayList<ArrayList<edge>> graph) {
		for(int i=0;i<graph.size();i++) {
			for(int j=0;j<graph.get(i).size();j++) {
				edge ce=graph.get(i).get(j);
				System.out.println(ce.src+" --> "+ce.nbr+" at weight "+ce.wt);
			}
		}
	}
	//Delete the edge
	public static void DelE(ArrayList<ArrayList<edge>> graph,int src,int nbr) {
		for(int i=0;i<graph.size();i++) {
			for(int j=0;j<graph.get(i).size();j++) {
				edge ce=graph.get(i).get(j);
				if(ce.src==src) {
					graph.get(i).remove(j);
				}
			}
		}
	}
	
	//remove edge--- twice nested loops used since it is BiDrectional
	public static void DelR(ArrayList<ArrayList<edge>> graph,int src,int nbr) {
		for(int i=0;i<graph.size();i++) {
			for(int j=0;j<graph.get(i).size();j++) {
				edge ce=graph.get(i).get(j);
				if(ce.src==src && ce.nbr==nbr) {
					graph.get(i).remove(j);
				}
			}
		}
		
		for(int i=0;i<graph.size();i++) {
			for(int j=0;j<graph.get(i).size();j++) {
				edge ce=graph.get(i).get(j);
				if(ce.src==nbr && ce.nbr==src) {
					graph.get(i).remove(j);
				}
			}
		}
	}
	
	//Delete vertx
	public static void DelV(ArrayList<ArrayList<edge>> graph,int src) {
		//this is okay, if the graph is unidriectional
		graph.remove(src);
		
		//when it is bi derectional
		for(int i=graph.size()-1;i>=0;i--) {
			for(int j=graph.get(i).size()-1;j>=0;j--) {
				edge ce=graph.get(i).get(j);
				if(ce.nbr==src || ce.src==src) {
					graph.get(i).remove(j);
				}
			}
		}
	}
	
	//DFS
	public static boolean HasPath(ArrayList<ArrayList<edge>> graph,int src,int des,boolean[] v) {
		if(src==des) {
//			System.out.println(path+des);
			return true;
		}
		v[src]=true;
		boolean res = false;
		for(int i=0;i<graph.get(src).size();i++) {
			edge ce=graph.get(src).get(i);
			if(v[ce.nbr]==false) {
				res=res || HasPath(graph,ce.nbr,des,v);
			}
		}
		
		v[src]=false;
		return res;
	}
	
	//Path
	public static void Path(ArrayList<ArrayList<edge>> graph,int src,int weight,int des,boolean[] v,String path) {
		if(src==des) {
			System.out.println(path+des +" @ "+weight);
			return;
		}
		v[src]=true;
		for(int i=0;i<graph.get(src).size();i++) {
			edge ce=graph.get(src).get(i);
			if(v[ce.nbr]==false) {
				Path(graph,ce.nbr,weight+ce.wt,des,v,path+src);
			}
		}
		v[src]=false;
	}
	
	//ALL Path
		public static void AllPath(ArrayList<ArrayList<edge>> graph,int src,int weight,boolean[] v,String path) {
		
			System.out.println(src+" : "+path +" @ "+weight);
			v[src]=true;
			for(int i=0;i<graph.get(src).size();i++) {
				edge ce=graph.get(src).get(i);
				if(v[ce.nbr]==false) {
					AllPath(graph,ce.nbr,weight+ce.wt,v,path+src);
				}
			}
			v[src]=false;
		}
	
	//path with max weight and path with min weight using static variables
	public static int max=0;
	public static int min=Integer.MAX_VALUE;
	public static String maxPath="";
	public static String minPath="";
	public static int LongPath(ArrayList<ArrayList<edge>> graph,int src,int des,boolean[] v,String path,int weight) {
		if(src==des) {
			if(weight>max) {
				max=weight;
				maxPath=path+des;
			}
			if(weight<min) {
				min=weight;
				minPath=path+des;
			}
		}
		int count=0;
		v[src]=true;
		for(int i=0;i<graph.get(src).size();i++) {
			edge ce=graph.get(src).get(i);
			if(v[ce.nbr]==false) {
				count= Math.max(count, LongPath(graph,ce.nbr,des,v,path+src,weight+ce.wt));
			}
		}
		v[src]=false;
		return count;
	}
	
	//path with max weight and path with min weight without using static variables
	public static class LH{
		int wot;
		String path;
		public LH(int w,String p){
			wot=w;
			path=p;
		}
	}
	
	public static LH LHPath(ArrayList<ArrayList<edge>> graph,int src,int des,boolean[] v) {
		if(src==des) {
			LH fin=new LH(0,src+"");
			return fin;
		}
		
		v[src]=true;
		LH myAns=new LH((int) 1e8,"");
		for(int i=0;i<graph.get(src).size();i++) {
			edge ce=graph.get(src).get(i);
			if(v[ce.nbr]==false) {
				LH res=LHPath(graph,ce.nbr,des,v);
				if(res.wot + ce.wt<myAns.wot) {
					myAns.wot=res.wot + ce.wt;
					myAns.path=src + res.path;
				}
			}
		}
		v[src]=false;
		return myAns;
	}
	
	
	//path with max weight and path with min weight without using static variables
		public static class LHmax{
			int wot;
			String path;
			public LHmax(int w,String p){
				wot=w;
				path=p;
			}
		}
		
		public static LHmax LHPathmax(ArrayList<ArrayList<edge>> graph,int src,int des,boolean[] v) {
			if(src==des) {
				LHmax fin=new LHmax(0,src+"");
				return fin;
			}
			
			v[src]=true;
			LHmax myAns=new LHmax((int)-1e8,"");
			for(int i=0;i<graph.get(src).size();i++) {
				edge ce=graph.get(src).get(i);
				if(v[ce.nbr]==false) {
					LHmax res=LHPathmax(graph,ce.nbr,des,v);
					if(res.wot + ce.wt>myAns.wot) {
						myAns.wot=res.wot + ce.wt;
						myAns.path=src + res.path;
					}
				}
			}
			v[src]=false;
			return myAns;
		}
		
		// ceil value of the given, when going from source to destination using static variables
		public static int ceil=(int)1e8;
		public static int floor=0;
		public static int ceilValeWithStatic(ArrayList<ArrayList<edge>> graph,int src, int dest,int weight, boolean[] vis, int data) {
			if(src==dest) {
//				System.out.println(weight);
				if(weight>data && weight<ceil) {
					ceil=weight;
				}
				if(data<weight && weight>floor) {
					floor=weight;
				}
			}
			int count=0;
			vis[src]=true;
			for(int i=0;i<graph.get(src).size();i++){
				edge ce=graph.get(src).get(i);
				if(vis[ce.nbr]==false) {
					count+=ceilValeWithStatic(graph,ce.nbr,dest,weight+ce.wt,vis,data);
				}
			}
			vis[src]=false;
	        return count;
	    }
		
		// ceil value of the given, when going from source to destination without using static
		public static int ceilVale(ArrayList<ArrayList<edge>> graph,int src, int dest,int weight, boolean[] vis, int data,int fin) {
			if(src==dest) {
				return weight;
			}
			vis[src]=true;
			for(int i=0;i<graph.get(src).size();i++) {
				edge ce=graph.get(src).get(i);
				if(vis[ce.nbr]==false) {
					int h=ceilVale(graph,ce.nbr,dest,weight+ce.wt,vis,data,fin);
					if(h>data && h<fin) {
						fin=h;
					}
				}
			}
			vis[src]=false;
	        return fin;
	    }
		
		// fllor value of the given, when going from source to destination without using static
				public static int floorVale(ArrayList<ArrayList<edge>> graph,int src, int dest,int weight, boolean[] vis, int data,int fin) {
					if(src==dest) {
						return weight;
					}
					vis[src]=true;
					for(int i=0;i<graph.get(src).size();i++) {
						edge ce=graph.get(src).get(i);
						if(vis[ce.nbr]==false) {
							int h=floorVale(graph,ce.nbr,dest,weight+ce.wt,vis,data,fin);
							if(h<data && h>fin) {
								fin=h;
							}
						}
					}
					vis[src]=false;
			        return fin;
			    }
	
   //removing a edge
   public static void removeEdge(ArrayList<ArrayList<edge>> graph,int src,int nbr) {
	   
	   for(int i=0;i<graph.get(src).size();i++) {
		   edge ce=graph.get(src).get(i);
		   if(ce.nbr==nbr) {
			   graph.get(src).remove(i);
		   }
	   }
	   for(int i=0;i<graph.get(nbr).size();i++) {
		   edge ce=graph.get(nbr).get(i);
		   if(ce.nbr==src) {
			   graph.get(nbr).remove(i);
		   }
	   }
   }
   
   //removing a vertex
   public static void removeVertex(ArrayList<ArrayList<edge>> graph,int src) {
	   for(int i=graph.get(src).size()-1;i>=0;i--) {
		   graph.get(src).remove(i);
	   }
	   for(int i=0;i<graph.size();i++) {
		   for(int j=0;j<graph.get(i).size();j++) {
			   edge ce=graph.get(i).get(j);
			   if(ce.nbr==src || ce.src==src) {
				   graph.get(i).remove(j);
			   }
		   }
	   }
   }
   
   //Gives Kth Smallest Path from source to destination
   public static int Kth=(int)1e8;
   public static void KthSmallest(ArrayList<ArrayList<edge>> graph,int src,int weight,int des,int floor,boolean[] v) {
	   if(src==des ) {
		   if(weight>floor) {
			   Kth=Math.min(weight,Kth);
		   }
			return;
		}
	   
		v[src]=true;
		for(int i=0;i<graph.get(src).size();i++) {
			edge ce=graph.get(src).get(i);
			if(v[ce.nbr]==false) {
				KthSmallest(graph,ce.nbr,weight+ce.wt,des,floor,v);
			}
		}
		v[src]=false;
   }
   
   public static void KthSmallest(ArrayList<ArrayList<edge>> graph,int src,int des,int k) {
	   int floor=(int)-1e8;
	   while(k-->0) {   //until K becomes 0, it will find new Kth smallest everytime
		   Kth=(int)1e8;
		   KthSmallest(graph,src,0,des,floor,new boolean[graph.size()]);
		   floor=Kth;
	   }
	   System.out.println(Kth);
   }
	
	
	
	public static void main(String[] args) {
		ArrayList<ArrayList<edge>> graph=new ArrayList<ArrayList<edge>>();
		for(int i=0;i<8;i++) {
			graph.add(new ArrayList<>());
		}
		AddEdge(graph,0,1,10);
		AddEdge(graph,1,2,10);
		AddEdge(graph,2,3,10);
		AddEdge(graph,0,3,40);
		AddEdge(graph,3,4,2);
		AddEdge(graph,4,5,5);
		AddEdge(graph,5,6,4);
		AddEdge(graph,4,6,3);
		print(graph);
//		DelE(graph,0,1);
//		DelV(graph,0);
//		DelV(graph,1);
//		DelV(graph,2);
//		DelV(graph,3);
//		DelV(graph,4);
//		DelV(graph,5);
//		DelV(graph,6);
		System.out.println("---------------------------------------");
//		DelR(graph,0,1);
//		removeEdge(graph,4,6);
//		print(graph);
//		System.out.println("---------------------------------------");
//		removeVertex(graph,0);
//		print(graph);
//		boolean f=HasPath(graph,0,6,new boolean[graph.size()]);
//		System.out.println(f);
//		AllPath(graph,0,0,new boolean[graph.size()],"");
		
		KthSmallest(graph,0,6,4);
		
//		int f=LongPath(graph,0,6,new boolean[graph.size()],"",0);
//		System.out.println(f);
//		System.out.println(min+"  "+minPath);
//		System.out.println(max+"  "+maxPath);
		
//		LH result=LHPath(graph,0,6,new boolean[graph.size()]);
//		System.out.println(result.wot+" "+result.path);
		
//		LHmax result2=LHPathmax(graph,0,6,new boolean[graph.size()]);
//		System.out.println(result2.wot+" "+result2.path);
		
//		ceilValeWithStatic(graph,0,6,0,new boolean[graph.size()],40);
//		System.out.println(ceil+"  and   "+floor);
		
//		int c=ceilVale(graph,0,6,0,new boolean[graph.size()],40,(int)1e8);
//		System.out.println(c);
//		int d=floorVale(graph,0,6,0,new boolean[graph.size()],40,0);
//		System.out.println(d);
	}

}
