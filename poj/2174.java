import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int mask = 32,ptr1,ptr2,curr;
		String str1 = in.next(), str2 = in.next(),ret = "";
		curr = Integer.parseInt(str2.substring(0,2),16)^mask;
		for(ptr1=0,ptr2=2;ptr2<str2.length();ptr1+=2,ptr2+=2){
			ret += Integer.toHexString(curr);
			if(ret.length()%2==1) ret = ret.substring(0,ret.length()-1)+0+ret.charAt(ret.length()-1);
			int a = Integer.parseInt(str1.substring(ptr1,ptr1+2),16)^curr;
			curr = Integer.parseInt(str2.substring(ptr2,ptr2+2),16)^a;
		}ret+= Integer.toHexString(curr);
		System.out.println(ret.toUpperCase());
	} 
}
