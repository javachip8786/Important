import java.util.*;
public class clientHM {

	public static void main(String[] args) {
		hashMap_<String,Integer> map=new hashMap_<>();
		map.put("india",2000);
		map.put("china",4000);
		map.put("pak",3000);
//		int val=map.get("china");
//		System.out.println(val);
		Set<String> ks=map.keySet();
		for(String str:ks) {
			System.out.println(map.get(str)+" -> "+str);
		}
		map.remove("india");
//		Set<String> s=map.keySet();
//		for(String str:s) {
//			System.out.println(map.get(str)+" -> "+str);
//		}
	}

}
