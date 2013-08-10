import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String n, d;
		for (n = in.next(), d = in.next(); !(d.equals("0") && n.equals("0")); n = in
				.next(), d = in.next()) {

			System.out.println(new BigInteger(n).pow(Integer.parseInt(d)));
		}
	}
}
