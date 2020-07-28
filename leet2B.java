import java.util.*;
public class leet2B {
    
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
//    	int[] arr=new int[2];
    	ArrayList<ArrayList<int[]>> graph=new ArrayList<>();
    	for(int i=0;i<n;i++) {
    		graph.add(new ArrayList<>());
    	}
    	for(int i=0;i<graph.size();i++) {
    		int[] arr=flights[i];
    		graph.get(arr[0]).add(new int[] {arr[0],arr[1],arr[2]});
    		}
    	PriorityQueue<int[]> que = new PriorityQueue<>((a,b)-> {  //Min Priority Queue on the basis of weight
			return a[0] - b[0];
		});  
    	que.add(new int[]{0,src,K+1});
    	while(que.size()!=0) {
    		int[] arr=que.peek();
    		System.out.println(arr[0]+" "+arr[1]+" "+arr[2]);
    		que.remove();
    		int u=arr[1];
    		int wsf = arr[0];
    		int stop = arr[2];
    		if(u==dst) {
    			return wsf;
    		}
    		if(stop == 0) {
    			continue;
    		}
    		for(int[] e: graph.get(u)) {
    			int nbr=e[1];
    			int wt=e[2];
    			que.add(new int[] {wsf+wt,nbr,stop-1});
    		}
    	}
    	return -1;
    	}
    
    
    
    public static void first(int n,String day) {
    	String[] days= {"mon","tues","wed","thurs","fri","sat","sun"};
    	
    	int[] arr=new int[7];
    	for(int i=0;i<7;i++) {
    		arr[i]=4;
    	}
    	int rem=n%7;
//    	System.out.println(rem);
    	if(rem!=0) {
	    	int g=0;
	    	for(int i=0;i<7;i++) {
	    		if(days[i].equals(day)) {
	    			g=i;
	    			break;
	    		}
	    	}
	    	for(int k=g;k<g+rem;k++) {
	    		int c=k%7;
	    		arr[c]+=1;
	    	}
    	}
    	for(int j=0;j<7;j++) {
    		System.out.print(arr[j]+" ");
    	}
    }
    
    
    public static void min2(int[][] arr){
        int[] min=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int mini=Integer.MAX_VALUE;
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]<mini){
                    mini=arr[i][j];
                }
            }
            min[i]=mini;
        }
        int[] max=new int[arr[0].length];
        for(int i=0;i<arr[0].length;i++){
            int maxi=Integer.MIN_VALUE;
            for(int j=0;j<arr.length;j++){
                if(arr[j][i]>maxi){
                    maxi=arr[j][i];
                }
            }
            max[i]=maxi;
        }
        
        for(int i=0;i<min.length;i++) {
            for(int j=0;j<max.length;j++) {
                if(min[i]==max[j]  && arr[i][j]==min[i]) {
                    System.out.println(min[i]);
                    return;
                }
            }
        }
        System.out.println("No Such Point Exist");
    }
   
    
	public static void main(String[] args) {
//		int n=3;
//		first(31,"wed");
//		Scanner scn=new Scanner(System.in);
//        int test=scn.nextInt();
//        for(int i=0;i<test;i++){
//            int days=scn.nextInt();
//            String d=scn.next();
//            first(days,d);
//		int[][] edges = {{0,1,100},{1,2,100},{0,2,500}};
//		int src=0;
//		int nbr=2;
//		int k=1;
//		
//		int h=findCheapestPrice(n,edges,src,nbr,k);
//		System.out.println(h);
//		int[][] arr= {{1,2,3,4,5},{7,6,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
		int[][] arr= {{1,2,3,4,5,0,7,8,9},
					  {10,11,12,13,14,3,16,17,19},
					  {20,21,22,23,24,19,26,27,29}};
		
		min2(arr);
		
		
	}

	
}
