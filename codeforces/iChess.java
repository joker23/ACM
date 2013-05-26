import java.util.*;
import java.io.*;
public class Main {
	 public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("ichess.in"));
        PrintWriter out = new PrintWriter("ichess.out");
        int b = in.nextInt(), w = in.nextInt();
        int n = 1;
        while (
            (n*n+0)/2 <= Math.min(b, w) && 
            (n*n+1)/2<= Math.max(b, w)) {
            n++;
        }
        
        if (n == 1) out.format("Impossible\n");
        else out.format("%d\n", n - 1);
        out.close();
	 }
}
