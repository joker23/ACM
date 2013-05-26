import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(new File("aztec.in"));
		PrintWriter out = new PrintWriter("aztec.out");
		int n,height,tot,tmp;
		for(n=in.nextInt(),height=0,tot=1,tmp=1;tot<=n;height++,tmp+=height*4,tot+=tmp);
		out.println(height);
		out.close();
	}
}
