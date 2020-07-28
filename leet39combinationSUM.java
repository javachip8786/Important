import java.util.*;
public class leet39combinationSUM {
	
	//leet 39 combination sum
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        combi(candidates,target,0,new ArrayList<Integer>());
		
		return s;
    }
    
	public static List<List<Integer>> s=new ArrayList<>();
	
	
	
	public static void combi(int[] candidates, int target,int idx,ArrayList<Integer> path) {
		if(target==0) {
			s.add(new ArrayList(path));
			return;
		}
		
		
		for(int i=idx;i<candidates.length;i++) {
			if(candidates[i]<=target) {
				path.add(candidates[i]);
				combi(candidates,target-candidates[i],i,path);
				path.remove(path.size()-1);
			}
	}
	}
	
	//place queens
	public static int PQ(int[] boxes,int q,int qpsf,String ans,int idx) {
		if(qpsf==q || idx==boxes.length) {
			if(qpsf==q) {
				System.out.println(ans);
				return 1;
			}
			return 0;
		}
		
		int count=0;
		for(int i=0;i<boxes.length;i++) {
			if(boxes[i]>=0) {
				boxes[i]=-boxes[i];
				count+=PQ(boxes,q,qpsf+1,ans+"b"+i,i);
				boxes[i]=-boxes[i];
			}
		}
		
		return count;
		
	}
	
	//leet 46 permutation -- incomplete
	public static List<List<Integer>> dd=new ArrayList<>();
	public static List<List<Integer>> permute(int[] nums) {
        perHelper(nums,new ArrayList<Integer>(),0);
        return dd;
    }
	
	public static void perHelper(int[] nums,ArrayList<Integer> path,int idx) {
		if(idx==nums.length) {
//			if(dd.contains(path)) {
				
//			}
//			else {
				dd.add(new ArrayList(path));
//			}
			return;
		}
		for(int i=idx;i<nums.length;i++) {
				path.add(nums[i]);
				perHelper(nums,path,i+1);
				path.remove(path.size()-1);
			
		}
	}
	
	
	////////
	public static ArrayList<String> AS=new ArrayList<>();
	public static boolean istrue(String big,String small) {
		perStr(small,"",0);
		for(int i=0;i<AS.size();i++) {
			if(big.contains(AS.get(i))) {
				return true;
			}
		}
		return false;
	}
	public static void perStr(String str,String ans,int idx) {
		if(str.length()==0) {
			AS.add(ans);
			return;
		}
		for(int i=idx;i<str.length();i++) {
			char ch=str.charAt(i);
			String roq=str.substring(0,i)+str.substring(i+1);
			perStr(roq,ans+ch,0);
		}
	}
	
	// leet 40- combination sum II
	public static List<List<Integer>> comsum=new ArrayList<>();
	
	 public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		 	Arrays.sort(candidates);
	        CS(candidates,0,target,new ArrayList<Integer>());
	        return comsum;
		 
	    }
	 
	 public static void CS(int[] arr,int idx,int target,ArrayList<Integer> path) {
		 if(target==0) {
			 if(comsum.contains(path)) {
				 
			 }
			 else {
				 comsum.add(new ArrayList(path));
			 }
			 return;
		 }
		 
		 for(int i=idx;i<arr.length;i++) {
			 if(target-arr[i]>=0) {
				 path.add(arr[i]);
				 CS(arr,i+1,target-arr[i],path);
				 path.remove(path.size()-1);
			 }
		 }
	 }
	 
	 // 77 combination leetcode
	 public static List<List<Integer>> fp=new ArrayList<>();
	 public static List<List<Integer>> combine(int n, int k) {
	        C(n,1,new ArrayList<Integer>(),k,0);
	        return fp;
	    }
	 
	 public static void C(int arr,int idx,ArrayList<Integer> path,int total,int count) {
		 if(count==total) {
			 if(fp.contains(path)) {
				 
			 }
			 else {
				 fp.add(new ArrayList(path));
			 }
			 return;
		 }
		 for(int i=idx;i<=arr;i++) {
				 path.add(i);
				 C(arr,i+1,path,total,count+1);
				 path.remove(path.size()-1);
		 }
	 }
	 
	 //216 Leetcode
	 public static List<List<Integer>> three=new ArrayList<>();
	 public static List<List<Integer>> combinationSum3(int k, int n) {
	        the(n,k,1,new ArrayList<Integer>(),0);
	        return three;
	    }
	 
	 public static void the(int n,int k,int idx,ArrayList<Integer> path,int count) {
		 if(count==k && n==0) {
			 three.add(new ArrayList(path));
			 return;
		 }
		 for(int i=idx;i<=9;i++) {
			 if(n-i>=0) {
				 path.add(i);
				 the(n-i,k,i+1,path,count+1);
				 path.remove(path.size()-1);
		 }
		 }
	 }
	 
	 
	 // 191- checkng for all 32 bits
	 public static int hammingWeight(int n) {
	     int count=0;
	     for(int i=1;i<=32;i++) {
	    	 if(n!=0) {
	    		 if((n&1)!=0) {
	    			 count+=1;
	    		 }
	    	 }
	    	 n>>=1;
	     }
	     return count;
	    }
	 
	 // 231- power of 2
	 public static boolean isPowerOfTwo(int n) {
	        if(n==0){
	            return false;
	        }
	        if(n==1){
	            return true;
	        }
	        while(n!=2){
	            int remainder=n%2;
	            if(remainder!=0){
	                return false;
	            }
	            n/=2;
	        }
	        return true;
	    }
	 
	 //190 reverse bits
	 public static int reverseBits(String n) {
		
	        String str=n;
//	        System.out.println(str);
	        String now="";
	        for(int i=0;i<str.length();i++) {
	        	char ch=str.charAt(i);
	        	if(ch=='1') {
	        		now+='0';
	        	}
	        	else {
	        		now+='1';
	        	}
	        }
	        int j=Integer.parseInt(now);
	        return j;
	    }
	 
	 //bits- 190
	 public static void bits(int x) {
//		 for(int i=0;i<32;i++) {
//			 if(x!=0) {
//				 System.out.println(x);
//				 x>>=1;
//			 }
//		 }
		 System.out.println(Integer.reverse(x));
	 }
	 
	 //338 counting bits
	 public static int[] countBits(int num) {
	        int[] arr=new int[num+1];
	        for(int i=0;i<arr.length;i++) {
	        	int count=0;
	        	int f=i;
	        	for(int j=0;j<32;j++) {
	        		int re=(f&1);
	        		if(re==1) {
	        			count+=1;
	        		}
	        		f>>=1;
	        	}
		        	arr[i]=count;
		        }
	        return arr;
	    }
	 // 342- power of 4
	 public static boolean isPowerOfFour(int num) {
	        if(num==1){
	            return true;
	        }
	        if(num<4){
	            return false;
	        }
	        while(num!=4){
	            int rem=num%4;
	            if(rem!=0){
	                return false;
	            }
	            num/=4;
	        }
	        return true;
	    }
	 
	 //342 by bits
	 public static boolean isPow(int num) {
		return (num>0) & ((num&(num-1))==0) & ((num-1)%3==0);
		//it should be positive, should be power of 2, should be even power of 2
	 }
	 
	 //78- subsets
	 
	 public static List<List<Integer>> paths=new ArrayList<>();
	 public static List<List<Integer>> subsets(int[] nums) {
	       subs(nums,new ArrayList<Integer>(),0);
	       return paths;
	 }
	 
	 public static void subs(int[] nums,ArrayList<Integer> path,int idx) {
		 if(idx==nums.length) {
			 if(paths.contains(path)) {
				 
			 }
			 else {
				 paths.add(new ArrayList(path));	 
			 }
			 return;
		 }
		 for(int i=idx;i<nums.length;i++) {
			 path.add(nums[i]);
			 subs(nums,path,i+1);
			 path.remove(path.size()-1);
			 subs(nums,path,i+1);
		 }
	 }
	 
	 //137 single number 2
	 public static int singleNumber(int[] nums) {
		 int count=0;
	     for(int i=0;i<nums.length;i++) {
	    	 int c=0;
	    	 int t=nums[i];
	    	 for(int j=0;j<nums.length;j++) {
	    		 if(t==nums[j]) {
	    			 c+=1;
	    		 }
	    	 }
//	    	 System.out.println(c);
	    	 if(c==1) {
	    		 return t;
	    	 }
	     }
	     return -1;
	 }
	 
	 
	 //137 single number 2
	 public static int SN4(int[] arr) {
		 int sn=0;
		 int[] brr=new int[32];
		 for(int i=0;i<32;i++) {
			 int mask = 1<<i;
			 for(int j=0;j<arr.length;j++) {
				 if((mask & arr[j])!=0) {
					 brr[i]+=1;
				 }
			 }
			 if(brr[i]%3!=0) {
				 sn |=mask;
			 }
		 }
		 return sn;
	 }
	 
	 //260
	 public static int[] singleNs(int[] nums) {
	    int[] arr=new int[2];
	    int idx=0;
	    for(int i=0;i<nums.length;i++) {
	    	int c=0;
	    	int t=nums[i];
	    	for(int j=0;j<nums.length;j++) {
	    		if(nums[j]==t) {
	    			c+=1;
	    		}
	    	}
	    	if(c==1) {
	    		arr[idx]=t;
	    		idx+=1;
	    	}
	    }
	    return arr;
	 }
	 
	//51 N-Queens
	public static List<List<String>> queen=new LinkedList<>();
	 public static boolean[] row;
	 public static boolean[] col;
	 public static boolean[] diagA;
	 public static boolean[] adiagA;
	 
	 public static List<List<String>> solveNQueens(int n) {
		 	row=new boolean[n];
		 	col=new boolean[n];
		 	diagA=new boolean[(2*n)-1];
		 	adiagA=new boolean[(2*n)-1];
		 	solverNQueens(n,0,n,"");
		 	return queen;
		 
	    }
	 
	 public static void solverNQueens(int n,int r,int tnq,char ans) {
		 if(tnq==0) {
			 if()
			 queen.add(new String(ans));
			 return;
		 }
		 for(int c=0;c<n;c++) {
			 if(row[r]==false && col[c]==false && diagA[r+c]==false && adiagA[r-c+n-1]==false) {
				 row[r]=true;
				 col[c]=true;
				 diagA[r+c]=true;
				 adiagA[r-c+n-1]=true;
				 solverNQueens(n,r+1,tnq-1,path+".");
				 row[r]=false;
				 col[c]=false;
				 diagA[r+c]=false;
				 adiagA[r-c+n-1]=false;
			 }
		 }
	 }
	 
	 //190 reverse bits
	 public static int reverseBits(int n) {
		 	boolean isNegative=n<0;
	        int reversebit=0;
	        for(int i=0;i<32;i++) {
	        	int lastBit= n&1;
	        	reversebit= reversebit | lastBit;
	        	reversebit = reversebit <<1;
	        	n=n>>1;
	        }
		       if(isNegative==true) {
		    	   return reversebit+1;
		       }
		       else {
		    	   return reversebit;
		       }
	    }
	 
	 public static int reverseBits2(int n) {
	        int ans = 0;
	        for(int i = 0 ; i<32 ; i++){
	            if((n&(1<<i)) != 0)
	                ans = ans|(1<<(31-i));
	        }
	        return ans;
	    }
	 
	 
	
	public static void main(String[] args) {
		
		int f=reverseBits2(43261596);
		System.out.println(f);
		
//		int[] hrr= {0,1,0,1,0,1,99};
//		int k=singleNumber(hrr);
//		System.out.println(k);
		
//		int[] arr={1,2,1,3,2,5};
//		int[] now=singleNs(arr);
//		for(int i=0;i<now.length;i++) {
//			System.out.print(now[i]+" ");
//		}
//		solveNQueens(4);
//		for(int i=0;i<queen.size();i++) {
//			System.out.println(queen.get(i));
//		}
		
		
		
		
//		int[] arr=countBits(2);
//		for(int i=0;i<arr.length;i++) {
//			System.out.println(arr[i]);
//		}
//		
	
//		boolean g=isPow(64);
//		System.out.println(g);
		
//		pow("123","");
		
//		int h=hammingWeight(7);
//		int th=hammingWeight(00000000000000000000000000001011);
//		int th=reverseBits("00000010100101000001111010011100");
//		System.out.println(th);
		
//		bits(43261596);
//		System.out.println(h);
//		int[] arr= {2,3,6,7};
//		int target=9;
//		List<List<Integer>> path=combinationSum(arr,target);
//		for(int i=0;i<path.size();i++){
//			System.out.println(path.get(i));
//		}
//		int[] arr= {1,1,1,1,1};
//		int h=PQ(arr,3,0,"",0);
//		System.out.println(h);
		
//		int[] nums= {0,-1,1};
//		List<List<Integer>> path2=permute(nums);
//		for(int i=0;i<path2.size();i++) {
//			System.out.println(path2.get(i));
//		}
//		printCombination(nums,3,3);
		
		
//		boolean f=istrue("eidbaooo","ba");
//		System.out.print(f);
//		perStr("ans","",0);
		
//		int[] arr= {10,1,2,7,6,1,5};
////		int[] arr= {1,1,2,5,6,7,10};
//		int target=8;
//		combinationSum2(arr,target);
//		for(int i=0;i<comsum.size();i++) {
//			System.out.println(comsum.get(i));
//		}
//		print("01","");
		
//		combine(1,1);
//		for(int i=0;i<fp.size();i++) {
//			System.out.println(fp.get(i));
//		}
		
//		combinationSum3(3,9);
//		for(int i=0;i<three.size();i++) {
//			System.out.println(three.get(i));
//		}
		
		
	}

}
