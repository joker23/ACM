import java.util.*;
public class Main {
	public static void main(String[] argss){
		Scanner in = new Scanner(System.in);
		int n,i,tmp,ans;
		long check;
		boolean found;
		for(i=1,n=in.nextInt();n>0;i++,n=in.nextInt()){
			System.out.print("Case "+i+": ");
			check  = ((long)(9*n)/gcd(n,8))+1;
			System.out.println(Math.log10(check));
//			System.out.println(ans);
		}
	}
	private static long gcd(long i,long j){
		if(j==0) return i;
		return gcd(j,i%j);
	}
}
