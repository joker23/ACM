
import java.util.*;
import java.math.*;
public class Main{
	static Scanner in;

	public static void main(String[] args){
		BigInteger n = new BigInteger("2");
		n = n.pow(1000);
		String s = n.toString();
		int ans = 0;
		for(int i=0;i<s.length(); i++){
			ans += s.charAt(i) - 48;
		}
		System.out.println(ans);
	}
}
