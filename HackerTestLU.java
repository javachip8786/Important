import java.util.*;
public class HackerTestLU {
	
	
	//Q1
	public static int OctalToDec(int n) {
		int sum=0;
		int pow=1;
		while(n>0) {
			int rem=n%10;
			n/=10;
			sum+=pow*rem;
			pow*=8;
		}
		return sum;
	}
	
	public static int BinToDec(int n) {
		int sum=0;
		int pow=1;
		while(n>0) {
			int rem=n%10;
			n/=10;
			sum+=pow*rem;
			pow*=2;
		}
		return sum;
	}
	
	public static int DecToOctal(int n) {
		int sum=0;
		int pow=1;
		while(n>0) {
			int rem=n%8;
			sum+=rem*pow;
			n/=8;
			pow*=10;
		}
		return sum;
	}
	
	
	
	
	//Q2
	public static int FME(int[] arr) {
		for(int i=1;i<=arr.length;i++) {
			int count=0;
			for(int j=0;j<arr.length;j++) {
				if(i==arr[j]) {
					count++;
				}
			}
			if(count==0) {
				return i;
			}
		}
		return arr.length+1;
	}
	
	//2 spheres
//	public static String Sphere(int r1,int r2,int[] c1,int[] c2,int[] a1,int[] a2) {
//		
//		int[] arr1=new int[3];
//		for(int i=0;i<3;i++) {
//			arr1[i]=c1[i]+r1;
//		}
//		
//		int[] arr2=new int[3];
//		for(int i=0;i<3;i++) {
//			arr2[i]=c2[i]-r2;
//		}
//		
//		for(int i=0;i<3;i++) {
//			if(arr2[i]+arr1[i]<0) {
//				return "YES";
//			}
//		}
//		
//		int[] aa1=new int[3];
//		for(int i=0;i<3;i++) {
//			
//		}
//	}
	
	
	
	//Q4
	public static boolean isSafe(boolean[][] v,int r,int c) {
		int[][] dir= {{0,-1},{-1,-1},{-1,0},{-1,1}};
		for(int i=0;i<dir.length;i++) {
			for(int j=0;j<=v.length;j++) {
				int x=r + (j * dir[i][0]);
				int y=c + (j * dir[i][1]);
				if(x>=0 && y>=0 && x<v.length && y<v[0].length ) {
					if(v[x][y]==true) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public static void NQueen(boolean[][] v,int tnq,int qpsf,int idx,String path) {
		if(tnq==0) {
			System.out.println(path);
			return;
		}
		
		for(int i=idx;i<v.length * v[0].length ;i++) {
			int r=i / v[0].length;
			int c=i % v[0].length;
			if(isSafe(v,r,c)==true) {
				v[r][c]=true;
				NQueen(v,tnq-1,qpsf+1,i+1,path+"["+r+"-"+c+"]");
				v[r][c]=false;
			}
		}
	}
	
	
	
	//Q5
	public static void Recur(int n,int curr) {
		for(int i=0;i<10;i++) {
			int temp= 10 * curr + i;
			if(temp>=n) {
				return;
			}
			if(temp>0) {
				System.out.println(temp);
				Recur(n,temp);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		//Q1
//		int o=scn.nextInt();
//		int b=scn.nextInt();
//		int TH=scn.nextInt();
//		int bin=BinToDec(b);
//		int oct2=DecToOctal(bin);
////		System.out.println(o);
////		System.out.println(oct2);
//		
//		if(Math.abs(oct2-o)>TH) {
//			System.out.println("john");
//		}
//		else {
//			System.out.println("ceena");
//		}
		
		
		
		
		//Q2
//		int size=scn.nextInt();
//		int[] arr=new int[size];
//		for(int i=0;i<size;i++) {
//			arr[i]=scn.nextInt();
//		}
//		int fin=FME(arr);
//		System.out.println(fin);
		
		
		
		
		//Q3
//		int test=scn.nextInt();
//		for(int i=0;i<test;i++) {
//			int r1=scn.nextInt(); //radius 1
//			int r2=scn.nextInt(); //radius 2
//			
//			int[] c1=new int[3];  //center of 1
//			for(int j=0;i<3;i++) {
//				c1[j]=scn.nextInt();
//			}
//			
//			int[] c2=new int[3];   //center of 2
//			for(int j=0;i<3;i++) {
//				c2[j]=scn.nextInt();
//			}
//			
//			int[] a1=new int[3];   //accel of 1
//			for(int j=0;i<3;i++) {
//				a1[j]=scn.nextInt();
//			}
//			
//			int[] a2=new int[3];  //accel of 2
//			for(int j=0;i<3;i++) {
//				a2[j]=scn.nextInt();
//			}
//		}
		
		
		//Q4
//		int a=scn.nextInt();
//		int b=scn.nextInt();
//		
//		NQueen(new boolean[a][a],b,b,0,"");
		
		
		//Q5
		Recur(20,0);

	}

}
