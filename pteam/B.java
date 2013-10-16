import java.math.*;
import java.util.*;

public class Main{
	static Scanner in;

	public static void main(String[] args){
		in = new Scanner(System.in);
		int test = in.nextInt();
		while(test-->0){
			int n = in.nextInt();
			int mod = in.nextInt() - 1;
			String num = in.next();
			int ans = 0;
			for(int i=0; i<num.length(); i++){
				ans = (ans+num.charAt(i) - 48) % mod;
			}
			System.out.println(n+ " " + ans);
		}
	}
}
