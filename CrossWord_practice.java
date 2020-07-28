import java.util.*;
public class CrossWord_practice {
	public static char[][] board={      { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
							            { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
							            { '+', '-', '-', '-', '-', '-', '-', '-', '+', '+' },
							            { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
							            { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
							            { '+', '-', '-', '-', '-', '-', '-', '+', '+', '+' }, 
							            { '+', '-', '+', '+', '+', '-', '+', '+', '+', '+' },
							            { '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' }, 
							            { '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' },
							            { '+', '+', '+', '+', '+', '+', '+', '+', '+', '+' } };
	
	public static boolean CanPlaceH(int r,int c,String word) {
		for(int i=0;i<word.length();i++) {
			if(c+i<board[0].length && (board[r][c+i]!='-' && board[r][c+i]!=word.charAt(i) )) {
				return false;
			}
		}
		return true;
	}
	public static boolean CanPlaceV(int r,int c,String word) {
		for(int i=0;i<word.length();i++) {
			if(r+i<board.length && (board[r+i][c]!='-' && board[r+i][c]!=word.charAt(i) )) {
				return false;
			}
		}
		return true;
	}
	//place horizontal
	public static boolean[] PlaceH(int r,int c,String word) {
		boolean[] loc= new boolean[word.length()];
		for(int i=0;i<word.length();i++) {
			if(board[r][c+i]=='-') {
				board[r][c+i]=word.charAt(i);
				loc[i]=true;
			}
		}
		return loc;
	}
	//unplace horizontal
	public static void UnPlaceH(int r,int c,String word,boolean[] loc) {
		for(int i=0;i<word.length();i++) {
			if(loc[i]==true) {
				board[r][c+i]='-';
			}
		}
	}
	//place vertical
	public static boolean[] PlaceV(int r,int c,String word) {
		boolean[] loc= new boolean[word.length()];
		for(int i=0;i<word.length();i++) {
			if(board[r+i][c]=='-') {
				board[r+i][c]=word.charAt(i);
				loc[i]=true;
			}
		}
		return loc;
	}
	//unplace verticle
	public static void UnPlaceV(int r,int c,String word,boolean[] loc) {
		for(int i=0;i<word.length();i++) {
			if(loc[i]==true) {
				board[r+i][c]='-';
			}
		}
	}
	
	public static void print() {
        for (char[] ar : board) {
            for (char ch : ar) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
	
	public static int CrossWord(String[] words,int idx) {
		if(idx==words.length) {
			print();
			return 1;
		}
		String word=words[idx];
		int count=0;
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(board[i][j]=='-' || board[i][j]==word.charAt(0)) {
					if(CanPlaceH(i,j,word)) {
						boolean[] loc=PlaceH(i,j,word);
						count+=CrossWord(words,idx+1);
						UnPlaceH(i,j,word,loc);
					}
					if(CanPlaceV(i,j,word)) {
						boolean[] loc=PlaceV(i,j,word);
						count+=CrossWord(words,idx+1);
						UnPlaceV(i,j,word,loc);
					}
				}
			}
		}
		return count;
	}
	
	public static String[] ans= {"agra", "norway", "england", "gwalior" };
	
	
	
	
	public static void main(String[] args) {
		String[] words= { "agra", "norway", "england", "gwalior" };
		int h=CrossWord(words,0);
		System.out.println(h);
		
	}
}