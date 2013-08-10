import java.util.*;
public class Main {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n,ret;
		while(true){
			n=in.nextInt();
			if(n==0)break;
			ret = n;
			if(n%2 == 0){
				ret/=2;
				do{n/=2;}while(n%2==0);
			}if(n%3==0){
				ret=ret/3*2;
				do{n/=3;}while(n%3==0);
			}int stop = (int) Math.sqrt(n)+2;
			for(int i=6;i<=stop;i+=6){
				if(n%(i-1)==0){
					ret = ret/(i-1)*(i-2);
					while(n%(i-1)==0) n/=i-1;
					stop = (int) Math.sqrt(n)+2;
				}if(n%(i+1)==0){
					ret = ret/(i+1)*i;
					while(n%(i+1)==0)n/=i+1;
					stop = (int) Math.sqrt(n)+2;
				}
			}if(n!=1) ret = ret/n*(n-1);
			System.out.println(ret);
		}
	}
}
