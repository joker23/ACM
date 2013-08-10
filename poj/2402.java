import java.util.*;
public class Main {
	static final int[] index = {0,1,10,19,109,199,1099,1999,10999,19999,109999,199999,1099999,1999999,
								10999999,19999999,109999999,199999999,1099999999,1999999999,2000000001};
	static final String small = "1000000000";
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n,i,cnt,tmp;
		String ans;
		while((n=in.nextInt())>0){
			solve(n);
			for(i=1;n>=index[i+1];i++);
			if(i==1){ 
				System.out.println(n);
				continue;
			}if(i==2){
				System.out.println((n-9)+""+(n-9));
				continue;
			} tmp = Integer.parseInt(small.substring(0,(int)((double)(i+1)/2)));
			cnt = tmp+n-index[i];
			ans = ""+cnt;
			if((i&1)==1)
				for(i=ans.length()-2;i>=0;i--)
					ans+=ans.charAt(i);
			else
				for(i=ans.length()-1;i>=0;i--)
					ans+=ans.charAt(i);
			
			System.out.println(ans);
		}
	}
	private static void solve(int n){
		int counter = 0;
		long num=0;
		while(counter<n){
			num++;
			if(isPalin(num)){
				counter++;
			}
		}System.out.println(num);
	}
	private static boolean isPalin(long num){
		String str = Long.toString(num);
		boolean ret = true;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)!=str.charAt(str.length()-1-i)){
				ret = false;
				break;
			}
		}return ret;
	}
}
