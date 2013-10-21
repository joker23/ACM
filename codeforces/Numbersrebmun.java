
import java.util.*;

public class Main{
	static Scanner in;
	static String[] arr = {"ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
	public static void main(String[] args){
		in = new Scanner(System.in);
		int[] dict = new int[255];
		for(int i=2; i<10; i++){
			String str = arr[i-2];
			for(int j = 0; j<str.length(); j++){
				dict[str.charAt(j)] = i;
			}
		}
		int test = in.nextInt();
		while(test-->0){
			String s = in.next().toUpperCase();
			String ans = "";
			for(int i=0; i<s.length(); i++){
				ans += dict[s.charAt(i)];
			}
			if(isPalin(ans)){
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}


	/**
	* checks if the given thing is a palindrome
	*/
	static boolean isPalin(int n){
		String str = n + "";
		for(int i = 0 ; i<=str.length()/2; i++){
			int j = str.length() -i -1;
			if(str.charAt(i)!= str.charAt(j)) return false;
		}return true;
	}
	
	static boolean isPalin(String str){
	  for(int i = 0 ; i<=str.length()/2; i++){
			int j = str.length() -i -1;
			if(str.charAt(i)!= str.charAt(j)) return false;
		}return true;
	}
}
