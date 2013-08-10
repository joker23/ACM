import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String num1 = in.next(), num2 = in.next();
		long ans =0;
		for(int i=0;i<num1.length();i++){
			for(int j=0;j<num2.length();j++){
				ans+= (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
			}
		}
		System.out.println(ans);
	}
}
