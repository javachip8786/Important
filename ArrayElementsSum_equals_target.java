//import java.util.Scanner;
import java.util.*;

public class ArrayElementsSum_equals_target {
	
	public static void find(int[] arr,int target) {
//		System.out.println("hello");
		int left=0;
		int right=arr.length-1;
		while(left<right) {
			if(arr[left]+arr[right]==target) {
				System.out.println(arr[left]+" and "+arr[right]);
				left++;
				right--;
			}
			else if(arr[left]+arr[right]<target) {
				left++;
			}
			else {
				right--;
			}
		}
	}

	public static void main(String[] args) {
//		System.out.println("hello");
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=scn.nextInt();
		}
//		System.out.println("hello");
		Arrays.sort(arr);
		int target=scn.nextInt();
		find(arr,target);
	}

}
