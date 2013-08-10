import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			StringTokenizer st = new StringTokenizer(in.readLine());
			int row =  Integer.parseInt(st.nextToken());
			int col =  Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(row == 0 && col == 0 && c == 0) break;
			int ret = 0;
			if(row<8||col<8){
				System.out.println(0);
				continue;
			}
			System.out.println(((row-7)*(col-7)+c)/2);
		}
	}

}
