
public class DP_summitSIr1 {
	//memorization
	public static int fibom(int[] arr,int n) {
		if(n==1 || n==0) {
			return n;
		}
		if(arr[n]!=0) {
			return arr[n];
		}
		int nm1=fibom(arr,n-1);
		int nm2=fibom(arr,n-2);
		int fn=nm1+nm2;
		arr[n]=fn;
		return fn;
	}
	
	//tabulation
	public static int fint(int n) {
		int[] f=new int[n+1];
		f[0]=0;
		f[1]=1;
		for(int i=2;i<=n;i++) {
			f[i]=f[i-1]+f[i-2];
		}
		return f[n];
	}
	
	//count path. source to destination
	public static int cbpm(int s,int d,int[] arr) {
		if(s>d) {
			return 0;
		}
		
		if(s==d) {
			return 1;
		}
		if(arr[s]!=0) {
			return arr[s];
		}
		int count=0;
		for(int dice=1;dice<=6;dice++) {
			int i=s+dice;
			count+=cbpm(i,d,arr);
		}
		arr[s]=count;
		return count;
	}

	public static void main(String[] args) {
		int n=30;
		int[] arr=new int[n+1];
//		System.out.println(fibom(arr,n));
//		System.out.println(fint(n));
//		long start = System.currentTimeMillis();
		
		System.out.println(cbpm(0,n,arr));
//		long end= System.currentTimeMillis();
//		System.out.println(end-start);
	}

}
