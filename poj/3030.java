import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		while(num-->0){
			double test = in.nextDouble() - in.nextDouble() + in.nextDouble();
			if(test>0){
				System.out.println("do not advertise");
			} else if(test==0){
				System.out.println("does not matter");
			} else{
				System.out.println("advertise");
			}
		}
	}
}
