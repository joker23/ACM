package practice;
import java.util.LinkedList;
import java.util.Scanner;


public class A499 {

	private static Scanner in;
	
	static {
		in = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		int n = in.nextInt();
		int m = in.nextInt();
		
		LinkedList<Integer> start = new LinkedList<Integer>();
		LinkedList<Integer> end = new LinkedList<Integer>();
		
		for (int i=0; i<n; i++) {
			start.add(in.nextInt());
			end.add(in.nextInt());
		}
		
		int pointer = 1;
		int ans = 0;
		
		while(!start.isEmpty()) {
			int skip = pointer + m;
			
			if (pointer >= end.peek()) {
				pointer ++;
				ans ++;
				end.poll();
				start.poll();
			} else if (skip > start.peek()) {
				pointer ++;
				ans ++;
			} else {
				pointer = skip;
			}
		}
		
		System.out.println(ans);
	}
}
