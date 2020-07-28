import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

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




//import java.util.*;
public class HW1_detectiveRatio {
	
	public static int max=Integer.MIN_VALUE;
	public static int min=Integer.MAX_VALUE;
	public static float finc=Integer.MAX_VALUE;;
	public static void func(int[] skills,int[] amount,int test) {
		for(int i=0;i<skills.length;i++) {
			float n=0;
			n=(float)amount[i]/skills[i];
//			n=(double)5/2;
//			System.out.println(n);
			float[] arr=new float[skills.length];
			for(int j=0;j<skills.length;j++) {
				arr[j]=n*skills[j];
			}
			float sum=0;
			for(int j=0;j<skills.length;j++) {
				if(arr[j]<amount[j]) {
					arr[j]=100000;
				}
			}
			print(arr);
			Arrays.sort(arr);
//			print(arr);
			for(int j=0;j<test;j++) {
					sum+=arr[j];
			}
			if(sum<finc) {
				finc=sum;
			}
		}	
	}
	
	
	public static void print(float[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"  ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
//		Scanner scn=new Scanner(System.in);
		Reader.init(System.in);
		int n=Reader.nextInt();
		int k=Reader.nextInt();
		int[] skills=new int[n];
		int[] amount=new int[n];
		for(int i=0;i<n;i++) {
			skills[i]=Reader.nextInt();
		}
		for(int i=0;i<n;i++) {
			amount[i]=Reader.nextInt();
		}
		for(int i=0;i<n;i++) {
			if(max<amount[i]) {
				max=amount[i];
			}
			if(min>amount[i]) {
				min=amount[i];
			}
		}
//		System.out.println(min);
//		System.out.println(max);
		if(k<n) {
			func(skills,amount,k);
			System.out.println((int)Math.ceil(finc));
		}
//		System.out.println(min);
//		System.out.println((int)Math.ceil(finc));
	}

}


