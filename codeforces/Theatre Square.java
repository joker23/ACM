import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		double m =  in.nextDouble(),n = in.nextDouble(), a = in.nextDouble();
		System.out.println((long)(Math.ceil(m/a)*Math.ceil(n/a)));
	}
}
