import java.util.Scanner;
public class Assigment {
	public static void de(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]<arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}
	public static void in(int[] arr) {
		for(int i=arr.length-1;i>=0;i--) {
			for(int j=i-1;j>=0;j--) {
				if(arr[j]>arr[i]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}
	
	
	
	public static void input(int[] arr) {
		Scanner scn=new Scanner(System.in);
		for(int i=0;i<arr.length;i++) {
			arr[i]=scn.nextInt();
		}
	}
	public static void display(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int[] first=new int[n];
		int[] second=new int[n];
		int[] third=new int[n];
		input(first);
		input(second);
		input(third);
		in(first);
		de(second);
		in(third);
		display(first);
		display(second);
		display(third);
	}

}
