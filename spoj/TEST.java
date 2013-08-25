import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader in;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        in = new BufferedReader(new InputStreamReader(System.in));
		long curr = Integer.parseInt(in.readLine().trim());
		while(curr != 42){
			System.out.println(curr);
			curr = Integer.parseInt(in.readLine().trim());
		}
    }
}
