import java.util.*;
public class EarPhones_HW1 {
	
	public static int EPL(String str) {
		int count=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='L') {
				count++;
			}
		}
		return count;	
	}
	public static int EPR(String str) {
		int count=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='R') {
				count++;
			}
		}
		return count;	
	}
	

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		String str=scn.next();
		int a=EPL(str);
		int b=EPR(str);
		if(a==b) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
//		System.out.println(EP2(str));
	}

}
