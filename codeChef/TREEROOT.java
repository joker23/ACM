import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int num = in.nextInt(),n,ret;
		while(num-->0){
			n = in.nextInt();
			ret = 0;
			while(n-->0){
				ret+= in.nextInt() - in.nextInt();
			}
			System.out.println(ret);
		}
	}
}
