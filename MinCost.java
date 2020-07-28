

public class MinCost {
	
	public static int min(int a,int b) {
		if(a>b) {
			return b;
		}
		
			return a;
	}
	public static void mini(int[][] arr) {
		int[][] dp=new int[arr.length][arr[0].length];
		
		for(int i=dp.length-1;i>=0;i--) {
			for(int j=dp[0].length-1;j>=0;j--) {
				if(i==arr.length-1 && j==arr[0].length-1) {
					dp[i][j]=arr[i][j];
				}
				else if(i==arr.length-1) {
					dp[i][j]=arr[i][j]+dp[i][j+1];
				}
				else if(j==arr[0].length-1) {
					dp[i][j]=arr[i][j]+dp[i+1][j];
				}
				else {
					int a=dp[i+1][j];
					int b=dp[i][j+1];
					int c=min(a,b);
					//System.out.println(a+" "+b+" min is "+c);
					dp[i][j]=arr[i][j]+c;
				}
			}
		}
		System.out.print(dp[0][0]);
	}

	public static void main(String[] args) {
		int[][] arr= {{3,8,30,7,4},
					{8,10,15,2,18},
					{6,29,27,13,15},
					{10,19,10,1,3},
					{4,8,20,2,6}};
		mini(arr);
		}

	
}
