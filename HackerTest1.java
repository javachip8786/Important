import java.util.*;
public class HackerTest1 {
	
	public static boolean condi(Long[] arr) {
		int count=0;
			long focus=arr[0];
			for(int j=0;j<arr.length;j++) {
				if(focus==arr[j]) {
					count++;
				}
			}
		
		for(int i=0;i<arr.length;i++) {
			int c=0;
			long f=arr[i];
			for(int j=0;j<arr.length;j++) {
				if(f==arr[j]) {
					c++;
				}
			}
			if(c!=count) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		long n=scn.nextLong();
		
		Long[] arr=new Long[(int) n];
		for(int i=0;i<n;i++) {
			long h=scn.nextInt();
			arr[i]=h;
		}
		boolean f=condi(arr);
		System.out.println(f);
	}

}
//8
//1 2 3 4 4 3 2 1

//9
//3 6 9
//9 6 3
//6 9 3