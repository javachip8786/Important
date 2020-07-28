import java.util.*;
public class LevelUp1 {
	
	
	//normal keypad question
	public static String[] words={":;/", "abc", "def", "ghi", "jkl", "mno",
		    "pqrs", "tuv", "wxyz", "&*%", "#@$"};
	
		    public static ArrayList<String> nokiaKeyPad(String str){
		        if(str.length()==0) {
		            ArrayList<String> base=new ArrayList<>();
		            base.add("");
		            return base;
		        }

		        char ch=str.charAt(0);
		        String nstr=str.substring(1);

		        String word=words[ch-'0'];
		        ArrayList<String> smallAns=nokiaKeyPad(nstr);

		        ArrayList<String> myAns=new ArrayList<>();
		        for(String s: smallAns){
		            for(int i=0;i<word.length();i++){
		                myAns.add(word.charAt(i) + s);
		            }
		        }

		        return myAns;
		    }
		    
		    
		    //also includes substring such as "112" - {1,1,2},{11,2},{1,12}
		    public static int nokiaKeyPad_02(String str,String ans){
		        if(str.length()==0) {
		            System.out.println(ans);
		            return 1;
		        }

		        char ch=str.charAt(0);
		        String nstr=str.substring(1);
		        String word=words[ch-'0'];
		        int count=0;

		        for(int i=0;i<word.length();i++){
		            count+=nokiaKeyPad_02(nstr,ans+word.charAt(i));
		        }

		        if(str.length() > 1){
		            char ch2=str.charAt(1);
		            int num = (ch-'0')*10 + (ch2-'0');
		            if(num >= 10 && num <= 11){
		                word=words[num];
		                for(int i=0;i<word.length();i++){
		                    count+=nokiaKeyPad_02(str.substring(2),ans + word.charAt(i));
		                }
		            }
		        }
		       
		        return count;
		    }
		    
		    //a-0,b-1,c-2,d-3 and so on... for "123" - {1,2,3=b,c,d} , {1,23=b,x} , {12,3=m,d}
		    public static int encoding(String str,String ans){
		        if(str.length()==0) {
		            System.out.println(ans);
		            return 1;
		        }

		        char ch=str.charAt(0);
		        String nstr=str.substring(1);
		        int count=0;
		        
		        count+=encoding(nstr,ans+(char)('a'+ (ch-'0')));

		        if(str.length() > 1){
		            char ch2=str.charAt(1);
		            int num = (ch-'0')*10 + (ch2-'0');
		            if(num >= 10 && num <= 25){
		                count+=encoding(str.substring(2),ans+ (char)('a'+ num));
		            }
		        }
		       
		        return count;
		    }

		  
		   public static int[][] dirA={{0,1},{-1,0},{0,-1},{1,0}};
		    
		   public static int getMaximumGold(int[][] grid) {
		        int n=grid.length;
		        int m=grid[0].length;
		        int maxGold=0;
		        for(int i=0;i<n;i++){
		            for(int j=0;j<m;j++){
		                maxGold=Math.max(maxGold,getMaximumGold(i,j,grid));
		            }
		        }
		        return maxGold;
		    }
		    
		  public static int getMaximumGold(int sr,int sc,int[][] grid){
		         int n=grid.length;
		        int m=grid[0].length;
		        grid[sr][sc]=-grid[sr][sc];
		        int maxGold=0;
		        for(int d=0;d<dirA.length;d++){
		            int r=sr + dirA[d][0];
		            int c=sc + dirA[d][1];
		            if(r>=0 && c>=0 && r<n && c<m && grid[r][c]>0){
		                maxGold =Math.max(maxGold, getMaximumGold(r,c,grid));
		            }
		        }
		        grid[sr][sc]=-grid[sr][sc];
		        return maxGold+grid[sr][sc];
		    }
		  
		  
//		  int[][] dirA ={{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
		  public static String[] dirS={"R","U","L","D"};

		  //print all ways to go from top left to bottom right and print the count
		 public static int floodFillAlgo(int sr, int sc, int er, int ec, int[][] board, String ans)
		  {
		      if (sr == er && sc == ec)
		      {
		          System.out.println(ans);
		          return 1;
		      }

		      int count = 0;
		      board[sr][sc] = 1; //mark visited
		      for (int d = 0; d < dirA.length; d++)
		      {
		          int r = sr + dirA[d][0];
		          int c = sc + dirA[d][1];
		          if (r >= 0 && c >= 0 && r <= er && c <= ec && board[r][c] == 0)
		              count += floodFillAlgo(r, c, er, ec, board, ans + dirS[d]);
		      }

		      board[sr][sc] = 0; //mark unvisited
		      return count;
		  }
		 
		 //floodfill when jumps are allowed
		 public static int floodFillJumpAlgo(int sr, int sc, int er, int ec, int[][] board, String ans)
		 {	 int n=er+1;
		 	 int m=ec+1;
		     if (sr == er && sc == ec)
		     {
		         System.out.println(ans);
		         return 1;
		     }

		     int count = 0;
		     board[sr][sc] = 1; //mark visited
		     for (int d = 0; d < dirA.length; d++)
		     {
		         for (int rad = 1; rad <= Math.max(n, m); rad++)
		         {
		             int r = sr + rad * dirA[d][0];
		             int c = sc + rad * dirA[d][1];
		             if (r >= 0 && c >= 0 && r <= er && c <= ec && board[r][c] == 0)
		                 count += floodFillJumpAlgo(r, c, er, ec, board, ans + dirS[d] + (rad));
		         }
		     }

//		     board[sr][sc] = 0; //mark unvisited
		     return count;
		 }
		 
		 
		 
		 //gives the longest Path from source to destination
		 public static class floodFillPair
		 {
		     String str = "";
		     int len = 0;

		     floodFillPair(String str, int len)
		     {
		         this.str = str;
		         this.len = len;
		     }
		 }

		 public static floodFillPair longestPath(int sr, int sc, int er, int ec, int[][] board)
		 {	int n=er+1;
		 	int m=ec+1;
		     if (sr == er && sc == ec)
		     {
		         floodFillPair base=new floodFillPair("", 0);
		         return base;
		     }

		     floodFillPair myAns=new floodFillPair("", 0);
		     board[sr][sc] = 1; //mark visited
		     for (int d = 0; d < dirA.length; d++)
		     {
		         for (int rad = 1; rad <= Math.max(n, m); rad++)
		         {
		             int r = sr + rad * dirA[d][0];
		             int c = sc + rad * dirA[d][1];
		             if (r >= 0 && c >= 0 && r <= er && c <= ec && board[r][c] == 0)
		             {
		                 floodFillPair recAns = longestPath(r, c, er, ec, board);
		                 if (recAns.len + 1 > myAns.len)
		                 {
		                     myAns.len = recAns.len + 1;
		                     myAns.str = dirS[d] + (rad) + recAns.str;
		                 }
		             }
		         }
		     }

		     board[sr][sc] = 0; //mark unvisited
		     return myAns;
		 }
		 
	//-------------------------------------------------------------------------------------	 
	//MAZE
	//permutation infinite
	public static int permutationINFI(int[] arr, int idx, int tar, String ans)
		 {
		     if (tar == 0)
		     {
		        System.out.println(ans);
		         return 1;
		     }

		     int count = 0;
		     for (int i = idx; i < arr.length; i++)
		     {
		         if (tar - arr[i] >= 0)
		             count += permutationINFI(arr, 0, tar - arr[i], ans + (arr[i]) + " ");
		     }
		     return count;
	}
	//combination infinity
	public static int combinationINFI(int[] arr, int idx, int tar, String ans)
	{
	    if (tar == 0)
	    {	System.out.println(ans);
	        return 1;
	    }

	    int count = 0;
	    for (int i = idx; i < arr.length; i++)
	    {
	        if (tar - arr[i] >= 0)
	            count += combinationINFI(arr, i, tar - arr[i], ans + (arr[i]) + " ");
	    }
	    return count;
	}
		 
	// combination of single coins
	public static int combinationSingleCoin(int[] arr, int idx, int tar, String ans)
	{
	    if (tar == 0)
	    {
	        System.out.println(ans);
	        return 1;
	    }

	    int count = 0;
	    for (int i = idx; i < arr.length; i++)
	    {
	        if (tar - arr[i] >= 0)
	            count += combinationSingleCoin(arr, i + 1, tar - arr[i], ans + (arr[i]) + " ");
	    }
	    return count;
	}
	
	// permutation of single coin
	public static int permutationSingleCoin(int[] arr, int idx, int tar, String ans)
	{
	    if (tar == 0)
	    {
	        System.out.println(ans);
	        return 1;
	    }

	    int count = 0;
	    for (int i = idx; i < arr.length; i++)
	    {
	        if (arr[i] >= 0 && tar - arr[i] >= 0)
	        {
	            int temp = arr[i];
	            arr[i] = -arr[i];  //converted to negative so that next time it wont be selected hence single coin
	            count += permutationSingleCoin(arr, 0, tar - temp, ans + (temp) + " ");
	            arr[i] = -arr[i];
	        }
	    }
	    return count;
	}
	//================================================================
	// Doing the same questions but with another approach
	
	//combination single coin
	public static int combinationSingleCoin_subseq(int[] arr, int idx, int tar, String ans)
	{
	    if (tar == 0 || idx == arr.length)
	    {
	        if (tar == 0)
	        {
	            System.out.println(ans);
	            return 1;
	        }
	        return 0;
	    }

	    int count = 0;
	    if (tar - arr[idx] >= 0) {
	        count += combinationSingleCoin_subseq(arr, idx + 1, tar - arr[idx], ans + (arr[idx]) + " ");  // one time subtract
	        count += combinationSingleCoin_subseq(arr, idx + 1, tar, ans);   //one time leave
	    }
	    return count;
	}
	
	//combination infinity
	public static int combinationINFI_subseq(int[] arr, int idx, int tar, String ans)
	{
	    if (tar == 0 || idx == arr.length)
	    {
	        if (tar == 0)
	        {
	            System.out.println(ans);
	            return 1;
	        }
	        return 0;
	    }

	    int count = 0;
	    if (tar - arr[idx] >= 0) {
	        count += combinationINFI_subseq(arr, idx, tar - arr[idx], ans + (arr[idx]) + " ");
	    	count += combinationINFI_subseq(arr, idx + 1, tar, ans);
	    }
	    return count;
	}
	
	//permutation infinity
	public static int permutationINFI_subseq(int[] arr, int idx, int tar, String ans)
	{
	    if (tar == 0 || idx == arr.length)
	    {
	        if (tar == 0)
	        {
	            System.out.println(ans);
	            return 1;
	        }
	        return 0;
	    }

	    int count = 0;
	    if (tar - arr[idx] >= 0) {
	        count += permutationINFI_subseq(arr, 0, tar - arr[idx], ans + (arr[idx]) + " ");
	    	count += permutationINFI_subseq(arr, idx + 1, tar, ans);
	    }
	    return count;
	}
	
	// permutation single coin
	public static int permutationSingleCoin_subseq(int[] arr, int idx, int tar, String ans)
	{
	    if (tar == 0 || idx == arr.length)
	    {
	        if (tar == 0)
	        {
	            System.out.println(ans);
	            return 1;
	        }
	        return 0;
	    }

	    int count = 0;

	    if (arr[idx] >= 0 && tar - arr[idx] >= 0)
	    {

	        int temp = arr[idx];
	        arr[idx] = -arr[idx];   // we made it negative so that it wont be chosen the next time
	        count += permutationSingleCoin_subseq(arr, 0, tar - temp, ans + (temp) + " ");
	        arr[idx] = -arr[idx];
	    }

	    count += permutationSingleCoin_subseq(arr, idx + 1, tar, ans);
	    return count;
	}
	
	
	// place queen on different blocks 
	
	// all combinations tnq=total no. of queens, qpsf= queens placed so far
	public static int queenCombination_1D(boolean[] boxes, int tnq, int idx, int qpsf, String ans) // tnq is equal to target.
	{
	    if (qpsf == tnq)
	    {
	        System.out.println(ans);
	        return 1;
	    }

	    int count = 0;
	    for (int i = idx; i < boxes.length; i++)
	    {
	        count += queenCombination_1D(boxes, tnq, i + 1, qpsf + 1, ans + "b" + (i) + "q" +(qpsf) + " ");
	    }
	    return count;
	}
	
	// all combinations subsequence
	public static int queenCombination_1D_subseq(boolean[] boxes, int tnq, int idx, int qpsf, String ans) // tnq is equal to target.
	{
	    if (qpsf == tnq || idx == boxes.length)
	    {
	        if (qpsf == tnq)
	        {
	            System.out.println(ans);
	            return 1;
	        }
	        return 0;
	    }

	    int count = 0;
	    count += queenCombination_1D_subseq(boxes, tnq, idx + 1, qpsf + 1, ans + "b" +(idx) + "q" +(qpsf) + " ");
	    count += queenCombination_1D_subseq(boxes, tnq, idx + 1, qpsf, ans);

	    return count;
	}
	
	// place queens using permutation
	public static int queenPermutation_1D(boolean[] boxes, int tnq, int idx, int qpsf, String ans) // tnq is equal to target.
	{
	    if (qpsf == tnq)
	    {
	       System.out.println(ans);
	        return 1;
	    }

	    int count = 0;
	    for (int i = idx; i < boxes.length; i++)
	    {
	        if (!boxes[i])
	        {
	            boxes[i] = true;
	            count += queenPermutation_1D(boxes, tnq, 0, qpsf + 1, ans + "b" + (i) + "q" +(qpsf) + " ");
	            boxes[i] = false;
	        }
	    }
	    return count;
	}
	
	// place queens using permutation 2D
	public static int queenCombination_2D(boolean[][] boxes, int tnq, int idx, int qpsf, String ans) // tnq is equal to target.
	{
	    if (qpsf == tnq)
	    {
	        System.out.println(ans);
	        return 1;
	    }

	    int count = 0;
	    for (int i = idx; i < boxes.length * boxes[0].length; i++)
	    {
	        int r = i / boxes[0].length;
	        int c = i % boxes[0].length;
	        count += queenCombination_2D(boxes, tnq, i + 1, qpsf + 1, ans + "(" +(r) + "," + (c) + ") ");
	    }
	    return count;
	}
	
	// place queens using combinations 2D

	public static int queenPermutation_2D(boolean[][] boxes, int tnq, int idx, int qpsf, String ans) // tnq is equal to target.
	{
	    if (qpsf == tnq)
	    {
	        System.out.println(ans);
	        return 1;
	    }

	    int count = 0;
	    for (int i = idx; i < boxes.length * boxes[0].length; i++)
	    {
	        int r = i / boxes[0].length;
	        int c = i % boxes[0].length;
	        if (!boxes[r][c])
	        {
	            boxes[r][c] = true;
	            count += queenPermutation_2D(boxes, tnq, 0, qpsf + 1, ans + "b" +(i) + "q" +(qpsf) + " ");
	            boxes[r][c] = false;
	        }
	    }
	    return count;
	}


	public static void main(String[] args) {
//		ArrayList<String> dd=nokiaKeyPad("113");
//		System.out.print(dd);
//		nokiaKeyPad_02("112","");
//		encoding("123","");
//		int[][] arr= {{0,6,0},{5,8,7},{0,9,0}};
//		int h=getMaximumGold(arr);
//		int h=floodFillAlgo(0,0,3,3,new int[4][4],"");
//		int h=floodFillJumpAlgo(0,0,2,2,new int[3][3],"");
//		floodFillPair s=longestPath(0,0,2,2,new int[3][3]);
//		System.out.println(s.str);
//		System.out.println(h);
		
		//maze-------------====================--------------
		int[] arr= {2,3,5,7};
		int tar=10;
		int c=permutationINFI(arr,0,tar,"");
//		int c=combinationINFI(arr,0,tar,"");
//		int c=combinationSingleCoin(arr,0,tar,"");
//		int c=permutationSingleCoin(arr,0,tar,"");
		System.out.println(c);
		
//		int d=combinationSingleCoin_subseq(arr,0,tar,"");
//		int d=combinationINFI_subseq(arr,0,tar,"");
//		int d=permutationINFI_subseq(arr,0,tar,"");
//		int d=permutationSingleCoin_subseq(arr,0,tar,"");
//		System.out.println(d);
		
		// ways to place queen on differernt blocks
		boolean[] places=new boolean[5];
//		int k=queenCombination_1D(places,3,0,0,"");
//		int k=queenCombination_1D_subseq(places,3,0,0,"");
//		int k=queenPermutation_1D(places,3,0,0,"");
		boolean[][] boxes=new boolean[4][4];
//		int k=queenCombination_2D(boxes,4,0,0,"");
//		int k=queenPermutation_2D(boxes,4,0,0,"");
//		System.out.println(k);
		
	}

}
