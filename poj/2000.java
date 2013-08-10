import java.util.*;
public class Main {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n,day,i;
		long ans;
		for(;;){
			n = in.nextInt();
			if(n==0) break;
			System.out.print(n+" ");
			for(ans=0,day=1,i=1;day<=n;){
				ans+=(long)i*(i++);
				day+=i;
			}
			ans+=(n-day+i)*i;
			System.out.println(ans);
		}
	}
}
