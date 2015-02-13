package practice;
import java.util.LinkedList;
import java.util.Scanner;


public class C500 {

	private static Scanner in;
	
	static {
		in = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		int n = in.nextInt(); // number of books
		int m = in.nextInt(); // number of readings
		
		int[] books = new int[n + 1];
		
		for (int i=1; i<n + 1; i++) {
			books[i] = in.nextInt();
		}
		
		int[] reading = new int[m];
		LinkedList<Integer> stack = new LinkedList<Integer>();
		
		for (int i=0; i<m; i++) {
			reading[i] = in.nextInt();
			
			if (!stack.contains(reading[i])) {
				stack.add(reading[i]);
			}
		}
				
		int ans = 0;
		
		for (int i=0; i<m; i++) {
			int read = reading[i];
			int w = 0;
			int j = 0;
			for (; j<stack.size(); j++) {
				if (stack.get(j) == read) break;
				w += books[stack.get(j)];
			}
			
			stack.addFirst(stack.remove(j));
			ans += w;
		}
		
		System.out.println(ans);
	}
}
