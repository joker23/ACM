import java.util.*;
import java.io.*;
public class Main {
	static Scanner in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.ENGLISH);
        in = new Scanner(new File("deepest.in"));
        out = new PrintWriter("deepest.out");
        int x = in.nextInt(), y = in.nextInt(),d = in.nextInt();
        int z2 = x * x + y * y;
        if (z2 > d * d) {
            out.println("Impossible");
        } else if (z2 < d * d) {
            double a = 0.5 * (d * d - z2) / d;
            double z = Math.sqrt(z2);
            out.format("%.12f %.12f %.12f\n", -y * a / z, x * a / z, d - a);
        } else {
            out.println("Single staircase");
        }
        in.close();
        out.close();
	}
}
