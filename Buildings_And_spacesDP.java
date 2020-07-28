import java.util.*;
public class Buildings_And_spacesDP {
	
	public static long buildings(int n) {
		long[] space=new long[n+1];
		long[] building=new long[n+1];
		
		space[1]=building[1]=1;
		for(int i=2;i<=n;i++) {
			space[i] = space[i-1] + building[i-1];
			building[i]= space[i-1];
		}
		long ans=space[n]+building[n];
		return ans * ans;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
