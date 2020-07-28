import java.util.*;
public class DP_LU {
	
	//Fibo using memorization
	public static int fibo(int n,int[] dp) {
		if(n==0 || n==1) {
			return n;
		}
		if(dp[n]!=0) {
			return dp[n];
		}
		int ans= fibo(n-1,dp) + fibo(n-2,dp);
		dp[n]=ans;
		return ans;
	}
	
	//Fibo using tabulation
		public static int fiboT(int n,int[] dp) {
			for(int i=0;i<n;i++) {
				if(i<=1) {
					dp[i] = n;
					continue;
				}
				int ans= dp[i-1] + dp[i-2];
				dp[i]=ans;
			}
			return dp[n];
		}
	
	//Fibo using Iteration
	public static int FiboOpti(int n) {
		int a=0;
		int b=1;
		for(int i=0;i<n;i++) {
			int sum=a+b;
			a=b;
			b=sum;
		}
		return a;
	}
	
	
	
	//two moves are allowed memorization
	public static int Paths(int sx,int sy,int ex,int ey,int[][] dp) {
		if(sx==ex && sy==ey) {
			return 1;
		}
		int count=0;
		if(dp[sx][sy]!=0) {
			return dp[sx][sy];
		}
		if(sx+1<=ex) {
			count+=Paths(sx+1,sy,ex,ey,dp);
		}
		if(sy+1<=ey) {
			count+=Paths(sx,sy+1,ex,ey,dp);
		}
		dp[sx][sy]=count;
		return count;
	}
	
	
	//left , down and diagonal are allowed memorization
	public static int Paths2(int sx,int sy,int ex,int ey,int[][] dp) {
		if(sx==ex && sy==ey) {
			return 1;
		}
		int count=0;
		if(dp[sx][sy]!=0) {
			return dp[sx][sy];
		}
		if(sx+1<=ex) {
			count+=Paths2(sx+1,sy,ex,ey,dp);
		}
		if(sy+1<=ey) {
			count+=Paths2(sx,sy+1,ex,ey,dp);
		}
		if(sy+1<=ey && sx+1<=ex) {
			count+=Paths2(sx+1,sy+1,ex,ey,dp);
		}
		dp[sx][sy]=count;
		return count;
	}
	
	//left , down and diagonal are allowed tabulation
		public static int Paths2T(int sx,int sy,int ex,int ey,int[][] dp) {
			for(sx=ex;sx>=0;sx--) {
				for(sy=ey;sy>=0;sy--) {
					if(sx==ex && sy==ey) {
						dp[sx][sy]=1;
						continue;
					}
					int count=0;
					if(sx+1<=ex) {
						count+=dp[sx+1][sy];
					}
					if(sy+1<=ey) {
						count+=dp[sx][sy+1];
					}
					if(sy+1<=ey && sx+1<=ex) {
						count+=dp[sx+1][sy+1];
					}
					dp[sx][sy]=count;
				}
			}
			return dp[0][0];
		}
	
	
	//left and down moves are allowed in jumps
	public static int Paths3(int sx,int sy,int ex,int ey,int[][] dp) {
		if(sx==ex && sy==ey) {
			return 1;
		}
		if(dp[sx][sy]!=0) {
			return dp[sx][sy];
		}
		int count=0;
		
		for(int i=1;i<=ex;i++) {
			if(sx+i<=ex) {
				count+=Paths3(sx+i,sy,ex,ey,dp);
			}
		}
		for(int i=1;i<=ey;i++) {
			if(sy+i<=ey ) {
				count+=Paths3(sx,sy+i,ex,ey,dp);
			}
		}
		
		dp[sx][sy]=count;	
		return count;
	}
	
	//left and down moves are allowed in jumps tabulation
		public static int Paths3T(int sx,int sy,int ex,int ey,int[][] dp) {
			for(sx=ex;sx>=0;sx--) {
				for(sy=ey;sy>=0;sy--) {
					if(sx==ex && sy==ey) {
						dp[sx][sy]=1;
						continue;
					}
					int count=0;
					
					for(int i=1;i<=ex;i++) {
						if(sx+i<=ex) {
							count+=dp[sx+i][sy];
						}
					}
					for(int i=1;i<=ey;i++) {
						if(sy+i<=ey ) {
							count+=dp[sx][sy+i];
						}
					}
					dp[sx][sy]=count;	
				}
			}
			return dp[0][0];
		}
		
		//Dice problem. we need to go from 1 to 10, with a dice, find all ways
		public static int dice(int q,int[] dp) {
			if(q==0) {
				return 1;
			}
			if(dp[q]!=0) {
				return dp[q];
			}
			int count=0;
			for(int i=1;i<=6;i++) {
				if(q-i>=0) {
					count+=dice(q-i,dp);	
				}
			}
			dp[q]=count;
			return count;
		}
		
		//Dice problem. we need to go from 1 to 10, with a dice, find all ways Tabulation
				public static int diceT(int q,int[] dp) {
					for(int i=q;i>=0;i--) {
						if(i==q) {
							dp[i] = 1;
							continue;
						}
						int count=0;
						for(int j=1;j<=6;j++) {
							if(i+j<=q) {
								count+=dp[i+j];	
							}
						}
						dp[i]=count;
					}
					return dp[0];
				}
				
		
		//we need to pay a amount with a fix coins, how many ways are there
		public static void dice2(int q,int[] arr,int[] dp,String path) {
			if(q==0) {
				System.out.println(path);
				return;
			}
			for(int i=0;i<arr.length;i++) {
				if(q-arr[i]>=0) {
					dice2(q-arr[i],arr,dp,path+arr[i]);
				}
			}
		}
		
		//we need to pay a amount with a fix coins, how many ways are there
		public static int dice2(int q,int[] arr,int[] dp) {
			if(q==0) {
				return 1;
			}
			int count=0;
			for(int i=0;i<arr.length;i++) {
				if(q-arr[i]>=0) {
					count+=dice2(q-arr[i],arr,dp);
				}
			}
			return count;
		}
		
		//we need to pay a amount with a fix coins, how many ways are there=== problem
		public static int dice2T(int q,int[] arr,int[] dp) {
			for(int i=q;i>=0;i--) {
				if(i==q) {
					dp[i]=1;
					continue;
				}
				int count=0;
				for(int j=0;j<arr.length;j++) {
					if(i+arr[j]<=q) {
						count+=dp[i+arr[j]];
					}
				}
				dp[i]=count;
			}
			return dp[0];
		}
			
		//board path=== going from 0 to ei, with a dice... no. of combination
		public static int boardPath_opti(int ei) {
	        LinkedList<Integer> ll = new LinkedList<>();

	        for (int si = 0; si <= ei; si++) {
	            if (si < 2) {
	                ll.addFirst(1);
	                continue;
	            }

	            if (ll.size() <= 6)
	                ll.addFirst(2 * ll.getFirst());
	            else {
	                ll.addFirst(2 * ll.getFirst() - ll.getLast());
	                ll.removeLast();
	            }
	        }

	        return ll.getFirst();
	    }
		
	//GoldMine
//	public static int max=0;
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
	
//	public static int max=0;
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
	
	//Leetcode 64 , 70
	public static int minPath(int[][] grid){
        int[][] dp=new int[grid.length][grid[0].length];
        
        for(int i=grid.length-1;i>=0;i--) {
        	for(int j=grid[0].length-1;j>=0;j--) {
        		if(i==grid.length-1 &&  j==grid[0].length-1) {
        			
        		}
        		int min=(int)1e8;
        		if(i+1<grid.length) {
        			min = Math.min(min, dp[i+1][j]);
        		}
        		if(j+1<grid.length) {
        			min = Math.min(min, dp[i][j+1]);
        		}
        		dp[i][j] = min +grid[i][j];
        	}
        }
        return dp[0][0];
    }
	
	//friends pair - GFG == no of pairs of friends
	public static int fri(int n, int[] dp) {
		if(n<=1) {
			return dp[n]=1;
		}
		if(dp[n]!=0) {
			return dp[n];
		}
		int single = fri(n-1,dp);
		int pairUp = fri(n-2,dp) * (n-1);    //Pair * all combination
		return dp[n]= single + pairUp;
	}
	//friends pair - GFG == no of pairs of friends using tabulation
		public static int friT(int n,int[] dp) {
			int N=n;
			for(n=0;n<=N;n++) {
				if(n<=1) {
					dp[n]=1;
					continue;
				}
				int single = dp[n-1];
				int pairUp = dp[n-2] * (n-1);    //Pair * all combination
				dp[n]= single + pairUp;
			}
			return dp[N];
		}
		
		//friends pair - GFG == no of pairs of friends Optimized
		public static int friO(int n) {
			int single=1;
			int pair=1;
			int ans=0;
			for(int i=2;i<n;i++) {
				ans = single + pair * (i-1);
				pair=single;
				single=ans;
			}
			return ans;
		}
		
		
		// https://www.geeksforgeeks.org/count-number-of-ways-to-partition-a-set-into-k-subsets/

	public static int count_of_ways(int n, int k, int[][] dp) {
		if (k == n || k == 1)
			return dp[k][n] = 1;

		if (dp[k][n] != -1)
			return dp[k][n];

		int ownGroup = count_of_ways(n - 1, k - 1, dp);
		int partOfOtherGroup = count_of_ways(n - 1, k, dp) * k;

		return dp[k][n] = ownGroup + partOfOtherGroup;
	}

	    public static int count_of_ways_DP(int n, int k, int[][] dp) {
	        int K = k;
	        int N = n;
	        for (k = 1; k <= K; k++) {
	            for (n = k; n <= N; n++) {
	                if (k == n || k == 1) {
	                    dp[k][n] = 1;
	                    continue;
	                }

	                int ownGroup = dp[k - 1][n - 1]; // count_of_ways(n - 1, k - 1, dp);
	                int partOfOtherGroup = dp[k][n - 1] * k;// count_of_ways(n - 1, k, dp) * k;

	                dp[k][n] = ownGroup + partOfOtherGroup;
	            }
	        }

	        return dp[K][N];
	    }

	    public static void count_of_ways(int n, int k) {
	        int[][] dp = new int[k + 1][n + 1];
	        for (int[] d : dp)
	            Arrays.fill(d, -1);

	        // System.out.println(count_of_ways(n, k, dp));
	        System.out.println(count_of_ways_DP(n, k, dp));

//	        display2D(dp);
	    }
	
	
	public static int[][] LongestPS(String str){t
		
	}
	
	
	//Palindromic Substring
		public static int PalinS(String ques) {
			boolean[][] path=new boolean[ques.length()][ques.length()];
			int count=0;
			int x=0;
			int y=0;
			for(int dia=0;dia<ques.length();dia++) {
				int col=dia;
				int row=0;
				while(col<ques.length()) {
					if(dia==0) {
						path[col][row]=true;
					}
					else if(dia==1) {
						if(ques.charAt(row)==ques.charAt(col)) {
							path[row][col]=true;
						}
					}
					else {
						if(ques.charAt(row)==ques.charAt(col) && path[row+1][col-1]==true) {
							path[row][col]=true;
						}
					}
					if(path[row][col]==true) {
						count++;
					}
					row++;
					col++;
				}
			}
			return count;
		}
		
		//Leetcode 647 , 005, 516
		
	
	    public static void SubStrings(String ques,String ans) {
	    	if(ques.length()==0) {
	    		System.out.println(ans);
	    		return;
	    	}
	    	for(int i=0;i<ques.length();i++) {
	    		char ch=ques.charAt(i);
		    	String roq=ques.substring(0,i)+ques.substring(i+1);
		    	SubStrings(roq,ans+ch);
	    	}
	    }

	public static void main(String[] args) {
		int[][] arr= {{1,3,1},
					  {1,5,1},
					  {4,2,1}};
		
//		minPathSum(arr);
		SubStrings("bbbab","");
//		int c=fiboT(10,new int[11]);
//		int c=FiboOpti(10);
//		int c=Paths3T(0,0,4,4,new int[5][5]);
//		int d=Paths3(0,0,4,4,new int[5][5]);
//		int c= dice(10,new int[11]);
//		int d= diceT(10,new int[11]);
//		System.out.println(c);
//		int[] coins= {2,4,1,5};
//		int c=dice2(10,coins,new int[11]);
//		int d=dice2T(10,coins,new int[11]);
//		int c=board(10,coins,new int[11]);
//		int c=boardPath_opti(10);
//		System.out.println(c);
//		System.out.println(d);
//		dice2(10,coins,new int[4]);
//		int[][] mine= {{2,6,0,5},
//				       {0,7,5,2},
//				       {3,0,3,7},
//				       {8,0,2,3}};
//		int max=0;
//		for(int i=0;i<mine.length;i++) {
//			int j=goldmine(mine,i,0,new int[mine.length][mine[0].length]);
////			System.out.println(j);
//			max=Math.max(max,j);
//		}
//		System.out.println(max);
//		int[][] arr= {{1,3,1},
//					  {1,5,1},
//					  {4,2,1}};
		
//		System.out.println(minPath(arr,0,0));
	}
	

}
