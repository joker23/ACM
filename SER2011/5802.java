
import java.util.*;

public class Main{
	static Scanner in;
	static String table = "PQWERTYUIOJ#SZK*?F@D!HNM&LXGABCV";
	public static void main(String[] args){
		in = new Scanner(System.in);
		int test = in.nextInt();
		while(test-->0){
			int d = in.nextInt();
			String ans = "";
			Double n = in.nextDouble();
			System.out.println);
			if( n> 1){
				System.out.println(d+" INVALID VALUE");
				continue;
			}
			if(n<0){
				n+=1;
				ans += '1';
			}else {
				ans += '0';
			}
			for(int i=1; i<17;i++){
				double sub = 1.0/(1<<i);
				if(sub<=n){
					n-=sub;
					ans+='1';
				} else {
					ans+='0';
				}
			}
			String ret = "";
			ret+= table.charAt(Integer.parseInt(ans.substring(0,5), 2));
			ret+=" " + Integer.parseInt(ans.substring(5,16),2);
			ret+= (ans.charAt(16) == '0') ? " F": " D";
			System.out.println(d+" "+ret);
		}
	}
}
