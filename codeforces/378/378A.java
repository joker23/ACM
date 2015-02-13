import java.util.*;
import java.math.*;
import java.io.*;

public class Main{
	static Scanner in;
	//static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;

	public static void main(String[] args) throws IOException{
		
		in = new Scanner(System.in);
		//in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

		//code starts here
		int a = in.nextInt();
		int b = in.nextInt();

		int awin = 0;
		int draw = 0;
		int bwin = 0;

		for(int i=1; i<7; i++){
			if( Math.abs(a - i) == Math.abs(b - i)){
				draw ++;
			} else if( Math.abs(a - i) > Math.abs(b - i)){
				awin ++;
			} else{
				bwin ++;
			}
		}

		out.println(bwin + " " + draw + " " + awin);

		//code ends here
		out.flush();
	}
}
