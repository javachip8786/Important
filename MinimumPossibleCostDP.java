
public class MinimumPossibleCostDP {
	public static int min(int a,int b) {
		if(a>b) {
			return b;
		}
		else {
		return a;
		}
	}
	public static int Mini(int[][] arr) {
		int[][] dp=new int[arr.length][arr[0].length];
		for(int i=dp.length-1;i>=0;i--) {
			
			for(int j=dp[0].length-1;j>=0;j--) {
				
				if(i==dp[0].length-1 && j==dp[0].length-1) {
					dp[i][j]=arr[i][j];
				}
				else if(i==dp.length-1) {
					dp[i][j]=arr[i][j]+dp[i][j+1];
				}
				else if(j==dp[0].length-1) {
					dp[i][j]=arr[i][j]+dp[i+1][j];
				}
				else {
					dp[i][j]=arr[i][j] + min(dp[i][j+1],dp[i+1][j]);
				}
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		int[][] arr= {{5,7,8,3,27},
					{9,11,11,21,25},
					{28,14,20,22,30},
					{18,31,15,4,2},
					{9,17,8,5,10}};
		System.out.print(Mini(arr));

	}
	
}