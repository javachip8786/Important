public class MissedClass_2Darray_anyDirectionExcept1 {
	public static int func(int i,int j,int[][] arr,String path) {
		int sum=0;
		if(i==arr.length-1 && j==arr[0].length-1) {
			System.out.println(path);
			return 1;
		}
		
		arr[i][j]=1;
		if(i-1>=0 && arr[i-1][j]!=1 ) {
			sum+=func(i-1,j,arr,path+'u');
		}
		if(j-1>=0 && arr[i][j-1]!=1) {
			sum+=func(i,j-1,arr,path+'l');
		}
		if(i+1<arr.length && arr[i+1][j]!=1 ) {
			sum+=func(i+1,j,arr,path+'d');
		}
		if(j+1<arr[0].length && arr[i][j+1]!=1 ) {
			sum+=func(i,j+1,arr,path+'r');
		}
		arr[i][j]=0;
		return sum;
	}
	public static void main(String[] args) {
		int[][] arr= {{0,0,0,0,0,0},
					  {0,1,0,1,0,0},
					  {0,0,0,0,0,0},
				      {0,0,1,0,1,0},
				      {1,0,0,0,0,0},
				      {0,0,0,0,0,0}};
		int finn=func(0,0,arr,"");
		System.out.println(finn);
	}
}