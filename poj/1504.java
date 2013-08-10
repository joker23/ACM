import java.util.*;
public class Main {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		while(test-->0){
			String num1 = in.next(),num2 = in.next(),one="",two="",ans,out="";
			for(int i=num1.length()-1;i>=0;i--)
				one+=num1.charAt(i);
			for(int i=num2.length()-1;i>=0;i--)
				two+=num2.charAt(i);
			int a = Integer.parseInt(one), b = Integer.parseInt(two),ret;
			ret = a+b;
			ans= ""+ret;
			for(int i=ans.length()-1;i>=0;i--)
				out+=ans.charAt(i);
			System.out.println(Integer.parseInt(out));
		}
	}
}
