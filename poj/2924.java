import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		//(m+n)*(m-n+1)/2 )
		for(int i=0;i<num;i++){
			long n  = in.nextLong();
			long m = in.nextLong();
			System.out.println("Scenario #"+(i+1)+":");
			System.out.println((long)(m+n)*(m-n+1)/2);
			System.out.println();
		}
	}
}
