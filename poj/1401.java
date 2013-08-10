import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0){
			System.out.println((int)countZeroes(in.nextInt()));
		}
	}
	private static double countZeroes(long n){
		int count = 0;
		while(n!=0){
				count+=n/5;
				n/=5;
		} return count;
	}	
}
