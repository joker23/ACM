import java.math.BigInteger;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			double p = in.nextDouble();
			if(p==0){
				System.out.println(0);
				continue;
			}
			int ret = 1;
			while(Math.pow(ret, n)!=p){
				ret++;
			}
			System.out.println(ret);
		}
	}

}
