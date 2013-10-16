
import java.util.*;

public class Main{
	static Scanner in;
	static String table = "PQWERTYUIOJ#SZK*?F@D!HNM&LXGABCV";
	public static void main(String[] args){
		in = new Scanner(System.in);
		int[] dict = new int[Character.MAX_VALUE];
		for(int i =0; i<table.length();i++){
			dict[table.charAt(i)] = i;
		}
		int test = in.nextInt();
		while(test-->0){
			int d = in.nextInt();
			char str = in.next().charAt(0);
			int num = in.nextInt();
			char str2 = in.next().charAt(0);
			String opt = Integer.toBinaryString(dict[str]);
			for(int i= 5- opt.length(); i>0; i--){
				opt = 0+opt;
			}
			String mid = Integer.toBinaryString(num);
			for(int i = 11 - mid.length(); i>0; i--){
				mid = 0+mid;
			}
			if(str2 == 'F'){
				mid+='0';
			} else {
				mid+='1';
			}
			String fin = opt+ mid;
			System.out.println(fin);
			double ans = 0;
			for(int i=1; i<fin.length(); i++){
				if(fin.charAt(i) == '1'){
					ans+=1.0/(1<<i);
				}
			}
			if(fin.charAt(0) == '1'){
				ans += -1;
			}
			System.out.println(ans);
		}
	}
}
