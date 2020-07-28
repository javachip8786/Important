import  java.util.*;
public class HAcker_2 {
	
	 public static int stairs(int n){
	        if(n<0){
	            return 0;
	        }
	        if(n==0){
	            return 1;
	        }
	        int sum=0;
	        for(int i=1;i<=3;i++){
	            sum+=stairs(n-i);
	        }
	        return sum;
	    }

	public static void main(String[] args) {
		
		Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int f=stairs(n);
        System.out.println(f);
	}

}
