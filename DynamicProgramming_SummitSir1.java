
public class DynamicProgramming_SummitSir1 {
	
	//normal fibonachi with recursion
	public static int NormalFibo(int n) {
		if(n==0 || n==1) {
			return n;
		}
		int fn=NormalFibo(n-1) + NormalFibo(n-2);
		return fn;
		
	}
	
	//fibonachi with DP        MEMORIZATION
	public static int DPFibo(int n,int[] dp) {
		if(n==0 || n==1) {
			return n;
		}
		if(dp[n]!=0) {
			return dp[n];
		}
		int fn=DPFibo(n-1,dp)+DPFibo(n-2,dp);
		dp[n]=fn;
		return dp[n];
	}
	
	//fibonachi with itteration and DP   TABULATION
	public static void fiboI(int n) {
		int[] arr=new int[n+1];
		arr[0]=0;
		arr[1]=1;
		for(int i=2;i<=n;i++) {
			arr[i]=arr[i-1]+arr[i-2];
		}
		System.out.println(arr[n]);
	}
	
	//paths from source to destination when throwing a dice
	public static int paths(int s,int d) {
		if(s>d){
			return 0;
		}
		if(s==d) {
			return 1;
		}
		int c=0;
		for(int i=1;i<=6;i++) {
			int p=s+i;
			int citod=paths(p,d);
			c+=citod;
		}
		return c;
	}
	
	//paths from source to destination when throwing a dice with DP
	public static int paths2(int s,int d,int[] dp) {
		if(s>d){
			return 0;
		}
		if(s==d) {
			return 1;
		}
		if(dp[s]!=0) {
			return dp[s];
		}
		int c=0;
		for(int i=1;i<=6;i++) {
			int p=s+i;
			int citod=paths2(p,d,dp);
			c+=citod;
			dp[s]=c;
		}
	
		return c;
	}
	
	//count path TABULATION
	public static void paths3(int n) {
		int[] pp=new int[n+1];
		pp[n]=1;
		int count=0;
		for(int i=n-1;i>=0;i--) {
			for(int j=1;j<=6;j++) {
				if(i+j<=n) {
					pp[i]+=pp[i+j];
				}
			}
		}
		System.out.println(pp[0]);
	}
	
	//paths in maze using simple recursion
	public static void mazeS(int x,int y,int ex,int ey,String p) {
		if(x==ex && y==ey) {
			System.out.println(p);
		}
		if(ex-x>=1) {
			mazeS(x+1,y,ex,ey,p+" h ");
		}
		if(ey-y>=1) {
			mazeS(x,y+1,ex,ey,p+" v ");
		}
	}
	
	//count paths in maze using simple recursion
	public static int mazeC(int x,int y,int ex,int ey) {
		if(x==ex && y==ey) {
			return 1;
		}
		if(x>ex || y>ey) {
			return 0;
		}
			
		int c1=mazeC(x+1,y,ex,ey);
		int c2=mazeC(x,y+1,ex,ey);
		return c1+c2;
	}
	
	//count paths in maze using memorization
		public static int mazeM(int x,int y,int ex,int ey,int[][] pq) {
			if(x==ex && y==ey) {
				return 1;
			}
			if(x>ex || y>ey) {
				return 0;
			}
			if(pq[x][y]!=0) {
				return pq[x][y];
			}
			int c1=mazeM(x+1,y,ex,ey,pq);
			int c2=mazeM(x,y+1,ex,ey,pq);
			pq[x][y]=c1+c2;
			
			return c1+c2;
		}
		//count paths in maze using memorization
		public static int mazeT(int ex,int ey) {
			int[][] pq=new int[ex+1][ey+1];
			pq[ex][ey]=1;
			for(int i=ex;i>=0;i--) {
				for(int j=ey;j>=0;j--) {
					if(i==ex && j==ey) {
						//last cell
						pq[i][j]=1;
					}
					else if(i==ex) {
						//last row
						pq[i][j]=pq[i][j+1];
					}
					else if(j==ey) {
						//last col
						pq[i][j]=pq[i+1][j];
					}
					else {
						pq[i][j]=pq[i+1][j]+pq[i][j+1];
					}
//					pq[i][j]+=pq[i+1][j]+pq[i][j+1];
				}
			}
			return pq[0][0];
				}
	//fibo slider
	public static void FS(int n) {
		int[] s=new int[2];
		s[0]=0;
		s[1]=1;
		for(int i=2;i<=n;i++) {
			int f2=s[0]+s[1];
			s[0]=s[1];
			s[1]=f2;
		}
		System.out.println(s[1]);
	}
	
	//slider for count path when dice is rolled
	public static void pathsS(int n) {
		int[] s=new int[6];
		s[0]=1;
		for(int i=1;i<=n;i++) {
			int nv=s[0]+s[1]+s[2]+s[3]+s[4]+s[5];
			s[5]=s[4];
			s[4]=s[3];
			s[3]=s[2];
			s[2]=s[1];
			s[1]=s[0];
			s[0]=nv;
		}
		System.out.println(s[0]);
	}
	
	//slider for Maze path
	public static void mazeS(int x,int y) {
		int[] s=new int[x+1];
		for(int i=0;i<=x;i++) {
			s[i]=1;
		}
		for(int i=1;i<=y;i++) {
			for(int j=s.length-2;j>=0;j--) {
				int nv=s[j]+s[j+1];
				s[j]=nv;
			}
		}
		System.out.println(s[0]);
	}
	
	//min cost path of a 2D array
	public static int z=Integer.MAX_VALUE;
	public static void minC(int x,int y,int[][] arr,int cost,String path) {
		if(x==arr.length-1 && y==arr[0].length-1) {
			if(cost<z) {
				z=cost;
			}
			System.out.println(path);
			return;
		}
		if(x<arr.length-1) {
			minC(x+1,y,arr,cost+arr[x+1][y],path+arr[x+1][y]);
		}
		if(y<arr[0].length-1) {
			minC(x,y+1,arr,cost+arr[x][y+1],path+arr[x][y+1]);
		}
	}
	
	//min cost path of a 2D array 
		public static int minC(int x,int y,int[][] arr) {
			if(x==arr.length-1 && y==arr[0].length-1) {
				return arr[x][y];
			}
			int m=0;
			int a=Integer.MAX_VALUE;
			int b=Integer.MAX_VALUE;
			if(x<arr.length-1) {
				a=minC(x+1,y,arr);
			}
			if(y<arr[0].length-1) {
				b=minC(x,y+1,arr);
			}
			m=arr[x][y]+Math.min(a,b);
			return m;
		}
		
		//min cost path of a 2D array using memorization
				public static int minCM(int x,int y,int[][] arr,int[][] pq) {
					if(x==arr.length-1 && y==arr[0].length-1) {
						return arr[x][y];
					}
					if(pq[x][y]!=0) {
						return pq[x][y];
					}
					
					int m=0;
					int a=Integer.MAX_VALUE;
					int b=Integer.MAX_VALUE;
					if(x<arr.length-1) {
						a=minCM(x+1,y,arr,pq);
					}
					if(y<arr[0].length-1) {
						b=minCM(x,y+1,arr,pq);
					}
					m=arr[x][y]+Math.min(a,b);
					pq[x][y]=m;
					return m;
				}
	//minCost by Tabulation
	public static void MinCT(int[][] cost) {
		int[][] minC=new int[cost.length][cost[0].length];
		String[][] path=new String[cost.length][cost[0].length];
		
		for(int i=cost.length-1;i>=0;i--) {
			for(int j=cost[0].length-1;j>=0;j--) {
				if(i==cost.length-1 && j==cost[0].length-1) {
					minC[i][j]=cost[i][j];
					path[i][j]=".";
				}
				else if(i==cost.length-1) {
					minC[i][j]=cost[i][j]+minC[i][j+1];
					path[i][j]="H"+path[i][j+1];
				}
				else if(j==cost[0].length-1) {
					minC[i][j]=cost[i][j]+minC[i+1][j];
					path[i][j]="V"+path[i+1][j];
				}
				else {
					if(minC[i][j+1]<minC[i+1][j]) {
						minC[i][j]=cost[i][j]+minC[i][j+1];
						path[i][j]="H"+path[i][j+1];
					}
					else {
						minC[i][j]=cost[i][j]+minC[i+1][j];
						path[i][j]="V"+path[i+1][j];
					}
				}
			}
		}
		System.out.println(minC[0][0]+" @ "+path[0][0]);
		
	}
	
	//biggest square of 1 in matrix by tabulation
	public static void MS(int[][] arr) {
		int[][] sq=new int[arr.length][arr[0].length];
		int omax=0;
		for(int i=arr.length-1;i>=0;i--) {
			for(int j=arr[0].length-1;j>=0;j--) {
				if(i==arr.length-1 && j==arr[0].length-1) {
					sq[i][j]=arr[i][j];
				}
				else if(i==arr.length-1) {
					sq[i][j]=arr[i][j];
				}
				else if(j==arr[0].length-1) {
					sq[i][j]=arr[i][j];
				}
				else {
					if(arr[i][j]==0) {
						sq[i][j]=0;
					}
					else {
						sq[i][j]=1+Math.min(sq[i+1][j+1],Math.min(sq[i][j+1], sq[i+1][j]));
						if(sq[i][j]>omax) {
							omax=sq[i][j];
						}
					}
				}
			}
		}
		System.out.println(omax);
	}
	
	//biggest square of 1 in matrix by normal recursion
	public static int MSRC=0;
	public static int MSR(int[][] arr,int x,int y) {
		if(x==arr.length-1 || y==arr[0].length-1) {
			return arr[x][y];
		}
		if(arr[x][y]==0) {
			return 0;
		}
		else {
			int a=MSR(arr,x+1,y);
			int b=MSR(arr,x,y+1);
			int c=MSR(arr,x+1,y+1);
			int res=1+Math.min(c, Math.min(a, b));
			if(MSRC<res) {
				MSRC=res;
			}
			return res;
		}
	}
	
	//biggest square of 1 in matrix by memorisation
		public static int MSRC2=0;
		public static int MSR2(int[][] arr,int x,int y,int[][] qb) {
			if(x==arr.length-1 || y==arr[0].length-1) {
				return arr[x][y];
			}
			if(qb[x][y]!=0) {
				return qb[x][y];
			}
//			System.out.println("hello");
			if(arr[x][y]==0) {
				return 0;
			}
			else {
				int a=MSR2(arr,x+1,y,qb);
				int b=MSR2(arr,x,y+1,qb);
				int c=MSR2(arr,x+1,y+1,qb);
				int res=1+Math.min(c, Math.min(a, b));
				if(MSRC2<res) {
					MSRC2=res;
				}
				qb[x][y]=res;
				return res;
			}
		}
	
	
	public static void main(String[] args) {
		int n=30;
//		System.out.println(NormalFibo(n));
		int[] dp=new int[n+1];
//		System.out.println(DPFibo(n,dp));
//		fiboI(n);
//		System.out.println(paths(0,n));
//		int[] dp=new int[]
//		System.out.println(paths2(0,n,dp));
//		paths3(n);
//		paths3(30);
//		mazeS(1,1,3,3,"");
//		System.out.println(mazeC(1,1,3,3));
//		System.out.println(mazeM(1,1,3,3,new int[4][4]));
//		System.out.println(mazeT(15,15));
//		FS(10);
//		pathsS(10);
//		mazeS(2,2);
//		int[][] arr= {{1,2,3},
//				      {2,3,-1},
//				      {3,0,5}};
//		minC(0,0,arr,1,"1");
//		System.out.println(z);
		
//		int[][] cost= {
//				{2,3,0,4},
//				{0,6,5,2},
//				{8,0,3,7},
//				{2,0,4,2}
//				};
		
//		System.out.println(minC(0,0,cost));
//		System.out.println(minCM(0,0,cost,new int[cost.length][cost[0].length]));
//		MinCT(cost);
		
		int[][] minSquare= {{1,0,1,0,0,1},
							{1,1,1,1,1,1},
							{1,1,1,1,1,1},
							{1,1,1,1,0,0},
							{1,1,1,1,1,1},
							{0,0,1,1,1,0}};
		
//		MS(minSquare);
//		MSR(minSquare,0,0);
		MSR2(minSquare,0,0,new int[minSquare.length][minSquare[0].length]);
		System.out.println(MSRC2);
	}
	
}
