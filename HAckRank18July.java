import java.util.*;
public class HAckRank18July {
	
	
	public static int[][] dir= {{1,0},{0,-1},{-1,0},{0,1}};
	
	public static void fin(int[][] matrix,int r,int c,int d) {
		if(r>matrix.length || c>matrix[0].length || r<0 || c<0) {
			System.out.println(r+" , "+c);
			return;
		}
		d=d%4;
		if(matrix[r+dir[d][0]][c+dir[d][1]]==0) {
			fin(matrix,r+dir[d][0],c+dir[d][1],d);
		}
		else if(matrix[r+dir[d][0]][c+dir[d][1]]==1) {
			fin(matrix,r+dir[d+1][0],c+dir[d+1][1],d+1);
		}
		
	}
	
	public static void pow(int m,int d){
		if(d==0){
            System.out.println(0);
            return;
        }
        long sum=1;
        while(d!=0){
            sum*=m;
            d-=1;
        }
        
//        if(sum>2147483647) {
        	sum=sum % (1000000000 + 7);
//        	sum+=7;
        	System.out.println(sum);
//        }
//        else {
//        	System.out.println(sum);
//        }
    }
	

	public static void main(String[] args) {
		int[][] matrix= {{0,0,1,0},{1,0,0,0},{0,0,0,0},{1,0,1,0}};
//		fin(matrix,0,0,0);
		
		pow(9,5);
	}

}
