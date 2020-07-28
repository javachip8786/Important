import java.util.*;
public class Leet {
	
	 public static int reverse(int x) {
	        int s;
	        long inter;
	        if(x>0){
	            int temp=x;
	            int len=0;
	            while(x>0){
	                len++;
	                x/=10;
	            }
	           // System.out.println(len);
	            long[] arr=new long[len];
	            int left=0;
	            while(temp>0){
	                arr[left]=temp%10;
	                temp=temp/10;
	                left++;
	            }
	            //dis(arr);
	            long fin=0;
	            int pow=1;
	            for(int i=arr.length-1;i>=0;i--){
	                fin+=arr[i]*(pow);
	               // System.out.println(arr[i]+"  " +"fin is "+fin);
	                pow*=10;
	            }
	          //  System.out.println("s is "+fin);
	            inter=fin;
	           // System.out.println("intern is "+inter);
	            if(inter>2147483647 || inter <-2147483648) {
		        	s=0;
		        }
	            else {
	            	s=(int)fin;
	            }
	            
	        }
	        else{
	            int temp=(-1)*x;
	            x=(-1)*x;
	            int len=0;
	            while(x>0){
	                len++;
	                x/=10;
	            }
	            long[] arr=new long[len];
	            int left=0;
	            while(temp>0){
	                arr[left]=temp%10;
	                temp=temp/10;
	                left++;
	            }
	            //dis(arr);
	            long fin=0;
	            int pow=1;
	            for(int i=arr.length-1;i>=0;i--){
	                fin+=arr[i]*(pow);
	                pow*=10;
	            }
	            inter=0-fin;
	            if(inter>2147483647 || inter <-2147483648) {
		        	s=0;
		        }
	            else {
	            	s=0-(int)fin;
	            }
	        } 
	        
	        return s;
	 }
	        
	        
	        
	        //palindrome
	        public static boolean isPalindrome(int x) {
	            int temp=x;
	            int len=0;
	            while(x>0){
	                x/=10;
	                len++;
	            }
	            System.out.println("len is "+len);
	            int[] arr=new int[len];
	            for(int i=0;i<arr.length;i++){
	                arr[i]=temp%10;
	                temp/=10;
	            }
	            dis(arr);
	            int left=0;
	            int right=arr.length-1;
	            while(left<=right){
	                if(arr[left]==arr[right]){
	                    left++;
	                    right--;
	                }
	                else{
	                    return false;
	                }
	                
	            }
	            return true;
	        }
	        
	        
	     
	 
	 
	 public static void dis(int[] arr) {
		 for(int i=0;i<arr.length;i++) {
			 System.out.print(arr[i]+" ");
		 }
		 System.out.println();
	 }

	public static void main(String[] args) {
		//System.out.println(reverse(1534236469));
		//System.out.println(isPalindrome(1000021));

	}

}
