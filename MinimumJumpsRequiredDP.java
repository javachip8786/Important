
public class MinimumJumpsRequiredDP {
	public static int MiniStepsRequired(int[] arr) {
		int[] dp=new int[arr.length];
		dp[dp.length-1]=0;
		for(int i=dp.length-2;i>=0;i--) {
			if(arr[i]==0) {
				dp[i]=Integer.MAX_VALUE;
			}
			else {
				int minjump=Integer.MAX_VALUE;
				for(int jump=1;jump<=arr[i] && i+jump<arr.length;jump++) {
					minjump=Math.min(minjump, dp[i+jump]);
				}
				dp[i]=minjump!=Integer.MAX_VALUE?minjump+1:Integer.MAX_VALUE;
			}
		}
		return dp[0];
		
	}

	public static void main(String[] args) {
		int[] arr= {4,5,1,0,2,2,3,1,2,0,1};
		System.out.println(MiniStepsRequired(arr));
	}

}
