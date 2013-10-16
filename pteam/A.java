
import java.util.*;

public class Main{
	static Scanner in;

	public static void main(String[] args){
		in = new Scanner(System.in);
		int test = in.nextInt();
		while(test-->0){
			int n = in.nextInt();
			long curr = in.nextLong();
			long ans = curr;
			while(curr!=1){
				if((curr&1)==0){
					curr = curr/2;
				} else {
					curr = curr* 3 +1;
					ans = Math.max(ans,curr);
				}
			} System.out.println(n + " " + ans);
		}
	}
}
