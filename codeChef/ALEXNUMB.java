import java.util.*;
import java.math.*;
import java.io.*;

public class Main{
	
	static BufferedReader in;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		in = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(in.readLine());
		while(test-->0){
			int n = Integer.parseInt(in.readLine());
			if(n==0){
				System.out.println(0);
				continue;
			} else if(n==1){
				System.out.println(0);
				String no = in.readLine();
				continue;
			}
			String no = in.readLine();
			BigInteger ans = BigInteger.valueOf(n);
			ans = ans.multiply(ans.subtract(BigInteger.ONE));
			ans = ans.divide(BigInteger.valueOf(2));
			System.out.println(ans);
		}
	}
}
