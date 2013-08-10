import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine().trim();
		int numBlanks = 0, num2Blanks = 0,tot = 0;
		for(int i = 0;i<str.length();i++){
			tot++;
			if(i<str.length()-1 && str.charAt(i) == '0' && str.charAt(i+1) == '0')
				num2Blanks++;
			if(str.charAt(i)=='0') numBlanks++;
		} if(str.charAt(0)=='0' && str.charAt(str.length()-1)=='0') num2Blanks++; 
		int diff = numBlanks * numBlanks - num2Blanks * tot;
		if(diff<0) System.out.println("SHOOT");
		else if(diff>0) System.out.println("ROTATE");
		else System.out.println("EQUAL");
	}
}
