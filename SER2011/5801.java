
import java.util.*;
import java.io.*;
public class Main{
	static Scanner in;
	
	public static void main(String[] args) throws IOException{
		PrintWriter out = new PrintWriter(new File("ans"));
		in = new Scanner(new File("b.in.txt"));
		int test = in.nextInt();
		while(test-->0){
			int d = in.nextInt();
			int n = in.nextInt();
			int m = in.nextInt();
			int ans;
			if(m == 0){
				ans = 1;
			} else{
				ans = 1;
				for(int i=0; i<n-m; i++){
					ans+=m;
				}
			}
			out.println(d+" "+ ans);
		}
		out.flush();
	}
}
