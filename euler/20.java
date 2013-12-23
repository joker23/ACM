import java.math.*;
public class Main{
	public static void main(String[] args){
		BigInteger n = BigInteger.ONE;
		for(int i=2;i<=100; i++){
			n = n.multiply(new BigInteger(i+""));
		}
		String str = n.toString();
		int ans = 0;
		for(int i=0;i<str.length(); i++){
			ans += str.charAt(i)-48;
		}
		System.out.println(ans);
	}
}
