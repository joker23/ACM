import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner in =  new Scanner(System.in);
		double amount = in.nextDouble();
		double balance = in.nextDouble();
		if(amount>balance-.5 || amount%5!=0) System.out.println(balance);
		else System.out.println(balance-.5-amount);
	}
}
