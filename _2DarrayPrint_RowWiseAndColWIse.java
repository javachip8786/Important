import java.util.*;
public class _2DarrayPrint_RowWiseAndColWIse {
	
	public static void Rowwise(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			if(i%2==0) {
				for(int j=0;j<arr[0].length;j++) {
					System.out.print(arr[i][j]+" ");
				}
			}
			else {
				for(int j=arr[0].length-1;j>=0;j--) {
					System.out.print(arr[i][j]+" ");
				}
			}
			
		}
	}
	
	public static void Colwise(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			if(i%2==0) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.print(arr[j][i]+" ");
			}
			}
			else {
				for(int j=arr[0].length-1;j>=0;j--) {
					System.out.print(arr[j][i]+" ");
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int row=scn.nextInt();
		int col=scn.nextInt();
		int[][] arr=new int[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				arr[i][j]=scn.nextInt();
			}
		}
		Rowwise(arr);
		System.out.println();
		Colwise(arr);
	}

}
