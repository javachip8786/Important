import java.util.*;
public class HackerRank_specialGrouping {
	
	
	public static void SG(int[] nrr,int[] trr) {
		ArrayList<Integer> fin=new ArrayList<Integer>();
		int i=0;
		while(i<nrr.length) {
			int s=nrr[i];
			for(int j=0;j<trr.length;j++) {
				if(s==trr[j]) {
					fin.add(s);
				}
			}
			i++;
		}
		
		int c=0;
		while(c<fin.size()) {
			System.out.print(fin.get(c)+" ");
			c++;
		}
		
	}
	

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int[] nrr=new int[n];
		for(int i=0;i<n;i++) {
			int h=scn.nextInt();
			nrr[i]=h;
		}
		int b=scn.nextInt();
		int[] trr=new int[b];
		for(int i=0;i<b;i++) {
			int h=scn.nextInt();
			trr[i]=h;
		}
		SG(nrr,trr);
	}

}
