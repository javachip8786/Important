

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



public class HeapSectionA_subarraysQ2 {
	public static void subarr(int[] arr) {
		int[] newarr=new int[(arr.length)*(arr.length-1)];
		for(int i=0;i<arr.length;i++) {
			newarr[i]=arr[i];
		}
		for(int i=arr.length;i<newarr.length;i++) {
			newarr[i]=
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		int loop= Reader.nextInt();
		for(int i=0;i<loop;i++) {
			int n=Reader.nextInt();
			int k=Reader.nextInt();
			int[] arr=new int[n];
			for(int j=0;j<n;j++) {
				arr[j]=Reader.nextInt();
			}
		}
		
	}
	

}
