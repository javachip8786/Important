import java.util.*;
public class BagCapacity_MaxProfit {
	public static int knapsap(int[] price,int[] weight,int index,int capacity) {
//		if(index==price.length) {
//			return 0;
//		}
		
		if(index==price.length) {
			if(capacity>=0) {
				return 0;
			}
			else {
				return Integer.MIN_VALUE;
			}
		}
		
		int r1=0+knapsap(price,weight,index+1,capacity);
		int r2=price[index]+knapsap(price,weight,index+1,capacity-weight[index]);
		if(r1>r2) {
			return r1;
		}
		else {
			return r2;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int p=scn.nextInt();
		int[] price=new int[p];
		for (int i=0;i<p;i++){
			price[i]=scn.nextInt();
		}
		
		int[] weight=new int[p];
		for (int i=0;i<p;i++){
			weight[i]=scn.nextInt();
		}
		int cap=scn.nextInt();
		int sum=knapsap(price,weight,0,cap);
		System.out.println(sum);
	}

}
