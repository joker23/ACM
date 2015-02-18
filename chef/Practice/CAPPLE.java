package practice;
import java.util.HashSet;
import java.util.Scanner;

public class CAPPLE {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HashSet<Integer> set;
		int test = in.nextInt();
		while (test --> 0) {
			int n = in.nextInt();
			set = new HashSet<Integer>();
			
			while (n --> 0) {
				set.add(in.nextInt());
			}
			
			System.out.println(set.size());
		}
	}
}
