import java.util.*;
public class DP_SumiitSir2 {
	
	public static int omax=0;
	//GoldMine
	public static void GM(int[][] mine) {
		int[][] smine=new int[mine.length][mine[0].length];
		String[][] path=new String[mine.length][mine[0].length];
		int omax=0;
		for(int c=mine[0].length-1;c>=0;c--) {
			for(int r=0;r<mine.length;r++) {
				int rp1=r+1;
				int rm1=r-1;
				int cp1=c+1;
				if(c==mine[0].length-1) {
					smine[r][c]=mine[r][c];
					path[r][c]=r+"_"+c;
				}
				else if(r==0) {
					if(smine[r][cp1]>smine[rp1][cp1]) {
						smine[r][c]=mine[r][c]+smine[r][cp1];
						path[r][c]=r+"_"+c+path[r][cp1];
					}
					else {
						smine[r][c]=mine[r][c]+smine[rp1][cp1];
						path[r][c]=r+"_"+c+path[rp1][cp1];
					}
				}
				else if(r==mine.length-1) {
					if(smine[r][cp1]>smine[rm1][cp1]) {
						smine[r][c]=mine[r][c]+smine[r][cp1];
						path[r][c]=r+"_"+c+path[r][cp1];
					}
					else {
						smine[r][c]=mine[r][c]+smine[rm1][cp1];
						path[r][c]=r+"_"+c+path[rm1][cp1];
					}
				}
				else {
					if(smine[r][cp1]>smine[rp1][cp1] && smine[r][cp1]>smine[rm1][cp1]) {
						smine[r][c]=mine[r][c]+smine[r][cp1];
						path[r][c]=r+"_"+c+path[r][cp1];
					}
					else if(smine[rm1][cp1]>smine[rp1][cp1] && smine[rm1][cp1]>smine[r][cp1]){
						smine[r][c]=mine[r][c]+smine[rm1][cp1];
						path[r][c]=r+"_"+c+path[rm1][cp1];
					}
					else {
						smine[r][c]=mine[r][c]+smine[rp1][cp1];
						path[r][c]=r+"_"+c+path[rp1][cp1];
					}
				}
				if(smine[r][c]>omax) {
					omax=smine[r][c];
				}
			}
			
		}
		System.out.println(omax);
		
	}
	
	
	//GoldMine using memorization
	public static int GMM(int[][] mine,int r ,int c,int[][] qb) {
		if(c==mine[0].length-1) {
			return mine[r][c];
		}
		if(qb[r][c]!=0) {
			return qb[r][c];
		}
		int max=0;
		int rm1=Integer.MIN_VALUE;
		int rp1=Integer.MIN_VALUE;
		int rp=Integer.MIN_VALUE;
		if(r>0) {
			rm1=GMM(mine,r-1,c+1,qb);
		}
		rp=GMM(mine,r,c+1,qb);
		if(r<mine.length-1) {
			rp1=GMM(mine,r+1,c+1,qb);
		}
		max=mine[r][c]+Math.max(rp,Math.max(rp1,rm1));
		qb[r][c]=max;
		return max;
	}
	
	
	//substrings
	public static void SS(String s,String ans) {
		if(s.length()==0) {
			System.out.println(ans);
			return;
		}
		
	
			char ch=s.charAt(0);
			String roq=s.substring(1);
			SS(roq,ans+ch);
			SS(roq,ans);
	}
	
	//palindromic substrings
	public static void PS(String str) {
		String[][] store=new String[str.length()][str.length()];
		int count=0;
		for(int d=0;d<str.length();d++) {
			int si=0;
			int ei=d;
			while(ei<str.length()) {
				if(d==0) {
					store[si][ei]="T";
				}
				else if(d==1) {
					if(str.charAt(si)==str.charAt(ei)) {
						store[si][ei]="T";
					}
				}
				else {
					if(str.charAt(si)==str.charAt(ei) && store[si+1][ei-1]=="T") {
						store[si][ei]="T";
					}
				}
				if(store[si][ei]=="T") {
					count++;
				}
				ei++;
				si++;
			}
		}
		System.out.println(count);
	}
	
	//max selling price of ROD
//	public static int[] rod= {0,3,5,6,15,10,25,12,24};
//	public static int count=0;
	public static void rod(int[] arr) {
		int[] strg=new int[arr.length];
		String[] path=new String[arr.length];
		strg[0]=0;
		strg[1]=arr[1];
		path[0]="";
		path[1]="1";
		
		for(int i=2;i<arr.length;i++) {
			strg[i]=arr[i];
			path[i]=i+"";
			int left=1;
			int right=i-1;
			while(left<=right) {
				if(strg[left]+strg[right]>strg[i]) {
					strg[i]=strg[left]+strg[right];
					path[i]=path[left]+path[right];
				}
				left++;
				right--;
			}
		}
		System.out.println(strg[arr.length-1]);
		System.out.println(path[arr.length-1]);
	}
	
	public static void main(String[] args) {
//		SS("abccbc","");
//		PS("abccbc");	
		int[][] mine= {{2,6,0,5},
				       {0,7,5,2},
				       {3,0,3,7},
				       {8,0,2,3}};
//		GM(mine);
		
		//goldmine memorization
		int omax=0;
		for(int r=0;r<mine.length;r++) {
			int rmax=GMM(mine,r,0,new int[mine.length][mine[0].length]);
			if(rmax>omax) {
				omax=rmax;
			}
		}
//		System.out.println(omax);
		
		int[] rod={0,3,5,6,15,10,25,12,24};
		rod(rod);
		}
	}


