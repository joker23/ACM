import java.util.*;

public class Main2{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		while(test-->0){
			String str  = in.next();
			int len = str.length();
			str += str;
			String min = null;
			int ans = 0;
			for(int i=0;i<len;i++){
				String temp = str.substring(i,i+len);
				if(min == null || min.compareTo(temp)>0){
					min = temp;
					ans = i;
				}
			}
			System.out.println(ans+1);
		}
	}
}
