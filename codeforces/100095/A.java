import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(new File("ate.in"));
		PrintWriter out = new PrintWriter("ate.out");
		int num = in.nextInt(),ret=0;
		if((num&1)==0&&num/2<100){
			out.println(2*(100-num/2-1)+1);
		} else if (num/2<100){
			out.println(2*(100-num/2-1));
		} else{
			out.println(0);
		}out.close();
		in.close();
	}
}
