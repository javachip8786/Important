import java.util.*;
public class HackerRank {
	
	public static int[] result=new int[26];
	public static void MaxFreq(String s) {
		int sum=0;
		for(int j=0;j<26;j++) {
			for(int i=0;i<s.length();i++) {
				char ch=(char)(j+97);
//				System.out.println(ch);
				if(ch==s.charAt(i)) {
					sum++;
				}
			}
			result[j]=sum;
			sum=0;
		}
		array(result);
//		Max(result);
	}
	
	//print array
	public static void array(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			char ch=(char)(97+i);
			String n="";
			if(arr[i]!=0 && arr[i]!=1) {
				n+=ch;
				n+=arr[i];
				System.out.print(n);
			}
			if(arr[i]==1) {
				n+=ch;
				System.out.print(n);
			}
		}
	}
	
	//gives the max freq
	public static void Max(int[] arr) {
		int sum=arr[0];
		char ch=(char)(97);
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>sum) {
				sum=arr[i];
				ch=(char)(97+i);
			}
		}
		System.out.println(ch);
	}
	
	//remove duplicates from string
	public static void SD(String s,String ans) {
		if(s.length()==0) {
			System.out.println(ans);
			return;
		}
		char ch=s.charAt(0);
		String roq=s.substring(1);
		boolean f=ispre(ans,ch);
		if(f==true) {
			SD(roq,ans+ch);
		}
		else {
			SD(roq,ans);
		}
	}
	//this check if a charcter is present in the string
	public static boolean ispre(String ans,char ch) {
		for(int i=0;i<ans.length();i++) {
			if(ans.charAt(i)==ch) {
				return false;
			}
		}
		return true;
	}
	
	//odd numbers in decreaing and even in increasing
	public static void OE(int n,int i) {
		if(i>n) {
			return;
		}
		OE(n,i+2);
		System.out.println(i);
	}
	public static void OE2(int n,int i) {
		if(i>n) {
			return;
		}
		System.out.println(i);
		OE2(n,i+2);
	}
	
	//print a triangle using recursion
	public static void tri(int n,int i) {
		if(i==n+1) {
			return;
		}
		tri(n,i+1);
		for(int j=1;j<=i;j++) {
			System.out.print("*"+" ");
		}
		System.out.println();
//		tri(n,i+1);
	}
	
	//pascal triangle
	public static void pascal(int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				int ncr=(fact(i)/(fact(j)*fact(i-j)));
				System.out.print(ncr);
//				ncr=0;
			}
			System.out.println();
		}
	}
	
	//factorial
	public static int fact(int n) {
		int sum=1;
		for(int i=1;i<=n;i++) {
			sum*=i;
		}
		return sum;
	}
	
	//Nth triable
	public static void Nth(int n,int i,int sum) {
		if(i==n+1) {
			System.out.println(sum);
			return;
		}
		sum+=i;
		Nth(n,i+1,sum);
	}
	
	//is array sorted using recursion
	public static boolean isSort(int[] arr,int i,int j) {
		if(i==arr.length-1) {
			return true;
		}
		if(arr[i]<arr[j]) {
			return false;
		}
		j=i;
		i=i+1;
		return isSort(arr,i,j);
//		System.out.println(arr[i]+" "+arr[j]);
//		return true;
	}
	
	//is a target element in present in the array using recursion
	public static boolean isTar(int[] arr,int i,int target) {
		if(i==arr.length) {
			return false;
		}
		if(arr[i]==target) {
			return true;
		}
		return isTar(arr,i+1,target);
	}
	
	//first index where target is found using recursion
	public static int find(int[] arr,int i,int target) {
		if(i==arr.length) {
			return -1;
		}
		if(arr[i]==target) {
			return i;
		}
		return find(arr,i+1,target);
	}
	
	//Last index where target is found using recursion
		public static int find2(int[] arr,int i,int target) {
			if(i<0) {
				return -1;
			}
			if(arr[i]==target) {
				return i;
			}
			return find2(arr,i-1,target);
		}
		
		
		//palindrome in a array using recursion
		public static boolean palin2(int[] arr,int l,int r) {
			if(l>r) {
				return true;
			}
			if(arr[l]!=arr[r]) {
				return false;
			}
			return palin2(arr,l+1,r-1);
		}
		
		//reversing a array using recursion
		public static void rev(int[] arr,int left,int right) {
			if(left>right) {
				return;
			}
			int temp=arr[right];
			arr[right]=arr[left];
			arr[left]=temp;
			rev(arr,left+1,right-1);
		}
	//print array
		public static void dis(int[] arr) {
			for(int i=0;i<arr.length;i++) {
				System.out.print(arr[i]+" ");
			}
		}
		
	//bubble sort using recursion
		public static void Bsort(int[] arr,int i,int j) {
			if(i==arr.length-1) {
				return;
			}
			if(j==arr.length) {
				Bsort(arr,i+1,i+2);
				return;
			}
			
			if(arr[i]>arr[j]) {
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
			Bsort(arr,i,j+1);
		}
		
	//sum of elements in a array using recursion
	public static void sumarr(String s,int sum) {
		if(s.length()==0) {
			System.out.println(sum);
			return;
		}
		char ch=s.charAt(0);
		int k=ch-'0';
		String row=s.substring(1);
		sumarr(row,sum+k);
	}
	
	//string to int using recur then division by l
	public static void STI(String s,int n,int pow,int l) {
		if(s.length()==0) {
			System.out.println(n/l);
			return;
		}
		char ch=s.charAt(s.length()-1);
		int c=ch-'0';
		String roq=s.substring(0,s.length()-1);
		STI(roq,n+(c*pow),pow*10,l);
	}
	
	//checks if two string are reverse of each other
	public static boolean isStr(String s1,String s2,int left,int right) {
		if(s1.length()!=s2.length()) {
			return false;
		}
		if(left==s1.length() || right<0) {
			return true;
		}
		if(s1.charAt(left) != s2.charAt(right)) {
			return false;
		}
		return isStr(s1,s2,left+1,right-1);
	}
	
	//check if a string is palindrome or not
	public static boolean palinR(String s,int left,int right) {
		if(left>right) {
			return true;
		}
		if(s.charAt(left)!=s.charAt(right)) {
			return false;
		}
		return palinR(s,left+1,right-1);
	}
	
	//string between the paranthesis
	public static void para(String s,int left,int right) {
		if(right==s.length()) {
			return;
		}
		if(s.charAt(left)=='(' && s.charAt(right)==')' && right>left) {
			System.out.println(s.substring(left,right+1));
			if(right+1<s.length()) {
				para(s,right+1,right+2);
				return;
			}
			return;
		}
		if(s.charAt(left)!='(' && right>left) {
			para(s,left+1,right+1);
//			return;
		}
		else if(s.charAt(right)!=')' && right>left) {
			para(s,left,right+1);
//			return;
		}
	}
	
	//ALLindexOfNumber
	public static ArrayList<Integer> LN=new ArrayList<Integer>();
	public static void LN(int[] arr,int target,int i) {
		if(i==arr.length) {
			return;
		}
		if(arr[i]==target) {
			LN.add(i);
		}
		LN(arr,target,i+1);
	}
	
	//Saperate Duplicates- basically if there is two similar consecutive characters, replace the later one with *
	public static void SD2(String s,String fin) {
		if(s.length()<0) {
			System.out.println(fin);
			return;
		}
		char ch=s.charAt(0);
		String roq=s.substring(1);
//		System.out.println(ch+"   "+roq);
		if(fin.length()!=0 && fin.charAt(fin.length()-1)==ch) {
			SD(roq,fin+"*");
//			return;
		}
		else {
			SD(roq,fin+ch);
//			return;
		}
	}
	//ppepcoding=p//pepcoding//p
	//pepcoding//p//epcoding//p*
	//ecoding//e
	public static String code_02(String str)
	{
		if(str.length()==1)
		{
			String base=new String(str);
			return base;
		}
		char ch=str.charAt(0);
		String nstr=str.substring(1);
		String smallans=code_02(nstr);
		String ans=new String();
		if(ch==smallans.charAt(0))
		{
		 ans=ch+"*"+smallans.substring(0);
		}
		else
		{
			ans=ch+smallans;
		}
		return ans;
	}
	
	//remove duplicates using recursion
	public static String RD(String s) {
		if(s.length()==1) {
			String base=new String(s);
			return base;
		}
		char ch=s.charAt(0);
		String roq=s.substring(1);
		String fin=RD(roq);
		String ans=new String();
		if(fin.charAt(0)==ch) {
			ans+=ch+fin.substring(1);
		}
		else {
			ans+=ch+fin.substring(0);
		}
		return ans;
	}
	
	
	
	
	
	//remove all c characters and add them in the last
		public static String RD3(String str,char c ) {
			if(str.length()==1) {
					String base=new String(str);
					return base;
				
			}
			char ch=str.charAt(0);
			String roq=str.substring(1);
			String fin=RD3(roq,c);
			String ans=new String();
			/*if(c==fin.charAt(0)) {
				ans+=ch+fin.substring(1);
			}
			else {
				ans+=ch+fin.substring(0);
			}*/
			if(ch==c)
			{
				ans=fin+ch;
			}
			else
				ans=ch+fin;
			return ans;
		}
		
		
		
		
		
		
		//remove all c characters and add them in the last by itteration
		public static String RDI(String s,int target) {
			String neW="";
			int count=0;
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)==target) {
					count++;
				}
				else {
					neW+=s.charAt(i);
//					count++;
				}
			}
			for(int i=0;i<count;i++) {
				neW+=(char)target;
			}
			System.out.println(count);
			return neW;
		}
	
		
		
		
	//count and remove "hi" in the string
    public static int count=0;
	public static String CAR(String str) {
		if(str.length()==1) {
//			System.out.println(count);
			String s=new String(str);
			return s;
		}
		char a=str.charAt(0);
		String roq=str.substring(1);
		String oo=CAR(roq);
		String ans=new String();
		if(a=='h' && oo.charAt(0)=='i') {
			count+=1;
			ans=oo.substring(1);
		}
		else {
//			count+=1;
			ans=a+oo.substring(0);
		}
		return ans;
	}
	
	//replace all "hi" with pep
	public static String RA(String str) {
		if(str.length()==1) {
			String s=new String(str);
			return s;
		}
		char a=str.charAt(0);
		String roq=str.substring(1);
		String oo=RA(roq);
		String ans=new String();
		if(a=='h' && oo.charAt(0)=='i') {
			ans="pep"+oo.substring(1);
		}
		else {
			ans=a+oo.substring(0);
		}
		return ans;
	}
	
	//remove all hi but not hit
	public static String HIT(String str) {
		if(str.length()<=1) {
			String s=new String(str);
			return s;
		}
		String ans=new String();
		String roq=new String();
		char a=str.charAt(0);
		char b=str.charAt(1);
		if(a=='h' && b=='i') {
			if(str.length()>=3 && str.charAt(2)=='t') {
				roq=str.substring(0, 3);
				ans=roq+HIT(str.substring(3));
			}
			else {
				ans=HIT(str.substring(2));	
			}
		}
		else {
			ans=a+HIT(str.substring(1));
		}
		return ans;
	}
	
	
	
	//replace hi with pep, ignore hit
	public static String HIT2(String str) {
		if(str.length()<=1) {
			String s=new String(str);
			return s;
		}
		String ans=new String();
		String roq=new String();
		char a=str.charAt(0);
		char b=str.charAt(1);
		if(a=='h' && b=='i') {
			if(str.length()>=3 && str.charAt(2)=='t') {
				roq=str.substring(0, 3);
				ans=roq+HIT2(str.substring(3));
			}
			else {
				ans="pep"+HIT2(str.substring(2));	
			}
		}
		else {
			ans=a+HIT2(str.substring(1));
		}
		return ans;
	}
	
	
	
	//twin over lap- twin is two similar char separated by another char
	public static int count1=0;
	public static void TO(String str,int i,int j) {
		if(j==str.length()) {
			return;
		}
		if(str.charAt(i)==str.charAt(j)) {
			count1+=1;
		}
		TO(str,i+1,j+1);
	}
	
	//Balance brackets
	public static boolean BB(String str,int left) {
		if(left>right) {
			return true;
		}
		if(str.charAt(left)=='[') {
			if(issame(str.charAt(left),str.charAt(str.length()-1))==true)
			{
				String roq=str.substring(0,str.length()-2);
				BB(str,left+1);
			}
			BB(str,left+1,right-1);
		}
		if(str.charAt(left)=='(' ) {
			BB(str,left+1,right-1);
		}
		if(str.charAt(left)=='{') {
			BB(str,left+1,right-1);
		}
	}
	public static boolean issame(char ch1,char ch2) {
		if(ch1==ch2) {
			return true;
		}
		return false;
	}
	
	//Balance brackets with itteration
//	public static boolean BBI(String str,int left,int right) {
//		if(left>right) {
//			return true;
//		}
//		if(str.charAt(left)=='[') {
//			if()
//		}
//		
//	}
	
	
	//subsequence
	public static ArrayList<String> SS1=new  ArrayList<String>();
	public static void SS(String str,String ans) {
		if(str.length()==0) {
			SS1.add(ans);
			return;
		}
		char ch=str.charAt(str.length()-1);
		String roq=str.substring(0,str.length()-1);
		SS(roq,ans);
		SS(roq,ch+ans);
	}
	
	//reverse a string
	public static String REV(String str) {
		String temp="";
		for(int i=str.length()-1;i>=0;i--) {
			temp+=str.charAt(i);
		}
		return temp;
	}
	//this directly prints answer
	public static void SS7(String str,String ans) {
		if(str.length()==0) {
			System.out.println(ans);
			return;
		}
		char ch=str.charAt(0);
		String roq=str.substring(1);
		SS7(roq,ans);
		SS7(roq,ans+ch);
	}
	
	public static void COM(String str) {
		String rev=REV(str);
		SS(str,"");
		System.out.println(SS1.size());
		System.out.println(SS1);
		SS7(str,"");
	}
	
	//maximum sum of subarray- Concatnations
	//basically make multiply array with k then ko kadane algo
	public static void C1(int[] arr,int k) {
		int size=arr.length * k;
		int[] fin=new int[size];
		int finl=0;
		int i=0;
		while(finl<size) {
			fin[finl]=arr[i];
			finl++;
			i++;
			if(i==arr.length) {
				i=0;
			}
		}
		K(fin);
	}
	//kedane algo
	public static void K(int[] arr) {
		int osum=0;
		int csum=0;
		for(int i=0;i<arr.length;i++) {
			if(csum>0) {
				csum+=arr[i];
			}
			else {
				csum=arr[i];
			}
			if(csum>osum) {
				osum=csum;
			}
		}
		System.out.println(osum);
		
	}
	
	//sorting and getting biggest, not using kedane
	public static void K2(int[] arr) {
		Arrays.sort(arr);
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>0) {
				sum+=arr[i];
			}
		}
		System.out.println(sum);
	}
	
	
	//balance brackets using recursion
	public static int B=0;
	public static boolean Bal(String str) {
		if(str.length()==0) {
			if(B%2==0) {
				return true;
			}
			else {
				return false;
			}
		}
		char chi=str.charAt(0);
		String roq=str.substring(1);
		if(chi=='(' || chi==')' || chi=='[' || chi=='{' || chi=='}' || chi==']' ) {
			B+=1;
		}
		return Bal(roq);
	}
	
	//substring
	public static void subS(String str) {
		for(int i=0;i<str.length();i++) {
			String ans="";
			for(int j=i;j<str.length();j++) {
				String ans1="";
				for(int k=i;k<=j;k++) {
					ans1+=str.charAt(k);	
				}
				System.out.println(ans1);
			}
		}
	}
	//substring- summit sir
	public static void subS2(String str) {
		for(int i=0;i<str.length();i++) {
			for(int j=i+1;j<=str.length();j++) {
				System.out.println(str.substring(i,j));
			}
//			System.out.println();
		}
	}
	
	//exist on sameline
	public static boolean line(int[][] arr) {
		int c1=0;
		int c2=0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i-1][0]==arr[i][0]) {
//				System.out.println(arr[i-1][0]+"  "+arr[i][0]);
				c1++;
			}
		}
		for(int i=1;i<arr.length;i++) {
			if(arr[i-1][1]==arr[i][1]) {
				c2++;
			}
		}
		if(c1==arr.length-1 || c2==arr.length-1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public static void main(String[] args) {
//		int[][] arr= {{0,1},{0,2},{1,3},{0,4},{0,5}};
//		boolean f=line(arr);
//		System.out.println(f);
		
		
//		subS2("abc");
//		Scanner scn=new Scanner(System.in);
//		int n=scn.nextInt();
//		int[] prr=new int[n];
//		for(int i=0;i<n;i++) {
//			prr[i]=scn.nextInt();
//		}
//		MaxFreq("aabbbcccccccds");
//		SD("arhaaaammm","");
//		OE(6,1);
//		OE2(6,2);
//		boolean f=Bal("[a+{b+(c+d)+e}+f");
//		System.out.println(f);
//		tri(5,1);
//		pascal(4);
//		System.out.println(fact(0));
//		Nth(5,1,0);
//		int[] arr= {2,89,10,12};
//		boolean f=isSort(arr,1,0);
//		System.out.println(f);
		
//		int arr[]= {2,9,6,8};
//		int t=8;
//		System.out.println(isTar(arr,0,t));
		
//		System.out.println(find(arr,0,t));
//		System.out.println(find2(arr,arr.length-1,t));
//		Bsort(arr,0,1);
//		dis(arr);
		
//		sumarr("23456789",0);
//		STI("23456789",0,1,10);
//		subS("abc","");
		
//		Scanner scn=new Scanner(System.in);
//        String s=scn.nextLine();
//        int l=scn.nextInt();
//        STI(s,0,1,l);
        
//        boolean f=isStr("abcd","acba",0,3);
//        System.out.println(f);
		
		
//		para("xyz(pepcoding)d(abc)ef",0,1);
//		int[] L= {2,8,6,4,8,6,4,9,0};
//		int target=8;
//		LN(L,target,0);
//		System.out.println(LN.get(1));
		
//		SD2("PEPPEPCODING","");
//		System.out.println(g);
		
//		RD("peppep","");
//		System.out.println(RR);
//		System.out.println(code_02("peppepcoding"));
//		System.out.println(RD("arhaaammd"));
//		String fin=RD("arhammmm");
//		System.out.println(fin);
//		String fin=RD3("arhamaaamm",'a');
//		System.out.println(fin);
		
//		System.out.println(RDI("axxxbeedeedxxx",'x'));
//		System.out.println(CAR("hihihihijjhi"));
//		System.out.println(count);
//		System.out.println(RA("hihihihijjhi"));
//		System.out.println(HIT("hihihithi"));
//		System.out.println(HIT2("hihihithi"));
		
		
//		TO("AxAxA",0,2);
//		System.out.println(count1);
		
		
//		String str="abc";
//		COM(str);
		
//		System.out.println(SS1.size());
		
//		int[] arr= {1,2};
//		int k=3;
//		C1(arr,k);
	}
	

}
