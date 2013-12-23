import java.util.*;
import java.math.*;
import java.io.*;

public class Main{
	static Scanner in;
	static final int MOD = 1000000007;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int test = Integer.parseInt(in.readLine().trim());
		while(test-->0){
			int n = Integer.parseInt(in.readLine().trim());
			
			int ans = 1;
			while(n-->0){
				ans<<=1;
				if(ans>MOD){
					ans%=MOD;
				}
			}
			ans--;
			out.println(ans);
		}out.flush();
	}
}
