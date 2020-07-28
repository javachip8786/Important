import java.util.*;
public class LevelUp_class2 {
	
	// place queens in boxes such that no one can kill the other
	public static boolean isSafe(boolean[][] boxes,int r ,int c) {
		int[][] dir= {{0,-1},{-1,-1},{-1,0},{-1,1}};
//		int[][] dir2={{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
		
		for(int d=0;d<dir.length;d++) {
			
			for(int rad=0;rad<=boxes.length;rad++) { //checks radius by radius
				
				int x=r+rad * dir[d][0];
				int y=c+rad * dir[d][1];
				if(x>=0 && y>=0 && x<boxes.length && y<boxes[0].length) {
					if(boxes[x][y]==true) { // checks if already a queen is placed or not
						return false;
					}
				}
			}
		}
		return true;
	}
	public static int Nqueen(boolean[][] boxes,int tnq,int idx,String ans) {
		
		if(tnq==0) {
			System.out.println(ans);
			return 1;
		}
		int count=0;
		for(int i=idx;i<boxes.length * boxes[0].length;i++) {
			int r=i / boxes[0].length;
			int c=i % boxes[0].length;
			if(isSafe(boxes,r,c)==true) {
				boxes[r][c]=true;
				count+=Nqueen(boxes,tnq-1,i+1,ans+"("+r+","+c+")");
				boxes[r][c]=false;
			}
		}
		
		return count;
	}
	
	//with permutation
	// place queens in boxes such that no one can kill the other with permutation
		public static boolean isSafeP(boolean[][] boxes,int r ,int c) {
//			int[][] dir= {{0,-1},{-1,-1},{-1,0},{-1,1}};
			int[][] dir={{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
			
			for(int d=0;d<dir.length;d++) {
				
				for(int rad=0;rad<=boxes.length;rad++) { //checks radius by radius
					
					int x=r+rad * dir[d][0];
					int y=c+rad * dir[d][1];
					if(x>=0 && y>=0 && x<boxes.length && y<boxes[0].length) {
						if(boxes[x][y]==true) { // checks if already a queen is placed or not
							return false;
						}
					}
				}
			}
			return true;
		}
		public static int NqueenP(boolean[][] boxes,int tnq,int idx,String ans) {
			
			if(tnq==0) {
				System.out.println(ans);
				return 1;
			}
			int count=0;
			for(int i=0;i<boxes.length * boxes[0].length;i++) {
				int r=i/ boxes[0].length;
				int c=i % boxes[0].length;
				if(isSafeP(boxes,r,c)==true) {
					boxes[r][c]=true;
					count+=NqueenP(boxes,tnq-1,i+1,ans+"("+r+","+c+")");
					boxes[r][c]=false;
				}
			}
			
			return count;
		}
		
		//more optimised way, we dont need a 2D array here. we just need 4 boolean array
		public static boolean[] rowA;
		public static boolean[] colA;
		public static boolean[] diagA;
		public static boolean[] adiagA;
		public static int NqueenO(boolean[][] boxes,int tnq,int idx,String ans) {
			if(tnq==0) {
				System.out.println(ans);
				return 1;
			}
			int count=0;
			int n=boxes.length;
			int m=boxes[0].length;
			for(int i=idx;i<n * m;i++) {
				int r=i / boxes[0].length;
				int c=i % boxes[0].length;
				if(rowA[r]==false && colA[c]==false && diagA[r+c]==false && adiagA[r-c+m-1]==false ) {
					rowA[r]=true;
					colA[c]=true;
					diagA[r+c]=true;
					adiagA[r-c+m-1]=true;
					count+=NqueenO(boxes,tnq-1,i+1,ans+"("+r+","+c+")");
					rowA[r]=false;
					colA[c]=false;
					diagA[r+c]=false;
					adiagA[r-c+m-1]=false;
					
				}
			
			}
			return count;
		}
		//doing the same just with permutations
		public static int NqueenOP(boolean[][] boxes,int tnq,int idx,String ans) {
			if(tnq==0) {
				System.out.println(ans);
				return 1;
			}
			int count=0;
			int n=boxes.length;
			int m=boxes[0].length;
			for(int i=0;i<n * m;i++) {
				int r=i / boxes[0].length;
				int c=i % boxes[0].length;
				if(rowA[r]==false && colA[c]==false && diagA[r+c]==false && adiagA[r-c+m-1]==false ) {
					rowA[r]=true;
					colA[c]=true;
					diagA[r+c]=true;
					adiagA[r-c+m-1]=true;
					count+=NqueenOP(boxes,tnq-1,i+1,ans+"("+r+","+c+")");
					rowA[r]=false;
					colA[c]=false;
					diagA[r+c]=false;
					adiagA[r-c+m-1]=false;
					
				}
			
			}
			return count;
		}
		
	// optimizing even more
	public static int NqueenOO(int n,int m,int tnq,int r,String ans) {
		if(tnq==0) {
			System.out.println(ans);
			return 1;
		}
		int count=0;
		for(int c=0;c<m;c++) {
			if(rowA[r]==false && colA[c]==false && diagA[r+c]==false && adiagA[r-c+m-1]==false) {
				rowA[r]=true;
				colA[c]=true;
				diagA[r+c]=true;
				adiagA[r-c+m-1]=true;
				count+=NqueenOO(n,m,tnq-1,r+1,ans+"("+r+","+c+")");
				rowA[r]=false;
				colA[c]=false;
				diagA[r+c]=false;
				adiagA[r-c+m-1]=false;
			}
		}
		return count;
	}
	
	// optimizing using bits
	public static int row = 0;
	public static int col = 0;
	public static int diag = 0;
	public static int adiag = 0;

	public static int Nqueen_05(int n, int m, int tnq, int r, String ans) // tnq is equal to target.
	{
	    if (tnq == 0)
	    {
	        System.out.println(ans);
	        return 1;
	    }

	    int count = 0;
	    //calls++;

	    for (int c = 0; c < m; c++)
	    {
	        if ((row & (1 << r)) == 0 && (col & (1 << c)) == 0 && (diag & (1 << (r + c))) == 0 && (adiag & (1 << (r - c + m - 1))) == 0)
	        {
	            row ^= (1 << r);
	            col ^= (1 << c);
	            diag ^= (1 << (r + c));
	            adiag ^= (1 << (r - c + m - 1));

	            count += Nqueen_05(n, m, tnq - 1, r + 1, ans + "(" + (r) + "," + (c) + ") ");

	            row ^= (1 << r);
	            col ^= (1 << c);
	            diag ^= (1 << (r + c));
	            adiag ^= (1 << (r - c + m - 1));
	        }
	    }
	    return count;
	}
	
	
	
	

	public static void main(String[] args) {
		int h=Nqueen(new boolean[5][5],4,0,"");
		
//		int h=NqueenP(new boolean[4][4],4,0,"");
		System.out.println(h);

		// same question but optimised
		rowA=new boolean[4];
		colA=new boolean[4];
		diagA=new boolean[7];
		adiagA=new boolean[7];
//		int h=NqueenO(new boolean[4][4],4,0,"");
//		int h=NqueenOP(new boolean[4][4],4,0,"");
//		int h=NqueenOO(4,4,4,0,"");
//		int h=Nqueen_05(4,4,4,0,"");
//		System.out.println(h);
	}

}
