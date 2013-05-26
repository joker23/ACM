import java.io.*;
 
public class Main {
 
	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int num = Integer.parseInt(in.readLine());
		for(int i=0;i<num;i++){
			int ans = 0;
			String test = in.readLine();
			int j;
			for(j = 0;j<test.length();j++){
				char c  = test.charAt(j);
				if(c=='O'||c=='Q'||c=='R'||c=='P'||c=='A'||c=='D'){
					ans++;
				}
				else if (c=='B'){
					ans+=2;
				}
			}
			out.println(ans);
			out.flush();
		}
	}
 
}