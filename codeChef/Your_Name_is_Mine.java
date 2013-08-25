import java.util.*;
public class Main_Your_Name_is_Mine {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		while(test-->0){
			String s1 = in.next().trim(), s2 = in.next().trim();
			if(s1.length()>s2.length()){
				String temp = s2;
				s2 = s1;
				s1 = temp;
			}
			int ptr=0;
			for(int i=0;i<s2.length();i++){
				if(ptr == s1.length()) break;
				if(s1.charAt(ptr)==s2.charAt(i)){
					ptr++;
				}
			}if(ptr==s1.length()) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
