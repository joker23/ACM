import java.math.*;

public class Main{
	
	public static void main(String[] args){
		BigInteger n1 = BigInteger.ONE;
		BigInteger n2 = BigInteger.ONE;
		int ans = 3;
		for(;; ans++){
			BigInteger tmp = new BigInteger(n1.toString());
			n1 = n1.add(n2);
			n2 = tmp;
			if(n1.toString().length()>=1000){
				break;
			}
		}
		System.out.println(ans);
	}
}
