import java.util.*;
public class Main {
	final static int num = 12;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int tests = num;
		double tot = 0.00;
		while(tests-->0){
			tot+=in.nextDouble();
		}
		tot = tot/num;
		tot = (double)Math.round(tot*100)/100;
		System.out.println("$"+tot);
	}
}

