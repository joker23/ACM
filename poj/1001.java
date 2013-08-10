import java.math.*;
import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		BigDecimal base,ans;
		String num;
		int exp;
		while(scan.hasNext()){
			base = scan.nextBigDecimal();
			exp = scan.nextInt();
			ans = base.pow(exp);
			num = ans.toPlainString();
			int i,j=num.length();
			for(i=0;num.charAt(i)=='0';i++);
			if(num.contains("."))
				for(j=num.length()-1;num.charAt(j)=='0';j--);
			if(num.charAt(j)!='.') j++;
			System.out.println(num.substring(i,j));
		}
	}
}
