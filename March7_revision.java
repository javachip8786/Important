
public class March7_revision {
	public static void quick(int[] arr) {
		int i=0;
		int pivot=arr[arr.length-1];
		int j=0;
		while(j<arr.length) {
			if(arr[j]<=pivot ) {
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				i++;
				j++;
			}
			else {
				j++;
			}
			
		}
		for(int t=0;t<arr.length;t++) {
			System.out.print(arr[t]+" ");
		}
	
	}

	public static void main(String[] args) {
		int[] arr= {3,8,10,12,18,6,5,4,3,9};
		quick(arr);

	}

}
