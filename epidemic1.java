import java.util.*;

public class epidemic1 {
	public static class Node{
		public int data;
		public int time;
	}
	
	
	public static int time(Node[][] arr) {
		int max=Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(arr[i][j].time<max) {
					max=arr[i][j].time;
				}
			}
		}
		return max;
	}
	
	
	public static void print(Node[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.println(arr[i][j].data+" "+arr[i][j].time);
			}
		}
	}
	
	
	public static boolean epi(Node[][] arr) {
		int count=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(arr[i][j].data==2) {
					//up
					if(i>0) {
						arr[i-1][j].data=2;
						arr[i-1][j].time+=1;
					}
					//left
					if(j>0) {
						arr[i][j-1].data=2;
						arr[i][j-1].time+=1;
					}
					//down
					if(i<arr.length-1) {
						arr[i+1][j].data=2;
						arr[i+1][j].time+=1;
					}
					//right
					if(j<arr[i].length-1) {
						arr[i][j+1].data=2;
						arr[i][j+1].time+=1;
					}
				}
			}
//			count++;
		}
//		System.out.println(count);
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(arr[i][j].data==1) {
					return false;
				}
			}
		}
		return true;
	}
	

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int m=scn.nextInt();
		Node[][] arr=new Node[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j]=new Node();
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				int d=scn.nextInt();
				arr[i][j].data=d;
				arr[i][j].time=0;
			}
		}
		
//		print(arr);
		boolean f=epi(arr);
		int time=time(arr);
		System.out.println(time);
		System.out.println(f);
//		print(arr);
	}

}

//3
//5
//2 1 0 2 1
//1 0 1 2 1
//1 0 0 2 1