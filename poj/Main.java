import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		while((st = new StringTokenizer(in.readLine())).hasMoreTokens()){
			String a = st.nextToken();
			String b = st.nextToken();
			if(a.length()>b.length()){
				out.println("NO");
				continue;
			}
			int ptra = 0;
			int ptrb = 0;
			for(ptrb = 0; ptrb<b.length() && ptra<a.length(); ptrb++){
				if(a.charAt(ptra) == b.charAt(ptrb)){
					ptra++;
				}
			} if(ptra == a.length()){
				out.println("YES");
			}else{
				out.println("NO");
			}
		}
		out.flush();
	}
}
