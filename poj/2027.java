import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		while(num-->0){
			if(in.nextInt()<in.nextInt()){
				System.out.println("NO BRAINS");
			} else{
				System.out.println("MMM BRAINS");
			}
		}
	}
}
