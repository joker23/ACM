import java.util.*;
import java.io.*;
public class Main {
	
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(new File("final.in"));
		PrintWriter out = new PrintWriter("final.out");
		int n=in.nextInt(),p=in.nextInt(),k=in.nextInt(),d=in.nextInt()-1,best;
		if (d != 0) {
            best = p-d*(d-1)/2;
            if (best <= d) {
                out.println("Wrong information");
            } else {
                out.println(best);
                for (int i = 1; i < d; i++) {
                    out.println(d - i);
                } for (int i = d; i < n; i++) {
                    out.println(0); //because we know that it will be at least 2
                }
            }
        } else if (p % k == 0) { //everyone else loses!
            for (int i = 0; i < k; i++) {
                out.println(p / k);
            } for (int i = k; i < n; i++) {
                out.println(0);
            }
        } else if (k<n&&p/k*(n-k)>=p%k) {
            int f = p/k;
            for (int i = 0; i < k; i++) {
                out.println(f);
                p-=f;
            }
            for (int i = k; i < n; i++) {
                int s = Math.min(f, p);
                out.println(s);
                p -= s;
            }
        } else {
            out.println("Wrong information");
        }
		out.close();
		in.close();
	}
}
