import java.util.*;
public class ExitPoint_90Turn {
	
	public static void exitpoint(int[][] arr) {
		int dir=0;
		int left=0;
		int right=0;
		while(left<arr.length || right<arr[0].length) {
			dir+=arr[left][right];
			
//			if(arr[left+1][right]==0 && arr[left][right+1]==1) {
			if(dir%4==0) {
				right++;
			}
//				if(arr[left][right+1]==0 && arr[left+1][right]==1) {
			else if(dir%4==1) {
				
				left++;
			}
			
			else if(dir%4==2) {
				right--;
			}
			else if(dir%4==3){
				left--;
			}
			if(left<0 || left==arr.length || right<0 || right==arr[0].length) {
				break;
			}
		}
		// if it get out from any of the four sides
		if(left<0){
            left++;
        }
        if(left==arr.length){
            left--;
        }
        if(right<0){
            right++;
        }
        if(right==arr[0].length){
            right--;
        }
		System.out.print(left+", "+right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int row=scn.nextInt();
		int col=scn.nextInt();
		int[][] arr=new int[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				arr[i][j]=scn.nextInt();
			}
		}
		exitpoint(arr);
	}

}
