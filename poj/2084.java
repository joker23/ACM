import java.math.BigInteger;
import java.util.*;
public class Main {
	static final int MAX = 101;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		BigInteger[] cat =  new BigInteger[MAX];
		Arrays.fill(cat, BigInteger.ZERO);
		cat[0] = BigInteger.ONE;
		for(int i=0;i<cat.length;i++)
			for(int j=0;j<i;j++)
				cat[i] = cat[i].add(cat[j].multiply(cat[i-j-1]));
		int curr;
		for(;;){
			curr = in.nextInt();
			if(curr==-1) break;
			System.out.println(cat[curr]);
		}
	}
}
