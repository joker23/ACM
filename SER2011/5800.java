import java.io.*;
import java.util.*;

public class Main{
	static Scanner in;
	public static void main(String[] args) throws IOException{
		in = new Scanner(System.in);
		int test = in.nextInt();
		while(test-->0){
			int n = in.nextInt();
			int t = in.nextInt();
			String str = in.next();
			String ans = "";
			for(int i = 0; i<str.length(); i++){
				char c = str.charAt(i);
				for(int j=0; j<t; j++){
					ans+=c;
				}
			}
			System.out.println(n+ " "+ ans);
		}
	}
}
