
import java.util.*;

public class Main{
	static Scanner in;
	public static void main(String[] args){
		in = new Scanner(System.in);
		int n;
		while((n=in.nextInt())!=-1){
			System.out.println(solve(n));
		}
	}
	
	public static int solve(int n){
		if(n == 0) return 1;
		if(n == 2) return 3;
		if(n%2 == 1) return 0;
		return 4 * solve(n - 2) - solve(n - 4);
	}
}
