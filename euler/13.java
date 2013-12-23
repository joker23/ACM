import java.util.*;
import java.math.*;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		BigInteger ans = BigInteger.ZERO;
		for(int i=0;i<100;i++){
			String num = in.next().trim();
			ans = ans.add(new BigInteger(num));
		}
		System.out.println(ans);
	}
}
