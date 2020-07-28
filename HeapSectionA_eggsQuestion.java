
//public class NitinSirKaCode_for_heap_labFOOBAR {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}


//import java.io.IOException;
//import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/** Class for buffered reading int and double values */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}



public class HeapSectionA_eggsQuestion {
	public static int N;
	
	public static void downheapify(int arr[], int i) 
	{ 
		if(N==0) {
			return;
		}
	    int largest = i; // Initialize largest as root 
	    int l = 2 * i ; // left = 2*i + 1 
	    int r = 2 * i +1; // right = 2*i + 2 
	  
	    if (l <= N && arr[l] > arr[largest]) 
	        largest = l; 
	  
	    if (r <= N && arr[r] > arr[largest]) 
	        largest = r; 
	  
	    if (largest != i) { 
	        int temp=arr[i];
	        arr[i]=arr[largest];
	        arr[largest]=temp;
	        downheapify(arr, largest); 
	    } 
	} 
	
	
	public static void upheapify(int arr[],int i) {
		if(i==0) {
			return;
		}
		int largest = i; // Initialize largest as root 
	    int l = 2 * i ; // left = 2*i + 1 
	    int r = 2 * i +1; // right = 2*i + 2 
	  
	    if (l <= N && arr[l] > arr[largest]) 
	        largest = l; 
	  
	    if (r <= N && arr[r] > arr[largest]) 
	        largest = r;
	    int temp=arr[i];
	    arr[i]=arr[largest];
	    arr[largest]=temp;
	    upheapify(arr,i/2);
	    
	}
	
	public static void insert(int ar[],int val )
    {
        N++;
        ar[N] = val;
        upheapify(ar,N);
    }
	
	
	 public static int  popout(int ar[])
	    {	int n=ar[1];
	        // swap with leaf
	        ar[1] = ar[N];
	        // disconnect the last node 
	        N--;
	        // downheapify on root
	        downheapify(ar, 1);
	        return n;
	    }

	public static void main(String[] args) throws IOException{
		N=0;
//		Reader.init(System.in);
//		int orders=Reader.nextInt();
//		int bags=Reader.nextInt();
		int[] arr=new int[5];
//		for(int i=0;i<bags;i++) {
//			int bag=Reader.nextInt();
//			insert(arr,bag);
//		}
//		int sum=0;
//		for(int j=0;j<orders;j++) {
//			int n1=popout(arr);
//			sum+=n1;
//			insert(arr,n1/2);
////			System.out.println(sum);
//		}
//		System.out.println(sum);
		insert(arr,10);
		insert(arr,10);
		insert(arr,3);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}System.out.println();
		System.out.println(popout(arr));
		insert(arr,1);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}System.out.println();
		System.out.println(popout(arr));
		insert(arr,1);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}System.out.println();
//		System.out.println(popout(arr));
//		System.out.println(popout(arr));
	}

}
