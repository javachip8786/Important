import java.util.*;
public class Leet3 {
	
 
    public static boolean isPalindrome(String str) {
        str = str.trim(); 
        String delims = "\\W+"; // split any non word 
        String[] tokens = str.split(delims); 
        String fin="";
        for (String item : tokens) { 
        	fin+=item;
        } 
        fin=fin.toUpperCase();
       // System.out.println(fin);
        	int left=0;
        	int right=fin.length()-1;
        	while(left<right) {
        		if(fin.charAt(left)!=fin.charAt(right)) {
        			return false;
        		}
        		left++;
        		right--;
        	}
        	return true;
    	}
    //pascal triangle
    public static ArrayList<ArrayList<Integer>> triF(ArrayList<Integer> n) {
    	ArrayList<ArrayList<Integer>> fin =new ArrayList<ArrayList<Integer>>();
    	int left=0;
    	int right=1;
    	while(left<n.size()) {
    		for(int i=left;i<=right;i++) {
    			System.out.println(i);
    		}
    		left=right;
    		right++;
    	}
    	return (fin);
    }
    
    public static ArrayList<Integer> tri(int n) {
    	ArrayList<Integer> fin =new ArrayList<Integer>();
    	int row=0;
    	while(row<n) {
    		int col=0;
    		int val=1;
    		while(col<=row) {
    			fin.add(val);
    			int nckp1=val*(row-col)/(col+1);
    			val=nckp1;
    			col++;
    		}
    		System.out.println();
    		row++;
    	}
    return fin;
    }
    //sum to two elements in a array equals target
public static int[] twoSum(int[] numbers, int target) {
        int[] arr=new int[2];
        int left=0;
        int right=numbers.length-1;
        while(left<right) {
        	if(numbers[left]+numbers[right]==target) {
        		arr[0]=left+1;
        		arr[1]=right+1;
        		return arr;
        	}
        	if(numbers[right]>=target || numbers[left]+numbers[right]>target) {
        		right--;
        	}
        	else {
        		left++;
        	}
        	System.out.println((left+1)+" "+(right+1));
        }
        return arr;
    }

	public static int majorityElement(int[] nums) {
		Arrays.sort(nums);
		int count=0;
		int rn=-645;
		int left=0;
		for(int i=0;i<nums.length;i++) {
			rn=nums[left];
			for(int j=i;j<nums.length;j++) {
				//System.out.print(nums[j]+" ");
				if(nums[j]==rn) {
					count++;
					left++;
				}
			if(count>nums.length/2) {
				return rn;
			}
			
			}
			count=0;
		}
		return -1;
	}
	
	//Factorial trailing zeroes
	public static int fact(int n) {
		if(n/5==0) {
			return 0;
		}
		return n/5 + fact(n/5);
	}
	
	//HashMap
	public static void Hash() {
		Map<String,String> id=new HashMap<>();
    	id.put("arham","9650747053");
    	id.put("papa","9213752557");
    	id.put("somi","9716251149");
//    	System.out.println(id.get("somi"));
    	Set<String> keys=id.keySet();
    	for(String i : keys) {
    		System.out.println(i+" : "+id.get(i));
    	}
	}
	
	//single numbers
	public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int cum=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==cum){
                cum=nums[i+1];
                i++;
            }
            else {
            	return cum;
            }
        }
        return cum;
    }
	
	//merge two sorted arrays
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] result=new int[nums1.length];
		int resultL=0;
        int leftnums1=0;
        int leftnums2=0;
        while(resultL<result.length) {
        	if(leftnums1<nums1.length && leftnums2<nums2.length) {
        		if(nums1[leftnums1]<nums2[leftnums2]) {
        			result[resultL++]=nums1[leftnums1++];
        			
        		}
        		else {
        			result[resultL++]=nums2[leftnums2++];
        			
        		}
        	}
        	else if(leftnums1<nums1.length) {
        		result[resultL++]=nums1[leftnums1++];
        	}
        	else if(leftnums2<nums2.length) {
        		result[resultL++]=nums2[leftnums2++];
    			
        	}
        }
        for(int i=0;i<result.length;i++) {
        	System.out.println(result[i]);
        }
    }
	
	//climbing stairs
	public static int climbStairs(int n) {
		if(n==0 || n==1) {
			return 1;
		}
        return climbStairs(n-1)+climbStairs(n-2);
    }
	//climbing stairs by dp
	public static int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
	
	//max string length
	public static int string(String s) {
		if(s == null)
            return 0;
        
        String[] parts = s.trim().split(" ");
        if(parts.length == 0)
            return 0;
        else
            return parts[parts.length - 1].length();
	}
	
	public static void trim(String a) {
		String[] parts=a.trim().split(" ");
//		for(int i=0;i<parts.length;i++) {
//			System.out.println(parts[i]);
//		}
		System.out.println(parts[parts.length-1]);
		
	}
	
	//plus one
	public static int[] plusOne(int[] digits) {
        long n=num(digits);
        n+=1;
        int[] result=arr(n);
        return result;
        
    }
	//converts array to int
	public static long num(int[] arr) {
		long n=0;
		long pow=1;
		for(int i=arr.length-1;i>=0;i--) {
			n+=arr[i]*pow;
			pow*=10;
		}
		return n;
	}
	
	//converts int to array
	public static int[] arr(long n) {
		int count=0;
		long temp=n;
		while(temp>0) {
			count++;
			temp/=10;
		}
		int[] result=new int[count];
		int left=result.length-1;
		while(n>0) {
			result[left]=(int) (n%10);
			n/=10;
			left--;
		}
		return result;
	}
	
	//plus one--Accepted
	public static int[] plusOne1(int[] digits) {
        int carry=1;
   
        for(int i=digits.length-1;i>=0;i--){
            digits[i]+=carry;
            if(digits[i]>9){
                digits[i]=0;
                carry=1;
            }
            else{
                carry=0;
            }
        }
	    if(carry==0){
	        return digits;
	    }
	    else{
	        int[] result=new int[digits.length+1];
	        result[0]=1;
	        for(int i=1;i<result.length;i++){
	            result[i]=0;
	        }
	        return result;
	    }
		
	}
	
	//Add Binary
	public static String addBinary(String a, String b) {
	        String str="";
	        int aL=a.length()-1;
	        int bL=b.length()-1;
	        int carry=0;
	        while(aL>=0 || bL>=0) {
	        	int aLast=a.charAt(aL)-'0';
	        	int bLast=b.charAt(bL)-'0';
	        	int sum=aLast+bLast+carry;
	        	if(sum<=1) {
	        		str+=sum;
	        		carry=0;
	        	}
	        	else if(sum==2) {
	        		str+=1;
	        		carry=0;
	        	}
	        	else if(sum==3) {
	        		str+=1;
	        		carry=1;
	        	}
	        	aL--;
	        	bL--;
	        }
	        return str;
	    }
	
	public static int mySqrt(int x) {
        int n=(int) Math.sqrt(x);
        return n;
    }
	
	public static void main(String[] args) 
    { 
//  
//        String str = "A man, a plan, a canal: Panama"; 
//        System.out.println(isPalindrome(str)); 
 //   	ArrayList<ArrayList<Integer>> brr=tri(5);
//    	ArrayList<Integer> gh=tri(5);
//    	triF(gh);
//    	int[] test= {12,13,23,28,43,44,59,60,61,68,70,86,88,92,124,125,136,168,173,173,180,199,212,221,227,230,277,282,306,314,316,321,325,328,336,337,363,365,368,370,370,371,375,384,387,394,400,404,414,422,422,427,430,435,457,493,506,527,531,538,541,546,568,583,585,587,650,652,677,691,730,737,740,751,755,764,778,783,785,789,794,803,809,815,847,858,863,863,874,887,896,916,920,926,927,930,933,957,981,997};
//    	System.out.println(test[60]);
//    	int[] fin=twoSum(test,542);
//    	System.out.println(fin[0]+" "+fin[1]);
//    	int[] test= {8,8,7,7,7};
//    	System.out.print(majorityElement(test));
//    	System.out.println(fact(5));
//    	Hash();
//    	int[] arr= {4,1,2,1,2};
//    	System.out.println(singleNumber(arr));
//    	int[] nums1= {1,2,3,0,0,0};
//    	int[] nums2= {2,5,6};
//    	int m=3;
//    	int n=3;
//    	merge(nums1,m,nums2,n);
    	
//    	for(int i=0;i<nums1.length;i++) {
//    		System.out.println(nums1[i]);
//    	}
    	//System.out.println(climbStairs2(45));
//    	System.out.println(string("      arham      "));
//    	trim("arham     ali  here");
//    	int[] arr= {9,8,7,6,5,4,3,2,1,0};
//    	System.out.println(num(arr));
    	
//    	int[] result=plusOne(arr);
//    	for(int i=0;i<result.length;i++) {
//    		System.out.print(result[i]+" ");
//    	}
//    	addBinary("11","1");
    	System.out.println(mySqrt(8));
    } 
	
}
