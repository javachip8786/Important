import java.util.*;
public class coronaSociety {
	
	
	public static boolean fin(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==0) {
				return false;
			}
		}
		return true;
	}
	

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int test=scn.nextInt();
		int[] arr=new int[test];
		for(int i=0;i<test;i++) {
			int p=scn.nextInt();
			int q=scn.nextInt();
			for(int j=0;j<p;j++) {
				int a=scn.nextInt();
				if(arr[a]==0) {
					arr[0]=1;
				}
			}
			for(int j=0;j<q;j++) {
				int a=scn.nextInt();
			}
		}
		boolean f=fin(arr);
		System.out.println(f);
		
		
	}

}
//3
//2 0
//1 2
//1 1
//0
//2
//0 0