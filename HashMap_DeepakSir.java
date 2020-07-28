import java.util.*;
public class HashMap_DeepakSir {
	//pass a string, this function will return char with max frequency
	public static char mostFreq(String str) {
		HashMap<Character,Integer> hm=new HashMap<>();
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(hm.containsKey(ch)) {
				int n=hm.get(ch);
				hm.put(ch, n+1);
			}
			else {
				hm.put(ch,1);
			}
		}
		char ans=str.charAt(0);
		int freq=1;
		for(char ch:hm.keySet()) {
			int cf= hm.get(ch);
			if(cf>freq) {
				ans=ch;
				freq=cf;
			}
		}
		return ans;
	}
	
	//finding common elements of two array
	public static void CE(int[] first,int[] second) {
		HashMap<Integer,Integer> hm=new HashMap<>();
		for(int i=0;i<first.length;i++) {
			if(hm.containsKey(first[i])) {
				int h=hm.get(first[i]);
				hm.put(first[i], h+1);
			}
			else {
				hm.put(first[i],1);
			}
		}
		
		for(int j=0;j<second.length;j++) {
			if(hm.containsKey(second[j])) {
				System.out.println(second[j]);
			}
		}
	}
	
	
	//finding common elements of two array
		public static void CE2(int[] first,int[] second) {
			HashMap<Integer,Integer> hm=new HashMap<>();
			for(int i=0;i<first.length;i++) {
				if(hm.containsKey(first[i])) {
					int h=hm.get(first[i]);
					hm.put(first[i], h+1);
				}
				else {
					hm.put(first[i],1);
				}
			}
			
			for(int j=0;j<second.length;j++) {
				if(hm.containsKey(second[j])) {
					int d=hm.get(second[j]);
//					System.out.println(d);
//					hm.remove(second[j]);
					hm.put(second[j],d-1);
					if(d>0) {
					System.out.println(second[j]);
					}
				}
			}
		}
	
	

	public static void main(String[] args) {
		String str="abacaddddceccbbaccdabcbA,123333cB";
		
		char c=mostFreq(str);
//		System.out.println(c);
		
		int[] first= {1,5,3,1,5,8,7,2,7,2,9,92};
		int[] second= {20,1,2,25,7,7,2,2,7,7,80,25};
		CE2(first,second);
		}

}
