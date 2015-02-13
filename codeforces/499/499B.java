package practice;
import java.util.HashMap;
import java.util.Scanner;


public class B499 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		for (int i=0; i<m; i++) {
			map.put(in.next(), in.next());
		}
				
		for (int i=0; i<n; i++) {
			if (i != 0) {
				System.out.print(" ");
			}
			
			String a = in.next();
			String b = map.get(a);
						
			if (b.length() < a.length()) {
				System.out.print(b);
			} else {
				System.out.print(a);
			}
		}
	}
}
