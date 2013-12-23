import java.util.*;
import java.math.*;
import java.io.*;

public class Main{
	//static Scanner in;
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	public static void main(String[] args) throws IOException{
		//in = new Scanner(System.in);
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		//code starts here
		
	//	for(int i=1; i< 100; i++){
			int i = Integer.parseInt(in.readLine().trim());
			char[] arr = (i + "").toCharArray();
			
			HashSet<Integer> visited = new HashSet<Integer>();
			
			int num = i;
			int counter = 0;
			while(num != 1){
				counter ++;
				visited.add(num);
				int n = 0;
				for(char c: arr){
					n += (c - 48) * (c - 48);
				}
				if(visited.contains(n)){
					break;
				}
				arr = (n+"").toCharArray();
				num = n;
			}
			
			if(num== 1){
				System.out.println(counter);
			}else{
				System.out.println(-1);
			}
	//	}
		//code ends here
		out.flush();
	}
}
