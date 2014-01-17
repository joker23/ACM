import java.util.*;
import java.math.*;
import java.io.*;

public class Main{
	//static Scanner in;
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;

	static LinkedList<String> dict;

	public static void main(String[] args) throws IOException{
		//in = new Scanner(System.in);
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

		String str = in.readLine();
		String[] split = new String[2];
		Arrays.fill(split, "");
		int ind = 0;
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) == '|'){
				ind = 1;
				continue;
			} else{
				split[ind] += str.charAt(i);
			}
		}
		int need = Math.abs(split[0].length() - split[1].length());


		String has = in.readLine();
		if(has.length() < need){
			out.println("Impossible");
			out.flush();
			return;
		}

		int ptr = 0;
		if(split[0].length() < split[1].length()){
			while(need --> 0){
				split[0] += has.charAt(ptr++);
			} 
			for(int i=ptr; i < has.length(); i++){
				if(i%2 ==1){
					split[0] += has.charAt(i);
				} else{
					split[1] += has.charAt(i);
				}
			}
		} else {
			while(need --> 0){
				split[1] += has.charAt(ptr++);
			} 
			for(int i=ptr; i < has.length(); i++){
				if(i%2 ==1){
					split[1] += has.charAt(i);
				} else{
					split[0] += has.charAt(i);
				}
			}
		}

		if(split[0].length() != split[1].length()){
			out.println("Impossible");
		}
		else{
			out.println(split[0] + "|" + split[1]);
		}
		out.flush();
	}

	public static void print(int[][] dp){
		for(int i=0;i<dp.length;i++){
			for(int j=0;j<dp[i].length; j++){
				System.out.print("["+dp[i][j]+"]");
			}System.out.println();
		} System.out.println();
	}
}
