import java.util.*;
public class Main_Name_Reduction {
	static int[] dict;
	static int[] curr;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		while(test-->0){
			dict = new int[Character.MAX_VALUE+1];
			String p1 = in.next(), p2 = in.next();
			for(int i=0;i<p1.length();i++){
				dict[p1.charAt(i)]++;
			}for(int i=0;i<p2.length();i++){
				dict[p2.charAt(i)]++;
			}boolean ans = true;
			int children = in.nextInt();
			curr = new int[Character.MAX_VALUE+1];
			while(children-->0){
				String temp = in.next();
				for(int i=0;i<temp.length();i++){
					curr[temp.charAt(i)]++;
				}
			}for(int i='a';i<='z';i++){
				if(curr[i]>dict[i]){
					ans=false;
					break;
				}
			}if(ans) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
