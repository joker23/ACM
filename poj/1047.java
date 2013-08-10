import java.math.BigInteger;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HashSet<BigInteger> lookup = new HashSet<BigInteger>(); 
		
		while(in.hasNext()){
			boolean flag = true;
			String num = in.next();
			String ret = num;
			BigInteger tester = new BigInteger(num);
			for(int i=0;i<num.length();i++){
				lookup.add(new BigInteger(num));
				num = num.substring(1,num.length()) + num.charAt(0);
			}
			for(int i=1;i<num.length()+1;i++){
				if(!lookup.contains(tester.multiply(new BigInteger(Integer.toString(i))))){
					flag = false;
					break;
				}
			}
			if(flag){
				System.out.println(ret+" is cyclic");
			} else{
				System.out.println(ret+" is not cyclic");
			}
			lookup.clear();
		}

	}

}
