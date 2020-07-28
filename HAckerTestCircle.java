import java.util.*;
public class HAckerTestCircle {
	
	public static int circle(int[] c1,int[] c2,double r1,double r2) {
		//touching at one point
		
		
		int d=(((c2[1]-c1[1])*(c2[1]-c1[1])) + ((c2[0]-c1[0])*(c2[0]-c1[0])));
		d=(int) Math.sqrt(d);
		double rad=(r1+r2);
//		System.out.println(d+"  "+rad);
		//concentric
		if(c1[0]==c2[0] && c1[1]==c2[1]) {
				return 1;
		}
		//overlaps
		if(r2>r1 && d<r2) {
			return 0;
		}
		else if(r1>r2 && d<r1) {
			return 0;
		}
		
		//touch at 1 point
		else if(d==rad) {
			return 2;
		}
		//far apart
		else if(d>rad) {
			return 3;
			
		}
		//touch at 2 point
		else if(d<rad) {
			return 4;
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner scn=new Scanner (System.in);
		int[] c1=new int[2];
		c1[0]=scn.nextInt();
		c1[1]=scn.nextInt();
		int[] c2=new int[2];
		c2[0]=scn.nextInt();
		c2[1]=scn.nextInt();
		double r1=scn.nextDouble();
		double r2=scn.nextDouble();
		int g=circle(c1,c2,r1,r2);
		
		if(g==0) {
			System.out.println("overlaps");
		}
		else if(g==1) {
			System.out.println("concentric");
		}
		else if(g==2) {
			System.out.println("touches at 1 point");
		}
		else if(g==3) {
			System.out.println("far-apart");
		}
		else {
			System.out.println("touches at 2 point");
		}
	}

}
//0 0
//0 0
//2
//5