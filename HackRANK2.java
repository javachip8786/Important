import java.util.*;
public class HackRANK2 {
	
	//permutations of a string
	public static void per(String str,String ans) {
		if(str.length()==0) {
			System.out.println(ans);
			return;
		}
		
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			String roq=str.substring(0,i)+str.substring(i+1);
			per(roq,ans+ch);
		}
	}
	
	//permutations of a string with arrayList
	public static ArrayList<String> s=new ArrayList<String>();
	public static void per2(String str,String ans) {
		if(str.length()==0) {
			s.add(ans);
			return;
		}
		
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			String roq=str.substring(0,i)+str.substring(i+1);
			per2(roq,ans+ch);
		}
	}
	
//	//Days in Month
//	public static int[] DIM1=new int[8];
//	public static void DIM(int n,int str) {
//		int rem=n%7;
//		for(int i=0;i<8;i++) {
//			DIM1[i]=4;
//		}
//		while(rem>0) {
//			DIM1[str]+=1;
//			rem--;
//			if(str>6) {
//				str=0;
//			}
//			else {
//			str++;
//			}
//		}
//	}
	
//Days in Month
    
    public static int[] DIM(int n,int str) {
        int[] DIM1=new int[8];
        int rem=n%7;
        for(int i=0;i<8;i++) {
            DIM1[i]=4;
        }
        while(rem>0) {
            DIM1[str]+=1;
            if(str>6) {
                str=0;
            }
            else {
            str++;
            }
            rem--;
        }
        return DIM1;
    }
    
    
	//gives a number corressponding to a string-integer coressponding to string
	public static int ICS(String str) {
		if(str.equals("mon")) {
			return 0;
		}
		else if(str.equals("tues")) {
			return 1;
		}
		else if(str.equals("wed")) {
			return 2;
		}
		else if(str.equals("thurs")) {
			return 3;
		}
		else if(str.equals("fri")) {
			return 4;
		}
		else if(str.equals("sat")) {
			return 5;
		}
		else if(str.equals("sun")) {
			return 6;
		}
		return 100;
	}
	
	//permutation without repitition
	public static ArrayList<String> s1=new ArrayList<String>();
	public static void per3(String str,String ans) {
		if(str.length()==0) {
			boolean f=per4(ans);
			if(f==false) {
				s1.add(ans);
			}
			return;
		}
		
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			String roq=str.substring(0,i)+str.substring(i+1);
			per3(roq,ans+ch);
		}
	}
	
	public static boolean per4(String s) {
		for(int i=0;i<s1.size();i++) {
			if(s1.get(i).equals(s)) {
				return true;
			}
		}
		return false;
	}
	
	//twin count without overlap
	public static int co=0;
	public static void TO(String str,int i,int j) {
		if(j==str.length()) {
			System.out.println(co);
			return;
		}
		if(str.charAt(i)==str.charAt(j)) {
			co+=1;
			if(j+3<str.length()) {
				TO(str,j+1,j+3);
			}
			else {
				TO(str,j+1,str.length());
			}
		}
		else {
			if(j+1<str.length()) {
				TO(str,i+1,j+1);
			}
			else {
				TO(str,j+1,str.length());
			}
		}
	}
	
	//tower of hanoi
	public static int ctr=0;
	public static void TOH(int n,String s,String d,String h) {
		
		if(n==0) {
			return;
		}
		TOH(n-1,s,h,d);
		ctr+=1;
		System.out.println("Move disc ["+n+"] from "+s+" to "+d);
		TOH(n-1,h,d,s);
	}
	
	public static void main(String[] args) {
		TOH(2,"A","C","B");
		System.out.println(ctr);
//		TO("AxAxAx",0,2);
//		 Scanner scn=new Scanner (System.in);
//	        String str=scn.nextLine();
//	        per3(str,"");
//	        System.out.println(s1.size());
//	        for(int i=0;i<s1.size();i++){
//	            System.out.println(s1.get(i));
//	        }
		
		
		
//		per2("aab","");
//		System.out.println(s);
//		per("aab","");
		
//		int str=ICS("wed");
////		System.out.println(str);
//		DIM(31,str);
//		for(int i=0;i<DIM1.length;i++) {
//			System.out.print(DIM1[i]);
//		}
		
//		System.out.println(ICS("wed"));
	        
//		 Scanner scn=new Scanner(System.in);
//	       String t=scn.nextLine();
//	        int test=Integer.parseInt(t);
//	        for(int i=0;i<test;i++){
//	            String n=scn.next();
//	            String p=scn.next();
////	            System.out.println(p);
//	            int n1=Integer.parseInt(n);
//	            int str=ICS(p);
////	            System.out.println(str);
//	            int[] DIM1=DIM(n1,str);
//	            for(int j=0;j<DIM1.length;j++) {
//	                System.out.print(DIM1[j]+" ");
//	            }
//	        }
		
		
		
	}

}
