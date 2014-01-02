import java.util.*;
import java.math.*;
import java.io.*;

public class Main{
	static Scanner in;
//	static BufferedReader in;
//	static StringTokenizer st;
	static PrintWriter out;

	static final double pi = Math.PI;
	public static void main(String[] args) throws IOException{
		
		in = new Scanner(System.in);
		//in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

		//code starts here
		int test = in.nextInt();
		double x,y, crit;
		for(int i=1; i<=test; i++) {
			x = in.nextDouble();
			y = in.nextDouble();
			
			crit = x*x + y*y;

			int ans;
			for(ans = 1; ; ans ++){
				double tmp = Math.sqrt(ans*100/pi);
				if(crit <= tmp* tmp){
					break;
				}
			}

			out.println("Property "+i+": This property will begin eroding in year "+ans+".");
			
		}
		out.println("END OF OUTPUT.");
		//code ends here
		out.flush();
	}
}
