package practice;

import java.util.Scanner;
import java.util.Stack;

public class CHEFBR {

	private static int[] arr;
	private static Scanner in;
	private static Stack<Integer> stack;
	private static int n;
	
	static {
		in = new Scanner(System.in);
		stack = new Stack<Integer>();
	}
	
	public static void main(String[] args) {
		n = in.nextInt();
		
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		
		System.out.println(solve_easy());
	}
	
	private static int solve_easy() {
		int count = 0;
		for (int i=0; i<(1 << n); i++) {
			if (check(i)) {
				count ++;
			}
		}
		
		return count;
	}
	
	private static boolean check(int sets) {
		stack.clear();
		for (int i=0; i<n; i++) {
			if ((sets & 1<<i) == 0) continue;
			int tmp = arr[i];
			
			if (tmp < 0) {
				stack.add(-tmp);
			} else {
				if (stack.isEmpty() || stack.peek() != tmp) {
					return false;
				} stack.pop();
			}
		}
		
		return stack.isEmpty();
	}
}
