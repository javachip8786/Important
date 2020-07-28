import java.util.*;
public class DP_SummitSir {
	
	//Max square of one memorization
	public static int max=0;
	public static int SquareM(int[][] arr,int x,int y,int[][] dp) {
		int n=arr.length-1;
		int m=arr[0].length-1;
		if(x==n || y==m) {
			return arr[x][y];
		}
		if(arr[x][y]==0) {
			return 0;
		}
		if(dp[x][y]!=0) {
			return dp[x][y];
		}
		else {
			int k= Math.min(SquareM(arr,x+1,y,dp), Math.min(SquareM(arr,x,y+1,dp), SquareM(arr,x+1,y+1,dp))) + 1;
			if(k>max) {
				max=k;
			}
			dp[x][y]=k;
			return k;
		}
	}
	

	//Max square of one itterative
	public static int square(int[][] arr) {
		int n=arr.length;
		int m=arr[0].length;
		int[][] ans=new int[n][m];
		int max=-1;
		for(int i=n-1;i>=0;i--) {
			for(int j=m-1;j>=0;j--) {
				if(i==n-1 || j==m-1) {
					ans[i][j]=arr[i][j];
				}
				else {
					if(arr[i][j]==0) {
						ans[i][j]=0;
					}
					else {
						int a=ans[i][j+1];
						int b=ans[i+1][j];
						int c=ans[i+1][j+1];
						ans[i][j]=1+Math.min(a, Math.min(c, b));
					}
				}
				if(max<ans[i][j]) {
					max=ans[i][j];
				}
				
			}
		}
		return max;
	}
	
	//GoldMine Problem
	public static int goldmine(int[][] mine,int sx,int sy,int[][] dp) {
		if(sy==mine[0].length-1) {
			return mine[sx][sy];
		}
		if(dp[sx][sy]!=0) {
			return dp[sx][sy];
		}
		int max=0;
		int a=Integer.MIN_VALUE;
		int b=Integer.MIN_VALUE;
		int c=Integer.MIN_VALUE;
		if(sx>0) {
			a=goldmine(mine,sx-1,sy+1,dp);
		}
		b=goldmine(mine,sx,sy+1,dp);
		if(sx<mine[0].length-1) {
			c=goldmine(mine,sx+1,sy+1,dp);
		}
		max=mine[sx][sy] + Math.max(a, Math.max(b, c));
		dp[sx][sy]=max;
		return max;
	}
	
	//GoldMine itterative
	public static int goldmineProblem_DP(int[][] grid, int sr, int sc, int[][] dp) {

        int[][] dirA = { { 0, 1 }, { -1, 1 }, { 1, 1 } };
        for (sc = grid[0].length - 1; sc >= 0; sc--) {
            for (sr = grid.length - 1; sr >= 0; sr--) {
                if (sc == grid[0].length - 1) {
                    dp[sr][sc] = grid[sr][sc];
                    continue;
                }

                int maxCoin = 0; // max coin collected by nbrs.
                for (int d = 0; d < 3; d++) {
                    int r = sr + dirA[d][0];
                    int c = sc + dirA[d][1];
                    if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length) {
                        maxCoin = Math.max(maxCoin, dp[r][c]);
                    }
                }

                dp[sr][sc] = maxCoin + grid[sr][sc];
            }
        }
        int MaxCoins = 0;
        for (int i = 0; i < grid.length; i++) {
            MaxCoins = Math.max(MaxCoins, dp[i][0]);
        }
        return MaxCoins;
    }
	
	//Count Board Path Slider
	public static int CBPS(int n) {
		int[] arr=new int[6];
		arr[0]=1;   //s1,2,3,4,5 = 11,12,13,14,15
		for(int i=1;i<=n;i++) {
			int nv=arr[0]+arr[1]+arr[2]+arr[3]+arr[4]+arr[5];
			arr[5]=arr[4];
			arr[4]=arr[3];
			arr[3]=arr[2];
			arr[2]=arr[1];
			arr[1]=arr[0];
			arr[0]=nv;
		}
		
		return arr[0];
	}
	
	//Count Maze Path Slider
	public static int CMP(int dr,int dc) {
		int[] arr=new int[dc+1];
//		Arrays.fill(arr, 1);
		for(int i=0;i<arr.length;i++) {
			arr[i]=1;
		}
		for(int i=1;i<=dr;i++) {
			for(int c=arr.length-2 ; c>=0; c--) {
				int nv= arr[c] + arr[c+1];
				arr[c]=nv;
			}
		}
		return arr[0];
	}
	
	//Longest Increasing Subsequence Tabulation
	public static void LIS(int[] arr) {
		int omax=0;
		String path="";
		int[] lis=new int[arr.length];
		String[] plis=new String[arr.length];
		lis[0]=1;
		plis[0]=arr[0]+"";
		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<=i-1;j++) {
				if(arr[j]<arr[i]) {
					if(lis[j]>lis[i]) {
						lis[i]=lis[j];
						plis[i]=plis[j];
					}
				}
			}
			lis[i]+=1;
			plis[i]+=" "+arr[i];
			if(lis[i]>omax) {
				omax=lis[i];
				path=plis[i];
			}
		}
		System.out.println(omax);
		System.out.println(path);
	}
	
	//Longest Increasing Subsequence Memorization
	public static int LISM(int[] arr,int point,int[] dp) {
		if(point==0) {
			return 1;
		}
		if(dp[point]!=0) {
			return dp[point];
		}
		int LISendingatpoint=0;
		for(int i=0;i<point;i++) {
			if(arr[i]<arr[point]) {
				int LISendingati=LISM(arr,i,dp);
				if(LISendingati > LISendingatpoint) {
					LISendingatpoint=LISendingati;
				}
			}
		}
		LISendingatpoint +=1;
		dp[point] = LISendingatpoint;
		return LISendingatpoint;
	}
	
	public static void HelperLISM(int[] arr) {
		int omax=0;
		int[] dp=new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			int l=LISM(arr,i,dp);
			if(l>omax) {
				omax=l;
			}
		}
		System.out.println(omax);
	}
	
	//Minimum palindromic Cut
	public static int MPC(String str,int s,int e,int[][] dp) {
		if(ispalindrome(str,s,e)==true) {
			return 0;
		}
		if(dp[s][e]!=0) {
			return dp[s][e];
		}
		int mpc= Integer.MAX_VALUE;
		for(int i=s;i<e;i++) {
			int str1 = MPC(str,s,i,dp);
			int str2 = MPC(str,i+1,e,dp);
			int total=str1+str2+1;
			if(total<mpc) {
				mpc = total;
			}
		}
		dp[s][e]=mpc;
		return mpc;
	}
	
	public static boolean ispalindrome(String str,int s,int e) {
		while(s<e) {
			if(str.charAt(s)!=str.charAt(e)) {
				return false;
			}
			s++;
			e--;
		}
		return true;
	}
	
	//Palindromic Substring
	public static int PalinS(String ques) {
		boolean[][] path=new boolean[ques.length()][ques.length()];
		int count=0;
		for(int dia=0;dia<ques.length();dia++) {
			int ei=dia;
			int si=0;
			while(ei<ques.length()) {
				if(dia==0) {
					path[ei][si]=true;
				}
				else if(dia==1) {
					if(ques.charAt(si)==ques.charAt(ei)) {
						path[si][ei]=true;
					}
				}
				else {
					if(ques.charAt(si)==ques.charAt(ei) && path[si+1][ei-1]==true) {
						path[si][ei]=true;
					}
				}
				if(path[si][ei]==true) {
					count++;
				}
				ei++;
				si++;
			}
		}
		return count;
	}
	
	//Rod Cutting Problem=== Array tells the index length sells for the price mentioned in the array
	public static void Cut(int[] cost) {
		int[] strg= new int[cost.length];
		String[] path=new String[cost.length];
		
		strg[0]=0;
		strg[1]=cost[1];
		path[0]="";
		path[1]="1";
		for(int i=2;i<cost.length;i++) {
			strg[i]=cost[i];
			path[i]=i+"";
			int left=1;
			int right=i-1;
			while(left<=right) {
				if(strg[left]+strg[right]>strg[i]) {
					strg[i] = strg[left] + strg[right];
					path[i] = path[left] + path[right];
				}
				left++;
				right--;
			}
		}
		System.out.println(strg[cost.length-1]);
		System.out.println(path[cost.length-1]);
	}
	
	//Coin Change combination
		public static void CoinChangeC(int[] arr,int n,String path,int idx) {
			if(n==0) {
				System.out.println(path);
			}
			for(int i=idx;i<arr.length;i++) {
				if(n-arr[i]>=0) {
					CoinChangeC(arr,n-arr[i],path+arr[i],i);
				}
			}
		}
	
	//Coin Change
	public static int CoinChange(int[] arr,int n,String path,int[] dp) {
		if(n==0) {
			return 1;
		}
		if(dp[n]!=0) {
			return dp[n];
		}
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if(n-arr[i]>=0) {
				count+=CoinChange(arr,n-arr[i],path+arr[i],dp);
			}
		}
		dp[n]=count;
		return count;
	}
	//Coin Change using Iterartion. Combination
	public static void CCCT(int[] coins,int amount) {
		int[] strg=new int[amount+1];
		ArrayList<String>[] path=new ArrayList[amount+1];
		for(int i=0;i<path.length;i++) {
			path[i]=new ArrayList<String>();
		}
		strg[0]=1;
		path[0].add("");
		for(int i=0;i<coins.length;i++) {
			for(int j=coins[i];j<=amount;j++) {
				strg[j]=strg[j] + strg[j - coins[i]];
				for(String rstr : path[j- coins[i]]) {
					String nstr = rstr + coins[i];
					path[j].add(nstr);
				}
			}
		}
		System.out.println(strg[strg.length-1]);
		System.out.println(path[path.length-1]);
	}
	
	//Coin Change using Iterartion. Permutation
		public static void CCPT(int[] coins,int amount) {
			int[] strg=new int[amount+1];
			ArrayList<String>[] path=new ArrayList[amount+1];
			for(int i=0;i<path.length;i++) {
				path[i]=new ArrayList<String>();
			}
			strg[0]=1;
			path[0].add("");
			for(int j=1;j<=amount;j++) {
				for(int i=0;i<coins.length;i++) {
					if(j>=coins[i]) {
						strg[j]=strg[j] + strg[j - coins[i]];
						for(String rstr : path[j- coins[i]]) {
							String nstr = rstr + coins[i];
							path[j].add(nstr);
						}
					}
				}
			}
			System.out.println(strg[strg.length-1]);
			System.out.println(path[path.length-1]);
		}
		
	//Matrix chain Multiplication
	public static int MCM(int[] dims,int s,int e,int[][] dp) {
		if(e-s==1) {
			return 0;
		}
		if(dp[s][e]!=0) {
			return dp[s][e];
		}
		int min=Integer.MAX_VALUE;
		for(int i=s+1;i<e;i++) {
			int first=MCM(dims,s,i,dp);  //size= dims[s] * dims[i
			int second=MCM(dims,i,e,dp);   //size = dims[i] * dims[e]
			int pc= dims[s] * dims[e] * dims[i];
			int totalAtThisChain = first + second + pc;
			if(totalAtThisChain<min) {
				min= totalAtThisChain;
			}
		}
		dp[s][e]=min;
		return min;
	}
	
	//find the min floor on which egg survive when dropped
	public static int EggDrop(int eggs,int floors,int[][] dp) {
		if(eggs==1) {
			return floors;
		}
		if(floors==1 || floors==0) {
			return floors;
		}
		if(dp[eggs][floors]!=0) {
			return dp[eggs][floors];
		}
		int minTrials=Integer.MAX_VALUE;
		for(int f=1;f<=floors;f++) {
			int eggBreaks= EggDrop(eggs-1,f-1,dp);
			int eggSurvives= EggDrop(eggs,floors-f,dp);
			if(Math.max(eggBreaks, eggSurvives)<minTrials) {
				minTrials = Math.max(eggBreaks, eggSurvives);
			}
		}
		dp[eggs][floors]=minTrials+1;
		return minTrials+1;
	}
	
	public static void main(String[] args) {
		int[][] arr= {{1,0,1,0,0,1},
					  {1,0,1,1,1,1},
					  {1,1,1,1,1,1},
					  {1,1,1,1,0,0},
					  {1,1,1,1,1,1},
					  {0,0,1,1,1,0}};
//		int m=SquareM(arr,0,0,new int[arr.length][arr[0].length]);
//		int m=square(arr);
//		System.out.println(max);
//		SqaureM(arr,0,0);
//		int[][] mine= {{2,6,0,5},
//			       {0,7,5,2},
//			       {3,0,3,7},
//			       {8,0,2,3}};
//		GoldMineT(mine);
//		int max=0;
//		for(int i=0;i<mine.length;i++) {
//			int j=goldmine(mine,i,0,new int[mine.length][mine[0].length]);
//	//		System.out.println(j);
//			max=Math.max(max,j);
//		}
//		System.out.println(max);
//		
////		int c= CBPS(30);
//		int c=CMP(20,20);
//		int c=PalinS("abccbc");
//		System.out.println(c);
//		int[] cost= {0,3,5,6,15,10,25,12,24};
//		Cut(cost);
//		int[] coin= {2,3,5,6};
//		CCPT(coin,10);
//		int c=CoinChange(coin,10,"",new int[11]);
//		System.out.println(c);
//		CoinChangeC(coin,10,"",0);
//		int[] path= {10,22,9,33,21,50,41,60,80,1};
//		HelperLISM(path);
//		String str="abccbc";
//		int[][] dp=new int[str.length()][str.length()];
//		int j=MPC(str,0,str.length()-1,dp);
//		System.out.println(j);
//		int[] dims= {10,20,30,40,50,60};
//		int[][] dp=new int[dims.length][dims.length];
//		int k=MCM(dims,0,dims.length-1,dp);
		int k=EggDrop(2,64,new int[3][65]);
		System.out.println(k);
		}
	

	}

