import java.util.*;
public class MazeRatBackTracking_GFG {
//-------------------------------------------------------------------
	//Rat in a Maze | Backtracking-2
	public static int[][] moves= {{0,1},{1,0}};
	public static String[] movesPath= {"R","D"};
	
	public static int MRB(int sx,int sy,int ex,int ey,int[][] grid,int[][] v,String path) {
		if(sx==ex && sy==ey) {
			System.out.println(path);
			return 1;
		}
		
		int count=0;
		v[sx][sy]=1;  //mark
		for(int i=0;i<moves.length;i++) {
			int x=sx+ moves[i][0];
			int y=sy+ moves[i][1];
			
			if(x>=0 && y>=0 && x<=ex && y<=ey && v[x][y]==0 && grid[x][y]!=0) {
//				System.out.println("yes");
				count+=MRB(x,y,ex,ey,grid,v,path+movesPath[i]);
			}
		}
		v[sx][sy]=0;  //unmark
		return count;
	}
	
	
	//---------------------------------------------------------------------------
	
	//same problem as above, just all four directions are allowed now
	public static int[][] moves2= {{0,1},{-1,0},{0,-1},{1,0}};
	public static String[] movesPath2= {"R","U","L","D"};
	
	public static int MRBA(int sx,int sy,int ex,int ey,int[][] grid,int[][] v,String path) {
		if(sx==ex && sy==ey) {
			System.out.println(path);
			return 1;
		}
		int count=0; //mark
		v[sx][sy]=1;
		for(int i=0;i<moves2.length;i++) {
			int x=sx+moves2[i][0];
			int y=sy+moves2[i][1];
			if(x>=0 && y>=0 && x<=ex && y<=ey && grid[x][y]!=0 && v[x][y]==0) {
				count+=MRBA(x,y,ex,ey,grid,v,path+movesPath2[i]);
			}
		}
		
		v[sx][sy]=0; //unmark
		return count;
	}
	
	
	
	

	public static void main(String[] args) {
		int[][] grido= {{1,0,0,0},
					    {1,1,0,1},
					    {1,1,0,0},
					    {0,1,1,1}};
		
//		int h=MRB(0,0,3,3,grido,new int[5][5],"");
		int h=MRBA(0,0,3,3,grido,new int[5][5],"");
		System.out.println(h);
	}

}
