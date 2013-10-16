import java.math.*;
import java.util.*;
import java.io.*;

public class Main{
	static BufferedReader in;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		in = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(in.readLine().trim());
		while(test-->0){
			int n = Integer.parseInt(in.readLine().trim());
			String num = in.readLine();
			int ptr = 0;
			int m = Integer.parseInt(in.readLine().trim());
			String ans = "";
			st = new StringTokenizer(in.readLine());
			for(int i=0; i<m; i++){
				int tmp = Integer.parseInt(st.nextToken());
				ptr = ((ptr+tmp)%num.length());
				if(ptr < 0){
					ptr = num.length() - (Math.abs(ptr)%num.length());
				}
				ans += num.charAt(ptr);
			}
			System.out.println(n+" " +ans);
		}
	}
}
