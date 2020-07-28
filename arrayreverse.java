import java.util.Arrays;
public class arrayreverse {
	
	public static void rotate(int arr[],int left,int right) {
		while(left<right) {
			int temp=arr[left];
			arr[left]=arr[right];
			arr[right]=temp;
			left++;
			right--;
		}
	}
	
	public static void main(String[] args) {
		int arr[]= {3,4,8,2,1,6};
		int rotat=3;
		rotate(arr,arr.length-rotat,arr.length-1);
		rotate(arr,0,arr.length-rotat-1);
		rotate(arr,0,arr.length-1);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
		}
		System.out.println("");
	}
	

}
