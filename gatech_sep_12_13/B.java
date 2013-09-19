import java.util.*;
import java.math.*;
public class B{
	static Scanner in;
	static boolean[] check;
	public static void main(String[] args){
		in = new Scanner(System.in);
		while(in.hasNext()){
			String str = in.next();
			if(str.equals("")){
				break;
			}
			check = new boolean[10];
			BigInteger ans = BigInteger.ONE;
			BigInteger num = new BigInteger(str);
			while(!check(check)){
				str = num.multiply(ans).toString();
				for(int i = 0; i<str.length();i++){
					check[str.charAt(i)-48] = true;
				}	
				ans = ans.add(BigInteger.ONE);
			}
			ans = ans.subtract(BigInteger.ONE);
			System.out.println(ans);
		}
	}
	static boolean check(boolean[] arr){
		for(boolean b: arr){
			if(!b) return false;
		}return true;
	}
}
