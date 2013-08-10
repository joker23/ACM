import java.math.BigInteger;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner in =  new Scanner(System.in);
		int num = in.nextInt();
		while(num-->0){
			BigInteger fact = BigInteger.ONE;
			int n = in.nextInt();
			for(int i = n; i>1;i--) fact = fact.multiply(new BigInteger(Integer.toString(i)));
			String find = in.next();
			int ret = 0;
			String hay = fact.toString();
			for(int i=0;i<hay.length();i++){
				if(Character.toString(hay.charAt(i)).equals(find)) ret++;
			}
			System.out.println(ret);
		}
	}

}
